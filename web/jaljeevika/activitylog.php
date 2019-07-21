<?php
require('connect.php');
//include "database.php";
//include "database.php";

//echo $_GET;
//$str = file_get_contents('.json');
//if(isset())
// $temp =explode($_POST)
// $x = json_decode($_POST);
// print $x;
//foreach (getallheaders() as $name=>$value){
  //  echo $name: $value<br>;
//s}
// $str=$_POST['pond'];
//$decoded=json_decode($_SERVER['JSON'],true);
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
// echo $str;

$activity_name = $_GET['activity_selected'];
$pond_id = $_GET['pond'];
 
$log_query = "INSERT INTO activity_new (activity_name, pond_id) VALUES ('$activity_name','$pond_id')";
//$log_query = "INSERT INTO activity_new (activity_name, pond_id,farmer_id) VALUES ('$activity_selected','pond1','f1')";

echo $log_query."\n";
 $log = mysqli_query($conn,$log_query);
 if(!$log) {
     echo "Please Try Again";
	 echo $log;
 }
 else{
     echo 'Log Created';
 }
?>