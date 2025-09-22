function debounce(fn, delay) {
  // Variável para guardar a referência do timer
  let timeoutId;

  // Retorna a nova função que aplicará o debounce
  return function(...args) {
    // Cancela o timer anterior se a função for chamada novamente
    clearTimeout(timeoutId);

    // Cria um novo timer para executar a função original 'fn' após o 'delay'git status
    timeoutId = setTimeout(() => {
      fn(...args);
    }, delay);
  };
}