<%-- 
    Document   : newjsp
    Created on : 10-02-2017, 09:45:24
    Author     : Yousinho
     <h2> <%out.print(textList); %> </h2>

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%      String name = (String) session.getAttribute("userName");
            String textList =(String) request.getAttribute("textList");%>
        <h1>Hello <%out.print(name); %>!</h1>

        
     <form action="NewServlet" method="Post">
      
            <input type="text" name="newMessege" value="" />
            <input type="submit" value="chat" name="origin" />
        </form>
        
        <table >
  <tr>
    <th>Sender</th>
    <th>Messege</th> 

  </tr>
  <%for (String newMessege : textList.split("-")) {
      %>
        <tr>
            <td><%out.print(newMessege);%></td>
  
        
        
        </tr>   
      <%}
  %>

 
</table>
        
  
    </body>
</html>
