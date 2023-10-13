<?php if ($role == false): ?>
    <section class="content-header">
        <h1>
            You are not authorized yet
        </h1>
    </section>
<?php else: ?>
    <section class="content-header">
        <h1>
            Add money to multiple accounts
        </h1>
    </section>
    <input type="hidden" id="listnickname" value='<?php echo $listnn ?>'>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-3">
                                </div>
                                <label class="col-sm-4" style="color: red;word-break: break-all"
                                       id="errorcode"><?php echo $error; ?>
                                </label>
                            </div>
                        </div>
                        <form action="<?php echo base_url("user/congtientaixiu") ?>" id="fileinfo" name="fileinfo"
                              enctype="multipart/form-data" method="post">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-2">
                                    </div>
                                    <label class="col-sm-2 control-label" for="exampleInputEmail1">Account:</label>

                                    <div class="col-sm-2">
                                        <input type="file" id="userfile" name="filexls"
                                               value="<?php echo $this->input->post('filexls') ?>">
                                    </div>
                                    <div class="col-sm-1">
                                        <input type="submit" class="btn btn-primary pull-left" id="upload"
                                               value="Upload"
                                               name="ok">

                                    </div>
                                </div>
                            </div>
                        </form>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-2">
                                </div>
                                <label class="col-sm-2 control-label">Reason:</label>

                                <div class="col-sm-2">
                                    <input id="txtlydo" type="text" class="form-control"
                                           placeholder="Enter the reason for Add money">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-2">
                                </div>
                                <label class="col-sm-2 control-label">Type of money:</label>

                                <div class="col-sm-2">
                                    <select class="form-control" id="typemoney">
                                        <option value="vin">Win</option>
                                        <option value="xu">Coin</option>
                                    </select>
                                </div>
                            </div>
                        </div>
						<div class="form-group">
                            <div class="row">
                                <div class="col-sm-2">
                                </div>
                                <label class="col-sm-2 control-label">Act:</label>

                                <div class="col-sm-2">
                                    <select class="form-control" id="typeaction">
                                        <option value="Admin">Over/under refund</option>
                                        <option value="EventVP">Pay vippoint event rewards</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <?php if($this->session->userdata('isMobileSecure') == 1) { ?>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-2">
                                </div>
                                <label class="col-sm-2 control-label">OTP:</label>

                                <div class="col-sm-1">
                                    <input id="txtotp" type="text" class="form-control" placeholder="Import OTP">
                                </div>
                                <div class="col-sm-1">
                                    <select id="typeotp" class="form-control">
                                        <option value="0">OTP SMS</option>
                                        <option value="1">OTP APP</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <?php } ?>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-1"><input type="button" value="Add money" name="submit"
                                                             class="btn btn-primary pull-left" id="congtien"></div>

                            </div>
                        </div>
                        <div class="modal fade" id="bsModal3" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-header">
                                    </div>
                                    <div class="modal-body">
                                        <p style="color: #0000ff">You successfully added money</p>
                                    </div>
                                    <div class="modal-footer">
                                        <input class="blueB logMeIn" type="button" value="Close" data-dismiss="modal"
                                               aria-hidden="true">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Nickname</th>
                                    <th>Money</th>
                                    <th>Account</th>
                                    <th>Error code</th>
                                </tr>
                                </thead>
                                <tbody id="logaction">

                                </tbody>
                            </table>

                            <div id="spinner" class="spinner" style="display:none;">
                                <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>"
                                     alt="Loading"/>
                            </div>
                            <div class="text-center pull-right">
                                <ul id="pagination-demo" class="pagination-lg"></ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<?php endif; ?>
<div id="spinner" class="spinner" style="display:none;">
    <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
</div>
<style>.spinner {
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
    }</style><script>
    $("#congtien").click(function () {
        if ($("#txtlydo").val() == "") {
            $("#errorcode").html("You have not entered a reason for adding money");
            return false;
        }

        if ($("#txtotp").val() == "") {
            $("#errorcode").html("You have not entered the OTP code");
            return false;
        }
        if ($("#listnickname").val() == "") {
            $("#errorcode").html("No file or key Nickname exists, Money is spelled incorrectly");
        } else {
            $("#spinner").show();
            var result = "";
            $.ajax({
                type: "POST",
                url: "<?php echo base_url('user/congtientaixiuajax')?>",
                data: {
                    nickname: $("#listnickname").val(),
                    money: $("#typemoney").val(),
                    otp: $("#txtotp").val(),
                    lydo: $("#txtlydo").val(),
                    typeotp: $("#typeotp").val(),
					 action : $("#typeaction").val()
                },
                dataType: 'json',
                success: function (res) {
                    $("#spinner").hide();
                    if (res.errorCode == 0) {
                        $("#bsModal3").modal("show");
                        $("#errorcode").html("");
                        $("#txtlydo").val("");
                        $("#txtotp").val("");
						
                        stt = 1;
                        $.each(res.listResponse, function (index, value) {
                            result += resultrespone(stt, value.nickname, value.money, value.isBot, value.errorCode);
                            stt++;
                        });
                        $('#logaction').html(result);

                        $("#example2").table2excel({
                            exclude: ".noExl",
                            name: "Excel Document Name",
                            filename: "listuser",
                            fileext: ".xls",
                            exclude_img: true,
                            exclude_links: true,
                            exclude_inputs: true
                        });

                    } else if (res.errorCode == 1001) {
                        $("#errorcode").html("Add money failed");
                    }
                    else if (res.errorCode == 1008) {
                        $("#errorcode").html("OTP is wrong");
                    }
                    else if (res.errorCode == 1021) {
                        $("#errorcode").html("OTP is wrong");
                    }

                }, error: function () {
                    $("#spinner").hide();
                    $("#errorcode").html("Spy system. Please try again later");
                }
            });
        }
    });
	 $('#bsModal3').on('hidden.bs.modal', function () {
        window.location.href = '<?php echo base_url("user/congtientaixiu") ?>';
    });
    function resultrespone(stt,nickname,money,isbot,error) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + nickname + "</td>";
        rs += "<td>" + commaSeparateNumber(money) + "</td>";
        if (isbot == true) {
            rs += "<td>" + "Bot" + "</td>";
        } else if (isbot == false) {
            rs += "<td>" + "Often" + "</td>";
        }
        rs += "<td>" + kqresult(error) + "</td>";

        rs += "</tr>";
        return rs;
    }

    function commaSeparateNumber(val) {
        while (/(\d+)(\d{3})/.test(val.toString())) {
            val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
        }
        return val;
    }

function kqresult(error){
    var str = "";
    if (error == 0) {
        str = "Success";
    } else if (error == 1001) {
        str = "Failure";
    }
    else if (error == 1002) {
        str = "Account does not have enough money";
    }
    else if (error == 2001) {
        str = "Nickname does not exist";
    }
    else  {
        str = "Other error";
    }
    return str;
}
</script>
