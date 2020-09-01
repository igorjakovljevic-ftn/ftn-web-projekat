function registerManager() {
    let email = document.getElementById("email1").value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password1').value;
    let password1 = document.getElementById('password2').value;
    let username = document.getElementById('username').value;
    let date=document.getElementById('date').value;
    let cinema=document.getElementById('cinema').value;
    let id=sessionStorage.getItem("id");
    if(password1==password){
        var formData = JSON.stringify({
            "email": email,
            "name": name,
            "phone_number":phone,
            "lastname":lastname,
            "password":password,
            "username":username,
            "date":date,
            "role":1,
            "activity":true,
            "cinema_id":cinema
        });
        $.ajax({
            url: '/register-manager',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: formData,
            success: function(data){
                window.location.replace("/account/"+id+"/managers");
            },
            error: function( jqXhr, textStatus, errorThrown ){
                window.location.replace("/account/"+id+"/managers");
            }
        });
    }else{
        alert("Lozinke se ne poklapaju.");
    }
}

function managers(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/managers");
}

function createManager(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/register_man");
}

function deleteManager(manager_id){
    let id=sessionStorage.getItem("id");
    $.ajax({
        url: '/remove_manager/'+manager_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/account/"+id+"/managers");
        },
        error: function(){
            window.location.replace("/account/"+id+"/managers");
        }
    });
}


function initCinema(){
    let id = sessionStorage.getItem("id");
    let role = sessionStorage.getItem("role");
    let offline=document.getElementById("offline");
    let online=document.getElementById("online");
    let admin = document.getElementsByClassName("admin");
    if (id == null) {
    	for (let i = 0; i < admin.length; i++) {
    		admin[i].style.display = "none";
    	}
        offline.style.display="block";
        online.style.display="none";
    } else {
    	if (role == "ADMIN") {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "";
    		}
    	} else {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "none";
    		}
    	}
        online.style.display = "block";
        offline.style.display = "none";
    }
}

function init(){
    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementById("online");
    if (id == null) {
        online.style.display="none";
        offline.style.display="block";
    } else {
        online.style.display="block";
        offline.style.display="none";
    }
}
function initAcc(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let viewer=document.getElementsByClassName("viewer");
    let admin=document.getElementsByClassName("admin");
    let manager=document.getElementsByClassName("manager");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }
        for (let i = 0; i < admin.length; i++) {
            admin[i].style.display = "none";
        }
        for (let i = 0; i < manager.length; i++) {
            manager[i].style.display = "none";
        }
        alert("You have to be logged in to view your profile!");
        window.location.replace("/");
    } else {
        let role=sessionStorage.getItem("role");
        if (role == "VIEWER") {
    		for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
    	} else if(role=="ADMIN"){
    		for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
        }else{
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "";
            }
        }
        

        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
function initMovie(){

    let id = sessionStorage.getItem("id");
    let role=sessionStorage.getItem("role");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    if (id == null || role!="VIEWER") {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        alert("Samo gledaoci mogu da rezervisu karte.");
        window.location.replace("/");
    } else {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
function initMovies(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let viewer=document.getElementsByClassName("viewer");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }
        
    } else {
        let role=sessionStorage.getItem("role");
        if (role == "VIEWER") {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }
            
    	} else {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }

    	}
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}

function cancelReservation(projection_id){
    var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "projection_id": projection_id,
    });
    $.ajax({
        url: '/cancel_reservation',
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        data: formData,
        success: function(){
            window.location.replace("/account/"+id+"/reservations");
        },
        error: function(){
            window.location.replace("/account/"+id+"/reservations");
        }
    });
    
}

function addCinema() {
    let email = document.getElementById('emailc').value;
    let name = document.getElementById('name').value;
    let phone = document.getElementById('phone').value;
    let address = document.getElementById('address').value;
    var formData = JSON.stringify({
        "email": email,
        "name": name,
        "phone_number":phone,
        "address":address
    });
    console.log(formData);
    $.ajax({
        url: '/add-cinema',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(){
        	console.log("success");
            window.location.replace("/cinemas");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Greska.");
                return;
                }
        }
    });
}
function deleteCinema(id) {

    $.ajax({
        url: '/cinemas/'+id,
        type: 'delete',
        success: function(){
        	console.log("success");
            window.location.replace("/cinemas");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Greska.");
                return;
                }
        }
    });
}
function edit(cinema_id){
    window.location.replace("/cinema/"+cinema_id);
}
function editCinema(cinema_id){

    let name=document.getElementById("name").value;
    let address=document.getElementById("address").value;
    let phone_number=document.getElementById("phone_number").value;
    let email=document.getElementById("email").value;
    var formData = JSON.stringify({
        "id":cinema_id,
        "name": name,
        "address": address,
        "email":email,
        "phone_number":phone_number,
        "schedule":null,
        "managers":null,
        "rooms":null
    });
    $.ajax({
        url: '/edit_cinema',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Greska.");
			}
			else {
				window.location.replace("/cinemas");
			}
		  }
    });
    
}

function login() {
    // get the form data
    // there are many ways to get this data using jQuery (you can use the class or id also)
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    var formData = JSON.stringify({
        "email": email,
        "password": password
    });
    console.log(formData);
    $.ajax({
        url: '/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("role",data["role"]);

            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Nepostojeca email adresa.");
                return;
            } else if (jqXhr.status == 400) {
                alert("Pogresna lozinka.");
                return;
            } else if (jqXhr.status == 406) {
            	alert("Serverska greska.");
            	return;
            }
            // default handling
            alert("error")
        }
    });
}
function register() {
    let email = document.getElementById('email').value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password').value;
    let password1 = document.getElementById('password1').value;
    let username = document.getElementById('username').value;
    let date=document.getElementById('date').value;
    
    if(password1!=password){
    	alert("Lozinke se ne poklapaju.");
    	return;
    }
    else{
    var formData = JSON.stringify({
        "email": email,
        "name": name,
        "phone_number":phone,
        "lastname":lastname,
        "password":password,
        "username":username,
        "date":date,
        "role":0,
        "activity":false
    });
    console.log(formData);
    $.ajax({
        url: '/register-user',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
        	console.log("success");
        	sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("role",data["role"]);
            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Greska.");
                return;
                }
        }
    });
    }
}
function logOut() {
	sessionStorage.clear();
	window.location.replace("/");
}
function profile(){
	var id=sessionStorage.getItem("id");
	window.location.replace("/account/"+id);
}
function watched_movies(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/watched_movies");
}
function reservations(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/reservations");
}

function sort(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("Movies");
  switching = true;
  dir = "asc";
  var thead=document.getElementById("th"+n);
  while (switching) {
    switching = false;
    rows = table.rows;
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;
    } else {
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
 	
}


function filterData(moviesDTO)
{
	var moviename=document.getElementById("moviename").value;
	var genre=document.getElementById("genre").value;
	var time=document.getElementById("time").value;
	var rating=document.getElementById("rating").value;
	var description=document.getElementById("description").value;
	var price=document.getElementById("price").value;
	var filter=[];
	var movies=moviesDTO.movies;
	for(let i=0;i<movies.length;i++)
	{
		document.getElementById(movies[i].id).style.display="";
	}
	if(moviename!="")
		filter["name"]=moviename;
		
	if(genre!="Genre")
		filter["genre"]=genre;
		

	if(rating!="")
		filter["rating"]=rating;
		
		
	if(description!="")
		filter["description"]=description;
		
		
	if(price!="")
		filter["price"]=price;
		
		
	if(time!="")
		filter["time"]=time;;
	for (const [key, value] of Object.entries(filter)) {
		filterOne(movies,key,value);
	}
}

function filterOne(movies,key,value)
{
	for(let i=0;i<movies.length;i++)
	{
		finalFilter(movies[i],key,value);
	}
}

function finalFilter(movie,key,value)
{
	if(document.getElementById(movie.id).style.display=="none")
	{
		return;
	}
	let flag=false;
	if(key=="price"){
		for(let i=0;i<movie.projections.length;i++){
			if(parseInt(value)>=movie.projections[i].price)
				flag=true;
		}
	}
	else if(key=="time"){
		let help=value.split(":");
		for(let i=0;i<movie.projections.length;i++)
		{
			let arr=movie.projections[i].time.split(":");
			if(parseInt(help[0])>=parseInt(arr[0]))
			{
				if(parseInt(help[1])>=parseInt(arr[1]))
					flag=true;	
			}	
		}
	}
	else if(key=="rating"){
		if(parseFloat(value)<=parseFloat(movie.rating))
			flag=true;
	}else if(key=="name"){
		if(movie.name.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="description"){
		if(movie.description.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="genre"){
		if(value!="Genre")
		{
			if(movie.genre==value)
				flag=true;
		}
		else
			flag=true;
	}
	
	if(flag){
		document.getElementById(movie.id).style.display="";
	}
	else{
		document.getElementById(movie.id).style.display="none";
	}
	
	
}

function getMovie(id) {
    $.ajax({
        url: '/movie/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/movie/"+id);
        },
        error: function(){
            	alert("Server error");
            	return;
        }
    });
}
function reserve(projection_id){

	var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "projection_id": projection_id,
    });
    $.ajax({
        url: '/reserve_ticket',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Vec imate rezervaciju / Sala je puna.");
			}
			else {
				window.location.replace("/account/"+id+"/reservations");
			}
		  }
    });
    
}

function rateMovie(movie_id,watched_movie_id){
    let rating=parseInt(document.getElementById("rated").value);
    var formData = JSON.stringify({
        "movie_id": movie_id,
        "watched_movie_id": watched_movie_id,
        "rating":rating
    });
    var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/rate',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
			if (status === 'error') {
				console.log(error);
				alert("Neuspesno ocenjivanje.");
			}
			else {
                window.location.replace("/account/"+id+"/watched_movies");			
            }
		  }
    });
    
}
function showRated(user){
    showAll(user);
    for(let i=0;i<user.watched_movies.length;i++){
        if(user.watched_movies[i].rating!=0)
            document.getElementById(user.watched_movies[i].id).style.display="";
        else
            document.getElementById(user.watched_movies[i].id).style.display="none";
    }
}
function showUnrated(user){
    showAll(user);
    for(let i=0;i<user.watched_movies.length;i++){
        if(user.watched_movies[i].rating==0)
            document.getElementById(user.watched_movies[i].id).style.display="";
        else
            document.getElementById(user.watched_movies[i].id).style.display="none";
    }
}
function showAll(user){
    for(let i=0;i<user.watched_movies.length;i++){
        document.getElementById(user.watched_movies[i].id).style.display="";
    }
}


function addRoom(cinema_id){

	var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "mark": mark,
        "capacity": capacity,
        "cinema_id":cinema_id
    });
    $.ajax({
        url: '/add_room',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Greska");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function deleteRoom(room_id,cinema_id){

	var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/delete_room/'+cinema_id+'/room/'+room_id,
        dataType: 'json',
        type: 'delete',
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Greska");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function editRoom(room_id){

	var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "id":room_id,
        "mark": mark,
        "capacity": capacity,
    });
    $.ajax({
        url: '/edit_room',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Greska");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function edit(room_id){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/cinema/room/"+room_id);
}
function cinema(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/cinema");
}
function schedule(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/schedule");
}

function AddProjection(cinema_id){
    var id=sessionStorage.getItem("id");
    let movie=document.getElementById("movie").value;
    let room=document.getElementById("room").value;
    let date=document.getElementById("date").value;
    let time=document.getElementById("time").value;
    let price=document.getElementById("price").value;
    var formData = JSON.stringify({
        "room_id": room,
        "movie_id": movie,
        "day":date,
        "time":time,
        "price":price,
        "cinema_id":cinema_id
    });
    $.ajax({
        url: '/add_projection',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Greska");
			}
			else {
				window.location.replace("/account/"+id+"/schedule");
			}
		  }
    });
}
