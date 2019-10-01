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
  

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<style>
#header_area{
width:600px;
height:65px;
}
#side_area{
width:300px;
height:400px;


}
#text_area{
width:800px;
height:300px;

}


</style>

<body >




	<div class="page-header header-filter" style="background-image: url('img/qq.jpeg'); ">

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
 		  <h1 id="header_area" ><span style="background-color: #ff9933">Author: <%out.println(auth);%></span></h1>
 		
	
 <img src="<%out.println(img); %>" id="side_area">

 <div class="list-group" id="text_area">
 

  <ul >
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Title :</span>  <%out.println(title); %>	</li>
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Publication :</span>    <%out.println(pub); %></li>
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Published date :</span> <%out.println(date); %></li>
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Category :</span>       <%out.println(cat); %></li>
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Country :</span> 	   <%out.println(cont); %></li>
  <li class="list-group-item list-group-item-action" ><span style="background-color: #FFF000">Discription :</span>    <%out.println(dis); %></li>
  <a href="<%out.println(more);%>" class="btn btn-info" role="button">For More Info</a> 
  </ul>
 
  <%break;}
    }%>
   </center>
</div>	
</body>
</html>