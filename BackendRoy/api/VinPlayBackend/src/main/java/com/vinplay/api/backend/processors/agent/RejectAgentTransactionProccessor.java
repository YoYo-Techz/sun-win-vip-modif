package com.vinplay.api.backend.processors.agent;

import com.vinplay.dal.dao.AgentDAO;
import com.vinplay.dal.dao.impl.AgentDAOImpl;
import com.vinplay.dal.entities.agent.UserAgentModel;
import com.vinplay.payment.entities.AgentTransaction;
import com.vinplay.payment.utils.Constant;
import com.vinplay.payment.utils.PayCommon.PAYSTATUS;
import com.vinplay.usercore.service.AgentTransactionsService;
import com.vinplay.usercore.service.impl.AgentTransactionsServiceImpl;
import com.vinplay.utils.TelegramAlert;
import com.vinplay.vbee.common.cp.BaseProcessor;
import com.vinplay.vbee.common.cp.Param;
import com.vinplay.vbee.common.response.BaseResponse;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Date;

public class RejectAgentTransactionProccessor implements BaseProcessor<HttpServletRequest, String> {
    @Override
    public String execute(Param<HttpServletRequest> param) {
        HttpServletRequest request = param.get();
        String serPath = request.getServletPath();
        if(serPath == null || serPath.trim().isEmpty() || serPath != "/api_agent"){
            return BaseResponse.error(Constant.ERROR_PARAM, "Not allow access this api");
        }
        
        String transId = request.getParameter("id");
        if(StringUtils.isBlank(transId))
			return BaseResponse.error(Constant.ERROR_PARAM, "TransactionId can not empty");
        
        String agentCode = request.getParameter("code");
        if(StringUtils.isBlank(agentCode))
			return BaseResponse.error(Constant.ERROR_PARAM, "Code of agent can not empty");
        
        AgentDAO agentDao = new AgentDAOImpl();
        UserAgentModel agentModel;
		try {
			agentModel = agentDao.DetailUserAgentByCode(agentCode);
		} catch (SQLException e1) {
			e1.printStackTrace();
			agentModel = null;
		}
		
        if(agentModel == null)
        	return BaseResponse.error(Constant.ERROR_PARAM, "Agent code is invalid");
        
        String description = request.getParameter("des");
        if(StringUtils.isBlank(description))
        	description = "Rejected by: " + agentModel.getNickname() + " at: " + new Date();
        
        AgentTransactionsService service = new AgentTransactionsServiceImpl();
        AgentTransaction transaction = new AgentTransaction();
        transaction = service.getById(transId);
        if(transaction == null)
        	return BaseResponse.error(Constant.ERROR_PARAM, "TransactionId is invalid");
        
        if(transaction.Status != PAYSTATUS.PENDING.getId() || transaction.IsDeleted == true)
        	return BaseResponse.error("1002", "Can not reject this transaction");
        
        transaction.Status = PAYSTATUS.FAILED.getId();
        transaction.UserApprove = agentModel.getNickname();
        try {
        	String rs = service.updateStatus(transId, PAYSTATUS.FAILED.getId(), description, agentModel.getNickname());
        	if("success".equalsIgnoreCase(rs)) {
        		String message = "<b>[AGENT-ADMIN][REJECTED] Yêu cầu nạp tiền từ đại lý " + agentModel.getUsername() + "</b>";
        		message += "\n Mã yêu cầu: <b>" + transId + "(" + transaction.CreatedAt.toString() + ")" + "</b>";
	            message += "\n Số tiền: <b>"+ transaction.Money + "</b>";
	            message += "\n Người thực hiện: <b>" + agentModel.getUsername() + "</b>";
				TelegramAlert.SendMessageRechard(message);
        		return BaseResponse.success("0", rs, rs);
        	}
        	else
        		return BaseResponse.error("1001", rs);
        }
        catch (Exception e) {
            return BaseResponse.error("-1", e.getMessage());
        }
    }
}