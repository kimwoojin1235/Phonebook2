package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;



@WebServlet("/pbc")
public class PhoneController extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러 테스트
		System.out.println("controller");
		
		//파라미터 action값 읽어서
		String action = request.getParameter("action");
		//action = 뒤에올 입력 값을 읽어온다.
		System.out.println(action);
		
		//action =list -->리스트 출려관련
		if("list".equals(action)){
			System.out.println("리스트 처리");
			//리스트 출력 처리
			PhoneDao phoneDao = new PhoneDao();
			List<PhoneVo> personList = phoneDao.getpersonList();//리스트를 다가지고 온다.
			//html-->개 복잡-->jsp에서 짜는게 편함
			
			//데이터 전달
			request.setAttribute("pList",personList);
			//request.setAttribute <-("내가 정한 이름", 전송할 데이터);넣는다.
			//jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); //jsp파일 위치를 알려줌
			rd.forward(request, response);
			//rd에게 리스트의 위치를 알려주고 받은걸 처리해 준다.
			//action =wform >등록폼
			//action =
		} else if ("wform".equals(action)) {
			System.out.println("등록폼 처리");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
		}else if ("insert".equals(action)) {
			System.out.println("전화번호 저장");
			//파라미터3개값
			String name= request.getParameter("name");
			String hp= request.getParameter("hp");
			String company= request.getParameter("company");
			//PhoneVo 묶고
			PhoneVo phoneVo = new PhoneVo(name, hp,company);
			//new dao
			PhoneDao phoneDao = new PhoneDao();
			//dao personinsert(PhoneVo)
			phoneDao.personInsert(phoneVo);
			//번호를 저장한다.
			
			response.sendRedirect("/phonebook2/pbc?action=list");
			//다시 리스트를 불러온다.
		}else if ("delete".equals(action)) {
			int Id=Integer.parseInt(request.getParameter("id"));
			PhoneVo phoneVo = new PhoneVo(Id);
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.persondelete(phoneVo);
			response.sendRedirect("/phonebook2/pbc?action=list");
		}else if ("update".equals(action)) {
			System.out.println("수정폼 처리");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
			rd.forward(request, response);
		}else if ("update1".equals(action)) {
			//파라미터4개값
			String name= request.getParameter("name");
			String hp= request.getParameter("hp");
			String company= request.getParameter("company");
			int Id=Integer.parseInt(request.getParameter("Id"));
			//PhoneVo 묶고
			PhoneVo phoneVo = new PhoneVo(Id,name, hp,company);
			//new dao
			PhoneDao phoneDao = new PhoneDao();
			//dao personinsert(PhoneVo)
			phoneDao.personUpdate(phoneVo);
			//번호를 저장한다.
			response.sendRedirect("/phonebook2/pbc?action=list");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
