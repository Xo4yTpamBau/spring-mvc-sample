package by.sample.filter;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



//@WebFilter(urlPatterns = "/calculator")
public class Authorization extends HttpFilter {


//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (req.getSession().getAttribute("user") != null) {
//            chain.doFilter(req, res);
//        }else{
//            res.sendRedirect("/");
//        }
//    }
}
