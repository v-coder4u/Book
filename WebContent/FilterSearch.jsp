
<html>
<head>
<meta charset="utf-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/min.css" rel="stylesheet">
</head>
<body>
<center>
<h3><font color="black"><font size="7"><span style="background-color: #FFF000">Book Search By Filters</span></font></h3	>
  </center>

	<div class="page-header header-filter" style="background-image: url('img/g.gif'); ">
<div class="dropdown dropdown-lg">
<div class="container">
	<div class="row">
		<div class="col-md-12">
            <div class="input-group" id="adv-search">
                <input type="text" class="form-control" placeholder="Search for snippets" />
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form class="form-horizontal" role="form" action="filter" method = "post"  >
                                
                                <div class="form-group">
                                    <label for="filter">Search by</label>
                                    <select class="form-control" id="searchby" name="searchby">
                                        <option value="0" selected>Author</option>
                                        <option value="1">Publication</option>
                                     <option value="2">Category</option>
                                        
                                    </select>
                                 
                               </div>
                                <div class="form-group">
                                    <label for="search">Type Name</label>
                                    <input class="form-control" type="text" id="search" placeholder="type Name " name="search"/>
                            
                                </div>
                                  <div class="form-group">
                                    <label for="filter">Order by</label>
                                    <select class="form-control" id="order" name="order">
                                        <option value="0" selected>Default</option>
                                        <option value="1">Newest</option>
                                     <option value="2">Relevance</option>
                                        
                                    </select>
                                  </div>
                                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                </form>
                                
                                
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </div>
                </div>
            </div>
          </div>
        </div>
	</div>
</div>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<br><br>


<br><br><br><br><br><br><br>
<br><br><br><br><br><br>	
<h5>Vaibhav Varshney</h5>
</body>
</html>