import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Computer computer = new Computer();
        DAO dao = new DAO();
        computer.setCompModel(req.getParameter("COMP_MODEL"));
        computer.setPrice(Integer.parseInt(req.getParameter("COMP_PRICE")));
        dao.Query(4,"UPDATE COMPUTERS SET COMP_PRICE = (?) WHERE COMP_MODEL = (?)",computer);
        PrintWriter out = resp.getWriter();
        out.print("<html><script>window.history.back();</script></html>");
    }
}
