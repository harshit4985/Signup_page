package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.Userdao;
import dto.User;

@WebServlet("/login")
public class login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Userdao dao=new Userdao();
		User user=dao.find(email);
		if(user==null){
			res.getWriter().print("<h1>invalid email</h1>");
			req.getRequestDispatcher("login.html").include(req, res);
		}else{
		if(user.getPassword().equals(password)){
			res.getWriter().print("<h1>login succesfuly</h1>");
//			List<User> l=dao.fetchAll();
//			for (User u : l) {
////				"<html><body> <table><tr><td>Username</td><td>email</td><td>phno</td><td>password</td></tr>  <tr><td>"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPhno()+"</td><td>"+u.getPassword()+"</td></tr> </table>    </body></html>"
//				res.getWriter().print("<h1>username"+u.getName()+"</h1>");
//			}
		}
		else{
			res.getWriter().print("<h1>invalid password</h1>");
			req.getRequestDispatcher("login.html").include(req, res);
		}
		}
	}

}
