<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$name = $_POST["name"];
$roll = $_POST["roll"];
$email = $_POST["email"];
$address = $_POST["address"];
$department = $_POST["department"];
$contact = $_POST["contact"];
$cgpa = $_POST["cgpa"];
$passing = $_POST["passing"];

$sql = "INSERT INTO clearance(name,roll,email,address,department,contact,cgpa,passing) VALUES ('$name','$roll','$email','$address','$department','$contact','$cgpa','$passing')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>