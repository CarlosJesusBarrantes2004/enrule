package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.CompanyUser;
import logic.LogicController;
import logic.NormalUser;
import logic.User;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    private final LogicController CONTROL = new LogicController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = CONTROL.getUser(email, password);
        
        if(user != null){
            HttpSession session = request.getSession();
            
            if(user instanceof NormalUser){
                NormalUser useN = (NormalUser) user;
            }else if(user instanceof CompanyUser){
                CompanyUser useC = (CompanyUser) user;
            }
            session.setAttribute("user", user);

            response.sendRedirect("home.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}