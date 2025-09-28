export default {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  darkMode: "class",
  theme: {
    extend: {
      colors: {
        primary: "var(--color-primary)",
        "primary-hover": "var(--color-primary-hover)",

        // Texto
        "text-primary": "var(--color-text-primary)",
        "text-secondary": "var(--color-text-secondary)",

        // Fundo / superfícies
        bg: "var(--color-bg)",
        surface: "var(--color-surface)",

        // Bordas
        border: "var(--color-border)",

        // Tags
        "tag-bg": "var(--color-tag-bg)",
        "tag-text": "var(--color-tag-text)",

        // Avisos
        warning: "var(--color-warning)",

        // Skeletons
        "skeleton-base": "var(--color-skeleton-base)",
        "skeleton-shine": "var(--color-skeleton-shine)",
      },
      boxShadow: {
        sm: "var(--shadow-sm)",
        md: "var(--shadow-md)",
        lg: "var(--shadow-lg)",
      },
      borderRadius: {
        DEFAULT: "var(--border-radius)",
      },
    },
  },
  plugins: [],
};
