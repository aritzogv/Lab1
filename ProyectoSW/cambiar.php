<?php
include "ParametrosDB.php";
$mysqli = mysqli_connect($server,$user,$pass,$basededatos);
$mail = $_GET['email'];
$estado = $_GET['estado'];
if(!$mysqli){
  die("Fallo al conectar con BD:" . mysqli_connect_error());
}else{
  if($estado=="activo"){
    $cambiar = mysqli_query($mysqli, "Update usuarios set estado='bloqueado' where email='$mail'");
  }else{
    $cambiar = mysqli_query($mysqli, "Update usuarios set estado='activo' where email='$mail'");
  }
}
header("Location:GestionarCuentas.php");
?>
