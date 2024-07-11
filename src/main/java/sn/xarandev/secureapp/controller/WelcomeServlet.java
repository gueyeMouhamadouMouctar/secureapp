package sn.xarandev.secureapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.service.AccountUserService;
import sn.xarandev.secureapp.service.IAccountUserService;

@WebServlet(name = "welcome", value = "/welcome")
public class WelcomeServlet extends HttpServlet {

	private IAccountUserService accountUserService = new AccountUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String showForm = (String) req.getParameter("showForm");
		
		if (showForm == null)  {
			
			req.setAttribute("accounts", accountUserService.getAll());
			req.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(req, resp);
		
		}else if (showForm.equals("ok")) {
			try {

				int id = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("account", accountUserService.getAccount(id));
				req.setAttribute("accounts", accountUserService.getAll());
				req.setAttribute("showForm", showForm) ;
				req.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(req, resp);
				
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		String firstname = req.getParameter("firstname") ;
		String lastname = req.getParameter("lastname") ;
		

		System.out.println("email => " + email);
		System.out.println("password => " + password);
		
		AccountUserDto accountUserDto = new AccountUserDto(0, email, firstname, lastname, "client", password, true) ;

		boolean result =  accountUserService.update(accountUserDto) ;
		System.err.println("result  => " + result);
		req.setAttribute("showForm", null);
		req.setAttribute("accounts", null);
		doGet(req, resp);
	}

}
