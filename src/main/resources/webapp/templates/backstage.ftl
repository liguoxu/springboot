<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>招生管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
<div class="header">
    <img src="images/logo.png" alt="">
    <h1>招生管理系统</h1>
    <div class="username">
        <span>欢迎你：魏志勇</span>
        <span>|</span>
        <input class="exit" type="button" value="修改密码">
        <span>|</span>
        <input class="exit" type="button" value="退出">
    </div>
</div>
<div class="aside">
    <ul>
        <li class="active" index="admission">高考录取查询维护</li>
        <li index="fraction">历年分数查询维护</li>
        <li index="setting">查询系统基础设置</li>
    </ul>
</div>
<div class="main">
    <iframe src="admission.html" frameborder="0" width="100%" height="100%" scrolling leftmargin="0" topmargin="0" style="padding: 14px;background-color: #fff"></iframe>
</div>
</body>
</html>