import React from 'react';
import Button from './Button';

const ProductCard = ({ product }) => {
  const rating = (product.vote_average / 2).toFixed(1);

  return (
    <div className="card-base">
      <div className="card-image-wrapper">
        <img src={product.image} alt={product.title} className="card-image" loading="lazy" />
      </div>
      <div className="card-content">
        <h3 className="card-title">{product.title}</h3>
        <div className="card-info">
          <p className="card-price">R$ {product.price.replace('.', ',')}</p>
          <div className="card-rating">
            <span>&#9733;</span>
            <span>{rating}</span>
          </div>
        </div>
        <div className="card-action">
          <Button variant="solid">Alugar</Button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
