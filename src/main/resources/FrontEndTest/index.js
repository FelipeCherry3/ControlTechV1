document.getElementById("cadastroForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value;
    const senha = document.getElementById("senha").value;
    const login = document.getElementById("login").value;
    const endereco = document.getElementById("endereco").value;

    const userData = {
        nome: nome,
        login: login,
        user_password: senha,
        endereco: endereco

    };

    fetch('http://localhost:8080/users/cadastro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })

    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Falha ao cadastrar usuário');
        }
    })
    .then(data => {
        alert(data); // Exibe a resposta do servidor (por exemplo, "Usuário cadastrado com sucesso!")
    })
    .catch(error => {
        console.error(error);
        alert('Erro ao cadastrar usuário');
    });
});