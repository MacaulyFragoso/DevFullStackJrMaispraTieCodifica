const apiKey = "SUA_CHAVE_DA_API_AQUI";

const apiUrl = "https://api.themoviedb.org/3";
const imageUrlBase = "https://image.tmdb.org/t/p/w500";

const processApiResponse = (data) => {
  return data.results.map(movie => ({
    ...movie,
    price: (Math.random() * (25 - 7) + 7).toFixed(2),
    image: movie.poster_path 
      ? `${imageUrlBase}${movie.poster_path}` 
      : "https://placehold.co/500x750/1f2937/fff?text=Poster+Indisponivel",
  }));
};

// CSS Global
export const fetchPopularMovies = async () => {
  try {
    const response = await fetch(`${apiUrl}/movie/popular?api_key=${apiKey}&language=pt-BR&page=1`);
    if (!response.ok) throw new Error("Erro ao buscar filmes populares");
    const data = await response.json();
    return processApiResponse(data);
  } catch (error) {
    console.error("Erro:", error);
    return [];
  }
};

// CSS Modules
export const fetchTopRatedMovies = async () => {
  try {
    const response = await fetch(`${apiUrl}/movie/top_rated?api_key=${apiKey}&language=pt-BR&page=1`);
    if (!response.ok) throw new Error("Erro ao buscar filmes mais bem avaliados");
    const data = await response.json();
    return processApiResponse(data);
  } catch (error) {
    console.error("Erro:", error);
    return [];
  }
};

// Tailwind
export const fetchUpcomingMovies = async () => {
  try {
    const response = await fetch(`${apiUrl}/movie/upcoming?api_key=${apiKey}&language=pt-BR&page=1`);
    if (!response.ok) throw new Error("Erro ao buscar próximos lançamentos");
    const data = await response.json();
    return processApiResponse(data);
  } catch (error) {
    console.error("Erro:", error);
    return [];
  }
};

// Styled-Components
export const fetchNowPlayingMovies = async () => {
  try {
    const response = await fetch(`${apiUrl}/movie/now_playing?api_key=${apiKey}&language=pt-BR&page=1`);
    if (!response.ok) throw new Error("Erro ao buscar filmes em cartaz");
    const data = await response.json();
    return processApiResponse(data);
  } catch (error) {
    console.error("Erro:", error);
    return [];
  }
};
