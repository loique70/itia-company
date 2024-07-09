// app/layout.tsx or app/layout.js
import React from "react";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html>
      <head>
        <title>Itia</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        {/* Add other meta tags or links to stylesheets here */}
      </head>
      <body>{children}</body>
    </html>
  );
}
