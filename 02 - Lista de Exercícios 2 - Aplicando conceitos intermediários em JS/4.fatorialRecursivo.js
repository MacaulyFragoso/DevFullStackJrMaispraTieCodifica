function fatorial(n) {
  [cite_start]// Condição para tratar números negativos. [cite: 172, 173]
  if (n < 0) {
    throw new Error("Fatorial não é definido para números negativos.");
  }

  [cite_start]// Caso base da recursão. [cite: 185]
  if (n === 0) {
    return 1;
  }

  [cite_start]// Passo recursivo da função. [cite: 184]
  return n * fatorial(n - 1);
}