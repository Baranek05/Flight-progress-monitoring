const menuButton = document.getElementById('menu')

const usernameItem = document.getElementById('username')
const firstNameItem = document.getElementById('first-name')
const lastNameItem = document.getElementById('last-name')
const jobDetailsItem = document.getElementById('job-details')

const username = getCookie('user')

fetch(`/accountInfo/${username}`, {
    method: 'GET'
}).then(response => {
    return response.json()
}).then(result => {
    fillUserDetails(result)
})

function fillUserDetails(userDetails) {
    usernameItem.innerHTML = userDetails.login
    firstNameItem.innerHTML = userDetails.name
    lastNameItem.innerHTML = userDetails.surname
    jobDetailsItem.innerHTML = userDetails.jobDetails
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

