package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import technifutur.be.technifutur.models.entities.Client;
import technifutur.be.technifutur.services.ClientServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateClient", urlPatterns = "/updateClient")
public class UpdateServlet extends HttpServlet {

    ClientServiceImpl clientService = new ClientServiceImpl();
    HttpSession session;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession(true);
        Integer id = Integer.parseInt(request.getParameter("id"));
        Client client = clientService.getAllInfoById(id);
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String email = client.getEmail();
        String phoneNumber = client.getPhoneNumber();

        session.setAttribute("client_id", id);
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("email", email);
        session.setAttribute("phoneNumber", phoneNumber);

        request.getRequestDispatcher("WEB-INF/pages/updateClient.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        Client client = Client.builder()
                .firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber)
                .build();
        System.out.println(session.getAttribute("client_id").toString());
        Integer id = Integer.parseInt(session.getAttribute("client_id").toString());
        Boolean success = clientService.update(id, client);

        response.sendRedirect("clientList");

    }
    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
    }


}
