<?php if($role == false): ?>
    <section class="content-header">
        <h1>
            You are not authorized yet
        </h1>
    </section>
<?php else: ?>
<section class="content-header">
    <h1>
        Giftcode statistics đã dùng theo Source vận hành
    </h1>

</section>
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-body">
                    <h4 id="resultsearch" style="color: red"></h4>
                    <div class="form-group">
                        <div class="row">
                            <label class="col-sm-1 control-label" for="exampleInputEmail1">Money</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="money" name="money">
                                    <option value="1">Win</option>
                                    <option value="0">Coin</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">Source xuất:</label>

                            <div class="col-sm-2">
                                <select id="nguonxuat" class="form-control">
                                    <option value="">Select</option>
                                    <?php foreach($source as $row): ?>
                                        <option value="<?php echo $row->key ?>"><?php echo $row->name ?></option>
                                    <?php endforeach; ?>

                                </select>
                            </div>
                            <label id="labelvin" class="col-sm-1 control-label">Tìm theo</label>

                            <div class="col-sm-2">
                                <select name="filterdate" class="form-control" id="filterdate">
                                    <option value="1" <?php if ($this->input->post("filterdate") == "1") {echo "selected";} ?>>Date created</option>
                                    <option value="2" <?php if ($this->input->post("filterdate") == "2") {echo "selected";} ?>>Date of use</option>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label" for="exampleInputEmail1">Khóa giftcode</label>
                            <div class="col-sm-2">
                                <select name="blockgc" class="form-control" id="blockgc">
                                    <option value="0" <?php if ($this->input->post("blockgc") == "0") {echo "selected";} ?>>Chưa khóa</option>
                                    <option value="1" <?php if ($this->input->post("blockgc") == "1") {echo "selected";} ?>>Đang khóa</option>
                                </select>
                            </div>

                        </div>

                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label class="col-sm-1 control-label">Since:</label>
                            <div class="col-sm-2">
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" class="form-control" id="fromDate"> <span
                                        class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                                </div>
                            </div>
                            <label class="col-sm-1 control-label">To date:</label>

                            <div class="col-sm-2">
                                <div class="input-group date" id="datetimepicker2">
                                    <input type="text" class="form-control" id="toDate"> <span
                                        class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
</span>
                                </div>
                            </div>
                            <div class="col-sm-1"><input type="button" value="Search" name="submit"
                                                         class="btn btn-primary pull-right" id="search_tran"></div>
                            <div class="col-sm-1"><input type="reset" value="Reset" name="submit"
                                                         class="btn btn-primary pull-left" id="reset"  onclick="window.location.href = '<?php echo admin_url('giftcodevh/nicknameusegiftcodevh') ?>'; "></div>
                            </div>
                        </div>
                    <div class="col-sm-12">
                        <table id="example2" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Nick name</th>
                                <th>Giftcode</th>
                                <th>Revenue</th>
                                <th>Waste</th>
                            </tr>
                            </thead>
                            <tbody id="logaction">

                            </tbody>
                        </table>

                        <div id="spinner" class="spinner" style="display:none;">
                            <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
                        </div>
                        <div class="text-center pull-right">
                            <ul id="pagination-demo" class="pagination-sm"></ul>
                        </div>
                    </div>                </div>
            </div>
        </div>
    </div>
</section>
<?php endif; ?>
<style>
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
    }

</style>
<script>

    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss'
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss'
        });
    });
    $("#search_tran").click(function () {
        if($("#nguonxuat").val() == ""){
            alert('Bạn chưa chọn Source xuất');
            return false;
        }
        var fromDatetime = $("#fromDate").val();
        var toDatetime = $("#toDate").val();
        if (fromDatetime > toDatetime) {
            alert('The end date must be greater than the start date')
            return false;
        }
        var result = "";
        var oldpage = 0;
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url("giftcodevh/nicknameusegiftcodevhajax") ?>",
            data: {
                nguonxuat : $("#nguonxuat").val(),
                fromDate: $("#fromDate").val(),
                toDate: $("#toDate").val(),
                money: $("#money").val(),
                pages : 1,
                filterdate: $("#filterdate").val(),
                block : $("#blockgc").val()
            },
            dataType: 'json',
            success: function (result) {
                $("#spinner").hide();
                $.each(result.transactions, function (index, value) {
                    if(value.giftCodeUse == ""){
                        $("#resultsearch").html("No results were found");
                        $('#logaction').html("");
                    }else{
                        $("#resultsearch").html("");
                        var nickname = value.nickName.split(",");
                        var giftcode = value.giftCodeUse.split(",");
                        var totalmoney = value.totalMoney.split(",");
                        var fee       = value.fee.split(",");
                        stt = 1;
                        for(i=0; i < nickname.length-1 ;i++){
                            result += resultgiftcodevin(stt,nickname[i],giftcode[i],totalmoney[i],fee[i])
                            stt ++;
                        }
                        $('#logaction').html(result);

                        $('#pagination-demo').twbsPagination({
                            totalPages: 1000,
                            visiblePages: 5,
                            onPageClick: function (event, page) {
                                if (oldpage > 0) {
                                    $("#spinner").show();
                                    $.ajax({
                                        type: "POST",
                                        url: "<?php echo admin_url("giftcodevh/nicknameusegiftcodevhajax") ?>",
                                        data: {
                                            nguonxuat : $("#nguonxuat").val(),
                                            fromDate: $("#fromDate").val(),
                                            toDate: $("#toDate").val(),
                                            money: $("#money").val(),
                                            pages : page,
                                            filterdate: $("#filterdate").val(),
                                            block : $("#blockgc").val()
                                        },
                                        dataType: 'json',
                                        success: function (result) {
                                            $("#spinner").hide();
                                            $.each(result.transactions, function (index, value) {
                                            var nickname = value.nickName.split(",");
                                            var giftcode = value.giftCodeUse.split(",");
                                            var totalmoney = value.totalMoney.split(",");
                                            var fee       = value.fee.split(",");
                                            stt = 1;
                                            for(i=0; i < nickname.length-1 ;i++){
                                                result += resultgiftcodevin(stt,nickname[i],giftcode[i],totalmoney[i],fee[i])
                                                stt ++;
                                            }
                                            $('#logaction').html(result);
                                            });
                                        }

                                    });
                                }
                                oldpage = page;
                            }
                        });

                    }
                });
            }
        });
    });
    function resultgiftcodevin(stt,nickname,giftcode,totalMoney,fee) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + nickname + "</td>";
        rs += "<td>" + giftcode + "</td>";
        rs += "<td>" + commaSeparateNumber(totalMoney) + "</td>";
        rs += "<td>" + commaSeparateNumber(fee) + "</td>";
        rs += "</tr>";
        return rs;
    }

    function commaSeparateNumber(val) {
        while (/(\d+)(\d{3})/.test(val.toString())) {
            val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
        }
        return val;
    }
</script>
