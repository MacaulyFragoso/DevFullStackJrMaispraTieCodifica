import React from 'react';
import { createBrowserRouter, RouterProvider, Navigate } from 'react-router-dom';
import { ThemeProvider } from './contexts/ThemeContext';
import Layout from './components/Layout';
import CssGlobalPage from './pages/01-css-global';
import CssModulesPage from './pages/02-css-modules';
import TailwindPage from './pages/03-tailwind';
import StyledComponentsPage from './pages/04-styled-components';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Navigate to="/css-global" replace /> },
      { path: 'css-global', element: <CssGlobalPage /> },
      { path: 'css-modules', element: <CssModulesPage /> },
      { path: 'tailwind', element: <TailwindPage /> },
      { path: 'styled-components', element: <StyledComponentsPage /> },
    ],
  },
]);

function App() {
  return (
    <ThemeProvider>
      <RouterProvider router={router} />
    </ThemeProvider>
  );
}

export default App;
