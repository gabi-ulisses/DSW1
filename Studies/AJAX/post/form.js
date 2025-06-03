document.getElementById("data-form").addEventListener("submit", function(event) {
    event.preventDefault(); 

    const form = document.getElementById("data-form"); 
    const formData = new FormData(form); 

    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: formData 
    })
    .then(response => response.json()) 
    .then(data => {
        document.getElementById("response-message").textContent = "Post criado com sucesso! ID: " + data.id;
    })
    .catch(error => {
        document.getElementById("response-message").textContent = "Erro ao enviar post.";
        console.error("Erro ao criar o post:", error);
    });
});