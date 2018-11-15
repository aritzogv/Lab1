<?php
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
              //header('Location: VerPreguntasXML2.php?ce='. $_POST['direc']);
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
