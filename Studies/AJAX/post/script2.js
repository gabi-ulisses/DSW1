const formData = new FormData();

formData.append("title", "Novo Post");
formData.append("body", "Conteudo do Post");
formData.append("userId", 1);

fetch('https://jsonplaceholder.typicode.com/posts', 
{
    method: 'POST',
    body: formData
})
.then(response => response.json()) 
.then(data => {
    console.log("Post criado:", data);
}).catch(error => {
    console.error("Erro ao criar o post:", error);
});
