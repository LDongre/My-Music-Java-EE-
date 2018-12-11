<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta charset = "utf-8">
		<title>My Music</title>
		<link rel="icon" type="image/png" href="icon.png">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<!--css file made by me -->
		<link rel="stylesheet" href="style.css">

		<!-- js file made by me -->
		<script src="javascript.js" type="text/javascript"></script>
	</head>
	<body>

		<div class = "loader"></div>
	
        <!-- Navigation Bar-->
        <div class = "page">
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
                                    <a href="#" class="glyphicon glyphicon-user doWhite" data-toggle = "modal" data-target = "#signUpModal"> Sign Up</a>
                                </li>
                                <li>
                                    <a href="#" class="glyphicon glyphicon-log-in doWhite" data-toggle = "modal" data-target = "#logInModal"> Log In</a>
                                </li>
                            </ul>
                    </div>
            </div>
            
        </nav>  
         <!-- END Navigation Bar-->
         
         <!-- modal signUp -->
    
         <div id = "signUpModal" class = "modal fade" role = "dialog">
         <form name = "signUpForm" action = "/MyMusic/SignUpServlet" method = "post" >
         	<div  class = "modal-dialog">
         		<div class = "modal-content">
         			<div  class = "modal-header">
         				<button type = "button" class = "close" data-dismiss = "modal">&times;</button>
         				<h4 class = "modal-title text-center">Sign Up</h4>
         			</div>
         			<div class = "modal-body">
         		
                         <div class="form-group">
                              <label for="username">Username:</label>
                              <input type="text" class="form-control" name = "username" id="username" required autofocus>
                        </div>
                        <div class="form-group">
                              <label for="password">Password:</label>
                              <input type="password" class="form-control" id="password" name = "password" required>
                        </div>
                        <div class="form-group">
                              <label for="confirmPass">Confirm password:</label>
                                  <input type="password" class="form-control" name = "confirmPass" id="confirmPass" required>
                        </div>
         				<div class="form-group">
  							<label for="name">Name:</label>
  							<input type="text" class="form-control" name = "name" id="name" required>
						</div>
						<div class="form-group">				
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" name = "address" id="address" required>
						</div>
                        <div class="form-group">
                            <label for="mobile">Mobile number:</label>
                            <input type="text" class="form-control" name = "mobile" id="mobile" required>
                        </div>
                        <div class="form-group">
                              <label for="email">Email</label>
                              <input type="email" class="form-control" name = "email" id="email" required>
                        </div>
                    </div>
         			<div class = "modal-footer">
         				<button type = "submit" class = "btn btn-info center-block" onclick = "return validate();">Submit</button>
         			</div>
         			
         		</div>
         	</div>
         	</form>
         </div>
         <!--  END modal signUp -->
         
         <!-- modal logIn -->
         <div id = "logInModal" class = "modal fade" role = "dialog">
         <form action = "/MyMusic/LogInServlet" method = "post" name = "logInForm" >
         	<div  class = "modal-dialog">
         		<div class = "modal-content">
         			<div  class = "modal-header">
         				<button type = "button" class = "close" data-dismiss = "modal">&times;</button>
         				<h4 class = "modal-title text-center">Log In</h4>
         			</div>
         			<div class = "modal-body">
         			
         				<label for="loginUsername">Username:</label>
         				<div class="input-group">
      						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      						<input id="logInUsername" type="text" class="form-control" name="logInUsername" autofocus placeholder="Username">
    					</div>
    					<br/>
    					<label for="loginPass">Password:</label>
    					<div class="input-group">
      						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      						<input id="logInPass" type="password" class="form-control"  required name="logInPassword" placeholder="Password">
    					</div>

         			</div>
         			<div class = "modal-footer">
         				<button type = "submit" class = "btn btn-info center-block">Submit</button>
         			</div>
         		</div>
         	</div>
         	</form>
         </div>
         <!--  END modal logIn -->
         
         <!-- Carousel -->
         
         						<!-- indicator dots for carousel -->
         <div class="carousel slide" data-ride="carousel" id="myCarousel">
      		<ol class="carousel-indicators">
          	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          	<li data-target="#myCarousel" data-slide-to="1"></li>
          	<li data-target="#myCarousel" data-slide-to="2"></li>
      		</ol>
      							<!-- images of carousel -->
      		<div class="carousel-inner">
      
          		<div class="item active">
              		<img src="images/m1c.jpg" alt="handlaptopPhoto" class = "carouselImage">
              		<div class = "carousel-caption">
                       <p>Feel the Energy of Music</p>
		            </div>
          		</div>
		        <div class="item">
              		<img src="images/m2c.jpg" alt="laptopProjection" class = "carouselImage">
              		<div class = "carousel-caption">
              			<p>Enjoy the Freedom of Music</p>
                    </div>
         	 	</div>
	          <div class="item">
    	          <img src="images/m3c.jpg" alt="idea" class = "carouselImage">
    	          <div class = "carousel-caption">
	           		<P>Perfect place for Music lovers</p>
                  </div>
          	  </div>
          	 
          	 				<!-- arrows of carousel -->
          	  <a class = "left carousel-control" href = "#myCarousel" role = "button" data-slide = "prev">
               	<span class = "glyphicon glyphicon-chevron-left"></span> 
	            <span class = "sr-only">Previous</span>
       		  </a>

	          <a class = "right carousel-control" href = "#myCarousel" role = "button" data-slide = "next">
    	         <span class = "glyphicon glyphicon-chevron-right"></span>
        	     <span class="sr-only">Next</span>
              </a>
 
      	   </div>
  		</div>
  		<!-- END Carousel -->
     	
     	
     	<!-- facilities 
     		<div class = "container">   
     			  		
     				<span class = "glyphicon glyphicon-star">Star</span>
     				<span class = "glyphicon glyphicon-cloud">Cloud</span>
     				<span class = "glyphicon glyphicon-envelope">Envelope</span>
     				<span class = "glyphicon glyphicon-lock">Lock</span>
     		</div>
     	 END facilities -->
     	</div>
     	<!-- jQuery -->
     	<script>
     		$(document).ready(function() {
     	    	$(".page").hide(0);
     	    	$(".loader").delay(3000).hide(400);
     	    	$(".page").delay(4000).show(1000);
     	    	$("#signUpForm").get(0).reset();
     	    	$("#logInForm").get(0).reset();
     	  
     		});
     	</script>
     	<!-- END jQuery -->

	</body>
</html>