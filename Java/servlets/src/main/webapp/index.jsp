<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<h1><%= "Hello Servlets!" %>
</h1>
<br/>
<a href="hello-servlet">Hello</a>
<br />
<a href="videoFile">Video MIME</a>
<br />
<a href="person">Person-form</a>
<br>
<div>
    <h1>${person.getName()}</h1>
    <h2>${person.getAge()}</h2>
</div>
</body>
</html>