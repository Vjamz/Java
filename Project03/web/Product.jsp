<%-- 
    Document   : Product
    Created on : Jul 8, 2012, 4:46:33 PM
    Author     : James
--%>

<%@page import="Business.Product"%>
<%@page import="Business.ProductDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
<%
    Product product = (Product)session.getAttribute("product");
    String message = (String) session.getAttribute("message");
%>                         
       
        <h1>Product</h1>
        <%=message%>
        
        <form action="UpdateProductServlet" method="get">
           
        Product Code: <input type="text" name="Code" value="<%=product.getCode()%>"><br>
        Product Description: <input type="text" name="Description" value="<%=product.getDescription()%>"><br>
        Product Price: <input type="text" name="Price" value="<%=product.getPrice()%>"><br>
        
        <input type="submit" name="updateProduct" value="Update Product">
        </form>
                    
         <form action="displayProducts.jsp" method="get">
         <input type="submit" name="viewProducts" value="View Products">
         </form>
                   
         
        
    </body>
</html>
