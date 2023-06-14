const loginButton = document.getElementById('login')
const usernameInput = document.getElementById('username')
const passwordInput = document.getElementById('password')


loginButton.addEventListener('click', event => {
    event.preventDefault(); // prevent the form from being submitted normally
    const data = {
        login: usernameInput.value,
        password: passwordInput.value
    };
    fetch('/security/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    }).then(response => response.json())
        .then(data => {
            setCookie('sessionStarted', Date.now(), 310);
            setCookie('user', usernameInput.value, 310);
        });
});



function setCookie(cname, cvalue, exmins) {
    const d = new Date();
    d.setTime(d.getTime() + (exmins * 60 * 1000));
    let expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    console.log('set cookie')
}

function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}


function checkCookie(cname, cvalue, exmins) {
    let user = getCookie(cname);
    if (user == "") {
        setCookie(cname, cvalue, exmins);
    }
}
