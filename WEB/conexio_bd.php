<?php
$servidor = "localhost";
$username = "root";
$password = "root";
$base_dades = "projecte6";

$conexio = new mysqli($servidor, $username, $password, $base_dades);

if ($conexio->connect_errno){
	die("Hi ha un error en la connexió al servidor");
}

?>