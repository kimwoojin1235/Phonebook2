<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PhoneVo" %>
<%
int personId= Integer.parseInt(request.getParameter("id")); 

//PhoneDao phoneDao = new PhoneDao();
PhoneVo phoneVo=(PhoneVo)request.getAttribute("pVo");//=phoneDao.getPerson(personId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>김우진 전화번호 수정페이지</h1>
	<p>수정 화면 입니다.
	   아래항목을 수정 하시고 "수정" 버튼을 눌러주세요	</p>
	<Form action="/phonebook2/pbc" method="get">
	이름(name)<input type="text" name="name" value="<%= phoneVo.getName() %>"><br>
	핸드폰(hp)<input type="text" name="hp" value="<%= phoneVo.getHp() %>"><br>
	회사(company)<input type="text" name="company" value="<%=phoneVo.getCompany()%>"><br>
	코드(id)<input type="text" name="Id" value="<%=phoneVo.getPersonid() %>"><br>
	action:<input type="text" name="action"value="update1"><br>
	<button type="submit">수정</button>
	</Form>
</body>
</html>