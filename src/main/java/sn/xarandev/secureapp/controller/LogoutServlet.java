package sn.xarandev.secureapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout", value = "/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().invalidate();
		req.getSession().setAttribute("userAth", null);
		req.getSession().setAttribute("email", null);
		req.getSession().setAttribute("showForm", null);
		resp.sendRedirect("login");
	}
}
