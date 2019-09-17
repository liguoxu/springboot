<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/findRegister.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>

<body>
<div class="score">
    <div class="score_top clearfix">
        <p class="p1">省份：</p>
        <ul>
            <li class="active province" value="全国">全国</li>
            <#list provinces as province>
                <li class="province" value="${province}">${province}</li>
            </#list>
        </ul>
    </div>
    <div class="score_search">
        <form action="">
            <p>年份：
                <select id="year">
                    <#list years as year>
                     <option value="${year}">${year}</option>
                    </#list>
                </select>
            </p>
            <p>专业：
                <input class="score_search_text" type="text" id="findMajor">
            </p>
            <input class="score_search_button" type="button" value="搜   索" id="findInfo">
        </form>
    </div>
    <table cellpadding="0" cellspacing="0">
        <tbody>
            <tr class="firstRow">
                <td class="td-first center">年份</td>
                <td class="td-first center">省份</td>
                <td class="td-secend center">专业</td>
                <td class="td-first center">科类</td>
                <td class="td-first center">录取线</td>
            </tr>
            <tr class="tr_Score" style="display: none;" id="cpModel">
                <td class="td-first center" id="year"></td>
                <td class="td-first center" id="province"></td>
                <td class="td-secend center" id="major"></td>
                <td class="td-first center" id="subject"></td>
                <td class="td-first center" id="fraction"></td>
            </tr>
        </tbody>
        <tbody id="tbox">
        </tbody>
    </table>
</div>
<script>
    $(document).ready(function(){
        $(".province").on("click", function(){
            $(".active").attr("class","province");
            $(this).attr("class","active province");
        });

        $("#findInfo").on("click", function(){
            var province = $.trim($(".active").attr("value"))+'';
            if(province!="全国"){
                province = "%"+province+"%";
            }
            var year = $.trim($("#year").val())+'';
            var major = $.trim($("#findMajor").val())+'';
            if(major.length>0){
                major = "%"+major+"%";
            }
            $.ajax({
                url: '/findFranctionalLine',
                data: {province: province, year: year, major: major},
                type: 'POST',
                datatype: 'json',
                success: function(data){
                    // if(data.code!=200){
                    //     alert(data.msg);
                    //     $("#findMajor").select();
                    //     return;
                    // }

                    $("#tbox").empty();
                    $.each(data, function(k, v){
                        var parent = $("#cpModel").clone();
                        parent.find("#year").text(v.year);
                        parent.find("#province").text(v.province);
                        parent.find("#major").text(v.major);
                        parent.find("#subject").text(v.subject);
                        parent.find("#fraction").text(v.fraction);
                        parent.css("display","table-row");
                        $("#tbox").append(parent);
                    })


                    alert("查询成功");
                }
            });
        })
    });
</script>
</body>

</html>