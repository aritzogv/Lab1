<?php
include "ParametrosDB.php";
if(isset($_POST['mail'])){
  $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
  if(!$mysqli){
    die("Fallo al conectar con BD:" . mysqli_connect_error());
  }else{
    $username = $_POST['mail'];
    $contra = $_POST['contra'];
    $sql= "SELECT * FROM usuarios WHERE email='$username'";
    if(!mysqli_query($mysqli, $sql)){
      die('Error: ' . mysqli_error($mysqli));
    }else{
      $usuarios = mysqli_query($mysqli, $sql);
      $cont = mysqli_num_rows($usuarios);
      if($cont==1){
        $sql2= "UPDATE usuarios set contrasena='$contra' where email='$username'";
        if(!mysqli_query($mysqli, $sql2)){
          die('Error: ' . mysqli_error($mysqli));
        }else{
          echo("<script> alert('Contraseña modificada correctamente, redireccionando al Log In...')</script>");
          echo("<script> location.href=\"Login.php\";</script>");
        }
      }else{
        echo("El e-mail introducido no está registrado en nuestra base de datos");
      }
  }
}
}
?>
