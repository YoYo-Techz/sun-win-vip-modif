<?php $this->load->view('admin/admin/head', $this->data)?>
<div class="line"></div>
<div class="wrapper">
    <div class="widget">
        <div class="title">
            <h6>Decentralization of users</h6>
        </div>
        <form id="form" class="form" enctype="multipart/form-data" method="post" action="">
            <fieldset>
                <div class="formRow">
                    <?php echo $list ;?>
                </div>
                <div class="formSubmit">
                    <input type="submit" class="redB" value="Update">
                </div>
            </fieldset>
        </form>
    </div>
</div>

