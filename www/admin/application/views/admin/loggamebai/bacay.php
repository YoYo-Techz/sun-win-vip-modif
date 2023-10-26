
    <div class="titleArea">
        <div class="wrapper">
            <div class="pageTitle">
                <h5>Log card game</h5>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="line"></div><link rel="stylesheet"
          href="<?php echo public_url() ?>/site/css/loggamebai.css"><?php if($role == false): ?>
        <div class="wrapper">
            <div class="widget">
                <div class="title">
                    <h6>You are not authorized</h6>
                </div>
            </div>
        </div>
    <?php else: ?>
        <?php $this->load->view('admin/error')?>
    <div class="wrapper">
        <?php $this->load->view('admin/message', $this->data); ?>
        <div class="widget">
            <h4 id="resultsearch"></h4>
            <div class="title">
                <h6>History of card games</h6>
                <h6 class="total">Total Number of People playing:<span class="total-number" id="tong_player"></span></h6>
            </div>
            <form class="list_filter form" action="<?php echo admin_url('loggamebai/bacay') ?>" method="post">
            <div class="formRow">
                    <table>
                        <tr>
                            <td>
                                <label for="param_name" class="formLeft" id="nameuser">Since:</label></td>
                            <td class="item">
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" id="toDate" name="toDate" value="<?= empty($this->input->get('toDate')) ? $this->input->post('toDate') : $this->input->get('toDate') ?>"> <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </td>
                            <td>
                                <label for="param_name" class="formLeft formtoDate "> To date: </label>
                            </td>
                            <td class="item">

                                <div class="input-group date" id="datetimepicker2">
                                    <input type="text" id="fromDate" name="fromDate" value="<?= empty($this->input->get('fromDate')) ?   $this->input->post('fromDate') : $this->input->get('fromDate') ?>"> <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
    </span>
                                </div>
                            </td>

                        </tr>
                    </table>
            </div>
                <div class="formRow">
                    <table>
                        <tr>
                            <td><label class="session-1">Session:</label></td>
                            <td><input class="session-2" type="text" id="session_name" value="<?= empty($this->input->get('session_name')) ? $this->input->post('session_name') : $this->input->get('session_name') ?>" name="session_name"></td>
                            <td><label class="session-1" style="margin-left: 18px;">Nick name:</label></td>
                            <td><input class="session-2" style="margin-left: 1px;" type="text" id="filter_iname" value="<?= empty($this->input->get('name')) ?  $this->input->post('name') : $this->input->get('name') ?>" name="name"></td>
                            <td hidden><label class="money-type-1">Type of money:</label></td>
                            <td hidden><select class="money-type-2" id="moneytype" name="moneytype">
                                    <option value="" <?php if($this->input->post('moneytype') == ""){echo "selected";} ?>>Select</option>
                                    <option value="1" <?php if($this->input->post('moneytype') == "1"){echo "selected";} ?>>Vin</option>
                                    <option value="0" <?php if($this->input->post('moneytype') == "0"){echo "selected";} ?>>Coin</option>
                                </select></td>
                        </tr>
                    </table>
                </div>
                <div class="formRow">
                    <table>
                        <tr>
                            <td style="">
                                <input type="submit" id="search_tran" value="Search" class="button blueB search">
                            </td>
                            <td>
                                <input type="reset"
                                       onclick="window.location.href = '<?php echo admin_url('loggamebai/bacay') ?>'; "
                                       value="Reset" class="basic">
                            </td>
                        </tr>
                        </table>
                    </div>
            </form>
            <table cellpadding="0" cellspacing="0" width="100%" class="sTable mTable myTable withCheck" id="checkAll">
                <thead>
                <tr class="list-loggamebai">
                    <td>No</td>
                    <td>Session id</td>
                    <td>Nick name</td>
                    <td>Money</td>
                    <td>Date created</td>
                </tr>
                </thead>
                <tbody id="logaction">
                </tbody>
            </table>
        </div>
    </div>
    <?php endif;?>
    <div class="container">
        <h6 class="total-data">Total records:<span class="total-data-span" id="totalData"></span></h6>
        <div id="spinner" class="spinner image-loggamebai">
            <img id="img-spinner" src="<?php echo public_url('admin/images/gif-load.gif') ?>" alt="Loading"/>
        </div>
        <div class="text-center">
            <ul id="pagination-demo" class="pagination-lg"></ul>
        </div>

    </div>

    <script>
        $("#search_tran").click(function () {        var fromDatetime = $("#toDate").val();
            var toDatetime = $("#fromDate").val();
            if (fromDatetime > toDatetime) {
                alert('The end date must be greater than the start date')
                return false;
            }

        });

        $(function () {
            var startDate = moment(new Date()).hours(0).minutes(0).seconds(0).milliseconds(0);
            var endDate = moment(new Date()).hours(23).minutes(59).seconds(59).milliseconds(59);
            $('#datetimepicker1').datetimepicker({
                format: 'YYYY-MM-DD HH:mm:ss',
                defaultDate: startDate,
                useCurrent : false,
            });
            $('#datetimepicker2').datetimepicker({
                format: 'YYYY-MM-DD HH:mm:ss',
                defaultDate: endDate,
                useCurrent : false,
            });

        });

        $(document).ready(function () {

            var fromdate;
            var todate;
            var oldpage = 0;
            if($("#toDate").val()!=""){
                var match = $("#toDate").val().match(/^(\d+)-(\d+)-(\d+) (\d+)\:(\d+)\:(\d+)$/)
                var date = new Date(match[1], match[2] - 1, match[3], match[4], match[5], match[6])
                fromdate = date.getTime() / 1000;
            }
            else{
                fromdate =  "";
            }
            if($("#fromDate").val()!=""){
                var match = $("#fromDate").val().match(/^(\d+)-(\d+)-(\d+) (\d+)\:(\d+)\:(\d+)$/)
                var date = new Date(match[1], match[2] - 1, match[3], match[4], match[5], match[6])
                todate = date.getTime() / 1000;
            }
            else{
                todate =  "";
            }
            $('#pagination-demo').css("display", "block");
            $("#spinner").show();
            $.ajax({
                type: "POST",
                url: "<?php echo admin_url('loggamebai/bacayajax')?>",
                data: {
                    nickname: $("#filter_iname").val(),
                    namegame: 'BaCay',
                    toDate : fromdate,
                    fromDate : todate,
                    pages : 1,
                    sid : $("#session_name").val(),
                    money : $("#moneytype").val()
                },
                dataType: 'json',
                success: function (result) {
                    $("#spinner").hide();
                    var totalPage = result.total;
                    if (result.transactions == "") {
                        $('#pagination-demo').css("display", "none");
                        $("#resultsearch").html("No results were found");
                    } else {
                        $("#totalData").html($.number(result.totalRecord, undefined, '.', ','));
                        $("#tong_player").html($.number(result.totalPlayer, undefined, '.', ','));
                        $("#resultsearch").html("");
                        stt = 1;
                        $.each(result.transactions, function (index, value) {
                            result += resultSearchTransction(stt,value.sessionId, value.nickName, value.gameName,value.moneyType,value.timeLog);
                            stt ++;
                        });
                        $('#logaction').html(result);
                        $('#pagination-demo').twbsPagination({
                            totalPages: totalPage,
                            visiblePages: 5,
                            onPageClick: function (event, page) {
                                if(oldpage>0) {
                                    $("#spinner").show();
                                    $.ajax({
                                        type: "POST",
                                        url: "<?php echo admin_url('loggamebai/bacayajax')?>",
                                        // url: "http://192.168.0.251:8082/api_backend",
                                        data: {
                                            nickname: $("#filter_iname").val(),
                                            namegame: 'BaCay',
                                            toDate : fromdate,
                                            fromDate : todate,
                                            pages : page,
                                            sid : $("#session_name").val(),
                                            money : $("#moneytype").val()
                                        },
                                        dataType: 'json',
                                        success: function (result) {
                                            $("#spinner").hide();
                                            stt = (page - 1) * 50 + 1;
                                            $.each(result.transactions, function (index, value) {
                                                result += resultSearchTransction(stt, value.sessionId, value.nickName, value.gameName,value.moneyType, value.timeLog);
                                                stt++;
                                            });
                                            $('#logaction').html(result);
                                        }, error: function () {
                                            $('#logaction').html("");
                                            $("#spinner").hide();
                                            $("#error-popup").modal("show");
                                        }, timeout: 40000
                                    });
                                }
                                oldpage = page;
                            }
                        });
                    }

                }, error: function () {
                    $('#logaction').html("");
                    $("#spinner").hide();
                    $("#error-popup").modal("show");
                }, timeout: 40000
            })

        })
        function resultSearchTransction(stt,sid,nickname,gamename,moneytype,time) {
            var rs = "";
            rs += "<tr>";
            rs += "<td>" + stt + "</td>";
            rs += "<td width='50' >" + sid + "</td>";
            rs += "<td><a style='color: #0000FF' href='detail/"+sid+"/"+gamename+"/"+time+ getQuery() +"'>"+nickname+"</a>"+ "</td>";

            if(moneytype ==1){
                rs += "<td>" + "Win" + "</td>";
            }else if(moneytype == 0){
                rs += "<td>" + "Coin" + "</td>";
            }else{
                rs += "<td>" + "" + "</td>";
            }
            rs += "<td>" + moment.unix(time/1000).format("DD MMM YYYY hh:mm a"), + "</td>";
            rs += "</tr>";
            return rs;
        }
        function getQuery() {
            let queryString = '?toDate=' + $('#toDate').val() + '&fromDate=' + $('#fromDate').val() + '&session_name=' + $('#session_name').val() + '&name=' + $('#filter_iname').val();
            return queryString;
        }
    </script>