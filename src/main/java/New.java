import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class New extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Computer computer = new Computer();
        DAO dao = new DAO();
        computer.setCompMark(req.getParameter("Mark"));
        computer.setCompModel(req.getParameter("Model"));
        computer.setPrice(Integer.parseInt(req.getParameter("Price")));
        dao.Query(1, "INSERT INTO COMPUTERS (COMP_MARK, COMP_MODEL, COMP_PRICE)  VALUES ( ?, ?, ?)",computer);
        PrintWriter out = resp.getWriter();
        out.print("<html><script>window.history.back();</script></html>");



    }
}
