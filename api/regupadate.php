<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$id = $_POST["id"];
$name = $_POST["name"];
$roll = $_POST["roll"];
$email = $_POST["email"];
$passing = $_POST["passing"];
$department = $_POST["department"];

$sql = "UPDATE degree SET name = '$name',roll = '$roll',email = '$email',passing = '$passing',department = '$department' WHERE id = '$id'";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data updated";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

