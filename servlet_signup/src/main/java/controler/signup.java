package controler;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.Userdao;
import dto.User;

@WebServlet("/signup")
public class signup extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		User user=new User();
		user.setName(req.getParameter("name"));
		user.setPhno(Long.parseLong(req.getParameter("phno")));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setPassword(req.getParameter("password"));
		
		Userdao dao=new Userdao();
		dao.save(user);
	    res.getWriter().print("<h1>Account created succesfully</h1>");
		req.getRequestDispatcher("login.html").include(req, res);
		
	}
}
