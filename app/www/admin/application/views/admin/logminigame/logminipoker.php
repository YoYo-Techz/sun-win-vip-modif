<?php $this->load->view('admin/logminigame/head', $this->data) ?>
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


    <link rel="stylesheet" href="<?php echo public_url() ?>/site/css/loggamethirdparty.css">

    <div class="widget">
        <h4 id="resultsearch"></h4>
        <div class="title">
            <h6>Lịch sử minipoker </h6>
            <h6 style=" float: right;font-size:15px;text-transform:none;">Total Số người chơi:<span style="color:#0000ff;padding-left:10px;font-size:initial;" id="tong_player"></span></h6>
        </div>

        <form class="list_filter form" action="<?php echo admin_url('logminigame/logminipoker') ?>" method="post">
            <div class="formRow">
                <table>
                    <tr>
                        <td>
                            <label for="param_name" class="formLeft" id="nameuser">Since:</label></td>
                        <td class="item">
                            <div class="input-group date" id="datetimepicker1">
                                <input type="text" id="toDate" name="toDate" value="<?php echo $this->input->post('toDate') ?>"> <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                            </div>                        </td>

                        <td>
                            <label for="param_name" class="formLeft formtoDate"> To date: </label>
                        </td>
                        <td class="item">
                            <div class="input-group date" id="datetimepicker2">
                                <input type="text" id="fromDate" name="fromDate" value="<?php echo $this->input->post('fromDate') ?>"> <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                            </div>
                        </td>
                        </tr>
                    </table>
                </div>
            <div class="formRow">
                <table>
                    <tr>
                        <td><label  class="session-1">Nick name:</label></td>
                        <td ><input type="text" class="session-2" id="nickname" value="<?php echo $this->input->post('nickname') ?>" name="nickname"></td>
                        <td><label  id = "labelvin" class="money-type-1" style="margin-left: 19px">Room win:</label></td>

                        <td><select id="menhgiavin" name="menhgiavin"
                                    class="money-type-2" style="margin-left: 1px;width: 212px">
                                <option value="" <?php if($this->input->post('menhgiavin')== "" ){echo "selected";} ?>>Select</option>
                                <option value="100" <?php if($this->input->post('menhgiavin')== "100" ){echo "selected";} ?>>100 Win</option>
                                <option value="1000" <?php if($this->input->post('menhgiavin')== "1000" ){echo "selected";} ?>>1K Win</option>
                                <option value="10000" <?php if($this->input->post('menhgiavin')== "10000" ){echo "selected";} ?>>10K Win</option>
                            </select></td>
                        <td hidden><label class="money-type-1">Money:</label></td>
                        <td hidden>
                            <select id="money" name="money" class="money-type-2">
                                <option value="1" <?php if($this->input->post('money')== "1" ){echo "selected";} ?>>Vin</option>
                                <option value="0" <?php if($this->input->post('money')== "0" ){echo "selected";} ?>>Coin</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="formRow">
                <table>
                    <tr>
                        <td hidden><label  id = "labelxu" class="money-type-1">Room xu:</label></td>
                        <td hidden><select id="menhgiaxu" name="menhgiaxu"
                                    class="money-type-2">
                                <option value="" <?php if($this->input->post('menhgiaxu')== "" ){echo "selected";} ?>>Select</option>
                                <option value="1000" <?php if($this->input->post('menhgiaxu')== "1000" ){echo "selected";} ?>>1K Coin</option>
                                <option value="10000" <?php if($this->input->post('menhgiaxu')== "10000" ){echo "selected";} ?>>10K Coin</option>
                                <option value="100000" <?php if($this->input->post('menhgiaxu')== "100000" ){echo "selected";} ?>>100K Coin</option>
                            </select></td>
                    </tr>
                </table>
            </div>
            <div class="formRow">
                <table>
                    <tr>
                        <td style="">
                            <input type="submit" id="search_tran" value="Search" class="button blueB search">
                        </td>
                        <td>
                            <input type="reset"
                                   onclick="window.location.href = '<?php echo admin_url('logminigame/logminipoker') ?>'; "
                                   value="Reset" class="basic">
                        </td>
                    </tr>
                </table>
            </div>
        </form>
        <div class="formRow"></div>
        <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
            <thead>
            <tr class="list-logminigame">
                <td>No</td>
                <td>Nick name</td>
                <td style="width:100px;">Room chơi</td>
                <td style="width:100px;">Kết quả</td>
                <td>Money thưởng</td>
                <td>Quân bài</td>
                <td>Hũ hiện tại</td>
                <td>Fund hiện tại</td>
                <td>Type of money</td>
                <td>Date created</td>
            </tr>
            </thead>
            <tbody id="logaction">

            </tbody>
        </table>
    </div>
</div>
<?php endif; ?>
<div class="container">
    <h6 class="total-data">Total records:<span class="total-data-span" id="totalData"></span></h6>
    <div id="spinner" class="spinner image-logminigame">
        <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
    </div>
    <div class="text-center">
        <ul id="pagination-demo" class="pagination-lg"></ul>
    </div>
</div>
<div class="clear mt30"></div>
<script>
$(function () {
    var startDate = moment(new Date()).hours(0).minutes(0).seconds(0).milliseconds(0);
    var endDate = moment(new Date()).hours(23).minutes(59).seconds(59).milliseconds(59);
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        defaultDate: startDate,
        useCurrent : false,
    });
    $('#datetimepicker2').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        defaultDate: endDate,
        useCurrent : false,
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

function resultlogminipoker(stt,user_name,bet_value,result,prize,cards,current_pot,current_fund,money_type,time_log) {
    var rs = "";
    rs += "<tr>";
    rs += "<td>" + stt + "</td>";
    rs += "<td>" + user_name + "</td>";
    rs += "<td>" + commaSeparateNumber(bet_value) + "</td>";
    rs += "<td>" + resultminipoker(result) + "</td>";
    rs += "<td>" + commaSeparateNumber(prize) + "</td>";
    rs += "<td>" + cards + "</td>";
    rs += "<td>" + commaSeparateNumber(current_pot) + "</td>";
    rs += "<td>" + commaSeparateNumber(current_fund) + "</td>";
    if(money_type == 0){
        rs += "<td>" + "xu" + "</td>";
    }else if(money_type == 1){
        rs += "<td>" + "win" + "</td>";
    }
    rs += "<td>" + time_log + "</td>";
    rs += "</tr>";
    return rs;
}
$(document).ready(function () {
    var oldpage = 0;
    $('#pagination-demo').css("display","block");
    $("#spinner").show();
    if($("#money").val()==1) {
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('logminigame/logminipokerajax')?>",
            data: {
                nickname: $("#nickname").val(),
                roomvin : $("#menhgiavin").val(),
                toDate : $("#toDate").val(),
                fromDate : $("#fromDate").val(),
                money : $("#money").val(),
                pages : 1
            },
            dataType: 'json',
            success: function (result) {
                var totalPage = result.total;
                var countrow = result.totalRecord;
                $("#totalData").html($.number(result.totalRecord, undefined, '.', ','));
                $("#spinner").hide();
                if (result.transactions == "") {
                    $('#pagination-demo').css("display","none");
                    $("#resultsearch").html("No results were found");
                } else {
                    $("#tong_player").html($.number(result.total_player, undefined, '.', ','));
                    $("#resultsearch").html("");
                    stt = 1;
                    $.each(result.transactions, function (index, value) {
                        result += resultlogminipoker(stt,value.user_name,value.bet_value,value.result,value.prize,value.cards,value.current_pot,value.current_fund,value.money_type,value.time_log);
                        stt ++;
                    });
                    $('#logaction').html(result);
                    $('#pagination-demo').twbsPagination({
                        totalPages: totalPage,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            if(oldpage > 0) {
                                $("#spinner").show();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('logminigame/logminipokerajax')?>",
                                    data: {
                                        nickname: $("#nickname").val(),
                                        roomvin : $("#menhgiavin").val(),
                                        toDate : $("#toDate").val(),
                                        fromDate : $("#fromDate").val(),
                                        money : $("#money").val(),
                                        pages : page
                                    },
                                    dataType: 'json',
                                    success: function (result) {
                                        $("#spinner").hide();
                                        stt = (page - 1) * 50 + 1;
                                        $.each(result.transactions, function (index, value) {
                                            result += resultlogminipoker(stt,value.user_name, value.bet_value, value.result, value.prize, value.cards, value.current_pot, value.current_fund, value.money_type, value.time_log);
                                            stt ++;
                                        });
                                        $('#logaction').html(result);
                                    }
                                });
                            }
                            oldpage = page;
                        }
                    });
                }

            }
        })
    }else if($("#money").val()== 0){
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('logminigame/logminipokerajax')?>",
            data: {
                nickname: $("#nickname").val(),
                roomxu : $("#menhgiaxu").val(),
                toDate : $("#toDate").val(),
                fromDate : $("#fromDate").val(),
                money : $("#money").val(),
                pages : 1
            },
            dataType: 'json',
            success: function (result) {
                var totalPage = result.total;
                var countrow = result.totalRecord;
                $("#num").html(countrow);
                $("#spinner").hide();
                if (result.transactions == "") {
                    $('#pagination-demo').css("display","none");
                    $("#resultsearch").html("No results were found");
                } else {
                    $("#resultsearch").html("");
                    stt = 1;
                    $.each(result.transactions, function (index, value) {
                        result += resultlogminipoker(stt,value.user_name,value.bet_value,value.result,value.prize,value.cards,value.current_pot,value.current_fund,value.money_type,value.time_log);
                        stt ++;
                    });
                    $('#logaction').html(result);
                    $('#pagination-demo').twbsPagination({
                        totalPages: totalPage,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            if(oldpage>0) {
                                $("#spinner").show();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('logminigame/logminipokerajax')?>",
                                    data: {
                                        nickname: $("#nickname").val(),
                                        roomxu : $("#menhgiaxu").val(),
                                        toDate : $("#toDate").val(),
                                        fromDate : $("#fromDate").val(),
                                        money : $("#money").val(),
                                        pages : page
                                    },
                                    dataType: 'json',
                                    success: function (result) {
                                        $("#spinner").hide();
                                        stt = 1;
                                        $.each(result.transactions, function (index, value) {
                                            result += resultlogminipoker(stt,value.user_name, value.bet_value, value.result, value.prize, value.cards, value.current_pot, value.current_fund, value.money_type, value.time_log);
                                            stt ++;
                                        });
                                        $('#logaction').html(result);
                                    }
                                });
                            }
                            oldpage = page;
                        }
                    });
                }

            }
        })
    }});

function resultminipoker(count) {
    var strresult;
    switch (count) {
        case 0:
            strresult = "Trượt";
            break;
        case 1:
            strresult = "Nổ hũ";
            break;
        case 2:
            strresult = "Thùng phá sảnh nhỏ";
            break;
        case 3:
            strresult = "Tứ quý";
            break;
        case 4:
            strresult = "Cù lũ";
            break;
        case 5:
            strresult = "Thùng";
            break;
        case 6:
            strresult = "Sảnh";
        case 7:
            strresult = "Sám cô";
            break;
        case 8:
            strresult = "Hai đôi";
            break;
        case 9:
            strresult = "Một đôi to";
            break;
        case 10:
            strresult = "Một đôi nhỏ";
            break;
        case 11:
            strresult = "Scratch cards";
            break;
    }
    return strresult;
}

function commaSeparateNumber(val) {
    while (/(\d+)(\d{3})/.test(val.toString())) {
        val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
    }
    return val;
}
</script>
