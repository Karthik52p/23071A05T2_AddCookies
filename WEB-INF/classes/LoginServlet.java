import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Getting user data from request
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        // Creating cookies
        Cookie c1 = new Cookie("Username", username);
        Cookie c2 = new Cookie("Email", email);
        Cookie c3 = new Cookie("City", city);
        Cookie c4 = new Cookie("Country", country);

        // Adding cookies to the response
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);

        // Displaying cookies in a table
        out.println("<html><body>");
        out.println("<h2>Cookies Set:</h2>");
        out.println("<table border='1'><tr><th>Cookie Name</th><th>Value</th></tr>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                out.println("<tr><td>" + ck.getName() + "</td><td>" + ck.getValue() + "</td></tr>");
            }
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}