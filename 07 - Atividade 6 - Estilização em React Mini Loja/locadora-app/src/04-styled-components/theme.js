const baseTheme = {
  borderRadius: '0.5rem',
  shadows: {
    md: '0 4px 6px -1px rgb(0 0 0 / 0.1), 0 2px 4px -2px rgb(0 0 0 / 0.1)',
  }
};

export const lightTheme = {
  ...baseTheme,
  colors: {
    primary: '#2563eb',
    primaryHover: '#1d4ed8',
    textPrimary: '#111827',
    textSecondary: '#6b7280',
    bg: '#f9fafb',
    surface: '#ffffff',
    border: '#e5e7eb',
    tagBg: '#dbeafe',
    tagText: '#1e40af',
    warning: '#f59e0b',
    skeletonBase: '#f3f4f6',
  },
};

export const darkTheme = {
  ...baseTheme,
  colors: {
    primary: '#60a5fa',
    primaryHover: '#93c5fd',
    textPrimary: '#f9fafb',
    textSecondary: '#9ca3af',
    bg: '#111827',
    surface: '#1f2937',
    border: '#374151',
    tagBg: '#1e3a8a',
    tagText: '#bfdbfe',
    warning: '#fbbF56',
    skeletonBase: '#374151',
  },
};
