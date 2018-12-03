<?php session_start();
if($_SESSION['rol']!="administrador"){
  header("Location:Login.php");
}?>
<html>
  <head>
    <meta name="tipo_contenido" content="text/html;" http-equiv="content-type" charset="utf-8">
  <title>Preguntas</title>
    <link rel='stylesheet' type='text/css' href='estilos/style.css' />
  <link rel='stylesheet'
       type='text/css'
       media='only screen and (min-width: 530px) and (min-device-width: 481px)'
       href='estilos/wide.css' />
  <link rel='stylesheet'
       type='text/css'
       media='only screen and (max-width: 480px)'
       href='estilos/smartphone.css' />

  <script language="JavaScript">
  function cambiarEstado(email, estado){
    confirm("¿Está seguro de que quiere cambiar el estado de éste usuario?");
    document.location='cambiar.php?email=' + email+'&estado='+estado;
  }
  function eliminar(email){
    confirm("¿Está seguro de que quiere eliminar éste usuario?");
    document.location="eliminar.php?email=" + email;
  }
  </script>
  </head>
  <body>
  <div id='page-wrap'>
    <header class='main' id='h1'>
      <span class='right'><a href='Registrar.php' style='display:none;'>Registrarse</a></span>
            <span class='right' style='display:none;'><a href='Login.php'Login</a></span>
            <span class='right'><a href='Logout.php'>Logout</a></span>
      <h2>Quiz: el juego de las preguntas</h2>
      </header>
    <nav class='main' id='n1' role='navigation'>
      <span><a href='layout.php'>Inicio</a></span>
      <span><a href='GestionarCuentas.php?'>Gestionar usuarios</a></span>
      <span><a href='creditos.php?mail=$email'>Creditos</a></span>
    </nav>
  <div>
    <?php
      include "ParametrosDB.php";
      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
      if(!$mysqli){
        die("Fallo al conectar con BD:" . mysqli_connect_error());
      }else{
        $pregunta =mysqli_query($mysqli, "select * from usuarios");
        echo '<table border=1> <tr> <th> EMAIL </th> <th> NOMBRE </th> <th> CONTRASEÑA </th><th> ROL </th><th> ESTADO </th><th> CAMBIAR ESTADO </th><th> ELIMINAR </th></tr>';
        $cual = 1;
        while($row = mysqli_fetch_array($pregunta)){
          $cambiar = "cambiarEstado('$row[email]','$row[estado]')";
          $eliminar = "eliminar('$row[email]')";
          echo ("<tr><td>$row[email]</td><td>$row[nombre]</td><td>$row[contrasena]</td><td>$row[rol]</td><td>$row[estado]</td><td><input type='button' value='Cambiar estado' onClick=$cambiar></td><td><input type='button' value='Eliminar' onClick=$eliminar></td></tr>");
          $cual = $cual+1;
        }
        echo '</table>';
        $pregunta->close();
        mysqli_close($mysqli);
      }
    ?>
  </div>
  <footer class='main' id='f1'>
    <a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
  </footer>
</div>
</body>
</html>
