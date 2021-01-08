<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.dao.PhoneDao"%>
<%@ page import="com.javaex.vo.PhoneVo"%>

<%
//PhoneController 에서 포워드 시킨다.
	List<PhoneVo> personList= (List<PhoneVo>)request.getAttribute("pList");
	//컨트롤 에서 포워드한 plist를 꺼내라
	System.out.println("-----list.jsp------");
	System.out.println(personList);
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>
	<p>
	입력한 전화번호 리스트 입니다.
	</p>
	<%for(int i=0;i<personList.size();i++){ %>
	<table border = '1'>
		<tr>
			<td>이름(name)</td>
			<td><%= personList.get(i).getName() %></td>
		</tr>
		<tr>
			<td>핸드폰(hp)</td>
			<td><%= personList.get(i).getHp() %></td>
		</tr>
		<tr>
			<td>회사(company)</td>
			<td><%= personList.get(i).getCompany() %></td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=updateForm&id=<%=personList.get(i).getPersonid()%>">수정</a></td>
			<td><a href="/phonebook2/pbc?action=delete&id=<%=personList.get(i).getPersonid()%>">[삭제]</a></td>
		</tr>
	</table>
	<br>
	<%}%>
	<a href="">추가번호 등록</a>
</body>
</html>