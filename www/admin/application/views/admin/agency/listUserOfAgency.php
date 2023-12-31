
<div class="titleArea">
    <div class="wrapper">
        <div class="pageTitle">
            <h5>LIST OF USERS BELONGING TO AGENT</h5>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="line"></div>
<?php if (!empty($returnUrl)) { ?>
    <div class="wrapper return-url">
        <a class="" href="<?= admin_url($returnUrl) ?>">
            <i class="fas fa-angle-double-left"></i> Come back
        </a>
    </div>
<?php } ?>
<link rel="stylesheet" href="<?php echo public_url() ?>/site/css/loggamethirdparty.css"><?php if(false): ?>
    <div class="wrapper">
        <div class="widget">
            <div class="title">
                <h6>You are not authorized</h6>
            </div>
        </div>
    </div>
<?php else: ?>
    <?php $this->load->view('admin/error')?>
    <div class="wrapper">
        <?php $this->load->view('admin/message', $this->data); ?>
        <div class="widget">
            <h4 id="resultsearch"></h4>
            <div class="title">
                <h6>List of Users belonging to the agency</h6>
                <h6 class="total">Total revenue:<span class="total-number" id="total_doanhthu"></span></h6>
                <h6 class="total">Total withdrew:<span class="total-number" id="total_rut"></span></h6>
                <h6 class="total">Total loaded:<span class="total-number" id="total_nap"></span></h6>
                <h6 class="total">Total records:<span class="total-number" id="totalData"></span></h6>
            </div>
            <form class="list_filter form" action="" method="post">
                <div class="formRow">
                    <table>
                        <tr>
                            <td>
                                <label for="param_name" class="formLeft" id="nameuser">Since:</label></td>
                            <td class="item">
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" id="fromDate" name="fromDate" value="<?php echo $this->input->post('fromDate') ?>"> <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                                </div>                            </td>
                            <td>
                                <label for="param_name" class="formLeft formtoDate"> To date: </label>
                            </td>
                            <td class="item">

                                <div class="input-group date" id="datetimepicker2">
                                    <input type="text" id="toDate" name="toDate" value="<?php echo $this->input->post('toDate') ?>"> <span class="input-group-addon">
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
                            <td><label class="session-1">Nick name: </label></td>
                            <td><input type="text" class="session-2"
                                       id="nick_name" value="<?php echo $this->input->post('nick_name') ?>" name="nick_name"></td>
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
                                       onclick="window.location.href = ''; "
                                       value="Reset" class="basic">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
                <thead>
                <tr class="list-loggameslot">
                    <td>No</td>
                    <td>Nick name</td>
                    <td>Registration date</td>
                    <td>Balance</td>
                    <td>Total loaded (1)</td>
                    <td>Total withdraw (2)</td>
                    <td>Revenue (3) = (1) - (2)</td>
                    <td>Act</td>
                </tr>
                </thead>
                <tbody id="logaction">
                </tbody>
            </table>
        </div>
    </div>
<?php endif;?>
<div class="container">
    <div id="spinner" class="spinner image-loggameslot">
        <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
    </div>
    <div class="text-center">
        <ul id="pagination-demo" class="pagination-lg"></ul>
    </div>
</div>

<script>
    $("#search_tran").click(function () {
        var fromDatetime = $("#fromDate").val();
        var toDatetime = $("#toDate").val();
        if (fromDatetime > toDatetime) {
            alert('The end date must be greater than the start date')
            return false;
        }
    });

    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
        });
    });

    $(document).ready(function () {
        var url_string = window.location.href;
        var url = new URL(url_string);
        var referral_code = url.searchParams.get("referral_code");
        var fromdate;
        var todate;
        var oldpage = 0;
        if($("#toDate").val()!=""){
            var match = $("#toDate").val().match(/^(\d+)-(\d+)-(\d+)$/)
            var date = new Date(match[1], match[2] - 1, match[3])
            todate = moment.unix(date.getTime()/1000).format("YYYY-MM-DD")
        }
        else{
            todate =  "";
        }
        if($("#fromDate").val()!=""){
            var match = $("#fromDate").val().match(/^(\d+)-(\d+)-(\d+)$/)
            var date = new Date(match[1], match[2] - 1, match[3])
            fromdate = moment.unix(date.getTime()/1000).format("YYYY-MM-DD")
        }
        else{
            fromdate =  "";
        }
        $('#pagination-demo').css("display", "block");
        $('#logaction').html("");
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('agency/listUserOfAgencyajax')?>",
            data: {
                nick_name: $("#nick_name").val(),
                toDate: todate,
                fromDate: fromdate,
                referral_code: referral_code,
                doanh_thu: $("#doanh_thu").val(),
                page : 1,
                maxItem: 10
            },
            dataType: 'json',
            success: function (response) {
                $("#spinner").hide();
                if (!response.data || response.data == "") {
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                } else {
                    $("#resultsearch").html("");

                    let totalData = response.totalRecords
                    $("#totalData").html(totalData);
                    let totalPage = Math.floor(totalData/10) + (totalData%10?1:0);

                    let result = response.data
                    $("#total_nap").html($.number(result.total_nap, undefined, '.', ','));
                    $("#total_rut").html($.number(result.total_rut, undefined, '.', ','));
                    $("#total_doanhthu").html($.number(result.total_doanhthu, undefined, '.', ','));
                    stt = 1;
                    $.each(result.listData, function (index, value) {
                        result += resultSearchTransction(stt,value);
                        stt ++;
                    });
                    $('#logaction').html(result);
                    $('#pagination-demo').twbsPagination({
                        totalPages: totalPage,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            if(oldpage>0) {
                                $('#logaction').html("");
                                $("#spinner").show();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('agency/listUserOfAgencyajax')?>",
                                    data: {
                                        nick_name: $("#nick_name").val(),
                                        toDate: todate,
                                        fromDate: fromdate,
                                        referral_code: referral_code,
                                        doanh_thu: $("#doanh_thu").val(),
                                        page : page,
                                        maxItem: 10
                                    },
                                    dataType: 'json',
                                    success: function (response) {
                                        let result = response.data
                                        $("#spinner").hide();
                                        stt = (page - 1) * 10 + 1;
                                        $.each(result.listData, function (index, value) {
                                            result += resultSearchTransction(stt, value);
                                            stt++;
                                        });
                                        $('#logaction').html(result);
                                    }, error: function () {
                                        $('#logaction').html("");
                                        $("#spinner").hide();
                                        $("#error-popup").modal("show");
                                    }, timeout: 40000
                                });
                            }
                            oldpage = page;
                        }
                    });
                }
            }, error: function () {
                $('#logaction').html("");
                $("#spinner").hide();
                $("#error-popup").modal("show");
            }, timeout: 40000
        })
    });
    function resultSearchTransction(stt,value) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + value.nick_name + "</td>";
        rs += "<td>" + value.create_time + "</td>";
        rs += "<td>" + $.number(value.balance, undefined, '.', ',') + "</td>";
        rs += "<td>" + $.number(value.total_nap, undefined, '.', ',') + "</td>";
        rs += "<td>" + $.number(value.total_rut, undefined, '.', ',') + "</td>";
        rs += "<td>" + ( $.number(value.doanh_thu, undefined, '.', ',') || '-') + "</td>";
        rs += "<td class='option'>" +
            `<a href="<?php echo admin_url('agency/detailUserOfAgency')?>?nn=${value.nick_name}&<?= $redirectUri?>" style="color: blue"> Detail</a>` +
            "</td>";
        rs += "</tr>";
        return rs;
    }

</script>