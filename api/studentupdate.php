<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$id = $_POST["id"];
$name = $_POST["name"];
$father = $_POST["father"];
$contact = $_POST["contact"];
$email = $_POST["email"];
$address = $_POST["address"];


$sql = "UPDATE studentmodule SET name = '$name',father = '$father',contact = '$contact',email = '$email',address = '$address' WHERE id = '$id'";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data updated";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

