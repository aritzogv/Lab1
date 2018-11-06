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
		<span class="right"><a href="Registrar.php" style="display:none;">Registrarse</a></span>
      		<span class="right" style="display:none;"><a href="Login.php">Login</a></span>
      		<span class="right"><a href="layout.html">Logout</a></span>
		<h2>Quiz: el juego de las preguntas</h2>
    </header>
	<nav class='main' id='n1' role='navigation'>
		<span><a href='layoutR.html'>Inicio</a></span>
		<span><a href='pregunta.html'>Insertar Pregunta</a></span>
    <span><a href='VerPreguntas.php'>Ver preguntas</a></span>
		<span><a href='creditosR.html'>Creditos</a></span>
	</nav>
<?php
$xml = simplexml_load_file('preguntas.xml');
echo '<div><table border="1"><tr><th>Autor</th><th>Pregunta</th><th>Respuesta correcta</th></tr>';
foreach ($xml->xpath('//assessmentItem') as $preg) {
  echo utf8_decode("<tr><td>$preg[author]</td>");
  $ese = $preg->itemBody;
  echo utf8_decode("<td>$ese->p</td>");
  $ese2 = $preg->correctResponse;
  echo utf8_decode("<td>$ese2->value</td></tr>");
}
echo '</div> </table>';
?>
<footer class='main' id='f1'>
  <a href='https://github.com/aritzogv/Lab1/tree/master/ProyectoSW'>Link GITHUB</a>
</footer>
</div>
</body>
</html>
