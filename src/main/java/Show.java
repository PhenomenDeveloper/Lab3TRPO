import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Computer computer = new Computer();
        PrintWriter out = resp.getWriter();
        DAO dao = new DAO();
        dao.Query(2,"SELECT * FROM COMPUTERS;",computer);
        out.print("<html>" +
                "<head> " +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body>" +
                "<div class=\"table-responsive\">");
//        out.print("<table border='1'");
out.print("<table class=\"table table-hover table-bordered table-dark \" >\n" +
        "  <thead>\n" +
        "    <tr>\n" +
        "      <th scope=\"col\">Mark</th>\n" +
        "      <th scope=\"col\">Model</th>\n" +
        "      <th scope=\"col\">Price</th>\n" +
        "    </tr>\n" +
        "  </thead>\n" +
        "  <tbody>");
//        out.print("<tr><th>Mark</TH><TH>Model</TH> <th>Price</th></TR>");
        System.out.println(dao.getResponse());
        out.print(dao.getResponse());
        out.print("</table>" +
                "</div>");
        out.print("<button onclick=\"window.location.href=\'javascript:history.back()\'\" type=\"button\" class=\"btn btn-dark\">Back</button>");
        out.print("</body></html>");
    }
}
