const logOutButton = document.getElementById('log-out');

logOutButton.addEventListener('click', event => {
    document.cookie = `user=;expires=${new Date(0)}; path=/;`
})


