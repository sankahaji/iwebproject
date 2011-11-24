<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传产品图片</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product/${param.userId }/uploadProductPicture" method="POST" enctype="multipart/form-data">  
                    请选择上传的图片文件：<input name="productPicture" type="file"/><input type="submit" value="上传"/><br/>  
</form>  
</body>
</html>