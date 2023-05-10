package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import technifutur.be.technifutur.models.entities.Client;
import technifutur.be.technifutur.repositories.ClientRepository;
import technifutur.be.technifutur.repositories.ClientRepositoryImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "clientList", urlPatterns = "/clientList")
public class ClientListServlet extends HttpServlet {

    ClientRepository clientRepository = new ClientRepositoryImpl();
    HttpSession session;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        if(request.getParameter("id")!=null){
            Integer id = Integer.parseInt(request.getParameter("id"));
            clientRepository.delete(id);
        }
        List<Client> clients = clientRepository.getMany();

        request.setAttribute("clients", clients);

        request.getRequestDispatcher("WEB-INF/pages/clientList.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    public void init() throws ServletException {

    }

}
