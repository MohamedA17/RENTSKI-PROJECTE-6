<?php
	$conex = mysqli_connect("localhost", "root", "root", "projecte5");
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/equipaments-php.css">
    <link rel="shortcut icon" href="Imatges/RentSki.png">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>RENTSKI</title>
</head>

<body>
    <div id="all">

        <header>

            <h1>RentSki</h1>

           

        </header>

        <div id="menu">
            <ul>
                <nav>
                    <a href="index.html">
                        <div class="icon"><img src="Imatges/RentSki.png" alt=""></div>
                    </a>
                    </li>
                    <li><a class="active" href="equipaments.php">Equipaments</a></li>
                    <li><a href="clima.html">Clima</a></li>

                    <div class="search-container">
                <form action="busqueda.php">
                    <input type="text" id="myInput" onkeyup="functionBuscar()" placeholder="Buscar..." name="search">
                    <button id="boto-buscar" type="submit"><i class="fa fa-search" style="color: black"></i></button>
                </form>
            </div>
                    </li>

                </nav>

        </div>

        <section>
            <div class="container-equips">

                <div id="boxEsqui">

                    <div class="titol-equipament">
                        <h3>Esquís</h3>
                    </div>




                    <table class="equipament">

                        <tr>
                            <th>ID</th>
                            <th>Marca</th>
                            <th>Talla</th>
                            <th>Preu</th>
                        </tr>

                        <?php
                $conEsqui = "SELECT * FROM esqui ORDER BY marca";
                $resultado1 = mysqli_query($conex, $conEsqui);
                while ($row = mysqli_fetch_array($resultado1)) {
            ?>
                        <tr id="esquis" class="esquis filterElements">
                            <th><?php echo $row['idEsqui'] ?></th>
                            <th><?php echo $row['marca'] ?></th>
                            <th><?php echo $row['talla'] ?></hd>
                            <th><?php echo $row['preu'] ?></th>
                        </tr>

                        <?php
            }    
            ?>
                    </table>

                </div>
            </div>



            <div id="boxBotes">

                <div class="titol-equipament">
                    <h3>Botes</h3>
                </div>

                <table class="equipament">


                    <tr>
                        <th>ID</th>
                        <th>Marca</th>
                        <th>Talla</th>
                        <th>Preu</th>
                    </tr>

                    <?php
                $conBotes = "SELECT * FROM botes ORDER BY marca";
                $resultado2 = mysqli_query($conex, $conBotes);
                while ($row = mysqli_fetch_array($resultado2)) {
            ?>
                    <tr id="botes" class="botes filterElements">
                        <th><?php echo $row['idBotes'] ?></th>
                        <th><?php echo $row['marca'] ?></th>
                        <th><?php echo $row['talla'] ?></th>
                        <th><?php echo $row['preu'] ?></th>
                    </tr>
                    <?php
            }    
            ?>

                </table>


            </div>


            <div id="boxPals">

                <div class="titol-equipament">
                    <h3>Pals</h3>
                </div>
                <table class="equipament">




                    <tr>
                        <th>ID</th>
                        <th>Marca</th>
                        <th>Talla</th>
                        <th>Preu</th>
                    </tr>


                    <?php
                    $conPals = "SELECT * FROM pals ORDER BY marca";
                    $resultado3 = mysqli_query($conex, $conPals);
                    while ($row = mysqli_fetch_array($resultado3)) {
                ?>
                    <tr id="pal" class="pal filterElements">
                        <th><?php echo $row['idPals'] ?></th>
                        <th><?php echo $row['marca'] ?></th>
                        <th><?php echo $row['talla'] ?></th>
                        <th><?php echo $row['preu'] ?></th>
                    </tr>
                    <?php
}    
                ?>

                </table>
            </div>


            </div>

    </div>




    </section>


    </div>
</body>
//                                              FILTRE WEB                       //
<script>



</script>



</html>