<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <link rel="stylesheet" type="text/css" href="public/css/session.css">
    <title>Session</title>
</head>

<body>
    <div id="app">
        <div class="modal">
          <h1>SESSION</h1>
          <div class="session-info">
            <label>SHIFT BEGAN: </label>
            <div id='shift-begin'></div>
          </div>
          <div class="session-info">
            <label>CALCULATED BEGIN OF MANDATORY REST: </label>
            <div id='rest-begin'></div>
          </div>
          <div class="session-info">
            <label>CALCULATED END OF REST: </label>
            <div id='rest-end'></div>
          </div>
          <div class="session-info">
            <label>CALCULATED END OF SHIFT: </label>
            <div id='shift-end'></div>
          </div>
          
          <button id="menu">
            <a href='/menu'>
              BACK TO MENU
            </a>
          </button>
        </div>
      </div>

      <script src="public/js/session.js"></script>
</body>