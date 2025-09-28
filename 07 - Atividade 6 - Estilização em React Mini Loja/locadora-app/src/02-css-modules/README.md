## Versão 2: CSS Modules

Esta versão da locadora foi estilizada utilizando **CSS Modules**, uma abordagem que resolve o problema do escopo global do CSS tradicional.

### Características
- **Estilos com Escopo Local:**  
  Cada componente React importa seu próprio arquivo de estilos (ex: `Navbar.jsx` importa `Navbar.module.css`).  
  As classes definidas nesses arquivos são unicamente atreladas ao componente que as importou.

- **Nomes de Classes Hashed:**  
  O processo de build renomeia as classes CSS para um formato único (ex: `Component_className__-a3b4c`), o que garante que não haverá conflitos de nomes de classes entre diferentes componentes, mesmo que usem o mesmo nome (`.title`, por exemplo).

- **Uso de Variáveis Globais:**  
  Apesar de as classes serem locais, esta abordagem ainda se beneficia das **variáveis CSS (Custom Properties)** definidas globalmente no arquivo `src/index.css` para manter a consistência do tema e do sistema de design.

---

👉 **Observação:**  
Esta abordagem é excelente para projetos de média a grande escala, pois oferece uma solução robusta para a manutenibilidade do CSS, eliminando o risco de colisões de estilo e tornando o código mais previsível.
