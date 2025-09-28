import React from 'react';
import Button from './Button';

const ProductCard = ({ product }) => {
  const rating = (product.vote_average / 2).toFixed(1);

  return (
    <div className="bg-white dark:bg-slate-800 border border-gray-200 dark:border-slate-700 rounded-lg shadow-md flex flex-col transition-transform duration-200 ease-in-out hover:transform hover:-translate-y-1">
      <div className="relative w-full aspect-[2/3] overflow-hidden rounded-t-lg bg-gray-200 dark:bg-slate-700">
        <img src={product.image} alt={product.title} className="h-full w-full object-cover"/>
      </div>
      <div className="p-4 flex flex-col flex-grow">
        <h3 className="text-gray-900 dark:text-white font-bold text-lg h-14 line-clamp-2">{product.title}</h3>
        <div className="flex items-center justify-between mt-2">
          <p className="text-blue-600 dark:text-blue-400 font-bold text-xl">R$ {product.price.replace('.', ',')}</p>
          <div className="flex items-center">
            <span className="text-amber-500 text-lg">&#9733;</span>
            <span className="text-gray-500 dark:text-gray-400 ml-1 text-sm">{rating}</span>
          </div>
        </div>
        <div className="mt-4 pt-4 border-t border-gray-200 dark:border-slate-700 flex-grow flex items-end">
          <Button variant="solid">Alugar</Button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;