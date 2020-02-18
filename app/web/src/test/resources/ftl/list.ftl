<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>名字</th>
    </tr>
<#list names as name>
    <tr>
        <td>${name}</td>
    </tr>
</#list>
</table>

</body>
</html>