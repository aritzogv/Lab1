<?php
include "ParametrosDB.php";
$mysqli = mysqli_connect($server,$user,$pass,$basededatos);
$mail = $_GET['email'];
if(!$mysqli){
  die("Fallo al conectar con BD:" . mysqli_connect_error());
}else{
  $eliminar = mysqli_query($mysqli, "Delete from usuarios where email='$mail'");
}
header("Location:GestionarCuentas.php");
?>
