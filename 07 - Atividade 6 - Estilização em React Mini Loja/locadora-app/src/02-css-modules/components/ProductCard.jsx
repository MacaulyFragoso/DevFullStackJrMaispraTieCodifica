import React from 'react';
import Button from './Button';
import styles from './ProductCard.module.css';

const ProductCard = ({ product }) => {
  const rating = (product.vote_average / 2).toFixed(1);

  return (
    <div className={styles.cardBase}>
      <div className={styles.cardImageWrapper}>
        <img src={product.image} alt={product.title} className={styles.cardImage} loading="lazy" />
      </div>
      <div className={styles.cardContent}>
        <h3 className={styles.cardTitle}>{product.title}</h3>
        <div className={styles.cardInfo}>
          <p className={styles.cardPrice}>R$ {product.price.replace('.', ',')}</p>
          <div className={styles.cardRating}>
            <span>&#9733;</span>
            <span>{rating}</span>
          </div>
        </div>
        <div className={styles.cardAction}>
          <Button variant="solid">Alugar</Button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;