<%-- 
    Document   : displayProducts
    Created on : Jul 8, 2012, 4:15:05 PM
    Author     : James
--%>

<%@page import="Business.ProductDB"%>
<%@page import="Business.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Products</h1>
        
            <table border="1" cellspacing="2">
                <tr>
                    <td>Code</td>
                    <td>Description</td>
                    <td>Price</td>
                    
                </tr>
                <%
    ArrayList<Product> prods1 = ProductDB.selectProducts();
    
    for(int i = 0; i<prods1.size(); i++){
        Product prods = prods1.get(i);
    
%>

                <tr>
                    <td><%=prods.getCode()%></td>
                    <td><%=prods.getDescription()%></td>
                    <td><%=prods.getPrice()%></td>
                    <td><a href="DisplayProdServlet?productCode=<%=prods.getCode()%>">EDIT</a></td>
                    <td><a href="DeleteProductServlet?productCode=<%=prods.getCode()%>">DELETE</a></td>
                    
                    
                </tr>
        



<% } %>
            </table>
            <form action="DisplayProdServlet">
            <input type="submit" name="addProduct" value="Add Product">
        </form>
    </body>
</html>
