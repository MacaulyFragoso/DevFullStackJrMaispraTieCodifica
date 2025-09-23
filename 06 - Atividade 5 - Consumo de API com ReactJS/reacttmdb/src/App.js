import React, { useState, useEffect } from 'react';
import './App.css';

// Chave da API (substitua pela sua)
const API_KEY = '9993098c4f60c1be65629bc3ae211e12';
const API_URL = 'https://api.themoviedb.org/3';

function App() {
  const [searchTerm, setSearchTerm] = useState('');
  const [movies, setMovies] = useState([]);
  const [selectedMovie, setSelectedMovie] = useState(null);
  const [favorites, setFavorites] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0);

  // Carrega favoritos do localStorage ao iniciar
  useEffect(() => {
    const storedFavorites = JSON.parse(localStorage.getItem('movie-favorites'));
    if (storedFavorites) {
      setFavorites(storedFavorites);
    }
  }, []);

  // Salva favoritos no localStorage quando a lista muda
  const saveToLocalStorage = (items) => {
    localStorage.setItem('movie-favorites', JSON.stringify(items));
  };

  const searchMovies = async (term, page = 1) => {
    if (!term) {
      setError('Por favor, digite um termo de busca.');
      setMovies([]);
      return;
    }
    setLoading(true);
    setError(null);
    setSelectedMovie(null);

    try {
      const response = await fetch(
        `${API_URL}/search/movie?api_key=${API_KEY}&query=${term}&page=${page}&language=pt-BR`
      );
      if (!response.ok) {
        throw new Error('Falha ao buscar os filmes. Tente novamente.');
      }
      const data = await response.json();
      if (data.results.length === 0) {
        setError('Nenhum filme encontrado para este termo.');
      }
      setMovies(data.results);
      setCurrentPage(data.page);
      setTotalPages(data.total_pages);
    } catch (err) {
      setError(err.message);
      setMovies([]);
    } finally {
      setLoading(false);
    }
  };

  const getMovieDetails = async (id) => {
    setLoading(true);
    setError(null);
    try {
      const response = await fetch(
        `${API_URL}/movie/${id}?api_key=${API_KEY}&language=pt-BR&append_to_response=credits`
      );
      if (!response.ok) {
        throw new Error('Não foi possível carregar os detalhes do filme.');
      }
      const data = await response.json();
      setSelectedMovie(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const handleSearchSubmit = (event) => {
    event.preventDefault();
    searchMovies(searchTerm, 1);
  };

  const addFavoriteMovie = (movie) => {
    const newFavoriteList = [...favorites, movie];
    setFavorites(newFavoriteList);
    saveToLocalStorage(newFavoriteList);
  };

  const removeFavoriteMovie = (movie) => {
    const newFavoriteList = favorites.filter(
      (fav) => fav.id !== movie.id
    );
    setFavorites(newFavoriteList);
    saveToLocalStorage(newFavoriteList);
  };

  const isFavorite = (movie) => {
    return favorites.some((fav) => fav.id === movie.id);
  };

  const handlePageChange = (newPage) => {
    if (newPage > 0 && newPage <= totalPages) {
      searchMovies(searchTerm, newPage);
    }
  };

  const renderPagination = () => {
    if (totalPages <= 1) return null;
    return (
      <div className="pagination">
        <button onClick={() => handlePageChange(currentPage - 1)} disabled={currentPage === 1}>
          Anterior
        </button>
        <span>Página {currentPage} de {totalPages}</span>
        <button onClick={() => handlePageChange(currentPage + 1)} disabled={currentPage === totalPages}>
          Próxima
        </button>
      </div>
    );
  };

  return (
    <div className="app-container">
      <header>
        <h1>Busca Filmes</h1>
        <form onSubmit={handleSearchSubmit}>
          <input
            type="text"
            placeholder="Digite o nome do filme..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <button type="submit">Buscar</button>
        </form>
      </header>

      <main>
        {loading && <div className="loading">Carregando...</div>}
        {error && <div className="error">{error}</div>}

        {selectedMovie ? (
          <div className="movie-details">
            <button onClick={() => setSelectedMovie(null)}>Voltar para a busca</button>
            <h2>{selectedMovie.title}</h2>
            <img src={`https://image.tmdb.org/t/p/w500/${selectedMovie.poster_path}`} alt={selectedMovie.title} />
            <p><strong>Sinopse:</strong> {selectedMovie.overview}</p>
            <p><strong>Avaliação:</strong> {selectedMovie.vote_average.toFixed(1)}</p>
            <p><strong>Diretor:</strong> {selectedMovie.credits?.crew.find(c => c.job === 'Director')?.name || 'N/A'}</p>
            <p><strong>Elenco:</strong> {selectedMovie.credits?.cast.slice(0, 5).map(c => c.name).join(', ')}</p>
          </div>
        ) : (
          <>
            <div className="movie-list">
              {movies.map((movie) => (
                <div key={movie.id} className="movie-card">
                  <img src={`https://image.tmdb.org/t/p/w200/${movie.poster_path}`} alt={movie.title} />
                  <h3>{movie.title}</h3>
                  <p>{new Date(movie.release_date).getFullYear()}</p>
                  <button onClick={() => getMovieDetails(movie.id)}>Ver Detalhes</button>
                  {isFavorite(movie) ? (
                    <button onClick={() => removeFavoriteMovie(movie)}>Remover Favorito</button>
                  ) : (
                    <button onClick={() => addFavoriteMovie(movie)}>Adicionar Favorito</button>
                  )}
                </div>
              ))}
            </div>
            {renderPagination()}
          </>
        )}

        <section className="favorites-section">
          <h2>Meus Favoritos</h2>
          {favorites.length > 0 ? (
            <div className="movie-list">
              {favorites.map((movie) => (
                <div key={movie.id} className="movie-card">
                  <img src={`https://image.tmdb.org/t/p/w200/${movie.poster_path}`} alt={movie.title} />
                  <h3>{movie.title}</h3>
                  <button onClick={() => removeFavoriteMovie(movie)}>Remover</button>
                </div>
              ))}
            </div>
          ) : (
            <p>Sua lista de favoritos está vazia.</p>
          )}
        </section>
      </main>
    </div>
  );
}

export default App;