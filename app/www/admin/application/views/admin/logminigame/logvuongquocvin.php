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
        <h4 id="resultsearch" style="color: red;margin-left: 20px"></h4>
        <div class="widget">
            
            <link rel="stylesheet"
                  href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.15.35/css/bootstrap-datetimepicker.css">

            
            
            
            <script
                src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.15.35/js/bootstrap-datetimepicker.min.js"></script>
            <div class="title">
                <h6>Log TAMHUNG</h6>
            </div>
            <form class="list_filter form" action="<?php echo admin_url('logminigame/logvuongquocvin') ?>" method="post">
                <div class="formRow">
                    <table>
                        <tr>
                            <td>
                                <label for="param_name" class="formLeft" id="nameuser"
                                       style="margin-left: 50px;margin-bottom:-2px;width: 100px">Since:</label></td>
                            <td class="item">
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" id="toDate" name="toDate" value="<?php echo $this->input->post('toDate')?>"> <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                                </div>                            </td>

                            <td>
                                <label for="param_name" style="margin-left: 20px;width: 100px;margin-bottom:-3px;"
                                       class="formLeft"> To date: </label>
                            </td>
                            <td class="item">

                                <div class="input-group date" id="datetimepicker2">
                                    <input type="text" id="fromDate" name="fromDate" value="<?php echo $this->input->post('fromDate')?>"> <span class="input-group-addon">
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
                            <td><label  style="margin-left: 70px;margin-bottom:-2px;width: 80px;">Phiên:</label></td>
                            <td ><input type="text" style="margin-left: 0px;margin-bottom:-2px;width: 150px"  id="phienbc" value="<?php echo $this->input->post('phienbc') ?>" name="phienbc"></td>

                            <td><label  id = "labelvin" style="margin-left: 75px;margin-bottom:-2px;width: 80px;">Nickname:</label></td>

                            <td ><input type="text" style="margin-left: 20px;margin-bottom:-2px;width: 150px"  id="name" value="<?php echo $this->input->post('name') ?>" name="name"></td>

                        </tr>
                    </table>
                </div>
                <div class="formRow">
                    <table>
                        <tr>
                            <td><label  id = "labelvin" style="margin-left: 65px;margin-bottom:-2px;width: 75px;">Room Win:</label></td>

                            <td><select id="menhgiavin" name="menhgiavin"
                                        style="margin-left: 10px;margin-bottom:-2px;width: 150px;">
                                    <option value="" <?php if($this->input->post('menhgiavin')== "" ){echo "selected";} ?> >Select</option>
                                    <option value="100" <?php if($this->input->post('menhgiavin')== "100" ){echo "selected";} ?>>100 Win</option>
                                    <option value="1000" <?php if($this->input->post('menhgiavin')== "1000" ){echo "selected";} ?>>1K Win</option>
                                    <option value="10000" <?php if($this->input->post('menhgiavin')== "10000" ){echo "selected";} ?>>10K Win</option>
                                </select></td>
                            <td style="">
                                <input type="submit" id="search_tran" value="Search" class="button blueB"
                                       style="margin-left: 40px">
                            </td>
                            <td>
                                <input type="reset"
                                       onclick="window.location.href = '<?php echo admin_url('logminigame/logvuongquocvin') ?>'; "
                                       value="Reset" class="basic" style="margin-left: 20px">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            <div class="formRow"></div>
            <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
                <thead>
                <tr style="height: 20px;">
                    <td>No</td>
                    <td>Phiên</td>
                    <td>Nickname</td>
                    <td>Room</td>
                    <td>Dòng đặt</td>
                    <td>Dòng thắng</td>
                    <td>Money thưởng</td>
                    <td>Total thưởng</td>
                    <td>Kết quả</td>
                    <td>Time</td>
                </tr>
                </thead>
                <tbody id="logaction">
                </tbody>
            </table>

        </div>
    </div>
<?php endif; ?>
<style>
    td{
        word-break: break-all;
    }
    thead{
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
<div class="container">
    <div id="spinner" class="spinner" style="display:none;">
        <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
    </div>
    <div class="text-center">
        <ul id="pagination-demo" class="pagination-lg"></ul>
    </div>
</div>
<script src="<?php echo public_url() ?>/site/bootstrap/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="<?php echo public_url() ?>/site/bootstrap/jquery.dataTables.min.css">
<script>
    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'HH:mm:ss DD-MM-YYYY'
        });
        $('#datetimepicker2').datetimepicker({
            format: 'HH:mm:ss DD-MM-YYYY'
        });

    });
    $("#search_tran").click(function () {
        var fromDatetime = $("#toDate").val();
        var toDatetime = $("#fromDate").val();
        if (fromDatetime > toDatetime) {
            alert('The end date must be greater than the start date')
            return false;
        }
    })
    function resultlogCandy(stt,referid,nickname,room,linebet,linewin,prizeline,prize,result,time_log) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + referid + "</td>";
        rs += "<td>" + nickname + "</td>";
        rs += "<td>" + room + "</td>";
        rs += "<td class='col-sm-2'>" + linebet + "</td>";
        rs += "<td class='col-sm-2'>" + linewin + "</td>";
        rs += "<td class='col-sm-2'>" + prizeline + "</td>";
        rs += "<td>" + commaSeparateNumber(prize) + "</td>";
        rs += "<td>" + resultCandy(result) + "</td>";
        rs += "<td>" + time_log + "</td>";
        rs += "</tr>";
        return rs;
    }
    $(document).ready(function () {
        var result = "";
        var oldpage = 0;
        $('#pagination-demo').css("display", "block");
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('logminigame/logvuongquocvinajax')?>",
            data: {
                phienbc: $("#phienbc").val(),
                nickname: $("#name").val(),
                toDate: $("#toDate").val(),
                fromDate: $("#fromDate").val(),
                roomvin: $("#menhgiavin").val(),
                pages: 1
            },

            dataType: 'json',
            success: function (result) {
                $("#spinner").hide();
                if (result.transactions == "") {
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                } else {
                    var totalPage = result.total;
                    var countrow = result.totalRecord;
                    $("#num").html(countrow);
                    stt = 1;
                    $.each(result.transactions, function (index, value) {
                        result += resultlogCandy(stt, value.reference_id, value.user_name, value.bet_value, value.lines_betting, value.lines_win, value.prizes_on_line, value.prize, value.result, value.time_log);
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
                            if (oldpage > 0) {
                                $("#spinner").show();
                                table.destroy();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('logminigame/logvuongquocvinajax')?>",
                                    data: {

                                        phienbc: $("#phienbc").val(),
                                        nickname: $("#name").val(),
                                        toDate: $("#toDate").val(),
                                        fromDate: $("#fromDate").val(),
                                        roomvin: $("#menhgiavin").val(),
                                        pages: page
                                    },
                                    dataType: 'json',
                                    success: function (result) {
                                        $("#spinner").hide();
                                        stt = 1;
                                        $.each(result.transactions, function (index, value) {
                                            result += resultlogCandy(stt, value.reference_id, value.user_name, value.bet_value, value.lines_betting, value.lines_win, value.prizes_on_line, value.prize, value.result, value.time_log);
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
                            oldpage = page;
                        }
                    });

                }
            }
        })
    });
    function commaSeparateNumber(val) {
        while (/(\d+)(\d{3})/.test(val.toString())) {
            val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
        }
        return val;
    }

    function resultCandy(count) {
        var strresult;
        switch (count) {
            case 0:
                strresult = "Trượt";
                break;
            case 1:
                strresult = "Thắng";
                break;
            case 2:
                strresult = "Thắng lớn";
                break;
            case 3:
                strresult = "Nổ hũ";
                break;
            case 4:
                strresult = "Nổ hũ x2";
                break;
            case 5:
                strresult = "Mini MAYBACH";
                break;
            case 100:
                strresult = "Lỗi hệ thống";
                break;
            case 101:
                strresult = "Đặt cược không hợp lệ";
                break;
            case 102:
                strresult = "Not enough money";
                break;
        }
        return strresult;
    }
</script>
