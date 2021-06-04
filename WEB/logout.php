<?php
session_start();
unset($_SESSION["dni"]);
unset($_SESSION["contraseña"]);
header("Location:login.php");
?>