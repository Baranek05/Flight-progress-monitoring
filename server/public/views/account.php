<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <link rel="stylesheet" type="text/css" href="public/css/account.css">
    <title>Account</title>
</head>

<body>
    <div id="app">
        <div class="modal">
          <h1>ACCOUNT</h1>
          <div class="user-info">
            <label>USERNAME: </label>
            <div id='username'></div>
          </div>
          <div class="user-info">
            <label>FIRST NAME: </label>
            <div id='first-name'></div>
          </div>
          <div class="user-info">
            <label>LAST NAME: </label>
            <div id='last-name'></div>
          </div>
          <div class="user-info">
            <label>JOB DETAILS: </label>
            <div id='job-details'></div>
          </div>
          
          <button id="menu">
            <a href='/menu'>
              BACK TO MENU
            </a>
          </button>
        </div>
      </div>

      <script src="public/js/account.js"></script>
</body>
