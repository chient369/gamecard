'use strict';
$(document).ready(function () {
    setTimeout(function () {
        $('.table-background-logo').fadeOut()
        $('#menu-content').fadeIn();
    }, 1000);
});

//menu js
$('#menu-btn').click(function () {
    $('#menu-content').toggle();
})
//exit btn
$('.exit-btn').click(function () {
    $('#menu-content').hide();
})

//click btn create of process
function displayInfo(data) {
	
    var players = data.players;
    let roomId = data.roomId;
    let playerAmount = players.length;
    let yourIndex = 0;
    for (let i = 0; i < playerAmount; i++) {
        var player = players[i];
        if (players[i].id === id) {
            display(player, roomId, yourIndex);
            yourIndex = i;
            break;
        }
    }
    if (playerAmount > 1) {
        var index = 1;
        for (let i = (yourIndex + 1) % playerAmount; i < playerAmount; i = (i + 1) % playerAmount) {
            var player = players[i];
            if (i != yourIndex) {
                display(player, roomId, index);
                index++;
            } else {
                break;
            }

        }
    }




}
function display(player, roomId, index) {
    let role = player.role;

    let idElement = document.querySelector('#rid');
    $('.header-info_item:first').show();
    idElement.innerText = 'ROOM' +  roomId;
    document.querySelector('#pname').innerText = player.name;
    document.querySelector('#pwallet').innerText = player.wallet;

    let pInfoNode = '.player_info-' + (index + 1);

    console.log(pInfoNode);

    let pInfo = document.querySelector(pInfoNode);
    let infoNode = pInfo.getElementsByTagName('p');
    infoNode[0].innerText = player.name;
    infoNode[1].innerText = player.wallet;
    if (role === 'MASTER') {
        var dealerIndex = '.dealer-' + (index + 1);
        $(dealerIndex).show();
        $('.master_opera').show();
    } else {
        $('#menu_connect_game_form').hide();
        $('.joiner_opera').show();
    }
    $('#menu-content').hide();
}

//join game of form 

$('.join_game-btn').click(function () {
    $('#menu-content').hide();
    $('#menu_connect_game_form').show();
})

$('#join_back-btn').click(function () {
    $('#menu_connect_game_form').hide();
    $('#menu-content').show();
})



