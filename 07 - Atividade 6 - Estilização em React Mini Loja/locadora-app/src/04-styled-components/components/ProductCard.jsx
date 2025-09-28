import React from 'react';
import styled from 'styled-components';
import Button from './Button';

const CardBase = styled.div`
  background-color: ${({ theme }) => theme.colors.surface};
  border: 1px solid ${({ theme }) => theme.colors.border};
  border-radius: ${({ theme }) => theme.borderRadius};
  box-shadow: ${({ theme }) => theme.shadows.md};
  display: flex;
  flex-direction: column;
  transition: transform 0.2s ease-in-out;
  &:hover {
    transform: translateY(-4px);
  }
`;
const ImageWrapper = styled.div`
  position: relative;
  width: 100%;
  aspect-ratio: 2 / 3;
  overflow: hidden;
  border-top-left-radius: ${({ theme }) => theme.borderRadius};
  border-top-right-radius: ${({ theme }) => theme.borderRadius};
  background-color: ${({ theme }) => theme.colors.skeletonBase};
`;
const CardImage = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;
const CardContent = styled.div`
  padding: 1rem;
  display: flex;
  flex-direction: column;
  flex-grow: 1;
`;
const CardTitle = styled.h3`
  color: ${({ theme }) => theme.colors.textPrimary};
  font-weight: bold;
  font-size: 1.125rem;
  height: 3.5rem;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;
const CardInfo = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 0.5rem;
`;
const CardPrice = styled.p`
  color: ${({ theme }) => theme.colors.primary};
  font-weight: bold;
  font-size: 1.25rem;
`;
const CardRating = styled.div`
  display: flex;
  align-items: center;
  color: ${({ theme }) => theme.colors.warning};
  span:last-child {
    color: ${({ theme }) => theme.colors.textSecondary};
    margin-left: 0.25rem;
    font-size: 0.875rem;
  }
`;
const CardAction = styled.div`
  margin-top: 1rem;
  padding-top: 1rem;
  border-top: 1px solid ${({ theme }) => theme.colors.border};
  flex-grow: 1;
  display: flex;
  align-items: flex-end;
`;

const ProductCard = ({ product }) => {
  const rating = (product.vote_average / 2).toFixed(1);

  return (
    <CardBase>
      <ImageWrapper>
        <CardImage src={product.image} alt={product.title} loading="lazy" />
      </ImageWrapper>
      <CardContent>
        <CardTitle>{product.title}</CardTitle>
        <CardInfo>
          <CardPrice>R$ {product.price.replace('.', ',')}</CardPrice>
          <CardRating>
            <span>&#9733;</span>
            <span>{rating}</span>
          </CardRating>
        </CardInfo>
        <CardAction>
          <Button>Alugar</Button>
        </CardAction>
      </CardContent>
    </CardBase>
  );
};

export default ProductCard;