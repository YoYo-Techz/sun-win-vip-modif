<div class="titleArea">
    <div class="wrapper">
        <div class="pageTitle">
            <h5>List nạp rút</h5>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="line"></div>
<div class="wrapper">
    <?php $this->load->view('admin/message', $this->data); ?>

    <div class="widget backaccount">
        <form class="list_filter form" action="<?php echo admin_url('userAgency/transaction') ?>" method="post">
            <div class="formRow row">
                <div class="col-sm-1">
                    <label for="giftCode">Dealer code: </label>
                </div>
                <div class="col-sm-2">
                    <input type="text" id="key" value="<?php echo $this->input->post('key') ?>" name="key">
                </div>

                <div class="col-sm-1">
                    <label for="giftCode">Amount of money : </label>
                </div>
                <div class="col-sm-2">
                    <input type="text" id="m" value="<?php echo $this->input->post('m') ?>" name="m">
                </div>
                <div class="col-sm-1">
                    <label for="giftCode">Account Source : </label>
                </div>
                <div class="col-sm-2">
                    <input type="text" id="fbn" value="<?php echo $this->input->post('fbn') ?>" name="fbn">
                </div>
                <div class="col-sm-1">
                    <label for="giftCode">Account đích : </label>
                </div>
                <div class="col-sm-2">
                    <input type="text" id="tbn" value="<?php echo $this->input->post('tbn') ?>" name="tbn">
                </div>
            </div>
            <div class="formRow row">
                <div class="col-sm-1">
                    <input type="submit" id="search_tran" value="Search" class="button blueB">
                </div>
                <div class="col-sm-1">
                    <input type="reset" onclick="window.location.href = '<?= admin_url('userAgency/transaction') ?>';" value="Reset" class="basic">
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
                            <tr>
                                <th>No</th>
                                <th>People dùng</th>
                                <th>Mã đại lý</th>
                                <th>Point</th>
                                <th>Amount of money</th>
                                <th>Fee</th>
                                <th>Bonus</th>
                                <th>Status</th>
                                <th>Account Source</th>
                                <th>Account đích</th>
                                <th>Nội dung</th>
                                <th>People approved</th>
                                <th>Describe</th>
                                <th>Time yêu cầu</th>
                                <th>Act</th>
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
    $(document).ready(function (){
        initData()
    })
    function resultList(stt, value) {
        var rs = "";
        rs += "<tr>";
        rs += "<td>" + stt + "</td>";
        rs += "<td>" + value.Username + "</td>";
        rs += "<td>" + value.AgentCode + "</td>";
        rs += "<td>" + value.Point + "</td>";
        rs += "<td>" + value.Money + "</td>";
        rs += "<td>" + value.Fee + "</td>";
        rs += "<td>" + value.Bonus + "</td>";
        rs += "<td>" + value.Status + "</td>";
        rs += "<td>" + value.FromBankNumber + "</td>";
        rs += "<td>" + value.ToBankNumber + "</td>";
        rs += "<td>" + value.Content + "</td>";
        rs += "<td>" + value.UserApprove + "</td>";
        rs += "<td>" + value.Description + "</td>";
        rs += "<td>" + value.RequestTime + "</td>";
        rs += "<td class='option'>";

        if(value.Status == 0 || value.Status ==1) {
            rs +=  `<a href="#" class="text-decoration" onclick="approve(${value.Id}, '${value.Money}', '${value.AgentCode}')">Duyệt</a>`;
            rs += `<a href="#" class="text-decoration mb-2" onclick="reject(${value.Id}, '${value.Money}', '${value.AgentCode}')">Refuse</a><br>`;
        }
        rs +=  "</td>";
        return rs;
    }

    function reject(id, money, code) {
        bootbox.confirm("Bạn có chắc muốn từ chối giao dịch này : " + money,
        function(result)
        {
            if(result) {
                $.ajax({
                    type: "POST",
                    url: "<?php echo admin_url('userAgency/rejectTransaction')?>",
                    data: {
                        "id":  id,
                        "code":  code,
                    },
                    dataType: 'json',
                    success: function (response) {
                        $("#spinner").hide();
                        console.log(response);
                        if (response.success) {
                            alert('Success');
                            location.reload();
                        } else {
                            alert('Refuse thất bại');
                        }
                    }, error: function (e) {
                        console.error(e.message)
                        $("#spinner").hide();
                        $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
                    }, timeout: 20000
                })
            }
        });
    }
    
    function approve(id, money, code) {
        bootbox.confirm("Bạn có chắc muốn duyệt giao dịch này : " + money,
            function(result)
            {
                if(result) {
                    $.ajax({
                        type: "POST",
                        url: "<?php echo admin_url('userAgency/approveTransaction')?>",
                        data: {
                            "id":  id,
                            "code":  code,
                        },
                        dataType: 'json',
                        success: function (response) {
                            $("#spinner").hide();
                            console.log(response);
                            if (response.success) {
                                alert('Success');
                                location.reload();
                            } else {
                                alert('Duyệt thất bại');
                            }
                        }, error: function (e) {
                            console.error(e.message)
                            $("#spinner").hide();
                            $("#resultsearch").html("System overload. Please call 19008698 or F5 to return to the pages");
                        }, timeout: 20000
                    })
                }
            });
    }
    function initData() {
        var oldPage = 0;
        $('#pagination-demo').css("display", "block");
        $("#spinner").show();
        $.ajax({
            type: "POST",
            url: "<?php echo admin_url('userAgency/transactionAjax')?>",
            data: {
                m: $('#m').val(),
                key: $('#key').val(),
                fbn: $('#fbn').val(),
                tbn: $('#tbn').val(),
                pages : 1,
                size: page_size
            },
            dataType: 'json',
            success: function (response) {
                var totalRecords = response.totalRecords;
                $("#total").html(totalRecords);
                $("#spinner").hide();
                if (totalRecords == 0) {
                    list_data = []
                    $('#pagination-demo').css("display", "none");
                    $("#resultsearch").html("No results were found");
                }else {
                    list_data = response.data
                    $("#resultsearch").html("");
                    var totalPage = Math.floor(totalRecords/page_size) + (totalRecords%page_size?1:0);
                    let str = ''
                    let stt = 1;
                    $.each(response.data, function (index, value) {
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
                                    url: "<?php echo admin_url('userAgency/transactionAjax')?>",
                                    data: {
                                        m: $('#m').val(),
                                        key: $('#key').val(),
                                        fbn: $('#fbn').val(),
                                        tbn: $('#tbn').val(),
                                        pages : page,
                                        size: page_size
                                    },
                                    dataType: 'json',
                                    success: function (response) {
                                        list_data = response.data
                                        $("#resultsearch").html("");
                                        $("#spinner").hide();
                                        stt = (page -1) * page_size + 1;
                                        let str = ''
                                        $.each(response.data, function (index, value) {
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
                }
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
    function maskActive(val) {
        if (val == 1) {
            return 'Activated';
        }
        return 'Void';
    }
</script>
<style>
    .img-banner {
        max-height: 200px;
    }

    .text-decoration {
        color: blue;
        text-decoration: underline;
    }
</style>