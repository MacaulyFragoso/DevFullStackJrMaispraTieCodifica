import React from 'react';

const Button = ({ children, variant = 'solid', ...props }) => {
  const baseClass = "btn";
  const variantClass = `btn-${variant}`;

  return (
    <button className={`${baseClass} ${variantClass}`} {...props}>
      {children}
    </button>
  );
};

export default Button;
