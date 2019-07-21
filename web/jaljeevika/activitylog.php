<?php
require('connect.php');

include "database.php";
$str = file_get_contents('packages.json');

// $json = json_decode($str, true);
// foreach($json['packages'] as $key=>$value){
//     #echo $key . '=>' . $value . '<br/>';
//     foreach($value as $key => $val){
//         #echo $key . '=>' . $val . '<br/>';
//         if($key=="id"){
//            # echo $val;
//             checkId($val,$value);
//         }
//     }
// }
echo $str;

// $Activity_name = $_POST['activity_name'];
// $pond_id = $_POST['rest_id'];
// $f_id=$_

// $log_query = "INSERT INTO activity (activity_name, pond_id) VALUES ('$Activity_id','$pond_id')";

// $log = mysqli_query($conn,$log_query);

// if(!$log) {
//     echo "Please Try Again";
// }
// else{
//     echo 'Log Created';
// }

?>