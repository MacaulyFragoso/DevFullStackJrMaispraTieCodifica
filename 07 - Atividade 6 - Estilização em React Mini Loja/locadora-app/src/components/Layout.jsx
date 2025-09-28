import React from 'react';
import { Outlet, NavLink } from 'react-router-dom';

const Layout = () => {
  return (
    <div>
      <nav className="version-nav">
        <ul>
          <li><NavLink to="/css-global" className={({ isActive }) => isActive ? "version-link active" : "version-link"}>CSS Global</NavLink></li>
          <li><NavLink to="/css-modules" className={({ isActive }) => isActive ? "version-link active" : "version-link"}>CSS Modules</NavLink></li>
          <li><NavLink to="/tailwind" className={({ isActive }) => isActive ? "version-link active" : "version-link"}>Tailwind CSS</NavLink></li>
          <li><NavLink to="/styled-components" className={({ isActive }) => isActive ? "version-link active" : "version-link"}>Styled-Components</NavLink></li>
        </ul>
      </nav>
      <Outlet />
    </div>
  );
};

export default Layout;
