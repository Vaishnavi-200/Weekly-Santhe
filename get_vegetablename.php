<?php

include('dbconnect.php'); 

$v4=$_REQUEST['f4'];

 
$output=array();

 
$result=mysqli_query($conn,"select * from table_fvegetable WHERE city='$v4'");

$cnt=0;

while($r=mysqli_fetch_array($result))
{
    $cnt=1;
    $output[]=array("Name"=>$r["Name"]);  
 
}
$flag["code"]="0";

if($cnt>0)
{
    $flag["code"]="1";
    
    print(json_encode($output));
}
else
{   
    printf(json_encode("Error"));

} 
?>