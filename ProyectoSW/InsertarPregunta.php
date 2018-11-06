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
      	<header class='main' id='h1'>
      		<span class="right" style="display:none;"><a href="Registrar.php">Registrarse</a></span>
            		<span class="right" style="display:none;"><a href="Login.php">Login</a></span>
            		<span class="right"><a href="layout.html">Logout</a></span>
      		<h2>Quiz: el juego de las preguntas</h2>
          </header>
      	<nav class='main' id='n1' role='navigation'>
      		<span><a href='layoutR.html'>Inicio</a></span>
      		<span><a href='pregunta.html'>Insertar Pregunta</a></span>
      		<span><a href='creditosR.html'>Creditos</a></span>
      	</nav>
          <section class="main" id="s1">

      	<div>
          <?php
            include "ParametrosDB.php";
            function is_valid_email($str){
              $matches = null;
              return (1 === preg_match('/^[a-zA-Z]+[0-9][0-9][0-9]@ikasle.ehu.eus$/', $str, $matches));
            }
            function is_valid_comp($str){
              $matches = null;
              return (1 === preg_match('/[0-5]/', $str, $matches));
            }
            function filled($str){
              $matches = null;
              return (0 === preg_match('/^\s*$/', $str, $matches));
            }
            if(is_valid_email($_POST['direc'])){
              if(is_valid_comp($_POST['comp'])){
                if(filled($_POST['preg']) && filled($_POST['resc']) && filled($_POST['res1'])&& filled($_POST['res2'])
                    && filled($_POST['res3']) && filled($_POST['tema'])){
                      echo"Campos introducidos correctos. ";
                      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
                      if(!$mysqli){
                        die("Fallo al conectar con BD:" . mysqli_connect_error());
                      }else{
                        $xml = simplexml_load_file('preguntas.xml');
                        $preg = $xml->addChild('assessmentItem');
                        $preg2 = $preg->addChild('itemBody');
                        $preg2->addChild('p', $_POST['preg']);
                        $cor = $preg->addChild('correctResponse');
                        $cor->addChild('value', $_POST['resc']);
                        $incor = $preg->addChild('incorrectResponses');
                        $incor->addChild('value', $_POST['res1']);
                        $incor->addChild('value', $_POST['res2']);
                        $incor->addChild('value', $_POST['res3']);
                        $preg->addAttribute('subject', $_POST['tema']);
                        $preg->addAttribute('author', $_POST['direc']);
                        $xml->asXML('preguntas.xml');
                        echo 'Pregunta introducida en el documento XML, para visualizarla click <a href="VerPreguntasXML.php"> aquí. </a><br>';
                        $sql= "INSERT INTO preguntas(email, enunciado, respuestac, respuesta1, respuesta2, respuesta3,
                        complejidad, tema) VALUES('$_POST[direc]', '$_POST[preg]', '$_POST[resc]', '$_POST[res1]', '$_POST[res2]'
                        , '$_POST[res3]', $_POST[comp], '$_POST[tema]')";
                        if(!mysqli_query($mysqli, $sql)){
                          die('Error: ' . mysqli_error($mysqli));
                        }else{
                          echo "Tupla introducida correctamente en la base de datos";
                          echo '<p> Para ver la lista de preguntas, haga click <a href="VerPreguntas.php"> aquí. </a> </p>  ';
                        }
                      }
                    }
                    else{
                      echo "Rellene todos los campos obligatorios";
                    }
              }else{
                echo "La complejidad debe ir entre 0 y 5";
              }
            }else{
              echo "El email introducido es incorrecto";
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
