function anichange(objName) {
    if ($(objName).css('display') == 'none') {
        $(objName).animate({height: 'show'}, 400);
    } else {
        $(objName).animate({height: 'hide'}, 200);
    }
}

function addMessage(userId, writerId) {
    $.post("/addEntry",
        {
            message: $('#textbox').val(),
            userId: userId,
            writerId: writerId
        }, {});

    if (textbox.value == "") return false;
    var list = document.getElementById('list');
    var firstLi = list.getElementsByTagName('LI')[0];
    var newListElem = document.createElement('LI');
    // var image = document.createElement("button('button')")
    // image.className = "wall_image"
    // newListElem.innerHTML = textbox.value+image;
    newListElem.innerHTML = textbox.value;
    newListElem.className = "message";
    list.insertBefore(newListElem, firstLi);
    textbox.value = "";

}

function anichanged(objName) {
    if ($(objName).css('display') == 'none') {
        $(objName).animate({height: 'show'}, 400);
    }
}

function unanichanged(objName) {
    if ($(objName).css('display') != 'none') {
        $(objName).animate({height: 'hide'}, 200);
    }
}

function addToFriend(friendId, myId) {
    $.ajax(
        {
            type: 'POST',
            url: "/addToFriend",
            data: {
                friend: friendId,
                user: myId
            },
            complete: function () {
                window.location.replace("/user?id=" + friendId);
            }
        });
}

function deleteFriend(friendId, myId) {
    $.ajax(
        {
            type: 'POST',
            url: "/deleteFriend?friend=" + friendId,
            data: {
                friend: friendId,
                user: myId
            },
            complete: function () {
                window.location.replace("/user?id=" + friendId);
            }
        });
}

function search(searchText, objName) {
    // $("#searchLine").keyup(
    //     if ($(objName).css('display') == 'none') {
    //         $(objName).animate({height: 'show'}, 400);
    //     }
    // } else {
    //     $(objName).animate({height: 'hide'}, 200);
    // }
    $.ajax({
        type: 'GET',
        url: "/searchh",
        data: {
            line: $('#searchLine').val()
        },
        success: function (data) {
            var response = $(data);
            if ($(objName).css('display') == 'none') {
                $(objName).animate({height: 'show'}, 400);
            }
            // alert(data);
            $('#result').html(response.find("#result").html());
            // if(response.find("#result").h == response.find("#empty")){
            //     alert("empty");
            // }else {
            //     alert("not empty");
            // }
        }
    })

}