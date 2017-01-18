import JavaBeans.Entity;
import com.google.gson.Gson;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by Gaurav on 17/01/17.
 */
@WebServlet(name = "EntityAdded")
public class EntityAdded extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://api.api.ai/v1/entities?v=20150910");
            connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("Authorization", "Bearer 3884986b290a40fd8cc65578ff70fbdf");
            connection.setDoOutput(true);
            Entity entity=(Entity) request.getSession().getAttribute("Entity");
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            Gson gson = new Gson();
            String JsonString=gson.toJson(entity);
            JSONObject jsonObject=new JSONObject(JsonString);
            System.out.println(jsonObject);
            wr.writeBytes(jsonObject.toString());
            wr.flush();
            wr.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responses = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                responses.append(inputLine);
            }
            in.close();
            response.setContentType("text/html");
            response.getWriter().println("<h1>"+responses.toString()+"</h1>");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.disconnect();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
