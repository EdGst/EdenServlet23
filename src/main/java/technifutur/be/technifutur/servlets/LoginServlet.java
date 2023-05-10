package technifutur.be.technifutur.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import technifutur.be.technifutur.exceptions.InvalidPasswordUserException;
import technifutur.be.technifutur.models.ConnectedUserDtos.ConnectedUserDto;
import technifutur.be.technifutur.models.entities.User;
import technifutur.be.technifutur.services.UserServiceImpl;

@WebServlet(name = "login", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {


    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
        String dbUser = this.getServletContext().getInitParameter("DB_USER");
        String dbPassword = this.getServletContext().getInitParameter("DB_PASSWORD");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.setAttribute("login", "");       //chaine de caratère vide en début
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        UserServiceImpl userService = new UserServiceImpl();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try{
            User user = userService.login(login, password);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", ConnectedUserDto.fromEntity(user));
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }catch (InvalidPasswordUserException e){
            request.setAttribute("errorMessage", "Invalid password");
        }

//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//        request.setAttribute("login",login);
//
//        //
//        try {
//            UserServiceImpl userService = new UserServiceImpl();
//            User user = userService.login(login, password);
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        } catch (RuntimeException e) {
//            request.setAttribute("errorMsg", "Erreur");
//            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request,response);
//        }
//        //



    }

    public void destroy() {


    }
}