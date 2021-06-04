window.addEventListener("load", inici, false);

function inici() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            carregaXML(this);
        }
    };
    xhttp.open("GET", "https://static-m.meteo.cat/content/opendata/ctermini_comarcal.xml", true);
    xhttp.send();






}


function carregaXML(xml) {

    xmlDoc = xml.responseXML;
    // x = xmlDoc.getElementsByTagName("comarca")[1].getAttribute("nomCOMARCA");
    x = xmlDoc.getElementsByTagName("comarca");
    simbolXML = xmlDoc.getElementsByTagName("simbol");
    prediccio = xmlDoc.getElementsByTagName("prediccio");
    precipitacioXML = xmlDoc.getElementsByTagName("precipitacio");
    calamarsaXML = xmlDoc.getElementsByTagName("calamarsa");
    dia = xmlDoc.getElementsByTagName("dia");
    document.getElementsByClassName("info").innerHTML = x;


}

function consulta(id) {

    seccio = document.getElementsByTagName("section");
    seccio[0].innerHTML = " ";


    //BUSQUEM AMB UN BUCLE LA ID DE COMARCA QUE CORRESPONGUI EN LES PREDICCIONS



    for (i = 0; i < prediccio.length; i++) {


        if (prediccio[i].getAttribute("idcomarca") == id) {


            
            variable = prediccio[i].getElementsByTagName("variable");
            for(p = 0; p <precipitacioXML.length; p++){

                if(precipitacioXML[p].getAttribute("id")== idPrecMATI){
                    console.log(precipitacioXML[p].getAttribute("nomprecipitaciomati"));
               
           
                }
            }


            //AMB ELS BUCLES SEGÜENTS OBTENIM LES DADES DE L'XML QUE NECESSITEM//

            for (c = 0; c < variable.length; c++) {
                
                var idSIMBOLMATI = variable[c].getAttribute("simbolmati").slice(0, -4);
                var idSimbolTARDA = variable[c].getAttribute("simboltarda").slice(0, -4);
                var idPrecMATI = variable[c].getAttribute("probprecipitacionsmati");
                var idPrecTarda = variable[c].getAttribute("probprecipitaciotarda");



               
                for (y = 0; y < simbolXML.length; y++) {
                   
                    if (simbolXML[y].getAttribute("id") == idSIMBOLMATI) {
                        console.log(simbolXML[y].getAttribute("nomsimbol"));


                        for (z = 0; z < simbolXML.length; z++) {

                            if (simbolXML[z].getAttribute("id") == idSimbolTARDA) {


                                seccio[0].innerHTML += "<div class='clima'>" +
                                    "<div class='dades-clima'>" +
                                    "<p> Comarca: " + x[i].getAttribute("nomCOMARCA") + "</p>" +
                                    "<p> Capital: " + x[i].getAttribute("nomCAPITALCO") + "</p>" +
                                    "<p> Data: " + variable[c].getAttribute("data") + "</p>" +
                                    "<p> Temperatura màxima: " + variable[c].getAttribute("tempmax") + "ºC</p>" +
                                    "<p> Temperatura mínima: " + variable[c].getAttribute("tempmin") + "ºC</p>" +
                                    "</div>" +
                                    "<div class='dades-simbol'>" + "<p>Matí: " + simbolXML[y].getAttribute("nomsimbol") + "</p>" + "<div class='simbols'>" + "<img src='https://static-m.meteo.cat/assets-w3/images/meteors/estatcel/" + variable[c].getAttribute("simbolmati") + "'+ alt='simbolclima'>" + "</div>" + "</div>" +
                                    "<div class='dades-simbol'>" + "<p>Tarda: " + simbolXML[z].getAttribute("nomsimbol") + "</p>" + "<div class='simbols'>" + "<img src='https://static-m.meteo.cat/assets-w3/images/meteors/estatcel/" + variable[c].getAttribute("simboltarda") + "'+ alt='simbolclima'>" + "</div>" + "</div>" +
                                    "</div>";


                            }

                        }


                    }



                }
            }

        }
    }



}