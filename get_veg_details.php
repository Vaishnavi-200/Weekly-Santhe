<?php

include('dbconnect.php'); 
$v1=$_REQUEST['f1'];
$v2=$_REQUEST['f2'];
 
$output=array();

 
$result=mysqli_query($conn,"SELECT * FROM table_fvegetable Where Name='$v1' and city='$v2'");

$cnt=0;

while($r=mysqli_fetch_array($result))
{
    $cnt=1;
    $output[]=array("Name"=>$r["Name"],"city"=>$r["city"],"price"=>$r["price"],"date"=>$r["date"]);
    

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