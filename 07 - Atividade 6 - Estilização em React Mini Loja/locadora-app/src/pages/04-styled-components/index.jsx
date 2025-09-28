import React, { useState, useEffect } from 'react';
import { ThemeProvider as StyledThemeProvider } from 'styled-components';
import Navbar from '../../04-styled-components/components/Navbar';
import ProductCard from '../../04-styled-components/components/ProductCard';
import Skeleton from '../../04-styled-components/components/Skeleton';
import { lightTheme, darkTheme } from '../../04-styled-components/theme';
import { useTheme } from '../../contexts/ThemeContext';
import styled from 'styled-components';
import { fetchNowPlayingMovies } from '../../services/api';

const PageMain = styled.main`
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
`;
const ProductGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(1, 1fr);
  gap: 2rem;
  @media (min-width: 640px) { grid-template-columns: repeat(2, 1fr); }
  @media (min-width: 1024px) { grid-template-columns: repeat(3, 1fr); }
`;

const StyledComponentsPage = () => {
  const { theme } = useTheme();
  const [loading, setLoading] = useState(true);
  const [movies, setMovies] = useState([]);
  const currentTheme = theme === 'light' ? lightTheme : darkTheme;

  useEffect(() => {
    const getMovies = async () => {
      setLoading(true);
      const nowPlayingMovies = await fetchNowPlayingMovies();
      setMovies(nowPlayingMovies.slice(0, 6));
      setLoading(false);
    };
    getMovies();
  }, []);

  return (
    <StyledThemeProvider theme={currentTheme}>
      <div>
        <Navbar />
        <PageMain>
          <ProductGrid>
            {loading
              ? Array.from({ length: 6 }).map((_, index) => <Skeleton key={index} />)
              : movies.map((movie) => <ProductCard key={movie.id} product={movie} />)}
          </ProductGrid>
        </PageMain>
      </div>
    </StyledThemeProvider>
  );
};

export default StyledComponentsPage;
