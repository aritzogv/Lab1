<?php
session_start();
 ?>
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <script language="JavaScript">
  </script>
  </head>
  <body>
  <div id='page-wrap'>
  <header class='main' id='h1'>
    <span class="right"><a href="Registrar.php">Registrarse</a></span>
          <span class="right"><a href="Login.php">Login</a></span>
          <span class="right" style="display:none;"><a href="/logout">Logout</a></span>
    <h2>Quiz: el juego de las preguntas</h2>
    </header>
  <nav class='main' id='n1' role='navigation'>
    <span><a href='layout.php'>Inicio</a></span>
    <span><a href='pregunta.html'  style="display:none;">Insertar Pregunta</a></span>
    <span><a href='creditos.php'>Creditos</a></span>
    <span><a href='restablecerContraseña.php'>Restablecer contraseña</a></span>
  </nav>
    <section class="main" id="s1">
  <div>
    <form method="POST" id="fpreguntas" name="fpreguntas" action="Login.php">
      <?php
      if(isset($_GET['mail'])){
        $mail = $_GET['mail'];
        echo ("<h3>Correo electrónico:*</h3><input type='text' name='direc' size='125' id='ce' value='$mail'><br>");
      }else{
          echo ("<h3>Correo electrónico:*</h3><input type='text' name='direc' size='125' id='ce' ><br>");
      }
      ?>
      <h3>Contraseña:*</h3><input type="password" name="pass" size="125" id="pass"><br>
      <input type="submit" name="env" value="Iniciar sesión" id="bt">
    </form>
    <?php
    include "ParametrosDB.php";
    if(isset($_POST['direc'])){
      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
      if(!$mysqli){
        die("Fallo al conectar con BD:" . mysqli_connect_error());
      }else{
        $username = $_POST['direc'];
        $password = $_POST['pass'];
        $sql= "SELECT * FROM usuarios WHERE email='$username' AND contrasena='$password'";
        if(!mysqli_query($mysqli, $sql)){
          die('Error: ' . mysqli_error($mysqli));
        }else{
          $usuarios = mysqli_query($mysqli, $sql);
          $cont = mysqli_num_rows($usuarios);
          if($cont==1){
            $sql2="SELECT rol FROM usuarios WHERE email='$username' AND contrasena='$password'";
            $rol = mysqli_query($mysqli, $sql2);
            $row = mysqli_fetch_array($rol);
            mysqli_close($mysqli);
            $_SESSION['rol']=$row['rol'];
            $_SESSION['mail']=$username;
            echo("<script> alert('Bienvenido al sistema:".$username."')</script>");
            echo("<script> location.href=\"layout.php\";</script>");
          }else{
            echo("Parámetros de login incorrectos<p><a href='Login.php'>Puede intentarlo de nuevo</a></p>");
          }
        }
      }
    }
    ?>
  </div>
    </section>
  <footer class='main' id='f1'>
    <a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
  </footer>
</div>
</body>
</html>
