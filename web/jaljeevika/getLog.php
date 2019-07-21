<?php
require('connect.php');

$rest_id = $_POST['rest_id'];
$mem_id = $_POST['mem_id'];
$date = $_POST['date'];

$check = 0;

if ($mem_id=="") {
    $verify_query = "SELECT * FROM restaurantlog WHERE DATE(timeStamp) = '$date' AND rest_id = '$rest_id'";
    $check = 1;
}
elseif($date=="") {
    $verify_query = "SELECT * FROM restaurantlog WHERE mem_id = '$mem_id' AND rest_id = '$rest_id'";
    $check = 2;
}
else {
    $verify_query = "SELECT * FROM restaurantlog WHERE DATE(timeStamp) = '$date' AND rest_id = '$rest_id' AND mem_id = '$mem_id'";
    $check = 3;
}


$verify = mysqli_query($conn,$verify_query);


if(mysqli_num_rows($verify)>0) {
    while($row = mysqli_fetch_array($verify)) {
        $jsonarray[] = $row;
    }
    echo json_encode($jsonarray);
}
else{
    echo 'no records found';
}

?>