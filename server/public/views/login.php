<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <title>LOGIN PAGE</title>
</head>

<body>
  <div id="app">
    <form class="modal" action='login' method='POST'>
      <div class="input-container">
        <div class="input-group">
          <label for="username">USERNAME:</label>
          <input name='username' type="text" id="username">
        </div>
        <div class="input-group">
          <label for="password">PASSWORD:</label>
          <input name='password' type="password" id="password">
        </div>
      </div>
      <button id='login' type="submit">LOG IN</button>
    </form>
  </div>

  <script src="public/js/login.js"></script>
</body>

