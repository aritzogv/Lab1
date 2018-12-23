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
    <form method="POST" id="fpreguntas" name="fpreguntas" action="restablecerContraseña.php">
      <h3>E-mail:*</h3><input type="text" name="mail" size="125" id="pass"><br>
      <input type="submit" name="env" value="Mandar mail de cambio de contraseña" id="bt">
    </form>
    <?php
    include "ParametrosDB.php";
    if(isset($_POST['mail'])){
      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
      if(!$mysqli){
        die("Fallo al conectar con BD:" . mysqli_connect_error());
      }else{
        $username = $_POST['mail'];
        $sql= "SELECT * FROM usuarios WHERE email='$username'";
        if(!mysqli_query($mysqli, $sql)){
          die('Error: ' . mysqli_error($mysqli));
        }else{
          $usuarios = mysqli_query($mysqli, $sql);
          $cont = mysqli_num_rows($usuarios);
          if($cont==1){
            $from = "admin@ehu.es";
            $to = $username;
            $subject = "Cambio de contraseña";
            $message = "Para cambiar la contraseña de $username haga click en el siguiente enlace:  https://sw18c040g.000webhostapp.com/ProyectoSW/cambiarContrasena.php?mail=$username";
            $headers = "From:" . $from;
            mail($to,$subject,$message, $headers);
            echo "El email se envió al correo electrónico del usuario.";
          }else{
            echo("El e-mail introducido no está registrado en nuestra base de datos");
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
