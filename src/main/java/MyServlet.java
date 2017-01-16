import JavaBeans.Entity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Gaurav on 12/01/17.
 */
@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get requested");
        Entity entity=new Entity();
        entity.setEntries("/Users/sprinklr/Entries.csv");
        System.out.println("entries set in servlet");
        entity.setExtend(false);
        entity.setIsEnum(false);
        entity.setName("Applications");
        request.setAttribute("Entity", entity);
        RequestDispatcher rd = request.getRequestDispatcher("EntityDetails.jsp");
        rd.forward(request, response);
    }
}

