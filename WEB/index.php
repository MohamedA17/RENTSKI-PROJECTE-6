<?php
session_start();
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" href="Imatges/RentSki.png">
    <script src="JS/navbar.js"></script>
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
                    <li><a href="login.php">Iniciar Sessió</a></li>
                    <li><a href="Registre.php">Registrar-se</a></li>
                    <li><a href="equipaments.php">Equipaments</a></li>
                    <li><a href="cursos.php">Cursos</a></li>
                    <li><a href="clima.html">Clima</a></li>
       
    </div>
    </div>
</nav>



    </div>
    <section>

        <div class="slideshow-container">

            <div class="mySlides fade">

                <img src="Imatges/esqui1.jpg">

            </div>

            <div class="mySlides fade">

                <img src="Imatges/Portes_du_Soleil.jpg">

            </div>

            <div class="mySlides fade">

                <img src="Imatges/alpes2.jpg">

            </div>
            <br>
            <div style="text-align:center">
                <span class="dot"></span>
                <span class="dot"></span>
                <span class="dot"></span>
            </div>

        </div>

        <div class="text">

            <h2>Vols esquiar i no tens l'equiment corresponent per a fer-ho?</h2>
            <h2>Consulta ara mateix els kits disponibles en <a href="equipaments.php">aquest enllaç</a> i
                contacta'ns!</h2>

        </div>
    </section>

    <footer>
        <div id="footer">
            <p>RentSki: die Alpe, der beste Ort zum Skifahren</p>
            <div class="insta">
                <a href="https://www.instagram.com/__rentski__/"><img src="Imatges/ig-logo-email.png"
                        alt="Instagram"></a>

            </div>

        </div>

    </footer>


</body>

<script>
    var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex >
            slides.length) {
            slideIndex = 1
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
        setTimeout(showSlides, 5000); // Change image every 2 seconds 
    }
</script>

</html>