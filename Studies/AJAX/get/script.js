document.addEventListener("DOMContentLoaded", function (e){

    const titulo = document.getElementById("titulo");
    const conteudo = document.getElementById("conteudo");

    fetch('https://jsonplaceholder.typicode.com/posts/1')
    .then(response => response.json())
    .then(data => {
        titulo.textContent = data.title;
        conteudo.textContent = data.body;
    }).catch(error => {
        console.error("Error: ", error);
    })
})

