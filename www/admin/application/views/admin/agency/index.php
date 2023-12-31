<!-- head -->
<?php $this->load->view('admin/agency/head', $this->data) ?>
<div class="line"></div>
<div class="wrapper">
    <?php $this->load->view('admin/message', $this->data); ?>
    <div class="widget">
        <?php if($status == "D") : ?>
        <div class="title">
            <h6>List of affiliated level 2 agents</h6>
        </div>
        <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
            <thead class="filter">

            </thead>
            <thead>
            <tr>
                <td style="width:80px;">No</td>
                <td>Nick name</td>
                <td>Mail</td>
                <td>Phone number</td>
                <td>Transaction</td>
                <td style="width:100px;">Act</td>
            </tr>
            </thead>
            <tbody>
            <?php $i = 1; ?>
            <?php foreach ($list2 as $row): ?>
                <tr>
                    <td class="textC"><?php echo $i; ?></td>
                    <td><span title="<?php echo $row->FullName ?>" class="tipS">
							  <a href="<?php echo admin_url('agency/listtranferdaily/' . $row->FullName) ?>" style="color: #37ca1e">
                                  <?php echo $row->FullName ?>
                              </a>
						</span></td>
                    <td><span title="<?php echo $row->Email ?>" class="tipS">
							<?php echo $row->Email ?>
						</span></td>
                    <td><span title="<?php echo $row->Phone ?>" class="tipS">
							<?php echo $row->Phone ?>
						</span></td>
                    <td class="option">
                        <a href="<?php echo admin_url('agency/doanhso/' . $row->FullName) ?>">
                            Detail
                        </a>
                    </td>
                    <td class="option">
                        <a href="<?php echo admin_url('agency/delete/' . $row->ID) ?>" title="Erase"
                           class="tipS verify_action">
                            <img src="<?php echo public_url('admin') ?>/images/icons/color/delete.png"/>
                        </a>
                    </td>
                </tr>
                <?php $i++; ?>
            <?php endforeach; ?>
            </tbody>
        </table>
        <?php else: ?>
        <div class="title">
            <h6>List of level 1 agents</h6>
        </div>
        <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
            <thead class="filter">

            </thead>
            <thead>
            <tr>
                <td style="width:80px;">No</td>
                <td>Nick name</td>
                <td>Name of agent</td>
                <td>Address</td>
                <td>Phone number</td>
                <td>Transaction</td>
                <td>Act</td>

            </tr>
            </thead>
            <tbody>
            <?php $i = 1; ?>
            <?php foreach ($list1 as $row): ?>
                <tr>
                    <td class="textC"><?php echo $i; ?></td>
                    <td><span title="<?php echo $row->FullName ?>" class="tipS">
							  <a href="<?php echo admin_url('agency/listtranferdaily/' . $row->FullName) ?>" style="color: #37ca1e">
                                  <?php echo $row->FullName ?>
                              </a>
						</span></td>
                    <td><span title="<?php echo $row->NameAgent ?>" class="tipS">
							<?php echo $row->NameAgent ?>
						</span></td>
                    <td><span title="<?php echo $row->Address ?>" class="tipS">
							<?php echo $row->Address ?>
						</span></td>
                    <td><span title="<?php echo $row->Phone ?>" class="tipS">
							<?php echo $row->Phone ?>
						</span></td>
                    <td class="option">
                        <a href="<?php echo admin_url('agency/doanhso/' . $row->FullName) ?>">
                            Detail
                        </a>
                    </td>
                    <td class="option">
                        <a href="<?php echo admin_url('agency/delete/' . $row->ID) ?>" title="Erase"
                           class="tipS verify_action">
                            <img src="<?php echo public_url('admin') ?>/images/icons/color/delete.png"/>
                        </a>
                        <a href="<?php echo admin_url('agency/editinfo/' . $row->ID) ?>" title="Edit"
                           class="tipS">
                            <img src="<?php echo public_url('admin') ?>/images/icons/color/edit.png"/>
                        </a>
                    </td>
                </tr>
                <?php $i++; ?>
            <?php endforeach; ?>
            </tbody>
        </table>
        <?php endif; ?>
    </div>
    <div class="pagination">

    </div>
</div>
<div class="clear mt30"></div>

