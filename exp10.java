EXPERIMENT 10: - Simple application using servlet
Program: -
  
  
  
index.html
<html>
<head>
<title>Calculator App</title>
</head>
<body>
<form action="CalServlet" method="post" >
Enter First Number <input type="text" name="txtN1" ><br> Enter Second Number <input
type="text" name="txtN2" ><br> Select an Operation
<input type="radio" name="opr" value="+">ADDTION
<input type="radio" name="opr" value="*">MULTIPLY <input type="radio" name="opr"
value="/">DIVIDE
<input type="radio" name="opr" value="-"> Substraction
<br> <input type="reset">
<input type="submit" value="Calculate" >
</form>
</body>
</html>


CalServlet.java



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class CalServlet
 */
public class CalServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public CalServlet() {
 super();
 // TODO Auto-generated constructor stub
 }
 /**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
response)
 */
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 // TODO Auto-generated method stub
 //response.getWriter().append("Served at:
").append(request.getContextPath());
 response.setContentType("text/html;charset=UTF-8");
 PrintWriter out = response.getWriter();
 out.println("<html><head><title>Servlet CalServlet</title></head><body>");
double n1 =
 Double.parseDouble(request.getParameter("txtN1"));
 double n2 = Double.parseDouble(request.getParameter("txtN2"));
 double result =0;
 String opr=request.getParameter("opr");
 if(opr.equals("+")) result=n1+n2;
 if(opr.equals("-")) result=n1-n2;
 if(opr.equals("*")) result=n1*n2;
 if(opr.equals("/")) result=n1/n2;
 out.println("<h1> Result = "+result);
 out.println("</body></html>");
 }
 /**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
response)
 */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 // TODO Auto-generated method stub
 doGet(request, response);
 }
} 
