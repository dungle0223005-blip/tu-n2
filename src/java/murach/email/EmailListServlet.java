package murach.email;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import murach.business.User;
import murach.data.UserDB;

@WebServlet("/EmailListServlet")   // Servlet mapping
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        if (action.equals("join")) {
            url = "/index.html";
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object
            User user = new User(firstName, lastName, email);

            // validate email
            String message;
            if (email == null || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.html";
            } else {
                message = "";
                url = "/redirect.jsp";   // hoặc thanks.jsp nếu bạn tạo
                UserDB.insert(user);
            }

            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        // forward request and response
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
