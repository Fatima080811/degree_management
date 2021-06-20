<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$name = $_POST["name"];
$father = $_POST["father"];
$contact = $_POST["contact"];
$email = $_POST["email"];
$address = $_POST["address"];


$sql = "INSERT INTO studentmodule(name,father,contact,email,address) VALUES ('$name','$father','$contact','$email','$address')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>