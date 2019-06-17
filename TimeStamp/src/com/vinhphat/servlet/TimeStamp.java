package com.vinhphat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TimeStamp
 */
@WebServlet("/timestamp")
public class TimeStamp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeStamp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getTimeStamp(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void getTimeStamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String date = request.getParameter("timestamp");
		PrintWriter out = response.getWriter();
//		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
//		 Date date1=formatter1.parse(timeStamp);  
		String option = request.getParameter("option");
		String day = null;
		
		
		long unix = checkDate(date, option);
		if(unix>0) {
			day = unixToDate(unix);
			
			out.println("Unix: " + unix);
			out.println("<br>");
			out.println("Natural: " + day);
		}else {
			 day = null;
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('You entered the wrong format');");
			 out.println("location='Timestamp.jsp';");
			 out.println("</script>");
			}

	}

	// kiểm tra xem get giá trị có phải là unix time hay không
	public long checkUnix(String text) {
		try {

			long unix = Long.parseLong(text.trim());
//			System.out.println(unix);
			return unix;
		} catch (Exception e) {
			return -1;
		}
	}

	public String unixToDate(long unix) {
		String d = new java.text.SimpleDateFormat("MMMM dd, yyyy").format(new java.util.Date(unix));
		return d;
	}

	public long checkDate(String time, String formatting) {

		if (formatting.equals("unix")) {
			return checkUnix(time);
		} else {

			SimpleDateFormat formatter = new SimpleDateFormat(formatting);
	 
			Date d = null;
			long unixTime = 0;

			try {
				d = formatter.parse(time);
				unixTime = d.getTime();
				return unixTime;
			} catch (ParseException e) {
				return -1;
			}

		}
	}
}
