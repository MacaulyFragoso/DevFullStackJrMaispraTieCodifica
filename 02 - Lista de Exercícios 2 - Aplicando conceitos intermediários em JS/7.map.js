const produtos = [
  { nome: "Notebook", preco: 2500 },
  { nome: "Celular", preco: 1500 },
  { nome: "Teclado", preco: 150 },
  { nome: "Mouse", preco: 90 },
  { nome: "Monitor", preco: 1200 }
];

 // Ordena produtos por preço e retorna uma lista com os nomes.
@param {Array<Object>} produtos
@returns {Array<string>}

const obterNomesOrdenadosPorPreco = (produtos) => {

  // Ordena o array com base no preço de cada produto
  const produtosOrdenados = produtos.sort((a, b) => a.preco - b.preco);

  // Mapeia o array ordenado para extrair apenas os nomes
  const nomes = produtosOrdenados.map(produto => produto.nome);

  return nomes;
};

// Executa a função e exibe o resultado no console
const nomesOrdenados = obterNomesOrdenadosPorPreco(produtos);
console.log(nomesOrdenados);