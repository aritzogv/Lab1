<?php
$xml = simplexml_load_file('preguntas.xml');
$q = $_GET["ce"];
echo '<div><table border="1"><tr><th>Autor</th><th>Pregunta</th><th>Respuesta correcta</th></tr>';
foreach ($xml->xpath('//assessmentItem') as $preg) {
  if($preg["author"] == $q){
    echo utf8_decode("<tr><td>$preg[author]</td>");
    $ese = $preg->itemBody;
    echo utf8_decode("<td>$ese->p</td>");
    $ese2 = $preg->correctResponse;
    echo utf8_decode("<td>$ese2->value</td></tr>");
  }
}
echo '</div> </table>';
?>
