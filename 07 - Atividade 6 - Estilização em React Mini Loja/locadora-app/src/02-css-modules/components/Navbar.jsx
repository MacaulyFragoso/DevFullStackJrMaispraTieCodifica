import React from 'react';
import { useTheme } from '../../contexts/ThemeContext';
import styles from './Navbar.module.css';

const Navbar = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <header className={styles.navbar}>
      <div className={styles.navbarLogo}>Locadora</div>
      <div className={styles.navbarActions}>
        <button onClick={toggleTheme} className={styles.themeToggle} aria-label="Toggle theme">
          {theme === 'light' ? '🌙' : '☀️'}
        </button>
        <div className={styles.cartBadge}>
          🛒
          <span className={styles.cartCount}>3</span>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
