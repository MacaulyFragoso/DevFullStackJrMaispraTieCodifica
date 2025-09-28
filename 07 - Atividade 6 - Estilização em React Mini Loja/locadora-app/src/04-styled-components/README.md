## Versão 4: Styled-Components

Esta versão da locadora foi estilizada utilizando **styled-components**, uma das bibliotecas mais populares de **CSS-in-JS** para React.

### Características
- **CSS dentro do JavaScript:**  
  Os estilos são escritos como *template literals* do JavaScript dentro dos próprios arquivos de componente (`.jsx`).  
  Isso colocaliza os estilos com a lógica e a estrutura do componente, melhorando a organização.

- **Componentes Estilizados:**  
  Em vez de aplicar classes a elementos, criamos componentes React que já vêm com seus próprios estilos encapsulados.  
  Por exemplo, podemos criar um `<Button>` com todos os seus estilos aplicados diretamente no componente.

- **Estilos com Escopo Automático:**  
  Assim como no CSS Modules, os estilos são automaticamente escopados para o componente, eliminando qualquer risco de conflito global.

- **Estilização Dinâmica com Props:**  
  É muito fácil alterar os estilos de um componente com base nas suas props.  
  Embora não tenhamos explorado profundamente neste projeto, seria possível criar variantes que alterariam, por exemplo, a cor do botão.

- **Suporte a Temas (Theming):**  
  A biblioteca oferece um componente `ThemeProvider` que permite passar um objeto de tema (com cores, fontes, etc.) para todos os componentes estilizados aninhados.  
  Nesta versão, o arquivo `theme.js` define os temas claro e escuro, que são aplicados na página principal.

---

👉 **Observação:**  
`styled-components` é uma abordagem poderosa que une a lógica e os estilos de um componente de forma muito coesa.  
É ideal para projetos que dependem de sistemas de design complexos e de estilização dinâmica.
