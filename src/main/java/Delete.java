import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Computer computer = new Computer();
        DAO dao = new DAO();
        computer.setCompModel(req.getParameter("COMP_MODEL"));
        dao.Query(3,"DELETE FROM COMPUTERS where COMP_MODEL = ( ?)",computer);
        PrintWriter out = resp.getWriter();
        out.print("<html><script>window.history.back();</script></html>");
    }
}
