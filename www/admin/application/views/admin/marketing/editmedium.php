<!-- head -->
<?php $this->load->view('admin/marketing/head', $this->data) ?>
<div class="line"></div>
<div class="wrapper">
    <div class="widget">
        <div class="title">
            <h6>Update medium</h6>
        </div>
        <form id="form" class="form" enctype="multipart/form-data" method="post" action="">
            <fieldset>
                <div class="formRow">
                    <label for="param_username" class="formLeft">Name utm_medium request:<span class="req">*</span></label>
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" value="<?php echo $info->name ?>"   name="name"></span>
                        <span class="autocheck" name="name_autocheck"></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="param_name" class="formLeft">Name utm_medium Display::<span class="req">*</span></label>
                    <div class="formRight">
                        <span class="oneTwo"><input type="text" _autocheck="true" id="param_name" value="<?php echo $info->name_display ?>"  name="display_name"></span>
                        <div class="clear error" name="name_error"><?php echo form_error('name') ?></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="formSubmit">
                    <input type="submit" class="redB" value="Update">
                </div>
            </fieldset>
        </form>
    </div>
</div>
