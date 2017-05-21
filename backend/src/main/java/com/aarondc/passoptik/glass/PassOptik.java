package com.aarondc.passoptik.glass;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aarondc on 5/21/17.
 */

public class PassOptik {
    public static String getRandomOptik(){
        String [] passOptions = {
                "                     ",
                "                     ",
                "                     ",
                "                     ",
                "                     "
        };
        int choice = new Random().nextInt(passOptions.length);
        return passOptions[choice];
    }//end getRandomOptik
    public static String render(ServletContext ctx, String template, Map<String, Object> data)
        throws IOException, ServletException{
        Configuration config = new Configuration();
        config.setServletContextForTemplateLoading(ctx, "WEB-INF/views");
        config.setDefaultEncoding("UTF-8");
        Template ftl = config.getTemplate(template);
        try{// Use the data to render the template to the servlet output
            StringWriter writer = new StringWriter();
            ftl.process(data, writer);
            return writer.toString();
        } catch (TemplateException e) {
            throw new ServletException("Problem while processing template", e);
        }//end try catch
    }//end render
}//end PassOptik
