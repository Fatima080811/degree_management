<?php
$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$result = array();
$result['data']=array();
$select = "SELECT *from degree";
$responce = mysqli_query($connection,$select);
while($row = mysqli_fetch_array($responce)){
    $index['id']  = $row['0'];
    $index['name']  = $row['1'];
    $index['roll']  = $row['2'];
    $index['email']  = $row['3'];
    $index['passing']  = $row['4'];
    $index['department']  = $row['5'];
    array_push($result['data'],$index);
    
}
$result["success"]="1";
echo json_encode($result);
mysqli_close($connection);
?>