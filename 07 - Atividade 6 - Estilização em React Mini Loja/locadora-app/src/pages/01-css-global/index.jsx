import React, { useState, useEffect } from 'react';
import Navbar from '../../01-css-global/components/Navbar';
import ProductCard from '../../01-css-global/components/ProductCard';
import Skeleton from '../../01-css-global/components/Skeleton';
import { fetchPopularMovies } from '../../services/api';
import '../../01-css-global/styles.css';

const CssGlobalPage = () => {
  const [loading, setLoading] = useState(true);
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    const getMovies = async () => {
      setLoading(true);
      const popularMovies = await fetchPopularMovies();
      setMovies(popularMovies.slice(0, 6));
      setLoading(false);
    };
    getMovies();
  }, []);

  return (
    <div>
      <Navbar />
      <main className="page-main">
        <div className="product-grid">
          {loading
            ? Array.from({ length: 6 }).map((_, index) => <Skeleton key={index} />)
            : movies.map((movie) => <ProductCard key={movie.id} product={movie} />)}
        </div>
      </main>
    </div>
  );
};

export default CssGlobalPage;
