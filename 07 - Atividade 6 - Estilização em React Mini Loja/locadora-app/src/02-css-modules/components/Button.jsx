import React from 'react';
import styles from './Button.module.css';

const Button = ({ children, variant = 'solid', ...props }) => {
  return (
    <button className={`${styles.btn} ${styles[variant]}`} {...props}>
      {children}
    </button>
  );
};

export default Button;