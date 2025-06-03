document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("cep-form");
    const conteudo = document.getElementById("conteudo");
    const cepInput = document.getElementById("cep");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); 

        const cepValue = cepInput.value; 

        if (cepValue.length === 8) { 
            const url = `https://brasilapi.com.br/api/cep/v1/${cepValue}`;

            fetch(url)
                .then(response => response.json())
                .then(data => {
                    if (data.cep) {
                        conteudo.textContent = ` [${data.cep}] ${data.street} - ${data.neighborhood} - ${data.city} (${data.state})`;
                    } else {
                        conteudo.textContent = "CEP não encontrado.";
                    }
                })
                .catch(error => {
                    console.error("Erro ao buscar CEP: ", error);
                    conteudo.textContent = "Erro ao buscar o CEP.";
                });
        }
    });
});
