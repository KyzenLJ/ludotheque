//
//$( document ).ready(function() {
//	
//	// SOUMETTRE LE FORMULAIRE
//    $("#modifJeuForm").submit(function(event) {
//		// Empêche le formulaire d'être lancé directement par le browser.
//		event.preventDefault();
//		ajaxPost();
//	});
//    
//    
//    function ajaxPost(){
//    	
//    	// DEFINI LES INFOS DU FORMULAIRE
//    	var formData = {
//    		titre : $("#titre").val(),
//    		description :  $("#description").val(),
//    		theme :  $("#theme").val(),
//    		joueurMin :  $("#joueurMin").val(),
//    		joueurMax :  $("#joueurMax").val(),
//    		exemplaireCatalogue :  $("#exemplaireCatalogue").val(),
//    		exemplaireDispo :  $("#exemplaireDispo").val()
//    	}
//    	
//    	// DO POST
//    	$.ajax({
//			type : "POST",
//			contentType : "application/json",
//			url : window.location + "/gestionCatalogue",
//			data : JSON.stringify(formData),
//			dataType : 'json',
//			success : function(result) {
//				if(result.status == "Done"){
//					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
//												"---> Le jeu " + 
//												result.data.titre + " à été ajouté avec succès " + "</p>");
//				}else{
//					$("#postResultDiv").html("<strong>Error</strong>");
//				}
//				console.log(result);
//			},
//			error : function(e) {
//				alert("Error!")
//				console.log("ERROR: ", e);
//			}
//		});
//
//    	resetData();
//    }
//    
//    function resetData() {
//    	$("#titre").val("");
//    	$("#description").val("");
//    	$("#theme").val("");
//    	$("#joueurMin").val("");
//    	$("#joueurMax").val("");
//    	$("#exemplaireCatalogue").val("");
//    	$("#exemplaireDispo").val("");
//    }
//})
//    }