<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>select one</title>
</head>
<body bgcolor='white'>

	<p>This is the select one</p>

	<h3>��Ƭd��/�R��/�ק�:</h3>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>�Эץ��H�U���~:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<ul>



		<li>
			<FORM METHOD="post" ACTION="AttServlet">
				<b>�d��:��J���u�s�� (�p7):</b>
				 <input type="text" name="attno"> 
				 <input	type="submit" value="�d�߳浧">
				  <input type="hidden"name="action" value="getOne_For_Display">
			</FORM>
		<li>	
		 	
			

		



	</ul>
<input type="button" value="�^����" onclick="javascript:location.href='../index.jsp'"/>


</body>

</html>
