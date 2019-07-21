<?php
require('connect.php');

$mem_id = $_POST['mem_id'];
$rest_id = $_POST['rest_id'];

$log_query = "INSERT INTO restaurantlog (mem_id, rest_id) VALUES ('$mem_id','$rest_id')";

$log = mysqli_query($conn,$log_query);

if(!$log) {
    echo "Please Try Again";
}
else{
    echo 'Log Created';
}

?>