import React from 'react';
import { useTheme } from '../../contexts/ThemeContext';

const Navbar = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <header className="bg-white dark:bg-slate-900 border-b border-gray-200 dark:border-slate-700 p-4 flex items-center justify-between sticky top-0 z-10 mb-8">
      <div className="text-blue-600 dark:text-blue-400 font-bold text-2xl">
        Locadora
      </div>
      <div className="flex items-center space-x-6">
        <button onClick={toggleTheme} className="text-2xl text-gray-700 dark:text-gray-300">
          {theme === 'light' ? '🌙' : '☀️'}
        </button>
        <div className="relative">
          <span className="text-3xl">🛒</span>
          <span className="absolute -top-2 -right-2 bg-blue-600 text-white text-xs font-bold w-5 h-5 flex items-center justify-center rounded-full">3</span>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
