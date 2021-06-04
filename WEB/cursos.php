<?php
	$conex = mysqli_connect("localhost", "root", "root", "projecte6");

   
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/equipaments-php.css">
    <link rel="shortcut icon" href="Imatges/RentSki.png">
    <script src="JS/navbar.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>RENTSKI</title>
</head>

<body>
    <div id="all">

        <header>

            <h1>RentSki</h1>
            <h3>-Les Pyrénées, la montagne du ski-</h3>



        </header>

        <nav>
            <div class="dropdown">



                <button onclick="myFunction()" class="dropbtn">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp☰</button>



                <div id="myDropdown" class="dropdown-content">
                    <li class="li-icon">

                    </li>
                    <li><a href="index.html">Inici</a></li>
                    <li><a href="Registre.php">Registrar-se</a></li>
                    <li><a href="equipaments.php">Equipaments</a></li>
                    <li><a href="cursos.php">Cursos</a></li>
                    <li><a href="clima.html">Clima</a></li>

                </div>
            </div>
        </nav>

        <div class="cursos">

            <table class="taula-cursos"></table>
            <tr>
                <th>idCurs</th>
                <th>DNI</th>
                <th>hores</th>
            </tr>
            <?php
                $conEsqui = "SELECT * FROM hores WHERE DNI = $dni";
                $resultado1 = mysqli_query($conex, $conEsqui);
                while ($row = mysqli_fetch_array($resultado1)) {
            ?>
                    <tr id="HORES" class="esquis filterElements">
                        <th><?php echo $row['idCurs'] ?></th>
                        <th><?php echo $row['DNI'] ?></th>
                        <th><?php echo $row['hores'] ?></th>
                    </tr>

                    <?php
            }    
            ?>
                </table>





        </div>





    </div>
</body>


</html>