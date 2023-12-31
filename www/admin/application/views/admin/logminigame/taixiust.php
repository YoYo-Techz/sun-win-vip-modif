<div class="titleArea">
    <div class="wrapper">
        <div class="pageTitle">
            <h5>Log mini game</h5>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="line"></div>
<div class="wrapper">
    <?php $this->load->view('admin/message', $this->data); ?>

    <div class="widget backaccount">
        <div class="title">
            <h6>Over/under siêu tốc</h6>
        </div>

        <form class="list_filter form" action="<?= admin_url('logminigame/taixiust') ?>" method="post">
            <div class="formRow row">
                <div class="col-sm-1">
                    <label for="giftCode">Since : </label>
                </div>
                <div class="col-sm-2">
                    <div class="input-group" id="frompicker">
                        <input type="text" id="fromDate" name="ft" value="<?php echo $this->input->post('ft') ?>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
                <div class="col-sm-1">
                    <label for="giftCode">To date : </label>
                </div>
                <div class="col-sm-2">
                    <div class="input-group" id="topicker">
                        <input type="text" id="toDate" name="et" value="<?php echo $this->input->post('et') ?>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
            <div class="formRow row">
                <div class="col-sm-1">
                    <label for="giftCode">Status : </label>
                </div>
                <div class="col-sm-2">
                    <select id="st" name="st" class="money-type-2">
                        <option value="" <?php if($this->input->post('st') == ""){echo "selected";} ?>>Select</option>
                        <option value="1" <?php if($this->input->post('st') == "1"){echo "selected";} ?>>Active</option>
                        <option value="0" <?php if($this->input->post('st') == "0"){echo "selected";} ?>>Deactive</option>
                    </select>
                </div>
            </div>
            <div class="formRow row">
                <div class="col-sm-1">
                    <input type="submit" id="search_tran" value="Search" class="button blueB">
                </div>
                <div class="col-sm-1">
                    <input type="reset" onclick="window.location.href = '<?php echo admin_url('logminigame/taixiust') ?>';" value="Reset" class="basic">
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-sm-12">
                <h3 class="float-right">Total records:<span style="color:#0000ff" id="total"></span></h3>
            </div>
            <div class="col-sm-12">
                <div id="resultsearch" class="float-left text-danger"></div>
            </div>
        </div>
        <div class="formRow">
            <div class="row">
                <div class="col-xs-12">
                    <table id="checkAll" class="table table-bordered" style="table-layout: fixed">
                        <thead>
                        <tr style="height: 20px;">
                            <th style="width:40px">No</th>
                            <th>id</th>
                            <th>Time bắt đầu</th>
                            <th>Time kết thúc</th>
                            <th>Status</th>
                            <th>Kết quả</th>
                            <th>Amount of money</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="logaction">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div id="spinner" class="spinner" style="display:none;">
        <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
    </div>
    <div class="text-center">
        <ul id="pagination-demo" class="pagination-lg"></ul>
    </div>
</div>
<script>
    var page_size = '<?php echo $this->input->post('page_size') ?>' || 10
    var list_data =[]
    $(document).ready(function () {
        var startDate = $('#fromDate').val();
        var endDate = $('#toDate').val();
        if (startDate > endDate) {
            alert("Day bắt đầu lớn hơn Day kết thúc.");
        }
        initData();
    })

    function resultList(stt, value) {
        var rs = "";
        rs += "<tr>";
        rs += "<td class='stt'>" + stt + "</td>";
        rs += "<td>" + value.id + "</td>";
        rs += "<td>" + value.openTime + "</td>";
        rs += "<td>" + value.endTime + "</td>";
        rs += "<td>" + value.status + "</td>";
        rs += "<td>" + value.result + "</td>";
        rs += "<td>" + value.resultAmount + "</td>";
        rs += "<td>" + '<a href="<?= admin_url('logminigame/taixiustDetail')?>?rid='+value.id+'">Detail</a>' + "</td>";
        return rs;
    }

    function initData() {
        var oldPage = 0;
        $('#pagination-demo').css("display", "block");
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('logminigame/taixiustAjax')?>",
            data: {
                et: $('#toDate').val(),
                ft: $('#fromDate').val(),
                st: $('#st').val(),
                pg : 1,
                mi: page_size
            },
            dataType: 'json',
            success: function (response) {
                let result = response
                result.total = response.totalRecords
                $("#total").html(result.total);
                $("#spinner").hide();

                if (result.data == undefined) {
                    list_data = []
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                    return;
                }

                list_data = result.data
                $("#resultsearch").html("");
                let totalPage = Math.floor(result.total/page_size) + (result.total%page_size?1:0);
                stt = 1;
                let str = ''
                $.each(result.data, function (index, value) {
                    str += resultList(stt, value);
                    stt++;
                });
                $('#logaction').html(str);

                $('#pagination-demo').twbsPagination({
                    totalPages: totalPage,
                    visiblePages: 5,
                    onPageClick: function (event, page) {
                        if (oldPage > 0) {
                            $("#spinner").show();
                            $.ajax({
                                type: "POST",
                                url: "<?php echo admin_url('logminigame/taixiustAjax')?>",
                                data: {
                                    et: $('#toDate').val(),
                                    ft: $('#fromDate').val(),
                                    st: $('#st').val(),
                                    pg : page,
                                    mi: page_size
                                },
                                dataType: 'json',
                                success: function (response) {
                                    let result = response
                                    list_data = result.data
                                    $("#resultsearch").html("");
                                    $("#spinner").hide();
                                    stt = (page -1) * page_size + 1;
                                    let str = ''
                                    $.each(result.data, function (index, value) {
                                        str += resultList(stt, value);
                                        stt++;
                                    });
                                    $('#logaction').html(str);
                                }, error: function () {
                                    list_data = []
                                    $("#spinner").hide();
                                    $('#logaction').html("");
                                    $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
                                },timeout : 20000
                            });
                        }
                        oldPage = page;
                    }
                });
            }, error: function () {
                list_data = []
                $("#spinner").hide();
                $('#logaction').html("");
                $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
            },timeout : 20000
        })

    };
</script>
<script>
    $('#frompicker').datetimepicker({
        format: 'YYYY-MM-DD',
        defaultDate: "<?= date('Y-m-d')?>"
    });
    $('#topicker').datetimepicker({
        format: 'YYYY-MM-DD',
        defaultDate: "<?= date('Y-m-d')?>"
    });
</script>
