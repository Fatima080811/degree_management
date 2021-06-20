<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$name = $_POST["name"];
$roll = $_POST["roll"];
$email = $_POST["email"];
$passing = $_POST["passing"];
$department = $_POST["department"];

$sql = "INSERT INTO degree(name,roll,email,passing,department) VALUES ('$name','$roll','$email','$passing','$department')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>