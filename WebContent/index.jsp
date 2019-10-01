<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Book Search here</title>
</head>
<style>


</style>

<body>

	<div class="page-header header-filter" style="background-image: url('img/web.gif'); ">



<div class="container"> 
<center>
<h2><font color="orange"><font size="9"><span style="background-color: #000000">Book Search App</span></font></h2>
  </center>
   
  <form action="books" method = "post"  >
    <div class="form-group" >
      <label for="auth" style="color:#000000"><font size="5"><span style="background-color: #FFF000">Author:</span></font></label>
      <input size="35" type="text" class="form-control" id="auth" placeholder="Enter Author" name="auth" >
    </div>
    <div class="form-group">
      <label for="title" style="color:#000000"><font size="5"><span style="background-color: #FFF000">title:</span></font></label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
  
    <div class="form-group">
  <label for="ex3" style="color:#000000"><font size="5"><span style="background-color: #FFF000">Language :</span></font></label>
  <select class="form-control" id="ex3">
    <option>English</option>
    <option>Hindi</option>
    <option>Urdu</option>
    <option>French</option>
  </select>
</div>
  <center>
    <button type="submit" class="btn btn-info">Submit</button>
    </center>
  </form>
  
  
</div>

<center>
	<br><br><br><br><br><br><br><br>

<br><br><br><br><br><br>
<h2>
<a href="FilterSearch.jsp" color="black"><span style="background-color: #000000">Search by filters</span></a><br>
</h2></center>

</body>
</html>