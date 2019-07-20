<?php
require('connect.php');

//$mem_id = $_POST['mem_id'];
//$mem_name = $_POST['mem_name'];
$mem_id='f3';
$mem_name='Yash Kabra';

//$verify_query = "SELECT * FROM member WHERE mem_id = '$mem_id' AND f_name = '$mem_name'";
switch($mem_id[0]){
case 'f' : $verify_query = "SELECT * FROM farmer WHERE f_id = '$mem_id' AND f_name = '$mem_name'";
             break;
case 'b' : $verify_query = "SELECT * FROM fish_buyer WHERE fb_id = '$mem_id' AND fb_name = '$mem_name'";
            break;
case 's' : $tablename='Supplier';
            break;
case 'e' : $tablename='expert';
            break;
case 'p': $tablename='pondowner';
            break;

}
//$verify_query = "SELECT * FROM $tablename WHERE mem_id = '$mem_id' AND f_name = '$mem_name'";

$verify = mysqli_query($conn,$verify_query);

if(mysqli_num_rows($verify)>0) {
    while($row = mysqli_fetch_array($verify)) {
       //$f_name = $row['f_name'];
       $f_name = $row[1];
       // $l_name = $row['l_name'];
        //$contact_number = $row['contact_number'];
        //$image = $row['image'];
    }
   // echo "$f_name|$l_name|$contact_number|".base64_encode($image);
   echo $f_name;
}
else{
    echo 'not a member';
}

?>