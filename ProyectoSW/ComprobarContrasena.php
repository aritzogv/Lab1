<?php
require_once('lib/nusoap.php');
require_once('lib/class.wsdlcache.php');
$ns = "http://localhost/ProyectoSW/samples";
$server = new soap_server;
$server->configureWSDL('comprobar', $ns);
$server->wsdl->schemaTargetNamespace=$ns;
$server->register('comprobar', array('x'=>'xsd:string','z'=>'xsd:int'), array('y'=>'xsd:string'), $ns);
function comprobar($x, $z){
  if($z==1010){
    $file = fopen("toppasswords.txt", "r") or exit("Unable to open file!");
    $y="VALIDA";
    while(!feof($file)&& $y=="VALIDA"){
      $este = fgets($file);
      $este2 = preg_replace("/[\r\n|\n|\r]+/", "", $este);
      if($este2==$x){
        $y="INVALIDA";
      }
    }
    fclose($file);
    return $y;
  }else{
    return "SIN SERVICIO";
  }
}
if(!isset($HTTP_RAW_POST_DATA)) $HTTP_RAW_POST_DATA=file_get_contents('php://input');
$server->service($HTTP_RAW_POST_DATA);
 ?>
