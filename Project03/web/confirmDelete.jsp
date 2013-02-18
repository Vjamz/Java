<%-- 
    Document   : confirmDelete
    Created on : Jul 8, 2012, 6:59:32 PM
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

%>      
        <h1><b>Are You Sure You Want To Delete This Product?</b></h1>
        
        Product Code: <%=product.getCode()%> <br/>
        Product Description: <%=product.getDescription()%> <br/>
        Product Price: <%=product.getPrice()%> <br/>
        
        <form action="DeleteProductServlet">
            <input type="submit" value="Yes"/>
            <input type="hidden" name="productCode" value="<%=product.getCode()%>" />
            <input type="hidden" name="yesBtn" value="yes"/>
        </form>
        <form action="DisplayProductsServlet">
            <input type="submit" value="No"/>
            <input type="hidden" name="productCode" value="<%=product.getCode()%>" />
            <input type="hidden" name="noBtn" value="no" />
        </form>
            
        
    </body>
    
</html>
