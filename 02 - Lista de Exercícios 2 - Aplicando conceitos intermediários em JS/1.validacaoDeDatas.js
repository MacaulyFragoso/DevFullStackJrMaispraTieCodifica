/**
 * Função para validar se uma data, com dia, mês e ano, é real.
 * Retorna true para datas válidas e false para inválidas.
 */
function ehDataValida(dia, mes, ano) {

  if (mes < 1 || mes > 12 || dia < 1) {
    return false;
  }

  let ultimoDiaDoMes;

  switch (mes) {
    case 2: // Esse é o caso de Fevereiro, o mais complicado.
      if ((ano % 4 === 0 && ano % 100 !== 0) || (ano % 400 === 0)) {
        ultimoDiaDoMes = 29; // Se for bissexto, fevereiro tem 29 dias.
      } else {
        ultimoDiaDoMes = 28; // Se não, tem 28 dias.
      }
      break;

    case 4:
    case 6:
    case 9:
    case 11:
      ultimoDiaDoMes = 30;
      break;

    default:
      ultimoDiaDoMes = 31;
      break;
  }

  if (dia > ultimoDiaDoMes) {
    return false;
  }

  return true;
}