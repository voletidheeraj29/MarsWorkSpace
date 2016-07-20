<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Online Shopping</title>
</head>

<style type="text/css">
#header {
	background-color: #c3dfef;
}

#search {
	float: right;
	padding: 20px;
}

.textInput {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
	width: 400px;
	height: 40px;
}

.searchButton {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: #ffffff;
	border: solid 1px #0076a3;
	border-right: 0px;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5));
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
	height: 40px;
}

.searchButton:hover {
	text-decoration: none;
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e));
	background: -moz-linear-gradient(top, #0095cc, #00678e);
}
/* Fixes submit button height problem in Firefox */
.searchButton::-moz-focus-inner {
	border: 0;
}

.clear {
	clear: both;
}

.logo {
	float: left;
}
</style>
</head>
<body>
	<!-- HTML for SEARCH BAR -->
	<div id="header">
		<form id="search" method="get" action="http://www.google.com">
			<img id="logo" alt="Online shopping india | flipkart" src="flip.png">
			<input type="text" class="textInput" name="q" size="21"
				maxlength="120"> <input type="submit" value="search"
				class="searchButton">
		</form>
		<div class="clear"></div>
	</div>
	<div id="navigate">
		<ul class="nav nav-tabs" role="tablist" id="nav">
			<li class="active"><a href="electronics.jsp">electronics</a></li>
			<li class="active"><a href="men.jsp">men</a></li>
			<li><a href="women.jsp">women</a></li>
			<li><a href="babyAndKids.jsp">baby & kids</a></li>
			<li><a href="homeAndFurniturejsp">home & furniture</a></li>
			<li><a href="booksAndMedia.jsp">books & media</a></li>
		</ul>

	</div>

	

		<script>
		
			$('#nav li a').mouseover(function() {
				var path = $(this).attr('href');//Get the path
				$('#result').load(path)//Load contents into a div#result
				, function() {
					$('#result').show();
				}
			});

			$('a').mouseout(function() {
				$('#result').hide();
			});
		
		</script>
		<div id="result">
	</div>


</body>
</html>