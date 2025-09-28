import React from 'react';

const Skeleton = () => {
  return (
    <div className="skeleton-card">
      <div className="skeleton-image"></div>
      <div className="skeleton-content">
        <div className="skeleton-line" style={{ width: '80%' }}></div>
        <div className="skeleton-line" style={{ width: '50%', marginTop: '1rem' }}></div>
        <div className="skeleton-button" style={{ marginTop: '2rem' }}></div>
      </div>
    </div>
  );
};

export default Skeleton;
