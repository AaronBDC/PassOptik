package glass.aarondc.com.passoptik;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aarondc on 5/21/17.
 */

public class PassOptikServlet extends HttpServlet {
    /** Accept an HTTP GET Request an write a random pass. */
    @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Please use the form to POST to this url");
    }
    public void doGet0(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {
        resp.setContentType("text/plain");
        String pass = PassOptik.getRandomOptik();
        resp.getWriter().println(pass);
    }//end doGet0
    public void doGet1(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {
        resp.setContentType("text/html; charset=utf-8");
        Map<String, Object> data = new Hashmap<String, Object>();
        data.put("pass", PassOptik.getRandomOptik());
        String html = PassOptik.render(getServletContext(), "web/optik.ftl", data);
        resp.getWriter().append(html);
    }//end doGet1

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/plain");
        if (name == null) {
            resp.getWriter().println("Please enter a name");
        }
        resp.getWriter().println("Hello " + name);
    }//end doPost
}//end PassOptikServlet
