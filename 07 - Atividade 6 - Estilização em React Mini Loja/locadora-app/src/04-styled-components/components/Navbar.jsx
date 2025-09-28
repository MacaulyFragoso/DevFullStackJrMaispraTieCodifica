import React from 'react';
import styled from 'styled-components';
import { useTheme } from '../../contexts/ThemeContext';

const StyledNavbar = styled.header`
  background-color: ${({ theme }) => theme.colors.surface};
  border-bottom: 1px solid ${({ theme }) => theme.colors.border};
  padding: 1rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: sticky;
  top: 0;
  z-index: 10;
  margin-bottom: 2rem;
`;

const Logo = styled.div`
  color: ${({ theme }) => theme.colors.primary};
  font-weight: bold;
  font-size: 1.5rem;
`;

const Actions = styled.div`
  display: flex;
  align-items: center;
  gap: 1.5rem;
`;

const ThemeToggle = styled.button`
  background: none;
  border: none;
  cursor: pointer;
  font-size: 1.5rem;
  color: ${({ theme }) => theme.colors.textSecondary};
`;

const CartBadge = styled.div`
  position: relative;
  font-size: 1.75rem;
`;

const CartCount = styled.span`
  position: absolute;
  top: -0.5rem;
  right: -0.5rem;
  background-color: ${({ theme }) => theme.colors.primary};
  color: white;
  font-size: 0.75rem;
  font-weight: bold;
  width: 1.25rem;
  height: 1.25rem;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 9999px;
`;

const Navbar = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <StyledNavbar>
      <Logo>Locadora</Logo>
      <Actions>
        <ThemeToggle onClick={toggleTheme} aria-label="Toggle theme">
          {theme === 'light' ? '🌙' : '☀️'}
        </ThemeToggle>
        <CartBadge>
          🛒
          <CartCount>3</CartCount>
        </CartBadge>
      </Actions>
    </StyledNavbar>
  );
};

export default Navbar;
