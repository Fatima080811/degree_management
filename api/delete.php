<?php
$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$id = $_POST["id"];
$sql = "DELETE FROM degree WHERE id='$id'";

$result=mysqli_query($connection,$sql);
if($result){
    echo "Data Deleted";
}
else{
    echo "failed";
}
mysqli_close($connection);
?>