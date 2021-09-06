package com.IgorT.Controller;

import com.IgorT.Entity.SafariCntry;
import com.IgorT.Service.WRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class WRController {
    @Autowired
    private WRService wrService;

    @RequestMapping(value="home", method = RequestMethod.GET)
    public Collection<SafariCntry> homeGet(HttpServletRequest req, HttpServletResponse res)  {
        HttpSession session = req.getSession();


        Collection<SafariCntry> allSafariCnt = wrService.getAllSafariCnt();

        session.setAttribute("safari_cntr",allSafariCnt);

        return allSafariCnt;

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
    }
    @RequestMapping(value="home", method = RequestMethod.POST)
    public Collection<SafariCntry> homePost(HttpServletRequest req, HttpServletResponse res)  {
        HttpSession session = req.getSession();

        String ordNo = req.getParameter("sf_order" );
        session.setAttribute("ordNo",ordNo);
        System.out.println(ordNo);

        String name = req.getParameter("sf_name" );
        session.setAttribute("name",name);

        System.out.printf("Order No %s Name of the country is :: %s %n", ordNo, name);
         wrService.updateSafari( Integer.valueOf(ordNo),name);

        Collection<SafariCntry> allSafariCnt = wrService.getAllSafariCnt();

        session.setAttribute("safari_cntr",allSafariCnt);

        return allSafariCnt;

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

        //WRService.updateStudentById(student);


    }
}
