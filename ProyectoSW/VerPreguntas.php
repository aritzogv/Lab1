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
    <span class="right"><a href="registro">Registrarse</a></span>
          <span class="right"><a href="login">Login</a></span>
          <span class="right" style="display:none;"><a href="/logout">Logout</a></span>
    <h2>Quiz: el juego de las preguntas</h2>
    </header>
  <nav class='main' id='n1' role='navigation'>
    <span><a href='layout.html'>Inicio</a></span>
    <span><a href='pregunta.html'>Insertar Pregunta</a></span>
    <span><a href='creditos.html'>Creditos</a></span>
  </nav>
    <section class="main" id="s1">

  <div>
    <?php
      include "ParametrosDB.php";
      $mysqli = mysqli_connect($server,$user,$pass,$basededatos);
      if(!$mysqli){
        die("Fallo al conectar con BD:" . mysqli_connect_error());
      }else{
        $pregunta =mysqli_query($mysqli, "select * from preguntas");
        echo '<table border=1> <tr> <th> AUTOR </th> <th> ENUNCIADO </th> <th> RESPUESTA CORRECTA </th></tr>';
        while($row = mysqli_fetch_array($pregunta)){
          echo '<tr> <td>' .$row['email'].'</td><td>' .$row['enunciado']. '</td><td>' .$row['respuestac']. '</td></tr>';
        }
        echo '</table>';
        $pregunta->close();
        mysqli_close($mysqli);
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
