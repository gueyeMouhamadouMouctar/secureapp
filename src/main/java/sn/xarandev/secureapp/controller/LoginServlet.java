package sn.xarandev.secureapp.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sn.xarandev.secureapp.dto.AccountUserDto;
import sn.xarandev.secureapp.service.AccountUserService;
import sn.xarandev.secureapp.service.IAccountUserService;

@WebServlet(name = "login", value = "/login") 
public class LoginServlet extends HttpServlet {

	private Logger log = LoggerFactory.getLogger(LoginServlet.class);
	
	private IAccountUserService accountUserService = new AccountUserService() ;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		log.info("Conection attemp detected on email => {}", email);
		
		try {
			
			Optional<AccountUserDto> accountUserDto = accountUserService.login(email, password) ;
			
			if (accountUserDto.isPresent()) {
				req.getSession().setAttribute("email", email);
				resp.sendRedirect("welcome");
			}else {
				resp.sendRedirect("login");
			}
		} catch (Exception e) {

			log.error("Error", e);
			resp.sendRedirect("login");
		}
	
	}
}
