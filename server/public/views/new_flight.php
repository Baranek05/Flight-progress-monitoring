<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <link rel="stylesheet" type="text/css" href="public/css/new_flight.css">
    <title>New Flight</title>
</head>

<body>
    <div id="app">
        <form class="container" action='addFlight' method='POST'>
            <div>
                <h1>
                    New Flight
                </h1>    
            </div>
            <div class="input">
                <textarea name='flightInfo' id="flight_input"></textarea>
            </div>
            <div class="form-control">
                <form action='addFlight' method='POST'>
                    <button type='submit' id="flight-create">Create</button>
                </form>
                <button id="flight-cancel">
                    <a href='/menu'>
                        Cancel
                    </a>
                </button>
            </div>
        </form>
      </div>
</body>
