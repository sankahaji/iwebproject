<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js" type="text/javascript"></script>
<title>发布产品</title>
</head>
<body>
发布产品
<label for="productDesc">产品描述：</label><textarea  cols="80" id="productDescription" name="productDescription" rows="10"></textarea>
<script type="text/javascript">
    CKEDITOR.replace( 'productDescription' ,{
        filebrowserImageUploadUrl : 'acvitity/uploadActivityPhoto.action?flag=comment',width:572
    });
</script>
</body>
</html>