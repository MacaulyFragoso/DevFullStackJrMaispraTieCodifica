import React from 'react';

const Skeleton = () => {
  return (
    <div className="bg-white dark:bg-slate-800 rounded-lg border border-gray-200 dark:border-slate-700 overflow-hidden">
      <div className="aspect-[2/3] bg-gray-300 dark:bg-slate-700 animate-pulse"></div>
      <div className="p-4">
        <div className="h-4 bg-gray-300 dark:bg-slate-700 rounded w-4/5 animate-pulse mb-4"></div>
        <div className="h-4 bg-gray-300 dark:bg-slate-700 rounded w-1/2 animate-pulse"></div>
        <div className="h-11 bg-gray-300 dark:bg-slate-700 rounded w-full mt-6 animate-pulse"></div>
      </div>
    </div>
  );
};

export default Skeleton;
