# 🎬 Locadora de Filmes - Estudo de Estilização em React

Este projeto é uma aplicação de **locadora de filmes virtual** desenvolvida em **React**.  
O objetivo principal é demonstrar e comparar **quatro abordagens diferentes de estilização de componentes**:

- CSS Global  
- CSS Modules  
- Tailwind CSS  
- Styled-Components  

A aplicação consome dados da **API do The Movie Database (TMDB)** para exibir catálogos de filmes dinâmicos e exclusivos em cada versão.

---

## 🚀 Como Usar a Aplicação

Bem-vindo à nossa locadora! A seguir, um breve tutorial sobre as funcionalidades disponíveis:

### 1. Navegação Entre Versões
No topo da página, você encontrará uma barra de navegação com quatro opções:

- **CSS Global**  
- **CSS Modules**  
- **Tailwind CSS**  
- **Styled-Components**

Clique em qualquer uma dessas opções para visualizar a mesma interface, estilizada com a tecnologia correspondente.  
Cada versão busca uma lista de filmes diferente da API do TMDB: **populares, mais bem avaliados, próximos lançamentos e em cartaz**.

---

### 2. Catálogo de Filmes
Cada página exibe um catálogo com **6 filmes**.  
Ao passar o mouse sobre um pôster, você notará um **efeito de elevação**.  

Cada card de filme exibe:
- 🎥 Pôster do filme  
- 📝 Título  
- 💰 Preço simulado em Reais (R$)  
- ⭐ Nota média de avaliação  
- 🎟️ Botão **"Alugar"**

---

### 3. Alternância de Tema (Claro/Escuro)
No canto superior direito, você encontrará um ícone de 🌙 (lua) ou ☀️ (sol).  
Clique nele para alternar entre os temas **claro** e **escuro**.  

> A preferência é salva localmente, então, ao recarregar a página, o tema escolhido será mantido.

---

### 4. Carrinho de Compras
Ao lado do botão de tema, há um **ícone de carrinho de compras** com um número.  
Este é apenas um **elemento visual estático**, simulando a aparência de um e-commerce real.

---

### 5. Design Responsivo
A aplicação é **totalmente responsiva**.  
Experimente redimensionar a janela do navegador ou acessar pelo celular:  
o layout da grade de filmes e da barra de navegação se ajusta automaticamente para a melhor experiência.

---

## 🛠️ Tecnologias Utilizadas
- **React** → Biblioteca principal para construção da interface  
- **Vite** → Ferramenta de build para desenvolvimento rápido  
- **React Router Dom** → Sistema de rotas e navegação  
- **TMDB API** → Fornecimento dinâmico dos dados dos filmes  
- **CSS Global, CSS Modules, Tailwind CSS, Styled-Components** → As quatro abordagens de estilização demonstradas  

---

## ⚙️ Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/MacaulyFragoso/DevFullStackJrMaispraTieCodifica/tree/main/07%20-%20Atividade%206%20-%20Estiliza%C3%A7%C3%A3o%20em%20React%20Mini%20Loja

2. Navegue até a pasta do projeto:
cd locadora-nova

3. Instale as dependências:
npm install

4. Adicione sua chave da API:
Abra o arquivo src/services/api.js
Substitua o texto "SUA_CHAVE_DA_API_AQUI" pela sua chave real da TMDB

5. Inicie o servidor de desenvolvimento:
npm run dev

6. Acesse a aplicação no navegador:
http://localhost:5173
