import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSRFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            String url = req.getParameter("url");
            URL obj = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            res.getWriter().write(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}