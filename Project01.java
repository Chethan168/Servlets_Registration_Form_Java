package com.gqt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Project01")
public class Project01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String usn = request.getParameter("usn");
            String uname = request.getParameter("uname");
            int marks1 = Integer.parseInt(request.getParameter("marks1"));
            int marks2 = Integer.parseInt(request.getParameter("marks2"));
            int marks3 = Integer.parseInt(request.getParameter("marks3"));
            float percent = Float.parseFloat(request.getParameter("percent"));

            Model m = new Model();
            m.setUsn(usn);
            m.setUname(uname);
            m.setMarks1(marks1);
            m.setMarks2(marks2);
            m.setMarks3(marks3);
            m.setPercent(percent);

            boolean check = m.getResult();

            if (check) {
                response.sendRedirect("disp.html");
            } else {
                response.sendRedirect("failed.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("failed.html");
        }
    }
}
