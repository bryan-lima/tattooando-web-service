<?php

include_once "model/servico.php";
include_once "dao/servicoDao.php";
header('Content-Type: application/json; charset=utf-8');

// Captura o método de requisição e armazena na váriavel
$metodo = $_SERVER['REQUEST_METHOD'];

// Modelo arquitetural REST
if($metodo == "GET") {
    $ServicoDao = new ServicoDao();
    if(isset($_GET['id'])) {
        $ServicoDao->listarServicoPorId($_GET['id']);
    } else if(isset($_GET['fkStudioId'])) {
        $ServicoDao->listarServicoPorStudio($_GET['fkStudioId']);
    } else {
        $ServicoDao->listarTodosServicos();
    }

} else if($metodo == "POST") {

} else if($metodo == "PUT") {

} else if($metodo == "DELETE") {

}

?>