<?php
	$conex = mysqli_connect("localhost", "root", "root", "projecte5");
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/busqueda-php.css">
    <link rel="shortcut icon" href="Imatges/RentSki.png">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>RENTSKI</title>
</head>

<body>
    <div id="all">

        <header>

            <h1>RentSki</h1>

            <h2>-Die Alpe, der beste Ort zum Skifahren-</h2>

        </header>

        <div id="menu">
            <ul>
                <nav>
                    <a href="index.html">
                        <div class="icon"><img src="Imatges/RentSki.png" alt=""></div>
                    </a>
                    </li>
                    <li><a class="active" href="equipaments.php">Equipaments</a></li>
                    <li><a href="contactar.html">Contactar</a></li>

                    <div class="search-container">
                <form action="busqueda.php">
                    <input type="text" id="myInput" onkeyup="functionBuscar()" placeholder="Buscar..." name="search">
                    <button id="boto-buscar" type="submit"><i class="fa fa-search" style="color: black"></i></button>
                </form>
            </div>
                    </li>

                </nav>

        </div>

</body>
</html>