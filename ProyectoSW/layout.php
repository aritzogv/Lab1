<?php
session_start();
 ?>
<!DOCTYPE html>
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
  </head>
  <body>
  <div id='page-wrap'>
    <?php
      if(isset($_SESSION['mail'])){
        $usu = $_SESSION['mail'];
        if($_SESSION['rol']=='alumno'){
          echo ("<header class='main' id='h1'>
            <span class='right'><a href='Registrar.php' style='display:none;'>Registrarse</a></span>
                  <span class='right' style='display:none;'></span>
                  <span class='right'>$usu</span>
                  <span class='right'><a href='Logout.php'>Logout</a></span>
            <h2>Quiz: el juego de las preguntas</h2>
            </header>
          <nav class='main' id='n1' role='navigation'>
            <span><a href='layout.php'>Inicio</a></span>
            <span><a href='GestionPreguntas.php'>Gestionar preguntas</a></span>
            <span><a href='creditos.php'>Creditos</a></span>
          </nav>");
        }else if($_SESSION['rol']=='administrador'){
          echo ("<header class='main' id='h1'>
            <span class='right'><a href='Registrar.php' style='display:none;'>Registrarse</a></span>
                  <span class='right' style='display:none;'></span>
                  <span class='right'>$usu</span>
                  <span class='right'><a href='Logout.php'>Logout</a></span>
            <h2>Quiz: el juego de las preguntas</h2>
            </header>
          <nav class='main' id='n1' role='navigation'>
            <span><a href='layout.php'>Inicio</a></span>
            <span><a href='GestionarCuentas.php?'>Gestionar usuarios</a></span>
            <span><a href='creditos.php'>Creditos</a></span>
          </nav>");
        }
      }else{
        echo ("<header class='main' id='h1'>
      		<span class='right'><a href='Registrar.php'>Registrarse</a></span>
            		<span class='right'><a href='Login.php'>Login</a></span>
            		<span class='right' style='display:none;'><a href='/logout'>Logout</a></span>
      		<h2>Quiz: el juego de las preguntas</h2>
          </header>
      	<nav class='main' id='n1' role='navigation'>
      		<span><a href='layout.php'>Inicio</a></span>
          <span><a href='creditos.php'>Creditos</a></span>
          <span><a href='restablecerContraseña.php'>Restablecer contraseña</a></span>
      		<span><a href='pregunta.html' style='display:none;'>Insertar Pregunta</a></span>
          <span><a href='VerPreguntas.php' style='display:none;'>Ver preguntas</a></span>
      	</nav>");
      }
    ?>
    <section class="main" id="s1">

	<div>
  <img src="giphy.gif" width="360" height="300">
	</div>
    </section>
	<footer class='main' id='f1'>
		<a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
	</footer>
</div>
</body>
</html>
