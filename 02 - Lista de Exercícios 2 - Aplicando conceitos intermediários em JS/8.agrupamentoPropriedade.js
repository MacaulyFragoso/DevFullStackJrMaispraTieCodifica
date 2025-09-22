const vendas = [
  { cliente: 'Joao', total: 150.50 },
  { cliente: 'Maria', total: 220.00 },
  { cliente: 'Pedro', total: 80.25 },
  { cliente: 'Ana', total: 300.00 },
  { cliente: 'Maria', total: 120.75 },
  { cliente: 'Carlos', total: 50.00 }
];

// Usa o método reduce para agrupar e somar as vendas por cliente
const totalPorCliente = vendas.reduce((acumulador, venda) => {
  const { cliente, total } = venda;

  // Verifica se o cliente já existe no acumulador
  if (acumulador[cliente]) {
    acumulador[cliente] += total;
  } else {
    acumulador[cliente] = total;
  }
  
  // Retorna o objeto para a próxima iteração
  return acumulador; 
}, {});

// Exibe o resultado no console
console.log(totalPorCliente);