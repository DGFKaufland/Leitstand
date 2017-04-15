$(function(){ 
   
	var host = window.location.origin;
	
///////// Navigation ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$('.nav li a').click(function(){
        $('.nav li a').removeClass('active')
        $(this).addClass('active') 
    });

    	
	//Schlummer & Beschreibung INITIAL IN DATENBANK EINTRAGEN	
	 $('#btnSetSnoozeAndDescription').unbind('click').click(function() {
		 writeSnoozeAndDescriptionInDB();
  	   	 });

  	   	 function writeSnoozeAndDescriptionInDB() {
  	   		 
  	   		 var snooze = document.getElementById("snooze_time").value;
  	   		 var description = document.getElementById("description").value;
  	   		 var id = document.getElementById("process_id").value;
  		
  	   	 $.ajax({
  	   	   	 type: 'POST',
  	   	   	 contentType: 'application/json',
  	   	   	 url: host+'/Leitstand/services/MobileNotification/setSnoozeAndMessage',
  	   	   	 dataType: "json",
  	   	   	 data: JSON.stringify({
  	   	   		 "id": id,
  	   	   		 "snooze_time": snooze,
  	   	   		 "message": description
  		 		}),
  	   	   	 success: function(data){   	   	
  	   
  	   	   	$('#anzfeld').load('home.html');

  	   	   	 },
  	   	   	 error: function(jqXHR, textStatus, errorThrown){
  	   	   	 alert('User anlegen error: ' + textStatus);
  	   	   	 }
  	   	   	 });
  	  }
	
 
  	 //State auf erledigt (2) setzen und kurze Beschreibung mitgeben, dass der Leitstand den Fehler behoben hat
	 $('#btnSetTaskSolved').unbind('click').click(function() {
    	 setTaskSolvedInDB();
		 return false;
    	 });

    	 function  setTaskSolvedInDB(){

    		if(confirm("Wollen Sie dieses Problem wirklich als behoben markieren?")){
    			   	
    			
    			var state = 2;
    			var description = "Task wurde durch den Leitstand auf erledigt gesetzt";
    			var snooze = 0;
    			var id = document.getElementById("process_id").value;
    			
    	    	 $.ajax({
    	    	 type: 'POST',
    	    	 contentType: 'application/json',
    	    	 url: host+'/Leitstand/services/MobileNotification/solveTask',
    	    	 dataType: "json",
    	    	 data: JSON.stringify({
      	   	   		 "id": id,
    	    		 "state": state,
    	    		 "snooze_time": snooze,
      	   	   		 "message": description
      		 		}),
    	    	 success: function(data, textStatus, jqXHR){
    	    	 alert('Problem wurde erfolgreich behoben');
    	    	 $('#anzfeld').load('home.html');
    	    	 },
    	    	 error: function(jqXHR, textStatus, errorThrown){
    	    	 alert('MobileNotification error: ' + textStatus);
    	    	 }
    	    	 });
    		}
    		return false;  
    	 }
	 
      	 //Testmail senden
    	 $('#btnSendTestmail').unbind('click').click(function() {
        	 sendTestmail();
    		 return false;
        	 });

        	 function sendTestmail(){

        		if(confirm("Wollen Sie wirklich eine Testmail senden ?")){
        			   	
        		
        			var id = 123;
        			
        	    	 $.ajax({
        	    	 type: 'POST',
        	    	 contentType: 'application/json',
        	    	 url: host+'/Leitstand/services/MobileNotification/sendTestmail',
        	    	 dataType: "json",
        	    	 data: JSON.stringify({
          	   	   		 "id": id
          		 		}),
        	    	 success: function(data, textStatus, jqXHR){
        	    	 alert('Testmail wurde versendet');
        	    	 $('#anzfeld').load('home.html');
        	    	 },
        	    	 error: function(jqXHR, textStatus, errorThrown){
        	    	 alert('Testmail senden error: ' + textStatus);
        	    	 }
        	    	 });
        		}
        		return false;  
        	 }
        	 
	 
});

