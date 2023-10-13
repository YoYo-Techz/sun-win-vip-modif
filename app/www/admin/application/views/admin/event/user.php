<div class="titleArea">
    <div class="wrapper">
        <div class="pageTitle">
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="line"></div>
<?php if($role == false): ?>
    <div class="wrapper">
        <div class="widget">
            <div class="title">
                <h6>You are not authorized</h6>
            </div>
        </div>
    </div>
<?php else: ?>
    <div class="wrapper">
    <?php $this->load->view('admin/message', $this->data); ?>
        <div class="widget">
    <h4 id="resultsearch" style="color: red;margin-left: 20px"></h4>

    <div class="title">
        <h6>VIP point management</h6>
    </div>
    <form class="list_filter form" action="<?php echo admin_url('event/user') ?>" method="post">
    <table>
        <tr>
            <td>
                <label for="param_name"
                       style="margin-top:30px;width: 100px">Since:</label></td>
            <td class="item">
                <div class="input-group date" id="datetimepicker1">
                    <input type="text" id="toDate" name="toDate"
                           value="<?php echo $this->input->post('toDate') ?>"> <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                </div>            </td>

            <td>
                <label for="param_name" style="margin-left: 20px;width: 100px;margin-bottom:-3px;"
                       class="formLeft"> To date: </label>
            </td>
            <td class="item">

                <div class="input-group date" id="datetimepicker2">
                    <input type="text" id="fromDate" name="fromDate"
                           value="<?php echo $this->input->post('fromDate') ?>"> <span
                        class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                </div>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td><label style="margin-left: 180px">Nick name:</label></td>
            <td><input type="text" style="margin-left: 20px;margin-top:30px;width: 150px"
                       id="filter_iname" value="<?php echo $this->input->post('name') ?>" name="name"></td>
            <td><label style="margin-left: 105px;margin-bottom:-2px;width: 100px">Money:</label></td>
            <td class="">
                <select id="money_type" name="money"
                        style="margin-left: -30px;margin-bottom:-2px;width: 143px">
                    <option value="Win" <?php if ($this->input->post('money') == "Win") {
                        echo "selected";
                    } ?>>Win
                    </option>
                    <option value="xu" <?php if ($this->input->post('money') == "xu") {
                        echo "selected";
                    } ?>>Coin
                    </option>
                </select>
            </td>

        </tr>

    </table>    <table>
        <tr>
            <td>
                <label for="param_name" style="width: 100px;margin-bottom:-3px;margin-left: 190px;margin-top: 30px"
                       class="formLeft">Service: </label>
            </td>
            <td class="item"><select id="servicename" name="servicename"
                                     style="margin-left: -15px;margin-bottom:-2px;width: 142px">
                    <option value="">Minigame</option>
                    <option value="VQMM" <?php if ($this->input->post('servicename') == "VQMM") {
                        echo "selected";
                    } ?>>------Spin VQMM
                    </option>
                    <option value="TaiXiu" <?php if ($this->input->post('servicename') == "TaiXiu") {
                        echo "selected";
                    } ?>>------Play game Over/under
                    </option>
                    <option value="MiniPoker" <?php if ($this->input->post('servicename') == "MiniPoker") {
                        echo "selected";
                    } ?>>------Play game Mini Poker
                    </option>
                    <option value="CaoThap" <?php if ($this->input->post('servicename') == "CaoThap") {
                        echo "selected";
                    } ?>>------Play game Cao Thấp
                    </option>
                    <option value="BauCua" <?php if ($this->input->post('servicename') == "BauCua") {
                        echo "selected";
                    } ?>>------Play game Bầu Cua
                    </option>
                    <option value="">Slot</option>
                    <option value="Candy" <?php if ($this->input->post('servicename') == "Candy") {
                        echo "selected";
                    } ?>>------Spin Candy
                    </option>
                    <option value="KhoBau" <?php if ($this->input->post('servicename') == "KhoBau") {
                        echo "selected";
                    } ?>>------Spin MAYBACH
                    </option>
                    <option value="Avengers" <?php if ($this->input->post('servicename') == "Avengers") {
                        echo "selected";
                    } ?>>------Spin Avengers
                    </option>
                    <option value="MyNhanNgu" <?php if ($this->input->post('servicename') == "MyNhanNgu") {
                        echo "selected";
                    } ?>>------Spin Mỹ Nhân Ngư
                    </option>
                    <option value="NuDiepVien" <?php if ($this->input->post('servicename') == "NuDiepVien") {
                        echo "selected";
                    } ?>>------Spin RANGEROVER
                    </option>
                    <option value="">Other services</option>
                    <option value="SafeMoney" <?php if ($this->input->post('servicename') == "SafeMoney") {
                        echo "selected";
                    } ?>>------Safe
                    </option>
                    <option
                        value="CashOutByCard" <?php if ($this->input->post('servicename') == "CashOutByCard") {
                        echo "selected";
                    } ?>>------Buy card code
                    </option>
                    <option
                        value="CashOutByTopUp" <?php if ($this->input->post('servicename') == "CashOutByTopUp") {
                        echo "selected";
                    } ?>>------Top up your phone
                    </option>
                    <option
                        value="CashOutByBank" <?php if ($this->input->post('servicename') == "CashOutByBank") {
                        echo "selected";
                    } ?>>------Bank transfer
                    </option>
                    <option
                        value="RechargeByCard" <?php if ($this->input->post('servicename') == "RechargeByCard") {
                        echo "selected";
                    } ?>>------Nạp Win qua thẻ
                    </option>
                    <option
                        value="RechargeByIAP" <?php if ($this->input->post('servicename') == "RechargeByIAP") {
                        echo "selected";
                    } ?>>------Nạp Win qua IAP
                    </option>
                    <option
                        value="RechargeByBank" <?php if ($this->input->post('servicename') == "RechargeByBank") {
                        echo "selected";
                    } ?>>------Nạp Win qua ngân hàng
                    </option>
                    <option value="NapXu" <?php if ($this->input->post('servicename') == "NapXu") {
                        echo "selected";
                    } ?>>------Load Coins
                    </option>
                    <option
                        value="TransferMoney" <?php if ($this->input->post('servicename') == "TransferMoney") {
                        echo "selected";
                    } ?>>------Transfer
                    </option>
                    <option value="Admin" <?php if ($this->input->post('servicename') == "Admin") {
                        echo "selected";
                    } ?>>------Admin
                    </option>
                    <option value="GiftCode" <?php if ($this->input->post('servicename') == "GiftCode") {
                        echo "selected";
                    } ?>>------GiftCode
                    </option>
                    <option value="CashoutByVP" <?php if ($this->input->post('servicename') == "CashoutByVP") {
                        echo "selected";
                    } ?>>------Redeem vippoint rewards
                    </option>
                    <option value="Bot" <?php if ($this->input->post('servicename') == "Bot") {
                        echo "selected";
                    } ?>>------Bot
                    </option>
                    <option value="RefundFee" <?php if ($this->input->post('servicename') == "RefundFee") {
                        echo "selected";
                    } ?>>------Refund of agent fees
                    </option>
                    <option value="">Card game</option>
                    <option value="Sam" <?php if ($this->input->post('servicename') == "Sam") {
                        echo "selected";
                    } ?>>------Play game Sam
                    </option>
                    <option value="BaCay" <?php if ($this->input->post('servicename') == "BaCay") {
                        echo "selected";
                    } ?>>------Play game Three trees
                    </option>
                    <option value="Binh" <?php if ($this->input->post('servicename') == "Binh") {
                        echo "selected";
                    } ?>>------Play game Binh
                    </option>
                    <option value="Tlmn" <?php if ($this->input->post('servicename') == "Tlmn") {
                        echo "selected";
                    } ?>>------Play game TLMN
                    </option>
                    <option value="TaLa" <?php if ($this->input->post('servicename') == "TaLa") {
                        echo "selected";
                    } ?>>------Play game Tá Lả
                    </option>
                    <option value="Lieng" <?php if ($this->input->post('servicename') == "Lieng") {
                        echo "selected";
                    } ?>>------Play game Lieng
                    </option>
                    <option value="XiTo" <?php if ($this->input->post('servicename') == "XiTo") {
                        echo "selected";
                    } ?>>------Play game Xì Tố
                    </option>
                    <option value="BaiCao" <?php if ($this->input->post('servicename') == "BaiCao") {
                        echo "selected";
                    } ?>>------Play game Bài Cào
                    </option>
                    <option value="XocDia" <?php if ($this->input->post('servicename') == "XocDia") {
                        echo "selected";
                    } ?>>------Play game Xóc Xóc
                    </option>
                    <option value="Poker" <?php if ($this->input->post('servicename') == "Poker") {
                        echo "selected";
                    } ?>>------Play game Poker
                    </option>
                </select>
            </td>
            <td style="">
                <input type="submit" id="search_tran" value="Search" class="button blueB"
                       style="margin-left: 60px">
            </td>
            <td>
                <input type="reset"
                       onclick="window.location.href = '<?php echo admin_url('transaction') ?>'; "
                       value="Reset" class="basic" style="margin-left: 20px">
            </td>
        </tr>
    </table>
    </form>
    <div class="formRow"></div>
    <table cellpadding="0" cellspacing="0" width="100%" class="tablesorter table table-bordered table-hover" id="checkAll">
        <thead>
        <tr style="height: 20px;">
            <th>No</th>
            <th>Nick name</th>
            <th>Service</th>
            <th>Act</th>
            <th class="col-sm-3" id="des">Describe</th>
            <th style="width:100px;">Surplus</th>
            <th>Change money</th>
            <th>Waste</th>
            <th>Date created</th>
        </tr>
        </thead>
        <tbody id="logaction">
        </tbody>
    </table>
    </div>
    </div>
<?php endif; ?>
<style>
    td {
        word-break: break-all;
    }

    thead {
        font-size: 12px;
    }

    .spinner {
        position: fixed;
        top: 50%;
        left: 50%;
        margin-left: -50px; /* half width of the spinner gif */
        margin-top: -50px; /* half height of the spinner gif */
        text-align: center;
        z-index: 1234;
        overflow: auto;
        width: 100px; /* width of the spinner gif */
        height: 102px; /*hight of the spinner gif +2px to fix IE8 issue */
    }</style>

<div id="spinner" class="spinner" style="display:none;">
    <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
</div>
<div class="text-center">
    <ul id="pagination-demo" class="pagination-sm"></ul>

</div>

<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<script>
    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss'
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss'
        });

    });
    $("#search_tran").click(function () {
        var fromDatetime = $("#toDate").val();
        var toDatetime = $("#fromDate").val();
        if (fromDatetime > toDatetime) {
            alert('The end date must be greater than the start date')
            return false;
        }
    });
    function resultSearchTransction(stt, transactionTime, nickName, actionName, description, currentMoney, moneyExchange, serviceName, fee) {
        var rs = "";

        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + nickName + "</td>";

        rs += "<td>" + actionName + "</td>";
        rs += "<td>" + serviceName + "</td>";
        if (actionName != "CashOutByCard") {
            rs += "<td>" + description + "</td>";
        }else{
            rs += "<td></td>";
        }
        rs += "<td>" + currentMoney + "</td>";
        rs += "<td>" + moneyExchange + "</td>";
        rs += "<td>" + fee + "</td>";
        rs += "<td>" + transactionTime + "</td>";
        rs += "</tr>";
        return rs;
    }
    $(document).ready(function () {
        var oldPage = 0;
        var result = "";

        $('#pagination-demo').css("display", "block");
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('transaction/indexajax')?>",
            // url: "http://192.168.0.251:8082/api_backend",
            data: {
                nickname: $("#filter_iname").val(),
                toDate: $("#toDate").val(),
                fromDate: $("#fromDate").val(),
                money: $("#money_type").val(),
                servicename: $("#servicename").val(),
                action_name: $("#action_name").val(),
                pages: 1,
                timkiemtheo: $("#timkiemtheo").val()
            },

            dataType: 'json',
            success: function (result) {
                $("#spinner").hide();
                if (result.transactions == "") {
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                } else {
                    var totalPage = result.totalPages;
                    stt = 1;
                    $.each(result.transactions, function (index, value) {
                        result += resultSearchTransction(stt, value.transactionTime, value.nickName, value.actionName, value.description, commaSeparateNumber(value.currentMoney), commaSeparateNumber(value.moneyExchange), value.serviceName, commaSeparateNumber(value.fee));
                        stt++;

                    });
                    $('#logaction').html(result);
                    var table = $('#checkAll').DataTable({
                        "ordering": true,
                        "searching": true,
                        "paging": false,
                        "draw": false
                    });

                    $('#pagination-demo').twbsPagination({
                        totalPages: totalPage,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            if (oldPage > 0) {
                                $("#spinner").show();
                                table.destroy();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('transaction/indexajax')?>",
                                    // url: "http://192.168.0.251:8082/api_backend",
                                    data: {
                                        nickname: $("#filter_iname").val(),
                                        toDate: $("#toDate").val(),
                                        fromDate: $("#fromDate").val(),
                                        money: $("#money_type").val(),
                                        servicename: $("#servicename").val(),
                                        action_name: $("#action_name").val(),
                                        pages: page,
                                        timkiemtheo: $("#timkiemtheo").val()
                                    },
                                    dataType: 'json',
                                    success: function (result) {
                                        $("#spinner").hide();
                                        stt = 1;
                                        $.each(result.transactions, function (index, value) {
                                            result += resultSearchTransction(stt, value.transactionTime, value.nickName, value.actionName, value.description, commaSeparateNumber(value.currentMoney), commaSeparateNumber(value.moneyExchange), value.serviceName, commaSeparateNumber(value.fee));
                                            stt++;

                                        });
                                        $('#logaction').html(result);
                                        table = $('#checkAll').DataTable({
                                            "ordering": true,
                                            "searching": true,
                                            "paging": false,
                                            "draw": false
                                        });
                                    }
                                });
                            }
                            oldPage = page;
                        }
                    });
                }
            }
        })

    });
</script>
<script>
    function commaSeparateNumber(val) {
        while (/(\d+)(\d{3})/.test(val.toString())) {
            val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
        }
        return val;
    }

    function commaSeparateNumber1(val) {
        while (/(\d+)(\d{3})/.test(val.toString())) {
            val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ' ' + '$2');
        }
        return val;
    }
</script>