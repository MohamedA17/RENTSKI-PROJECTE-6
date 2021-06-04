<?php
	$conexio = mysqli_connect("localhost", "root", "root", "projecte6");
   

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/registre.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" href="Imatges/RentSki.png">
    <script src="JS/navbar.js"></script>
    <title>RENTSKI</title>
</head>


<body>
    <header>
        <h1>RentSki</h1>
        <h2>-Les Pyrénées, la montagne du ski-</h2>

    </header>


    <nav>
        <div class="dropdown">



            <button onclick="myFunction()" class="dropbtn">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp☰</button>



            <div id="myDropdown" class="dropdown-content">
                <li class="li-icon">

                </li>
                <li><a href="index.html">Inici</a></li>
                    <li><a href="login.php">Iniciar Sessió</a></li>
                    <li><a href="Registre.php">Registrar-se</a></li>
                    <li><a href="equipaments.php">Equipaments</a></li>
                    <li><a href="clima.html">Clima</a></li>
                    <li><a href="logout.php">Tancar Sessió</a></li>

            </div>
        </div>
    </nav>


    <section class="loggers">

        <div class="registre">
            <h3>REGISTRA'T AQUÍ!</h3>
            <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">

                <div class="lbl-txtFields">
                    <p class="tipo">
                        <label for="DNI">DNI:</label>
                        <input type="text" name="DNI" id="DNI" placeholders="DNI" required>
                    </p><br>
                </div>
                <p class="tipo">
                    <label for="nom">Nom:</label>
                    <input type="text" name="nom" id="nom" placeholders="nom" required>
                </p><br>

                <p class="tipo">
                    <label for="cognom">Cognom:</label>
                    <input type="text" name="cognom" id="cognom" placeholders="cognom" required>
                </p><br>

                <p class="tipo">
                    <label for="mail">Mail:</label>
                    <input type="text" name="correu" id="correu" placeholders="correu" required>
                </p><br>

                <p class="tipo">
                    <label for="numCarnet">Família Nombrosa:</label>
                    <input type="text" name="numCarnet" id="numCarnet" placeholders="NumeroFamNombrosa" >
                </p><br>

                <p class="tipo">
                    <label for="numFederacio">Número de Federació:</label>
                    <input type="text" name="numFederacio" id="numFederacio" placeholders="numFede">
                </p><br>

                <p class="tipo">
                    <label for="nivellFede">Nivell de Federació:</label>
                    <input type="text" name="nivellFederacio" id="nivellFederacio" placeholders="nivellFede">
                </p><br>



                <p class="tipo">
                    <label for="password">Password:</label>
                    <input type="password" name="contraseña" id="contraseña" placeholders="password" required>
                </p><br>

                <p class="tipos">
                    <input type="submit" name="btn1" value="Registra't">
                    <input type="reset" value="Cancel·lar">
                </p>

                <?php
                if($_SERVER["REQUEST_METHOD"] == "POST") {
                    $dni = $_POST['DNI'];

                    $result = mysqli_query($conexio,"SELECT * FROM persones WHERE DNI='$dni'");

                    $num_rows = mysqli_num_rows($result);

                    if ($num_rows) {
                     header("location: registre.php?remarks=failed"); 
                    }else {
                     $dni = $_POST['DNI'];
                     $nom = $_POST['nom'];
                     $cognom = $_POST['cognom'];
                     $mail = $_POST['correu'];
                     $contrasena = $_POST['contraseña'];
                     $numCarnet = $_POST['numCarnet'];
                     $numFede = $_POST['numFederacio'];
                     $nivFederacio = $_POST['nivellFederacio']; 
                    

                        if(mysqli_query($conexio,"INSERT INTO persones (DNI, nom, cognom, correu, contraseña, numCarnet, numFederacio, nivellFederacio) VALUES ('$dni', '$nom', '$cognom', '$mail', '$contrasena', '$numCarnet', '$numFede', $nivFederacio)")){ 
                          
                         }else{
                            
                             echo('ERROR');	 
                         }
                    }
                }
            ?>
            </form>
        </div>

    </section>


</body>

</html>