package technifutur.be.technifutur.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import technifutur.be.technifutur.models.entities.Client;
import technifutur.be.technifutur.services.ClientServiceImpl;

@WebServlet(name = "addClient" ,urlPatterns = "/addClient",loadOnStartup = 1)
public class addClientServlet extends HttpServlet{
    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("add","");
        request.getRequestDispatcher("WEB-INF/pages/addClient.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");

        //
        ClientServiceImpl clientService = new ClientServiceImpl();
        Client client = clientService.add(new Client(firstname,lastname,email,phonenumber));
        //


        if (client != null){
//            response.sendRedirect(request.getContextPath()+"/");
            response.sendRedirect(request.getContextPath() + "/");  // on se dirige vers l'index
        }
        else
            request.getRequestDispatcher("WEB-INF/pages/addClient.jsp").forward(request,response);
    }
    public void destroy() {
    }


}
