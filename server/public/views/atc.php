<!DOCTYPE html>
<head>
    <link rel='stylesheet' type='text/css' href='public/css/style.css'>
    <title>ATC</title>

    <?php 
        function includeWithVariables($filePath, $variables = array(), $print = true)
        {
            $output = NULL;
            if(file_exists($filePath)){
                // Extract the variables to a local //namespace
                extract($variables);

                // Start output buffering
                ob_start();

                // Include the template file
                include $filePath;

                // End buffering and return its contents
                $output = ob_get_clean();
            }
            if ($print) {
                print $output;
            }
            return $output;
        }
    ?>
</head>

<body>
    <div id="app">
        <div class="container">
            <div class="left-nav">
                <div id="atc-create" class="nav-button clickable">
                    <a href='/addFlight'>
                        <img src="public/img/add.png" />
                    </a>
                </div>
                <div id="atc-delete" class="nav-button clickable">
                    <img src="public/img/bin.png"/>
                </div>
                <div id="atc-menu" class="nav-button clickable">
                    <a href='/menu'>
                        <img src="public/img/menu.png"/>
                    </a>
                </div>
            </div>
            <div class="atc-grid">
                <div class="atc-cell row1">
                    <h3>HOLD</h3>
                    <div id='hold' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $hold)) ?>
                    </div>        
                </div>
                <div class="atc-cell row1">
                    <h3>APPROACH</h3>
                    <div id='approach' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $approach)) ?>                
                    </div>
                </div>
                <div class="atc-cell row1">
                    <h3>DEPARTURE</h3>
                    <div id='departure' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $departure)) ?>
                    </div>
                </div>
                <div class="atc-cell row2">
                    <h3>AIRCRAFT ON STAND</h3>
                    <div id='departure' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $onStand)) ?>
                    </div>
                </div>
               <div class="atc-cell row2">
                    <h3>TAXI</h3>
                    <div id='taxi' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $taxi)) ?>
                    </div>
                </div>
                <div class="atc-cell row2">
                    <h3>RUNWAY</h3>
                    <div id='runway' class="atc-field">
                        <?php includeWithVariables('public/views/helpers/flights_entry.php', array('flights' => $runway)) ?>
                    </div>
                </div>
              </div> 
        </div>
      </div>

      <script src="public/js/atc_grid.js"></script>
</body>