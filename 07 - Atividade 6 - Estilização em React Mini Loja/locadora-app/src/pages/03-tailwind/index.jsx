import React, { useState, useEffect } from 'react';
import Navbar from '../../03-tailwind/components/Navbar';
import ProductCard from '../../03-tailwind/components/ProductCard';
import Skeleton from '../../03-tailwind/components/Skeleton';
import { fetchUpcomingMovies } from '../../services/api';

const TailwindPage = () => {
  const [loading, setLoading] = useState(true);
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    const getMovies = async () => {
      setLoading(true);
      const upcomingMovies = await fetchUpcomingMovies();
      setMovies(upcomingMovies.slice(0, 6));
      setLoading(false);
    };
    getMovies();
  }, []);

  return (
    <div>
      <Navbar />
      <main className="max-w-7xl mx-auto py-8 px-4">
        <div className="grid grid-cols-3 gap-8">
          {loading
            ? Array.from({ length: 6 }).map((_, index) => <Skeleton key={index} />)
            : movies.map((movie) => <ProductCard key={movie.id} product={movie} />)}
        </div>
      </main>
    </div>
  );
};

export default TailwindPage;
