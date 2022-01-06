const url = 'http://localhost:8090';
let stompClient;
var roomId;



function connectToSocket(rommId) {

	console.log("connecting to the room");
	let socket = new SockJS(url + "/gameplay");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected to the frame: " + frame);
		stompClient.subscribe("/topic/game-progress/" + rommId, function(response) {
			let data = JSON.parse(response.body);
			displayInfo(data);
			console.log(data);
			alert("Created")
		})
	})
}


function create_room() {
	var name = "chien";
	var id = "T001";
	$.ajax({
		url: url + "/api/create-room",
		type: 'POST',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify({
			"name": name,
			"id": id
		}),
		success: function(data) {
			connectToSocket(data.roomId);
			displayInfo(data, id);
		},
		error: function(error) {
			console.log(error);
		}
	})
}


function connectToGame() {
	console.log('conneting.....')
	var name = "hung";
	var id = "T008";
	let roomId = document.querySelector('#roomId').value.toUpperCase();
	console.log(roomId)

	if (roomId == null || roomId === '') {
		alert("Please enter room ID");
	} else {
		$.ajax({
			url: url + "/api/connect-room",
			type: 'POST',
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify({
				"roomId": roomId,
				"player": {
					"name": name,
					"id": id
				}
			}),
			success: function(data) {
				connectToSocket(data.roomId);
				displayInfo(data, id)
				//dp(data.roomId);
				alert('Connected to game : ' + data.roomId)
			},
			error: function(error) {
				console.log(error);
			}
		})
	}
}
