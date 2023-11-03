package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.CompanyUser;
import logic.LogicController;
import logic.NormalUser;
import logic.User;

@WebServlet(name = "SvEditUser", urlPatterns = {"/SvEditUser"})
public class SvEditUser extends HttpServlet {
    
    private final LogicController CONTROL = new LogicController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        User user = (User) request.getSession().getAttribute("user");
        
        if (user instanceof NormalUser) {
            NormalUser useN = (NormalUser) user;
            
            useN.setDni(request.getParameter("dni"));
            useN.setProfession(request.getParameter("profesion"));
            
            CONTROL.editNormalUser(useN);
        } else if (user instanceof CompanyUser) {
            CompanyUser useC = (CompanyUser) user;
            
            useC.setDescription(request.getParameter("descripcion"));
            CONTROL.editCompanyUser(useC);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
