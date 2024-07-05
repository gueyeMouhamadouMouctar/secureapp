package sn.xarandev.secureapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.service.AccountUserService;
import sn.xarandev.secureapp.service.IAccountUserService;

@WebServlet(name = "signup", value = "/signup")
public class SignupServlet extends HttpServlet {

	private IAccountUserService accountUserService = new AccountUserService() ;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email") ;
		String firstname = req.getParameter("firstname") ;
		String lastname = req.getParameter("lastname") ;
		
		String password = req.getParameter("password") ;
		String confirmPassword = req.getParameter("confirmPassword") ;
		
		if( confirmPassword.equals(password)) {
			String profil = "client" ;
			boolean state = true ;
			AccountUserDto dto = new AccountUserDto(0, email, firstname, lastname, profil,  password, state) ;
			System.out.println("**********************  Debut  SUCCESSS*************************");
			accountUserService.save(dto);
			System.out.println("**********************    SUCCESSS*************************");
			
			String userAuth = firstname + " " + lastname ;
			
			req.getSession().setAttribute("userAuth", userAuth);
			req.getSession().setAttribute("profil", profil);
			req.getSession().setAttribute("email", email);
			
			resp.sendRedirect("welcome");
		}
		
		
		
			
	}
}
