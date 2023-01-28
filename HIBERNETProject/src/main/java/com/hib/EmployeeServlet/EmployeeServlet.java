package com.hib.EmployeeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hib.cdac.Employee;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	PrintWriter out=resp.getWriter();
    	resp.setContentType("text/html");
    	
    	String action=req.getServletPath();
    	
    	
    		switch (action) {
			case "/addrecord":
				addRecord(req,resp);
				break;
			case "/deleterecord":
				deleteRecord(req,resp);
				break;
			case "/showrecord":
				showRecord(req,resp);
				break;
			default:
				break;
			}
    	}
    
    private void showRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	
    	RequestDispatcher rd=req.getRequestDispatcher("ShowRecord.jsp");
    	EmployeeDao emp=new EmployeeDao();
    	List<Employee> list=emp.getEmployee();
    	req.setAttribute("list", list);
        rd.forward(req, resp);
    	
    }
    private void deleteRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	
    }
    private void addRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}
