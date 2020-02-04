/**
 * 
 */



function getStudentData(){
	var urlString = "http://localhost:8080/First_WebApp_Examples/StudentList_JSON";
	var request = new XMLHttpRequest();
	request.open("GET", urlString, true);
	request.send();
	function requestListener(){
		if(request.readyState === 4 && request.status === 200){
			console.log("The Servlet returned the following JSON text: "+ request.responseText);
			showStudentList(request.responseText);
		}
	}
	
}



function showStudentList(jsonText){
	var jsonObj = JSON.parse(jsonText);
	var studentArray = jsonObj.students;
	console.log(studentArray)
	var outputText = "";
	for(var i = 0; i < studentArray.length; i++){
		outputText = outputText + studentArray[i].firstname + "<br/>"
	}
	document.getElementById("p1").innerHTML = outputText;
}

(function run(){
	getStudentData();
})();


