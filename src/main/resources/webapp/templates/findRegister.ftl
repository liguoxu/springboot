<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/findRegister.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>

<body>
<div class="Inquiry">
    <p>说明：输入考生号和身份证号后点击查询即可。</p>
    <p>查询前请确认你报考我校的招生批次已结束，考生成绩达到该批次我校录取分数线。</p>
    <form id="formTable" onsubmit="return  false;">
        <div class="Input_box clearfix">
            <span class="">考生号：</span>
            <input placeholder='请输入考生号' id="testNumber"/>
        </div>
        <div class="Input_box clearfix">
            <span class="">身份证：</span>
            <input placeholder='请输入身份证' id="cardId"/>
        </div>
        <div class="Input_box clearfix">
            <span class="">验证码：</span>
            <input placeholder='请输入验证码' class="code" id="checkCode"/>
            <img src="/checkCode" alt="验证码" id="checkImage">
        </div>
        <button type="submit" id="findRegister">查询</button>
    </form>
    <div class="table_box none" id="hideWindows">
        <h1>查询结果</h1>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>年份</th>
                <th>考生号
                </td>
                <th>身份证号</th>
                <th>姓名</th>
                <th>录取专业</th>
            </tr>
            <tr>
                <td id="year"></td>
                <td id="testNumberInfo"></td>
                <td id="cardIdInfo"></td>
                <td id="name"></td>
                <td id="major"></td>
            </tr>
        </table>
    </div>
</div>
<script>
    $(document).ready(function(){

        $("#checkImage").on("click", function(){
            $("#checkImage").attr("src","/checkCode?a="+new Date().getTime());
        });

        $("#findRegister").on("click",  function(){
            var testNumber = $.trim($("#testNumber").val())+'';
            var cardId = $.trim($("#cardId").val())+'';
            var checkCode = $.trim($("#checkCode").val())+'';
            var cardIdPattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;

            if(testNumber.length<1){
                alert("考生号不能为空");
                $("#checkImage").attr("src","/checkCode?a="+new Date().getTime());
                $("#testNumber").select();
                return;
            }
            if(cardIdPattern.test(cardId)==false||cardId.length<18){
                alert("身份证错误");
                $("#checkImage").attr("src","/checkCode?a="+new Date().getTime());
                $("#cardId").select();
                return;
            }
            if(checkCode.length<1){
                alert("验证码不能为空");
                $("#checkImage").attr("src","/checkCode?a="+new Date().getTime());
                $("#checkCode").select();
                return;
            }

            $.ajax({
               url: '/findRegister',
               data: {testNumber: testNumber, cardId: cardId, checkCode: checkCode},
               type: 'POST',
               datatype: 'json',
               success: function(data){
                   if(data.code!=200){
                       alert(data.msg);
                       $("#checkImage").attr("src","/checkCode?a="+new Date().getTime());
                       $("#testNumber").select();
                       return;
                   }
                   $("#year").text(data.object.year);
                   $("#testNumberInfo").text(data.object.testNumber);
                   $("#cardIdInfo").text(data.object.cardId);
                   $("#name").text(data.object.name);
                   $("#major").text(data.object.major);

                   $("#hideWindows").css("display","block");
                   alert("查询成功");
               }
            });
        });
    });
</script>
</body>

</html>