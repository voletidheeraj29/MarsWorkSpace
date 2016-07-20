function validate()
	{
		  var name = document.getElementById('name').value;
		  var pass = document.getElementById('pass').value;
		  var email = document.getElementById('email').value;
		  var regex=/^([a-z]+[A-Z]*)$/;
		  var regex1=/^([a-zA-Z]*[0-9!@#$%]+[a-zA-Z]+[0-9!@#$%]*)|([0-9!@#$%]*[a-zA-Z]+[0-9!@#$%]+[a-zA-Z]*)$/;
		  var regex2= /^(([a-zA-Z0-9.#]*[a-zA-z0-9]+[A-Z0-9.#]*)[@]([a-z]+)[.]([a-z]{2,3}[.])*([a-z]{2,4}))$/;
		  if (name==null || name=="")
		  {  
		  document.getElementById('name').style.border ='1px solid green';
		    alert("Name cannot be empty");  
		    document.getElementById('name').style.border ='';
		    return false;  
		  }
		  else if(!regex.test(name)){
		  document.getElementById('name').style.border ='1px solid green';
		    alert("invalid name ");  
		    document.getElementById('name').style.border ='';
		    return false;  
		  }
		  if (pass==null || pass=="")
		  {  
		  document.getElementById('pass').style.border ='1px solid green';
		    alert("password cannot be empty");  
		    document.getElementById('pass').style.border ='';
		    return false;  
		  }
		  else if(!regex1.test(pass)){
		  document.getElementById('pass').style.border ='1px solid green';
		    alert("invalid pass ");  
		    document.getElementById('pass').style.border ='';
		    return false;  
		  }  if (email==null || email=="")
		  {  
			  document.getElementById('email').style.border ='1px solid green';
			    alert("Email cannot be empty");  
			    document.getElementById('email').style.border ='';
			    return false;  
			  }
			  else if(!regex2.test(email)){
			  document.getElementById('email').style.border ='1px solid green';
			    alert("invalid Email ");  
			    document.getElementById('email').style.border ='';
			    return false;  
			  }	  
		  
	}



