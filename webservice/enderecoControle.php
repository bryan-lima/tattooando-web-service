<?php

include_once "model/endereco.php";
include_once "dao/enderecoDao.php";
header('Content-Type: application/json; charset=utf-8');

// Captura o método de requisição e armazena na váriavel
$metodo = $_SERVER['REQUEST_METHOD'];

// Modelo arquitetural REST
if($metodo == "GET") {

} else if($metodo == "POST") {

} else if($metodo == "PUT") {

} else if($metodo == "DELETE") {

}

?>