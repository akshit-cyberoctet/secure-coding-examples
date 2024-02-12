import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSRFServlet extends HttpServlet {
    private static final List<String> WHITELISTED_DOMAINS = Arrays.asList("http://example.com", "http://example2.com");

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            String url = req.getParameter("url");
            URL obj = new URL(url);

            // Validate the URL before making the request
            if (!WHITELISTED_DOMAINS.contains(obj.getHost())) {
                throw new IllegalArgumentException("Invalid URL");
            }

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