<?php foreach ($flights as $flight): ?>
    <div class="atc-entry clickable">
        <div id="<?= $flight->getId(); ?>">
            <?= $flight->getFlightInfo(); ?>
        </div>
    </div>
<?php endforeach; ?>