<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.tourcan.att.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 此頁為script取值 ，應練習改用採用 EL 的寫法取值 --%>

<%
AttVO attVO = (AttVO) request.getAttribute("attVO"); //EmpServlet.java(Concroller), 存入req的empVO物件

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='600'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3> ListOneEmp.jsp</h3>
		              <!-- <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td> --></tr></table>

<table border='1' bordercolor='#CCCCFF' width='600'>
	
	<tr>
		<th>id</th>
		<th>name</th>
		<th>addr</th>
		<th>intro</th>
		<th>open</th>
		<th>phone</th>
		<th>url</th>
		<th>price</th>
		<th>staytime</th>
	</tr>
	<tr align='center' valign='middle'>
		<td><%=attVO.getAtt_id()%></td>
		<td><%=attVO.getAtt_name()%></td>
		<td><%=attVO.getAtt_addr()%></td>
		<td><%=attVO.getAtt_intro()%></td>
		<td><%=attVO.getAtt_open()%></td>
		<td><%=attVO.getAtt_phone()%></td>
		<td><%=attVO.getAtt_url()%></td>
		<td><%=attVO.getAtt_price()%></td>
		<td><%=attVO.getAtt_staytime()%></td>
		
	<td>
	</td>
	</tr>
</table>
<h3> 會員姓名:${attVO.getAtt_name }</h3>

<%-- <h3>會員生日:${memVO.mem_bdate }</h3> --%>

<%-- <h3>會員帳號:${memVO.mem_account }</h3> --%>

<%-- <h3>會員密碼:${ memVO.mem_pwd}</h3> --%>

<%-- <h3>會員信箱:${memVO.mem_email }</h3> --%>


 <input type="button" value="回首頁" onclick="javascript:location.href='../index.jsp'"/>
 
</body>
</html>
