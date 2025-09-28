import React from 'react';

const Button = ({ children, variant = 'solid', ...props }) => {
  const baseStyles = "w-full px-4 py-3 rounded-md font-semibold transition-colors duration-200";
  const variants = {
    solid: 'bg-blue-600 text-white hover:bg-blue-700 dark:bg-blue-500 dark:hover:bg-blue-400',
  };

  return (
    <button className={`${baseStyles} ${variants[variant]}`} {...props}>
      {children}
    </button>
  );
};

export default Button;
