<div class="titleArea">
    <div class="wrapper">
        <div class="pageTitle">
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="line"></div>
<?php if ($role == false): ?>
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

        
        

        
        
        
        <script
            src="<?php echo public_url() ?>/site/bootstrap/bootstrap-datetimepicker.min.js"></script>
        <div class="widget">
            <h4 id="resultsearch" style="color: red;margin-left: 20px"></h4>

            <div class="title">
                <h6>Log to change Phone number</h6>
            </div>
            <form class="list_filter form" action="<?php echo admin_url('usergame/logchangemobile') ?>" method="post">

                <div class="formRow">

                    <table>
                        <tr>

                            <td><label style="margin-left: 48px;margin-bottom:-2px;width: 140px">New Phone number:</label></td>
                            <td><input type="text" style="margin-left: 20px;margin-bottom:-2px;width: 150px"
                                       id="txtmobienew" value="<?php echo $this->input->post('txtmobienew') ?>"
                                       name="txtmobienew"></td>
                            <td><label style="margin-left: 30px;margin-bottom:-2px;width: 140px">Old Phone number:</label></td>
                            <td><input type="text" style="margin-left: 20px;margin-bottom:-2px;width: 150px"
                                       id="txtmobieold" value="<?php echo $this->input->post('txtmobieold') ?>"
                                       name="txtmobieold"></td>
                        </tr>

                    </table>

                </div>
                <div class="formRow">

                    <table>
                        <tr>
                            <td><label style="margin-left: 48px;margin-bottom:-2px;width: 140px">Nick name:</label></td>
                            <td><input type="text" style="margin-left: 20px;margin-bottom:-2px;width: 150px"
                                       id="txtnickname" value="<?php echo $this->input->post('txtnickname') ?>"
                                       name="txtnickname"></td>
                            <td style="">
                                <input type="submit" id="search_tran" value="Search" class="button blueB"
                                       style="margin-left: 30px">
                            </td>
                            <td>
                                <input type="reset"
                                       onclick="window.location.href = '<?php echo admin_url('usergame/logchangemobile') ?>'; "
                                       value="Reset" class="basic" style="margin-left: 20px">
                            </td>

                        </tr>
                    </table>
                </div>
                <div class="formRow">
                </div>
            </form>
            <div class="formRow"></div>
            <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
                <thead>
                <tr style="height: 20px;">
                    <td>No</td>
                    <td>Nickname</td>
                    <td>New Phone number</td>
                    <td>Old Phone number cũ</td>
                    <td>Update time</td>
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
<div class="container">
    <div id="spinner" class="spinner" style="display:none;">
        <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
    </div>
    <div class="text-center">
        <ul id="pagination-demo" class="pagination-lg"></ul>
    </div>

</div>
<script>
    function resultSearchTransction(stt, nickname,mobilenew,mobileold,datetime) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + nickname + "</td>";
        rs += "<td>" + mobilenew + "</td>";
        rs += "<td>" + mobileold + "</td>";
        rs += "<td>" + datetime + "</td>";
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
            url: "<?php echo admin_url('usergame/logchangemobileajax')?>",
            data: {
                nickname: $("#txtnickname").val(),
                mobilenew: $("#txtmobienew").val(),
                mobileold: $("#txtmobieold").val(),
                pages: 1

            },

            dataType: 'json',
            success: function (result) {
                $("#spinner").hide();
                if (result.transactions == "") {
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                } else {
                    $("#resultsearch").html("");
                    var totalPage = result.total;
                    stt = 1;
                    $.each(result.transactions, function (index, value) {
                        result += resultSearchTransction(stt, value.nickName,value.mobile,value.mobileold,value.updateTime);
                        stt++;

                    });
                    $('#logaction').html(result);
                    $('#pagination-demo').twbsPagination({
                        totalPages: totalPage,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            if (oldPage > 0) {
                                $("#spinner").show();
                                $.ajax({
                                    type: "POST",
                                    url: "<?php echo admin_url('usergame/logchangemobileajax')?>",
                                    data: {
                                        nickname: $("#txtnickname").val(),
                                        mobilenew: $("#txtmobienew").val(),
                                        mobileold: $("#txtmobieold").val(),
                                        pages: page
                                    },
                                    dataType: 'json',
                                    success: function (result) {
                                        $("#resultsearch").html("");
                                        $("#spinner").hide();
                                        stt = 1;
                                        $.each(result.transactions, function (index, value) {
                                            result += resultSearchTransction(stt, value.nickName,value.mobile,value.mobileold,value.updateTime);
                                            stt++;

                                        });
                                        $('#logaction').html(result);
                                    }, error: function () {
                                        $("#spinner").hide();
                                        $('#logaction').html("");
                                        $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
                                    }, timeout: 20000
                                });
                            }
                            oldPage = page;
                        }
                    });
                }
            }, error: function () {
                $("#spinner").hide();
                $('#logaction').html("");
                $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
            }, timeout: 20000
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
</script>