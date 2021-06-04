<?php
include('conexio_bd.php');
session_start();
$pass=$_SESSION['login_user'];
$ses_sql=mysqli_query($conexio,"SELECT DNI FROM persones where contraseña='$pass'");
$row=mysqli_fetch_array($ses_sql,MYSQLI_ASSOC);
$loggedin_session=$row['DNI'];
if(!isset($loggedin_session) || $loggedin_session==NULL) {
	echo "Go back";
	header("Location: login.php");
}else{
    header("Location: index.php");
}
?>