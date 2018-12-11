
 
<!DOCTYPE html>
<html>
<head><meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>My Music</title>
		<link rel="icon" type="image/png" href="/MyMusic/icon.png">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
		</script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<!-- css file when LOCATION Changed -->
		<link rel = "stylesheet" href = "/MyMusic/style.css">

		

</head>
<body style = "background-color: red">
	<!-- Page -->
     <div class = "page">
     
		<!-- Navigation Bar-->
        <nav class = "navbar navbar-fixed-top  navbar-dark">
            <div class = "container">
            
               <div class = "navbar-header">
                   
                   <a href="#" class = "navbar-brand nav-item doWhite sizeHeading">
                        <span class="glyphicon glyphicon-music " ></span> My Music
                   </a>

                   <button type = "button" class = "navbar-toggle" data-toggle = "collapse" data-target = "#myNavbar">
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>                        
          	       </button>
          	       
               </div>
               
               <div class="collapse navbar-collapse" id="myNavbar">
                   <ul class="nav navbar-nav navbar-right ">

                       <li>
             	  			<a href="/MyMusic/secure/ScrollableServlet?source=player" class = "doWhite glyphicon glyphicon-play">
								Player
                        	</a>
                       </li>	

                       <li>
							<a href="/MyMusic/secure/ScrollableServlet?source=contact" class = "doWhite glyphicon glyphicon-earphone ">
								Contact
                       		</a>
                       </li>

                  </ul>
               </div>
            </div>
            
            <!--  search bar -->
            <form method="GET" action="/player">
            	<input type="text" placeholder="Search.." name="nsong" style= "height:40px;margin-left:20px;margin-right:10px;position: relative; width: 80%;margin-bottom:5px;float:left;border-radius:1em;text-align:right;font-size:20px;padding-right:20px;">
            	
            	<button type="submit" class="btn btn-danger" >
            		Search
            	</button>
            </form>
            <!-- End search bar -->
            
        </nav>  

		<!--  Scrollable -->
		<div class="container" style = "background-color:white;min-height:900px;overflow-y:scroll;padding-top:100px;">
		
		<%
		String command = request.getParameter("source");
		if(command != null) {
		if(command.equals("logIn") || command.equals("signUp") ||command.equals("All") || command.equals("player") || command.equals("Rock") || command.equals("Jazz") || command.equals("Hiphop") || command.equals("Pop")) {
		%>	
		 <%@include file = "player.jsp" %>		
		<%
		}
		%>
		
		<%
		if(command.equals("contact")) {
		%>
		 <%@include file = "contact.jsp" %>
		<%	
		}}
		%>
		
		</div>
		<!-- END Scrollable -->
		
		
		<!-- Footer -->	
		<div  class = "border border-dark bf-info" style = "height:80px;bottom:0;width:100%;position:fixed;background-color:#a98ecf;">
			<audio class = "center-block" id="song" preload="auto" controls style= "width:95%; margin-top:10px;">
					<source src="/MyMusic/music/pop/closer.mp4" type="video/mp4"/>
			</audio>		
		</div>
		<!-- END Footer -->
		
	</div>
	<!-- END Page -->
</body>
</html>