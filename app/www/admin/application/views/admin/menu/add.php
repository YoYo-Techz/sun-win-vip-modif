<!-- head -->
<?php $this->load->view('admin/menu/head', $this->data) ?>
<div class="line"></div>
<div class="wrapper">
    <div class="widget">
        <div class="title">
            <h6>Add new menu</h6>
        </div>
        <form id="form" class="form" enctype="multipart/form-data" method="post" action="">
            <fieldset>
                <div class="formRow">
                    <label for="param_name" class="formLeft">Name:<span class="req">*</span></label>
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" id="param_name" value="<?php echo set_value('name') ?>" name="name"></span>
                        <span class="autocheck" name="name_autocheck"></span>
                        <div class="clear error" name="name_error"><?php echo form_error('name') ?></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Numerical order:<span class="req">*</span></label>
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" value="<?php echo set_value('param') ?>" id="param_param" name="param"></span>
                        <span class="autocheck" name="name_autocheck"></span>
                        <div class="clear error" name="name_error"><?php echo form_error('param') ?></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Path:<span class="req">*</span></label>
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" value="<?php echo set_value('link') ?>" id="param_link" name="link"></span>
                        <span class="autocheck" name="name_autocheck"></span>
                        <div class="clear error" name="name_error"><?php echo form_error('link') ?></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Parent category:<span class="req">*</span></label>
                    <div class="formRight">
                        <?php echo $list; ?>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Account:<span class="req">*</span></label>
                    <div class="formRight">
                        <span style="width: 150px;float: left">
                            <input type="checkbox" id="tkthuong" name="isThuong" value="0"> Regular account
                             <input type="hidden" name="displaytkthuong" id="displaytkthuong" value="">
                        </span>
                        <span style="width: 150px;float: left">
                            <input type="checkbox" id="tksuper" name="isSuper" value="0"> Super Admin
                             <input type="hidden" name="displaytksuper" id="displaytksuper" value="">
                        </span>
                        <span class="autocheck" name="name_autocheck"></span>
                        <div class="clear error" name="name_error"><?php echo form_error('isSuper') ?></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Display:<span class="req">*</span></label>
                    <div class="formRight">
                        <span style="width: 150px;float: left">
                            <input type="checkbox" id="status" name="Status" checked="checked">
                        </span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formSubmit">
                    <input type="submit" class="redB" value="Add new">
                </div>
            </fieldset>
        </form>

    </div>
</div>
<script>
    $( document ).ready(function() {
        $("#displaytkthuong").val($('#tkthuong').val());
        $("#displaytksuper").val($('#tksuper').val());
    });
    $('#tkthuong').on('change', function(){
        this.value = this.checked ? 1 : 0;
        $("#displaytkthuong").val(this.value);
    }).change();
    $('#tksuper').on('change', function(){
        this.value = this.checked ? 1 : 0;
        $("#displaytksuper").val(this.value);
    }).change();
</script>