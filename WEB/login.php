<?php
error_reporting(0);
 $dbhost = "localhost";
 $dbuser = "root";
 $dbpass = "root";
 $dbname = "projecte6";
 $conn = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);

 $txt1= "DNI: ";
 $txt2= "Nom: ";
 $txt3= "Cognom: ";
 $txt4 = "Email: ";
 $txt5= "Contrasenya: ";
 $txt6= "Família Nombrosa: ";
 $txt7= "Número de Federació: ";
 $txt48= "Nivell de Federació: ";

 if (!$conn) 
 {
     die("No hay conexión: ".mysqli_connect_error());
 }
 

 ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/login.css">
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
    <div class="login">
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">


       <div id="tipo" style="display:">
            <p class="tipo">
                <label for="DNI">DNI:</label>
                <input type="text" name="DNI" id="DNI" placeholders="DNI" required>
            </p><br>

            <p class="tipo">
                <label for="password">Contrasenya:</label>
                <input type="password" name="contraseña" id="contraseña" placeholders="password" required>
            </p><br>

            <p class="tipos">
                <input type="submit" id="btn1"  value="Iniciar Sessió">
                <input type="reset" value="Cancel·lar">
            </p>

        </div>

 

<?php

        $dni = $_POST["DNI"];
        $pass = $_POST["contraseña"];

        $sql="SELECT * FROM persones WHERE DNI = '".$dni."' and contraseña = '".$pass."'";
        $result= mysqli_query($conn,$sql);
        if($show=mysqli_fetch_array($result)) {
            
        ?>
        <table id= "dadesSocio" style="display:none" class="DadesSocis">
             
                        <tr class="InsertsTaula">
                            <td><?php echo $txt1.$show['DNI']?></td>
                            <td><?php echo $txt2.$show['nom']?></td>
                            <td><?php echo $txt3.$show['cognom']?></td>
                            <td><?php echo $txt4.$show['correu']?></td>
                            <td><?php echo $txt5.$show['contraseña']?></td>
                            <td><?php echo $txt6.$show['numCarnet']?></td>
                            <td><?php echo $txt7.$show['numFederacio']?></td>
                            <td><?php echo $txt8.$show['nivellFederacio']?></td>
                        </tr>
                        <button id="mostrar-dades" style="display:" onclick="mostrar()"> Mostrar Dades</button>
                        <?php
        }
        ?>
    
                    </table>

                    <div class="cursos">

<table class="taula-cursos" style="display:none" id="tabla-cursos">

<?php
$conEsqui = "SELECT * from lloguer WHERE DNI = '".$dni."'";
$resultado1 = mysqli_query($conn, $conEsqui);
$txtLloguer1 = "ID CURS: ";
$txtLloguer2 = "DNI: ";
$txtLloguer3 = "Data del Curs: ";
$txtLloguer4 = "Hores Llogades: ";
$txtLloguer5 = "Preu: ";
while ($row = mysqli_fetch_array($resultado1)) {
?>
<tr id="HORES" class="esquis filterElements">
    <th><?php echo $txtLloguer1.$row['idCurs'] ?></th>
    <th><?php echo $txtLloguer2.$row['DNI'] ?></th>
    <th><?php echo $txtLloguer3.$row['data'] ?></th>
    <th><?php echo $txtLloguer4.$row['hores'] ?></th>
    <th><?php echo $txtLloguer5.$row['preu'] ?></th>
</tr>

<?php
}    
?>
</table>



</div>


                    
                </form>

            </div>






<script>

function mostrar(){
    document.getElementById("dadesSocio").style.display="";
    document.getElementById("tabla-cursos").style.display="";
    document.getElementById("mostrar-dades").style.display="none";
    document.getElementById("tipo").style.display="none";
}



</script>

</body>

</html>