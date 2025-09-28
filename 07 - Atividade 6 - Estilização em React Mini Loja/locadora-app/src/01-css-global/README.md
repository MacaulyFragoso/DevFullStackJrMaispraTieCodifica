## Versão 1: CSS Global

Esta versão da locadora foi estilizada utilizando a abordagem tradicional de **CSS** com uma única folha de estilos global.

### Características
- **Arquivo Único:** Todos os estilos da aplicação estão centralizados em `src/01-css-global/styles.css`.
- **Nomenclatura BEM:** As classes seguem uma convenção similar ao BEM (ex: `.navbar`, `.navbar-logo`, `.navbar-actions`) para manter a organização e evitar conflitos.
- **Variáveis CSS (Custom Properties):**  
  O tema (claro/escuro) e o sistema de design (cores, espaçamentos, etc.) são gerenciados por variáveis CSS definidas no arquivo `:root` em `src/index.css`, permitindo uma troca de tema eficiente.

---

👉 **Observação:**  
Esta abordagem é simples e direta, mas pode se tornar difícil de manter em projetos muito grandes devido ao risco de conflitos de nomes de classes e à falta de escopo.
