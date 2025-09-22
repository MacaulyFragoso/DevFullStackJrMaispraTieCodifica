function paresParaObjeto(pares) {
  let obj = {};

  // Itera sobre cada par no array de entrada.
  for (let i = 0; i < pares.length; i++) {
    let par = pares[i];
    let chave = par[0];
    let valor = par[1];
    obj[chave] = valor;
  }

  return obj;
}

function objetoParaPares(obj) {
  let pares = [];

  // Itera sobre cada chave no objeto.
  for (let chave in obj) {

    // Adiciona o par [chave, valor] ao array.
    pares.push([chave, obj[chave]]);
  }

  return pares;
}