<!-- head -->
<?php $this->load->view('admin/event/head', $this->data) ?>
<div class="line"></div>
<div class="wrapper">
    <div class="widget">
        <div class="title">
            <h6>Add free spins</h6>
        </div>
        <form method="post" action="" class="list_filter form">
            <fieldset>
                <div class="formRow">
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" id="param_name" style="width: 250px;"
                                                    placeholder="Enter account name"
                                                    value="<?php echo $this->input->post('name') ?>" name="name"></span>
                        <span class="autocheck" name="name_autocheck"></span>

                        <div class="submitdaily">
                            <input type="submit" value="Search" id="submit" class="button blueB"
                                   style="margin-left: -270px;">
                            <input type="reset"
                                   onclick="window.location.href = '<?php echo admin_url('event/addrotate') ?>'; "
                                   value="Reset" class="basic">
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </fieldset>
            <?php if ($this->input->post()) { ?>
                <?php if ($info == false) {
                    ?>
                    <div id="showinfo">
                        <div class="formRow">
                            <div class="formRight">
                                <label for="param_name" class="formLeft"><span class="req">Account does not exist</span></label>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div id="showinfo">
                        <div class="formRow">
                            <div class="formRight">
                                <label for="param_name"
                                       class="formLeft">Number of spins:<input type="text"  value="" id ="numadd" placeholder="You can only enter numbers" onkeypress="return isNumber1(event)" > </label>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div id="showinfo">
                        <div class="formRow">
                            <div class="formRight">
                                <label for="param_name"
                                       class="formLeft"> Nick name:  <input type="text" placeholder="You enter your nickname" id="addnickname" value="<?php echo $this->input->post('name')?>"> </label>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div id="showinfo">
                        <div class="formRow">
                            <div class="formRight">
                                <label for="param_name"
                                       class="formLeft">   <input type="button" class="button blueB" id="addrotate" value="Add new spins"> </label>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                <?php } else { ?>
                    <?php foreach ($info as $us): ?>
                        <div id="showinfo">
                            <div class="formRow">
                                <div class="formRight">
                                    <label for="param_name"
                                           class="formLeft">Number of spins:<input type="text"  value="" id="numupdate" placeholder="You can only enter numbers" onkeypress="return isNumber1(event)" > </label>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div id="showinfo">
                            <div class="formRow">
                                <div class="formRight">
                                    <label for="param_name"
                                           class="formLeft"> Nick name:  <input type="text" readonly id="updatenickname"  value="<?php echo $us->nick_name;?>"> </label>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div id="showinfo">
                            <div class="formRow">
                                <div class="formRight">
                                    <label for="param_name"
                                           class="formLeft">   <input type="button" class="button blueB" id="updaterotate" value="More spins"> </label>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    <?php endforeach; ?>
                <?php } ?>
            <?php } else { ?>
                <div id="showinfo" style="display: none">
                </div>

            <?php } ?>

            </fieldset>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#addrotate").click(function(){
            $.ajax({
                type: "POST",
                url: "<?php echo admin_url(); ?>" + "/event/insertrotate",
                dataType: 'json',
                data: {
                    nickname: $("#addnickname").val(),
                    numadd: $("#numadd").val()
                },
                success: function (response) {
                  alert(response);
                    location.reload();
                }
            });
        });
        $("#updaterotate").click(function(){
            $.ajax({
                type: "POST",
                url: "<?php echo admin_url(); ?>" + "/event/updaterotate",
                dataType: 'json',
                data: {
                    nickname: $("#updatenickname").val(),
                    numupdate: $("#numupdate").val()
                },
                success: function (response) {
                    alert(response);
                    location.reload();

                }
            });
        });

    });
    function isNumber1(evt) {
        evt = (evt) ? evt : window.event;
        var charCode = (evt.which) ? evt.which : evt.keyCode;
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            return false;
        }
        return true;
    }
</script>