package com.IgorT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class WRController {
    @RequestMapping(value="home", method = RequestMethod.GET)
    public String homeGet(HttpServletRequest req, HttpServletResponse res)  {
        HttpSession session = req.getSession();
        String name = req.getParameter("sf_name" );
        if(name != null)
            session.setAttribute("name",name);
        else
            session.setAttribute("name","XXXXX");
        /*
        try (PrintWriter out = res.getWriter())
        {
            out.println("Name of the country is: " + name);
        }
        catch( IOException e)
        {
             e.printStackTrace();
        }
        */

        return "home";
    }
    @RequestMapping(value="home", method = RequestMethod.POST)
    public String homePost(HttpServletRequest req, HttpServletResponse res)  {
        HttpSession session = req.getSession();
        String name = req.getParameter("sf_name" );
        session.setAttribute("name",name);
        System.out.println("Name of the country is :: "+name);
        /*
        try (PrintWriter out = res.getWriter())
        {
            out.println("Name of the country is: " + name);
        }
        catch( IOException e)
        {
             e.printStackTrace();
        }
        */

        return "home";
    }
}
