var formulario = document.getElementById("formulario");

formulario.addEventListener("submit", function(event) {
    var x = document.getElementById("nombre").value;
    if(document.getElementById("nombre").value.trim().length < 3){
        alert("El nombre del carro no debe tener menos de 3 caracteres sin contar espacios");
        event.preventDefault();
    }
    else if (x[0] === " "){
        alert("La primera letra del carro es un espacio")
        event.preventDefault();
    }
    else if (document.getElementById("asiento").value <= 0){
        alert("Un auto no debe tener menos de 1 asiento");
        event.preventDefault();
    }
    else if (document.getElementById("flotilla").value.trim().length <= 2){
        alert("La flotilla debe tener al menos 3 caracteres sin contar espacios")
        event.preventDefault();
    }
    else if(document.getElementById("flotilla").value[0] === " "){
        alert("La primera letra de la flotilla es un espacio")
        event.preventDefault();
    }
    else if (x[0] != x[0].toUpperCase()){
        alert("La primera letra del nombre es minuscula")
        event.preventDefault();
    }
    else {
        console.log("Datos enviados");
        let x = document.getElementById("resultado")
        x.innerHTML = "Formulario Enviado"
    }
});
