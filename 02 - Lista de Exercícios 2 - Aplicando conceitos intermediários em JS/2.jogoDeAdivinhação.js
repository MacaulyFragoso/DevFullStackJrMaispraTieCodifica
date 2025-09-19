// Importa o módulo para receber entrada do usuário
const prompt = require('prompt-sync')();

// Gera um número aleatório entre 1 e 100
const numeroSecreto = Math.floor(Math.random() * 100) + 1;

let palpiteDoUsuario;
let tentativas = 0;

console.log("Adivinhe o número secreto entre 1 e 100!");

// Loop continua enquanto o palpite estiver errado
while (palpiteDoUsuario !== numeroSecreto) {
    palpiteDoUsuario = Number(prompt("Qual o seu palpite? "));
    tentativas++;

    if (palpiteDoUsuario > numeroSecreto) {
        console.log("Mais baixo!");
    } else if (palpiteDoUsuario < numeroSecreto) {
        console.log("Mais alto!");
    }
}

// Mensagem de sucesso
console.log(`Parabéns! Você acertou o número ${numeroSecreto} em ${tentativas} tentativas.`);