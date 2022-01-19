<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ page import="java.text.*" %>

<html>
  <head>  
    <title>Psephoi Polling App</title>  
    <style>
    
    </style>
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">

			<%
				String ans=request.getParameter("ans");
				String host=request.getRemoteHost();
				if (ans !=null && ans.length()>0)
					{
						Cookie c=new Cookie("answered",host+"answered");
						c.setMaxAge(24 * 60 * 60);
						response.addCookie(c);
					}
				Cookie cookieArray[]=request.getCookies();
				boolean b=false;
				for(int i=0;cookieArray !=null && cookieArray.length>0 && i<cookieArray.length; i++)
					{
						String cName=cookieArray[i].getName();
						String cValue=cookieArray[i].getValue();
						
						if (cName.equals("answered")&& cValue.equals(host+"answered")){
							b=true;
							break;
						}
							}
//						if (b==true)
//							out.print("you have already voted");
//							else
//							{
			%>
			<%!
			
				double yesVote=0;
				double noVote=0;
				double neutralVote=0;
				double totalVotes=0;
				
					public double format2decimal (double d){
						NumberFormat n = NumberFormat.getInstance();
						n.setMaximumFractionDigits(2);
						return (Double.parseDouble(n.format(d)));
					}
			%>
			<%
				if (ans !=null && ans.length()>0) {
					if (ans.equals("Yes")) {
						yesVote++;
						totalVotes++;
					}
					else if (ans.equals("No")) {
						noVote++;
						totalVotes++;
					}
					else {
						neutralVote++;
						totalVotes++;
					}
				}
	
				double yesPercent=0;
				double noPercent=0;
				double neutralPercent=0;
		
				yesPercent=yesVote * 100/totalVotes;
				noPercent=noVote * 100/totalVotes;
				neutralPercent=neutralVote * 100/totalVotes;			
			%>
<table class="table">
  	<thead>
  		<tr>
  			<th scope="col"> Psephoi Polling App Results </th>
  		</tr>
  	</thead>
  	<tbody>
  		<tr>
  			<th scope="row"> Choice 1 </th>
  				<td>
					<%
							if ( b==false)
								out.print("0.0%");
							else
								out.print(""+format2decimal (yesPercent));
					%>
				</td>
  		</tr>
  		<tr>
 			<th scope="row"> Choice 2 </th>
 				<td>
					<%
							if (b==false)
								out.print("0.0%");
							else
								out.print(""+format2decimal (noPercent));
					%>
				</td>
  		</tr>
  		<tr>
 			<th scope="row"> Neither </th>
 				<td>
					<%
							if (b == false)
								out.print("0.0%");
							else
								out.print(""+format2decimal (neutralPercent));
					%>
				</td>
  		</tr>
  	</tbody>
  </table>
     		<%
     				response.setIntHeader("Refresh", 3);
     		%>
     		
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/poll_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/poll_controller.js' />"></script>
  </body>
</html>