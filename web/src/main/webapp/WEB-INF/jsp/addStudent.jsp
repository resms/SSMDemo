<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加</title>  
  </head>  
    
  <body>  
  	<h3>add</h3>
    <form action=edit method="post">  
	    id:<input type="text" name="id">  
	    name:<input type="text" name="name" value="${student.name }">  
	    age:<input type="text" name="age">  
	    province:<input type="text" name="address.province">  
	    city:<input type="city" name="address.city">  
	    <input type="submit" value="submit">  
	</form>
	<br/>
  </body>  
</html>