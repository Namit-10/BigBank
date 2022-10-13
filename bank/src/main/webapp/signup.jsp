<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	
	<script>
	function ageCalculator() {  
	    //collect input from HTML form and convert into date format  
	    var userinput = document.getElementById("dob").value;  
	    var dob = new Date(userinput);  
	      
	    //check user provide input or not  
	    if(userinput==null || userinput==''){  
	      document.getElementById("message").innerHTML = "Enter a valid date!";    
	      return false;   
	    }   
	      
	    //execute if user entered a date   
	    else {  
	    //extract and collect only date from date-time string  
	    var mdate = userinput.toString();  
	    var dobYear = parseInt(mdate.substring(0,4), 10);  
	    var dobMonth = parseInt(mdate.substring(5,7), 10);  
	    var dobDate = parseInt(mdate.substring(8,10), 10);  
	      
	    //get the current date from system  
	    var today = new Date();  
	    //date string after broking  
	    var birthday = new Date(dobYear, dobMonth-1, dobDate);  
	      
	    //calculate the difference of dates  
	    var diffInMillisecond = today.valueOf() - birthday.valueOf();  
	  
	    //convert the difference in milliseconds and store in day and year variable          
	    var year_age = Math.floor(diffInMillisecond / 31536000000);  
	    var day_age = Math.floor((diffInMillisecond % 31536000000) / 86400000);  
	  
	    //when birth date and month is same as today's date        
	    if ((today.getMonth() == birthday.getMonth()) && (today.getDate() == birthday.getDate())) {  
	            alert("Yaay!! Happy Birthday!");  
	        }  
	          
	     var month_age = Math.floor(day_age/30);          
	     day_ageday_age = day_age % 30;  
	          
	     var tMnt= (month_age + (year_age*12));  
	     var tDays =(tMnt*30) + day_age;  
	       
	    //DOB is greater than today's date, generate an error: Invalid date    
	     if (dob>today) {  
	        document.getElementById("result").innerHTML = ("Date cannot be after today!");  
	      }  
	      else {  
	        if(year_age < 18){
	        	document.getElementById("result").innerHTML = "Age cannot be less than 18 years old!!"
	        	
	        }
	        else {
	        	document.getElementById("result").innerHTML = "";
	        	document.getElementById("message").innerHTML = "";
	        	
	        }
	      }  
	   }  
	}
	
	
		function ValidateEmail(document.signUpForm.email)
		{
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(inputText.value.match(mailformat))
		{
		return true;
		}
		else
		{
		document.getElementById("error-email-message").innerHTML = "Please enter a valid email!";
		document.signUpForm.email.focus();
		return false;
		}
		}
		
		function subtractYears(numOfYears, date = new Date()) {
			  date.setFullYear(date.getFullYear() - numOfYears);

			  return date;
			}
		
		function checkUsername() {
			
		}
		
		function selectStateCountryPincodeByCity(x) {
			  alert("Function called");
			  if(x === "Bengaluru"){
				  document.getElementById("State").innerText = "Karnataka";
				  document.getElementById("pincode").innerText = 560001;
			  }
			  else if(x === "Chennai"){
				  document.getElementById("State").value = "Tamil Nadu";
				  document.getElementById("pincode").value = 600001;
			  }
			  else if(x === "Delhi"){
				  document.getElementById("State").value = "Delhi";
				  document.getElementById("pincode").value = 110001;
			  }
			  else if(x === "Mumbai"){
				  document.getElementById("State").value = "Maharashtra";
				  document.getElementById("pincode").value = 400001;
			  }
			  else if(x === "Kolkata"){
				  document.getElementById("State").value = "West Bengal";
				  document.getElementById("pincode").value = 700001;
			  }
			  else if(x === "Hyderabad"){
				  document.getElementById("State").value = "Telangana";
				  document.getElementById("pincode").value = 500001;
			  }
			  
			  document.getElementById("country").innerHTML.value = "India";
			}
	</script>
	<style>
		body{
			background-color: #800080;
		}
	</style>
<title>Sign up</title>
</head>
<body>
	<div class="form-contents" style="height: 100%; width: 50%; background-color: white;  border-radius: 15px; padding: 20px; align-items: center; margin-top: 5%; margin-bottom: 10%; margin-left: 25%;">
	<form class="signUpForm row g-3"  action="Signup" onsubmit="return validateForm()" method="post">
	<center><h1 style="padding: 30px;">Signup</h1></center>
  <div class="col-md-6">
    <label for="firstName" class="form-label">First Name</label>
    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter firstname" required>
  </div>
  <div class="col-md-6">
    <label for="lastName" class="form-label">Last Name</label>
    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter lastname" required>
  </div>
  
  <div class="col-md-12">
  <div class="form-check">
  <p>Gender</p>
  <input class="form-check-input" type="radio" name="gender" id="genderRadio1" value="Female">
  <label class="form-check-label" for="genderRadio1">
    Female
  </label>
  </div>
  <div class="form-check">
  <input class="form-check-input" type="radio" name="gender" id="genderRadio2" value="Male" checked>
  <label class="form-check-label" for="genderRadio2">
    Male
  </label>
  </div>
  </div>
 
  
   <div class="col-md-6">
    <label for="dob" class="form-label">Date of birth</label>
    <input type="date" class="form-control datepicker" id="dob" name="dob" required>
    <span id = "result" style="color:red"> </span>
    <script>
	$('#dob').datepicker({
  	endDate: '-18y'
	});
</script>
  </div>
  
  <div class="col-md-6">
    <span id = "message" style="color:red"> </span>
  </div>
  <div class="col-12">
  
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" id="email" onchange="ValidateEmail()" name="email" required>
    <p class="error-email-message"><p>
    
  </div>
  
  
  <div class="col-12">
    <label for="phoneNo" class="form-label">Phone Number<br><span><small>Enter a 10 digit valid phone number</small></span></label>
    <input type="number" class="form-control" id="phoneNo" name="phoneNo" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="10" required>
  </div>
  
  <div class="col-md-12 dropdown-divider" style="margin-top: 20px; margin-bottom: 20px;"></div>
  
  <div class="col-12">
    <label for="address" class="form-label">Address</label>
    <input type="textarea" class="form-control" id="address" name="address" placeholder="1234 Main St" required>
  </div>
  
  <!-- <div class="col-md-6">
    <label for="city" class="form-label">City</label>
    <select name="city" id="city">
    <option value="Bengaluru" selected>Bengaluru</option>
    <option value="Chennai">Chennai</option>
    <option value="Delhi">Delhi</option>
    <option value="Hyderabad">Hyderabad</option>
    <option value="Kolkata">Kolkata</option>
    <option value="Mumbai">Mumbai</option>
    </select>
  </div> -->
  
  <div class="input-group col-md-6">
  <div class="input-group-prepend">
    <label class="input-group-text" for="city">City</label>
  </div>
  <select class="custom-select" name="city" id="city" >
    <option value="Bengaluru" onclick="selectStateCountryPincodeByCity('Bengaluru')">Bengaluru</option>
    <option value="Chennai" onclick="selectStateCountryPincodeByCity(this.value)">Chennai</option>
    <option value="Delhi" onclick="selectStateCountryPincodeByCity(this.value)">Delhi</option>
    <option value="Hyderabad" onclick="selectStateCountryPincodeByCity(this.value)">Hyderabad</option>
    <option value="Kolkata" onclick="selectStateCountryPincodeByCity(this.value)">Kolkata</option>
    <option value="Mumbai" onclick="selectStateCountryPincodeByCity(this.value)">Mumbai</option>
  </select>
</div>

  <div class="col-md-6">
    <label for="inputState" class="form-label">State</label>
    <input type="text" class="form-control" id="state" name="state" required>
  </div>
  <div class="col-md-6">
    <label for="pincode" class="form-label">Pincode</label>
    <input type="number" class="form-control" id="pincode" name="pincode" min=0 maxlength="6" required>
  </div>
  
  <div class="col-md-6">
    <label for="pincode" class="form-label">Country</label>
    <input type="text" class="form-control" id="country" name="country" required>
  </div>
  
  <div class="col-md-12 dropdown-divider" style="margin-top: 20px; margin-bottom: 20px;"></div>
  
  <div class="col-12">
    <label for="panNo" class="form-label">PAN Number<br><span><small>Enter a 10 digit valid PAN number Example: ABCDG9782K</small></span></label>
    <input type="text" class="form-control" id="panNo" name="panNo" pattern="^[a-zA-Z]{5}[0-9]{4}[a-zA-Z]$" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="10" required>
  </div>
  
  <div class="col-12">
    <label for="aadharNo" class="form-label">Aadhar Number<br><span><small>Enter a 12 digit valid aadhar number</small></span></label>
    <input type="text" class="form-control" id="aadharNo" name="aadharNo" pattern="^[0-9]{12}$" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="12" required>
  </div>
  
  <div class="col-md-12 dropdown-divider" style="margin-top: 20px; margin-bottom: 20px;"></div>
  
  
  <div class="col-md-6">
  	<label for="username" class="form-label">Username<br><span><small>Choose a username.<br>You will use this for logging in.</small></span></label>
    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" oninput="checkUsername()" required>
    <p style="color:red;" id="username-already-taken" name="username-already-taken"></p>
  </div>
  <div class="col-md-6">
  	<label for="password" class="form-label">Password<br><span><small>Choose a password.<br><br></small></span></label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
    <p></p>
  </div>
  <div class="d-grid gap-2 col-8 mx-auto" style="padding: 30px;">
  <p>Already have an account?</p>
  <a href="login.jsp">Click here to login</a>
    <button type="submit" class="btn btn-primary" onclick="ValidateForm()">Sign in</button>
  </div>
  </div>
</form>
</div>
</body>
</html>