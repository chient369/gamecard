const url = 'http://localhost:8090';
let stompClient;
let roomId;
let playerType;


function response(response){
			alert("hahaha");
			let data = JSON.parse(response.body);
			console.log('respone of socket : ' + data);
			displayInfo(data)
		}

function connectToSocket(roomId) {
	console.log("connecting to the room");
	let socket = new SockJS("/gameplay");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function() {
		var url = "/topic-progress/";
		stompClient.subscribe(url,response)
		stompClient.send("/app/api/displayRespone",
			{},
			JSON.stringify({ roomId: roomId})
		)
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
			url: url + "/api/connect",
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

function dp(roomId) {
	$.ajax({
		url: url + "/api/displayRespone",
		type: 'POST',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify({
			"roomId": roomId
		}),
		success: function(data) {
			console.log(data);
		},
		error: function(error) {
			console.log(error);
		}
	})
}