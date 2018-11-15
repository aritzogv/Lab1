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
      var ce = $("#ce").val();
      var nom = $("#nom").val();
      var pass = $("#pass").val();
      var pass2 = $("#pass2").val();
      var emailER = /^[a-zA-Z]+[0-9][0-9][0-9]@ikasle.ehu.eus$/;
      var nomER = /^[a-zA-Z]+\s[a-zA-Z]+/
      var contrER = /^([^\n]){8,}$/
      if(emailER.test(ce)){
        if(nomER.test(nom)){
          if(contrER.test(pass)){
            if(pass==pass2){
              return true;
            }else{
              alert("Ambos campos de contraseña deben coincidir");
              return false;
            }
          }else{
            alert("La contraseña tiene que tener al menos 8 caracteres");
            return false;
          }
        }else{
          alert("Debes incluir al menos un apellido");
          return false;
        }
      }else{
        alert("Email incorrecto");
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
    <span><a href='pregunta.html' style="display:none;">Insertar Pregunta</a></span>
    <span><a href='creditos.php'>Creditos</a></span>
  </nav>
    <section class="main" id="s1">
  <div>
    <form method="POST" id="fpreguntas" name="fpreguntas" action="Registrar.php">
      <h3>Correo electrónico:*</h3><input type="text" name="direc" size="125" id="ce"><br>
      <h3>Nombre y apellido/s:*</h3><input type="text" name="nom" size="125" id="nom"><br>
      <h3>Contraseña:*</h3><input type="password" name="pass" size="125" id="pass"><br>
      <h3>Repetir contraseña:*</h3><input type="password" name="pass2" size="125" id="pass2"><br>
      <input type="submit" name="env" value="Registrar usuario" id="bt">
    </form>
    <?php
    include "ParametrosDB.php";
    if(isset($_POST['direc'])){
      $mail = $_POST['direc'];
      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
      if(!$mysqli){
        die("Fallo al conectar con BD:" . mysqli_connect_error());
      }else{
        $sql= "INSERT INTO usuarios(email, nombre, contrasena) VALUES('$_POST[direc]','$_POST[nom]', '$_POST[pass]')";
        if(!mysqli_query($mysqli, $sql)){
          die('Error: ' . mysqli_error($mysqli));
        }else{
          echo ("Usuario registrado correctamente.<p><a href='Login.php?mail=$mail'>Click aquí para iniciar sesión.</a>");
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
