import React from 'react';
import { useTheme } from '../../contexts/ThemeContext';

const Navbar = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <header className="navbar">
      <div className="navbar-logo">Locadora</div>
      <div className="navbar-actions">
        <button onClick={toggleTheme} className="theme-toggle" aria-label="Toggle theme">
          {theme === 'light' ? '🌙' : '☀️'}
        </button>
        <div className="cart-badge">
          🛒
          <span className="cart-count">3</span>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
