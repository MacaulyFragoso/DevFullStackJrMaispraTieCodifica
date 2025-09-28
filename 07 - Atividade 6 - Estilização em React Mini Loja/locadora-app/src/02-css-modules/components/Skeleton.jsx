import React from 'react';
import styles from './Skeleton.module.css';

const Skeleton = () => {
  return (
    <div className={styles.skeletonCard}>
      <div className={styles.skeletonImage}></div>
      <div className={styles.skeletonContent}>
        <div className={styles.skeletonLine} style={{ width: '80%' }}></div>
        <div className={styles.skeletonLine} style={{ width: '50%', marginTop: '1rem' }}></div>
        <div className={styles.skeletonButton} style={{ marginTop: '2rem' }}></div>
      </div>
    </div>
  );
};

export default Skeleton;
