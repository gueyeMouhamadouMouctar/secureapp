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

@WebServlet(name = "admin", value = "/admin")
public class AdminServlet extends HttpServlet {

	private IAccountUserService accountUserService = new AccountUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		try {
			//
			switch (action) {
			
			case "add": {
				addAccount(req, resp);
				break ;
			}
			case "deactivate": {
				deactivateAccount(req, resp);
				break;
			}
			case "delete": {
		
				deletAccount(req, resp);
				break;
			}
		}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id")) ;
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		String firstname = req.getParameter("firstname") ;
		String lastname = req.getParameter("lastname") ;
		String profil = req.getParameter("profil") ;
		
		AccountUserDto accountUserDto = new AccountUserDto(id, email, firstname, lastname, profil, password, true) ;

		accountUserService.update(accountUserDto) ;
		
		req.setAttribute("showForm", null);
		req.setAttribute("accounts", null);
		req.setAttribute("accounts", accountUserService.getAll());
		req.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(req, resp);
//		resp.sendRedirect("welcome");
	}

	public void deactivateAccount(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(req.getParameter("id")) ;
			accountUserService.deactivate(id) ;
			req.setAttribute("accounts", null);
			resp.sendRedirect("welcome");
			
		} catch (Exception e) {
			System.err.println("Error deactivate ");
		}
	}
	
	public void addAccount(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/accountForm.jsp").forward(req, resp) ;
	}

	public void deletAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id")) ;
		System.err.println("################################################   id => " + id);
		
		boolean result =  accountUserService.delete(id) ;
		System.err.println("################################################   id => " + result);
		if (result == true) {
			resp.sendRedirect("welcome");
		}else {
			System.err.println("Error deletion ");
		}
		
		
	}
}
