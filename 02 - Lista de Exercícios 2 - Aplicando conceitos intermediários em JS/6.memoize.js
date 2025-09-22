function memoize(fn) {
  [cite_start]// Armazenamento de dados temporário para futuras requisições.
  const cache = new Map();

  return function(...args) {
    [cite_start]// Converte os argumentos em uma string para usar como chave.
    const key = JSON.stringify(args);

    [cite_start]// Verifica se o resultado para esta chave já existe no cache.
    if (cache.has(key)) {
      return cache.get(key);
    }

    // Se não existir, executa a função original para obter o resultado.
    const result = fn(...args);

    // Armazena o novo resultado no cache antes de retorná-lo.
    cache.set(key, result);
    
    return result;
  };
}