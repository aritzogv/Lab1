<?php session_start();
session_destroy();
echo("<script> alert('Sesión cerrada correctamente')</script>");
header("Location:layout.php");
?>
