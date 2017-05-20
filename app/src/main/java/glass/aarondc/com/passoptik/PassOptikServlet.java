package glass.aarondc.com.passoptik;

/**
 * Created by aarondc on 5/21/17.
 */

public class PassOptikServlet extends HttpServlet {
    /** Accept an HTTP GET Request an write a random pass. */
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
}//end PassOptikServlet
