// Seleciona os elementos do DOM
const hamburgerButton = document.querySelector('.hamburger-menu');
const navLinks = document.querySelector('.nav-links');

// Adiciona o evento de clique ao botão
hamburgerButton.addEventListener('click', () => {
    // Alterna a classe 'active' na navegação
    navLinks.classList.toggle('active');
});