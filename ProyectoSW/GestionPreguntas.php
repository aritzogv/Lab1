<?php session_start();
if($_SESSION['rol']!="alumno"){
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <script language="JavaScript">
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function(){
      if(xmlhttp.readyState==4 && xmlhttp.status==200){
        document.getElementById("resul").innerHTML=xmlhttp.responseText;
      }
    }
    function visualizar(){
      xmlhttp.open("GET", "VerPreguntasXML2.php?ce="+document.getElementById("ce").value);
      xmlhttp.send(null);
    }
    $(document).ready(function(){
      $("#bt").click(function(){
        var ce = $("#ce").val();
        var en = $("#en").val();
        var rc = $("#rc").val();
        var r1 = $("#r1").val();
        var r2 = $("#r2").val();
        var r3 = $("#r3").val();
        var co = $("#co").val();
        var te = $("#te").val();
        var emailER = /^[a-zA-Z]+[0-9][0-9][0-9]@ikasle.ehu.eus$/;
        var comER = /[0-5]/;
        var enER = /^([^\n]){10,}$/;
        if(emailER.test(ce)){
          if(comER.test(co)){
            if(enER.test(en)){
              if(rc!=""&&r1!=""&&r2!=""&&r3!=""&&co!=""&&te!=""){
                var dataString = $("#fpreguntas").serialize();
                //alert('DAtos: '+dataString);
                  $.ajax({
                  type: "POST",
                  url: "InsertarPregunta2.php",
                  data: dataString,
                  cache: false,
                  success: function(data){
                    $("#resul").innerHTML=data;
                    visualizar();
                  }
                });
                return true;
              }else{
                alert("Rellena todos los campos marcados con asterísco");
                return false;
              }
            }else{
              alert("La pregunta debe ser superior a 10 caracteres");
              return false;
            }
          }else{
            alert("La complejidad debe ir desde 0 a 5 ambos inclusive");
            return false;
          }
        }else{
          alert("El email debe ser de la forma: Letras + 3 dígitos + “@ikasle.ehu.eus”");
          return false;
        }
      });
    });
  </script>
  </head>
  <body>
  <div id='page-wrap'>
    <?php
    if(isset($_SESSION['mail'])){
      $email = $_SESSION['mail'];
      if($_SESSION['rol']=='alumno'){
        echo ("<header class='main' id='h1'>
          <span class='right'><a href='Registrar.php' style='display:none;'>Registrarse</a></span>
                <span class='right' style='display:none;'></span>
                <span class='right'>$email</span>
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
                <span class='right'>$email</span>
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
        <span><a href='pregunta.html' style='display:none;'>Insertar Pregunta</a></span>
        <span><a href='VerPreguntas.php' style='display:none;'>Ver preguntas</a></span>
      </nav>");
    }

  echo("  <section class='main' id='s1'>

	<div>
	<form  id='fpreguntas' name='fpreguntas'>
    <h3>Correo electrónico:*</h3><input type='text' name='direc' size='125' id='ce' value='$email' readonly='readonly' ><br>");
    ?>
    <h3>Enunciado de la pregunta:*</h3><input type="text" name="preg" size="125" id="en"><br>
    <h3>Respuesta correcta:*</h3><input type="text" name="resc" size="125" id="rc"><br>
    <h3>Respuesta incorrecta 1:*</h3><input type="text" name="res1" size="125" id="r1"><br>
    <h3>Respuesta incorrecta 2:*</h3><input type="text" name="res2" size="125" id="r2"><br>
    <h3>Respuesta incorrecta 3:*</h3><input type="text" name="res3" size="125" id="r3"><br>
    <h3>Complejidad de la pregunta:*</h3><input type="text" name="comp" size="125" id="co"><br>
    <h3>Tema de la pregunta:*</h3><input type="text" name="tema" size="125" id="te"><br>
    <input type="button" name="ver" value="Ver preguntas" id="ver" onclick="visualizar()">
    <input type="button" name="env" value="Insertar pregunta" id="bt" onclick="insertar()">
  </form>
	</div>
  <div id="resul">

  </div>
    </section>
	<footer class='main' id='f1'>
		<a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
	</footer>
</div>
</body>
</html>
