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
  $(document).ready(function(){
   $("#bt").click(function(){
     var ce = $("#mail").val();
     var ps = $("#pass").val();
     var ps2 = $("#pass2").val();
     if(ps==ps2 && ce!=""){
       return true;
     }else{
       alert("Ambas contraseñas deben coincidir, si el apartado Email aparece vacío, usted no debería estar aquí.");
       return false;
     }
   });
  });
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
  </nav>
    <section class="main" id="s1">
  <div>
    <form method="POST" id="fpreguntas" name="fpreguntas" action="cambiarContrasena2.php">
      <?php
      $mail= $_GET['mail'];
      echo("<h3>Email:*</h3><input type='text' value='$mail' readonly='readonly' name='mail' size='125' id='mail'><br>");
       ?>
      <h3>Nueva contraseña:*</h3><input type="password" name="contra" size="125" id="pass"><br>
      <h3>Repita la nueva contraseña:*</h3><input type="password" name="contra2" size="125" id="pass2"><br>
      <input type="submit" name="env" value="Cambiar de contraseña" id="bt">
    </form>
  </div>
    </section>
  <footer class='main' id='f1'>
    <a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
  </footer>
</div>
</body>
</html>
