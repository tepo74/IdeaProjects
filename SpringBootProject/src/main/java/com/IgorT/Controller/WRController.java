package com.IgorT.Controller;

import com.IgorT.Service.StudentService;
import com.IgorT.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

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

    @RequestMapping(value="allstudents", method = RequestMethod.GET)
    public String allstudentsGet(HttpServletRequest req, HttpServletResponse res)
    {   HttpSession session = req.getSession();
        if( session.getAttribute("uname")==null) return "login";
        Collection<Student> cs ;
        StudentService studentService = StudentService.studSrv;
        cs = studentService.getAllStudents();
        req.setAttribute("cs",cs);
        return "allstudents";

    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String dologinGet(HttpServletRequest req, HttpServletResponse res)
    {
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String dologinPost(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession();

        if(req.getMethod().equals(RequestMethod.GET))  return "login";

        String uname = req.getParameter("uname" );
        String pass = req.getParameter("pass" );
        if(uname.equals("igort") && pass.equals("1234"))
        {
            session.setAttribute("uname", uname);
            System.out.println("Login success " + uname );
            return "home";
        }
        else
        {
            System.out.println("Login failed " + uname +"   "+pass);
            return "login";
        }
    }
    @RequestMapping(value="logout")
    public String dologout(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession();

        session.setAttribute("uname", "");
        session.invalidate();
        //res.sendRedirect("home");
        return "home";
    }




}
