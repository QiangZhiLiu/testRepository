<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
    function sendjson() {
    	  $.ajax({
  			type:"post",
  			url:"${pageContext.request.contextPath}/sendjson",
  			contentType:"application/json;charset=utf-8", 
  			data:'{"name":"iphoneX爆款手机","price":8000.9}',
  			success:function(data){
  				alert(data);
  			}
  			
  	/* 		error:function(data)
  			{
  				alert(data)
  			} */
  		});

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<input type="button" value="发送json数据" onclick="sendjson()">

<form action="${pageContext.request.contextPath }/updateAll" method="post">
查询条件：
<table width="100%" border=1>
<tr>

<td><input type="submit" value="批量修改" /></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
    <td></td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>

	
</tr>
<c:forEach items="${productList }" var="item" varStatus="status">
<tr>
    <td>
   <!--  <input type="checkbox" name="productlist" value=""> -->
   
    <input type="hidden" name="products[${status.index}]" value="${item.id }">
    </td>
	<td><input type="text" name="products[${status.index}].name" value="${item.name }"/></td>
	<td><input type="text" name="products[${status.index}].price" value="${item.price }"/></td>
	<td><input type="text" name="products[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
	<td><input type="text" name="products[${status.index}].detail" value ="${item.detail}"></td>
	
	<%-- <td><a href="${pageContext.request.contextPath }/itemEdit?id=${item.id}">修改</a></td> --%>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit/${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>