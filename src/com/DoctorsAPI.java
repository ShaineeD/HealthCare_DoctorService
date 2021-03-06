package com;

import com.Doctor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/ItemsAPI")
public class DoctorsAPI extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	Doctor docObj = new Doctor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}   

    
    
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String output = docObj.insertItem(request.getParameter("hospitalID"),
				request.getParameter("docName"),
				request.getParameter("docEmail"),
				request.getParameter("docAddress"),
				request.getParameter("specialization"),
				request.getParameter("workingTime"),
				request.getParameter("workingDays"),
				request.getParameter("workingHospitals"),
				request.getParameter("docFee"),
				request.getParameter("username"),
				request.getParameter("password"));
		
		response.getWriter().write(output);
	}

	
	
	
	
/*	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	     Map<String, String> map = new HashMap<String, String>();
	     try
	     {
	       Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	       String queryString = scanner.hasNext() ?
	                            scanner.useDelimiter("\\A").next() : "";
	       scanner.close();
	
	       String[] params = queryString.split("&");
	       for (String param : params)
	       {
		      String[] p = param.split("=");
		      map.put(p[0], p[1]);
		   }
		 }
		 catch (Exception e)
		 {
		 }
		 return map;
	 }
	
*/	
	
	
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map paras = getParasMap(request);
		
		String output = docObj.updateItem(paras.get("hidDocIDSave").toString(),
		                   paras.get("hospitalID").toString(),
		                   paras.get("docName").toString(),
		                   paras.get("docEmail").toString(),
		                   paras.get("docAddress").toString(),
		                   paras.get("specialization").toString(),
		                   paras.get("workingTime").toString(),
		                   paras.get("workingDays").toString(),
		                   paras.get("workingHospitals").toString(),
		                   paras.get("docFee").toString(),
		                   paras.get("username").toString(),
		                   paras.get("password").toString());
		
		response.getWriter().write(output);
	}
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map paras = getParasMap(request);
		
		String output = docObj.deleteItem(paras.get("docID").toString());
		
		response.getWriter().write(output);
	}
	
	
	
	private static Map getParasMap(HttpServletRequest request)
	{
	     Map<String, String> map = new HashMap<String, String>();
	     try
	     {
	       Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	       String queryString = scanner.hasNext() ?
	                            scanner.useDelimiter("\\A").next() : "";
	       scanner.close();
	
	       String[] params = queryString.split("&");
	       for (String param : params)
	       {
		      String[] p = param.split("=");
		      map.put(p[0], p[1]);
		   }
		 }
		 catch (Exception e)
		 {
		 }
		 return map;
	 }
	

}
