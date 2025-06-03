const post = {
    title: "Novo post",
    body: "Conteúdo do post",
    userId: 1
};

fetch('https://jsonplaceholder.typicode.com/posts', 
{
    method: 'POST',
    headers: {'Content-Type': 'application/json'}, 
    body: JSON.stringify(post)
})
.then(response => response.json()) 
.then(data => {
    console.log("Post criado:", data);
}).catch(error => {
    console.error("Erro ao criar o post:", error);
});
