<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, pack.GsonData, java.io.*" %>
<%@page import="java.util.*,pack.DbConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Search Here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- <style>
div {
    height: 400px;
    background: linear-gradient(to top right, #33ccff 0%, #ff99cc 100%)
}
</style> -->

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="container">
 <div class="page-header header-filter" style="background-image: url('img/aa.jpg'); "> 
<%
   if(request.getAttribute("list")!=null)
   {
    List<GsonData> list=(ArrayList<GsonData>)request.getAttribute("list");
    Iterator itr=list.iterator();
   	while(itr.hasNext())
    {
    	String title,auth,date,pub,dis,more,cat,cont,img,price;
 		GsonData g=(GsonData)itr.next();
 		title=g.getTitleData();
 		auth=g.getAuthorData();
 		date=g.getDateData();
 		pub=g.getPubData();
 		cat=g.getCatData();
 		cont=g.getCountryData();
 		dis=g.getDescriptionData();
 		more=g.getInfoData();
 		img=g.getImgData();
 		%>
 <center>	
 <img src="<%out.println(img); %>" class="w3-border" alt="Norway" style="padding:8px;width:200px; height:auto">
 </center>
 <div class="list-group">
 <center>
  <h2><font color="orange"><font size="9"><span style="background-color: #000000"><%out.println(auth);%></span></font></h2></center>
  <ul>
  <li class="list-group-item list-group-item-action">Title :          <%out.println(title); %></li>
  <li class="list-group-item list-group-item-action">Publication :    <%out.println(pub); %></li>
  <li class="list-group-item list-group-item-action">Published date : <%out.println(date); %></li>
  <li class="list-group-item list-group-item-action">Category :       <%out.println(cat); %></li>
  <li class="list-group-item list-group-item-action">Country : 		  <%out.println(cont); %></li>
  <li class="list-group-item list-group-item-action">Discription :    <%out.println(dis); %></li>
  <a href="<%out.println(more);%>" class="btn btn-info" role="button">For More Info</a> 
  </ul>
 
  <%}%>
 	<%}%>
 	</div>
</div>	
</body>
</html>