import React from 'react';
import styled, { keyframes } from 'styled-components';

const pulse = keyframes`
  50% { opacity: .5; }
`;

const SkeletonCard = styled.div`
  background-color: ${({ theme }) => theme.colors.surface};
  border: 1px solid ${({ theme }) => theme.colors.border};
  border-radius: ${({ theme }) => theme.borderRadius};
  overflow: hidden;
`;

const SkeletonImage = styled.div`
  aspect-ratio: 2 / 3;
  background-color: ${({ theme }) => theme.colors.skeletonBase};
  animation: ${pulse} 2s cubic-bezier(0.4, 0, 0.6, 1) infinite;
`;

const SkeletonContent = styled.div`
  padding: 1rem;
`;

const SkeletonLine = styled.div`
  height: 1rem;
  border-radius: 0.25rem;
  background-color: ${({ theme }) => theme.colors.skeletonBase};
  animation: ${pulse} 2s cubic-bezier(0.4, 0, 0.6, 1) infinite;
`;

const SkeletonButton = styled.div`
  height: 2.75rem;
  border-radius: 0.25rem;
  background-color: ${({ theme }) => theme.colors.skeletonBase};
  animation: ${pulse} 2s cubic-bezier(0.4, 0, 0.6, 1) infinite;
`;

const Skeleton = () => {
  return (
    <SkeletonCard>
      <SkeletonImage />
      <SkeletonContent>
        <SkeletonLine style={{ width: '80%' }} />
        <SkeletonLine style={{ width: '50%', marginTop: '1rem' }} />
        <SkeletonButton style={{ marginTop: '2rem' }} />
      </SkeletonContent>
    </SkeletonCard>
  );
};

export default Skeleton;
