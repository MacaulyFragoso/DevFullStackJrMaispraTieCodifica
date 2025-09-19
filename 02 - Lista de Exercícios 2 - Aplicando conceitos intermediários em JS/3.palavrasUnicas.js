function extrairPalavrasUnicas(frase) {
  // Converte a string para minúsculas e divide em um array de palavras.
  const palavras = frase.toLowerCase().split(' ');
  const palavrasUnicas = [];

  // Itera sobre cada palavra do array 'palavras'.
  for (let i = 0; i < palavras.length; i++) {
    const palavraAtual = palavras[i];
    let palavraJaExiste = false;

    // Verifica se a palavra atual já está no array de palavras únicas.
    for (let j = 0; j < palavrasUnicas.length; j++) {
      if (palavrasUnicas[j] === palavraAtual) {
        palavraJaExiste = true;
        break; // Sai do loop interno se a palavra for encontrada.
      }
    }

    // Se a palavra não foi encontrada no array de únicas, adiciona ela.
    if (!palavraJaExiste) {
      palavrasUnicas.push(palavraAtual);
    }
  }

  // Exibe o resultado.
  console.log(palavrasUnicas);
}

// Exemplo de uso da função.
const minhaFrase = "olá olá mundo mundo";
extrairPalavrasUnicas(minhaFrase);