    <?php //$this->load->view('admin/usergame/head', $this->data) ?>
    <!--<div class="line"></div>-->
    <?php //if ($role == false): ?>
    <!--    <div class="wrapper">-->
    <!--        <div class="widget">-->
    <!--            <div class="title">-->
    <!--                <h6>You are not authorized</h6>-->
    <!--            </div>-->
    <!--        </div>-->
    <!--    </div>-->
    <?php //else: ?>
    <!--    <div class="wrapper">-->
    <!--        --><?php //$this->load->view('admin/message', $this->data); ?>
    <!--        --><!--        <input type="hidden" id="listnickname" value="--><?php //echo $listnn ?><!--">-->
    <!---->
    <!--        <div class="widget">-->
    <!--            <div class="title">-->
    <!--                <h4>Khóa nhiều tài khoản <span style="color: #0000FF"></h4>-->
    <!--            </div>-->
    <!--            <input type="hidden" id="txtaction" value="">-->
    <!---->
    <!--            <div class="formRow">-->
    <!--                <div class="row">-->
    <!--                    <div class="col-sm-4"></div>-->
    <!--                    <label class="col-sm-4" style="color: red" id="errocode">--><?php //echo $error; ?>
    <!--                    </label>-->
    <!---->
    <!--                </div>-->
    <!--            </div>-->
    <!--            <div id="list_role">-->
    <!---->
    <!--                <div class="formRow">-->
    <!--                    <div class="row">-->
    <!--                        <div class="col-sm-1"></div>-->
    <!--                        <label class="col-sm-1" style="width: 154px"> Login is prohibited</label>-->
    <!---->
    <!--                        <div class="col-sm-1">-->
    <!--                            <input type="checkbox" name="role" value="0">-->
    <!--                        </div>-->
    <!--                        <label class="col-sm-1" style="width: 154px"> Rewards are prohibited</label>-->
    <!---->
    <!--                        <div class="col-sm-1">-->
    <!--                            <input type="checkbox" name="role" value="1">-->
    <!--                        </div>-->
    <!--                        <label class="col-sm-1" style="width: 154px"> Money transfer is prohibited</label>-->
    <!---->
    <!--                        <div class="col-sm-1">-->
    <!--                            <input type="checkbox" name="role" value="3">-->
    <!--                        </div>-->
    <!--                        <label class="col-sm-1" style="width: 154px">Reason lock</label>-->
    <!---->
    <!--                        <div class="col-sm-2">-->
    <!--                            <input type="text" id="txtlydo" class="form-control" placeholder="Enter the lock reason">-->
    <!--                        </div>-->
    <!--                    </div>-->
    <!--                </div>-->
    <!---->
    <!--            </div>-->
    <!--            <div class="formRow">-->
    <!--                <form action="--><?php //echo admin_url("usergame/lockalluser") ?><!--" id="fileinfo" name="fileinfo"-->
    <!--                      enctype="multipart/form-data" method="post">-->
    <!--                    <div class="row">-->
    <!--                        <div class="col-sm-1"></div>-->
    <!--                        <label class="col-sm-1 control-label" for="exampleInputEmail1">Account:</label>-->
    <!---->
    <!--                        <div class="col-sm-2">-->
    <!--                            <input type="file" id="userfile" name="filexls"-->
    <!--                                   value="--><?php //echo $this->input->post('filexls') ?><!--">-->
    <!--                        </div>-->
    <!--                        <div class="col-sm-1">-->
    <!--                            <input type="submit" class="btn btn-primary pull-left button blueB" id="upload"-->
    <!--                                   value="Upload" name="ok">-->
    <!--                        </div>-->
    <!--                </form>-->
    <!--                <div class="col-sm-1">Chức năng-->
    <!--                </div>-->
    <!--                <div class="col-sm-2"><select id="select_type">-->
    <!--                        <option value="1">Lock account</option>-->
    <!--                        <option value="0">Unlock account</option>-->
    <!--                    </select>-->
    <!--                </div>-->
    <!--                <div class="col-sm-1"><input type="button" id="openuser" value="Update" class="button blueB">-->
    <!--                </div>-->
    <!--            </div>-->
    <!---->
    <!--        </div>-->
    <!--        <div class="modal fade" id="bsModal3" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"-->
    <!--             aria-hidden="true">-->
    <!--            <div class="modal-dialog modal-sm">-->
    <!--                <div class="modal-content">-->
    <!--                    <div class="modal-header">-->
    <!--                    </div>-->
    <!--                    <div class="modal-body">-->
    <!--                        <p style="color: #0000ff">Bạn khóa tài khoản thành công</p>-->
    <!--                    </div>-->
    <!--                    <div class="modal-footer">-->
    <!--                        <input class="blueB logMeIn" type="button" value="Close" data-dismiss="modal" aria-hidden="true">-->
    <!--                    </div>-->
    <!--                </div>-->
    <!--            </div>-->
    <!--        </div>-->
    <!--    </div>-->
    <!--    </div>-->
    <?php //endif; ?>
    <!--<style>.spinner {-->
    <!--        position: fixed;-->
    <!--        top: 50%;-->
    <!--        left: 50%;-->
    <!--        margin-left: -50px; /* half width of the spinner gif */-->
    <!--        margin-top: -50px; /* half height of the spinner gif */-->
    <!--        text-align: center;-->
    <!--        z-index: 1234;-->
    <!--        overflow: auto;-->
    <!--        width: 100px; /* width of the spinner gif */-->
    <!--        height: 102px; /*hight of the spinner gif +2px to fix IE8 issue */-->
    <!--    }</style>-->
    <!--<div class="container">-->
    <!--    <div id="spinner" class="spinner" style="display:none;">-->
    <!--        <img id="img-spinner" src="--><?php //echo public_url('admin/images/gif-load.gif') ?><!--" alt="Loading"/>-->
    <!--    </div>-->
    <!--</div>-->
    <!--<script type="text/javascript">-->
    <!--    $(document).ready(function () {-->
    <!--    });-->
    <!---->
    <!--    $('#bsModal3').on('hidden.bs.modal', function () {-->
    <!--        location.reload();-->
    <!--    });-->
    <!--    $("#openuser").click(function () {-->
    <!--        var lst_role = [];-->
    <!--        var lst_role_txt = [];-->
    <!--        $.each($("input[name='role']:checked"), function () {-->
    <!--            lst_role.push($(this).val());-->
    <!--            lst_role_txt.push(getlockuser($(this).val()));-->
    <!--        });-->
    <!--        if ($("#txtlydo").val() == "") {-->
    <!--            alert("Bạn chưa Enter the lock reason");-->
    <!--            return false;-->
    <!--        }-->
    <!--        if (lst_role.length > 0) {-->
    <!--            $("#txtaction").val(lst_role_txt.join(','));-->
    <!--            if($("#listnickname").val() == ""){-->
    <!--                $("#errocode").html("Không tồn tại file hoặc key Nickname viết sai");-->
    <!--            }else {-->
    <!--                $("#spinner").show();-->
    <!--                $.ajax({-->
    <!--                    type: "POST",-->
    <!--                    url: "--><?php //echo admin_url('usergame/lockalluserajax')?>//",
    //                    data: {
    //                        nickname: $("#listnickname").val(),
    //                        action: lst_role.join(','),
    //                        type: $("#select_type").val(),
    //                        txtlydo: $("#txtlydo").val(),
    //                        txtaction: $("#txtaction").val()
    //
    //                    },
    //                    dataType: 'json',
    //                    success: function (res) {
    //                        $("#spinner").hide();
    //                        if (res.errorCode == 0) {
    //                            $("#bsModal3").modal("show");
    //                            if (res.nickName != null || res.nickName != "") {
    //                                $("#errocode").html("Nick name does not exist:" + (res.nickName));
    //                            }
    //                        } else if (res.errorCode == 10001) {
    //                            $("#errocode").html("Nick name does not exist:" + (res.nickName));
    //                        }
    //                    }, error: function () {
    //                        $("#spinner").hide();
    //                        $("#errocode").html("You cannot lock your account");
    //                    }
    //                });
    //            }
    //
    //        } else {
    //            $("#errocode").html("You must select the account lock function");
    //            return false;
    //        }
    //    });
    //
    //
    //    function getlockuser(count) {
    //        var strresult = "";
    //        switch (count) {
    //            case "0":
    //                strresult = "Login Prohibited";
    //                break;
    //            case "1":
    //                strresult = "Reward Redemption Prohibited";
    //                break;
    //            case "2":
    //                strresult = "Login sandbox";
    //                break;
    //            case "3":
    //                strresult = "Remittance Transfer Prohibited";
    //                break;
    //            case "8":
    //                strresult = "It is forbidden to play ginseng";
    //                break;
    //            case "9":
    //                strresult = "Playing three cards is prohibited";
    //                break;
    //            case "10":
    //                strresult = "Playing soldiers is prohibited";
    //                break;
    //            case "11":
    //                strresult = "Playing tlmn is prohibited";
    //                break;
    //            case "12":
    //                strresult = "It is forbidden to play gossip";
    //                break;
    //            case "13":
    //                strresult = "It is forbidden to play liêng";
    //                break;
    //            case "14":
    //                strresult = "Playing poker is prohibited";
    //                break;
    //            case "15":
    //                strresult = "Playing scratch cards is prohibited";
    //                break;
    //            case "16":
    //                strresult = "Playing shock jockey is prohibited";
    //                break;
    //            case "17":
    //                strresult = "Playing poker is prohibited";
    //                break;
    //        }
    //        return strresult;
    //    }
    //</script>
