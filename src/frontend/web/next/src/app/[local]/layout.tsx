import Footer from "@/components/Footer";
import Header from "@/components/Header";
import ScrollToTop from "@/components/ScrollToTop";
import { Inter } from "next/font/google";
import "node_modules/react-modal-video/css/modal-video.css";
import "../../styles/index.css";
import { NextIntlClientProvider } from "next-intl";
import { getMessages } from "next-intl/server";

const inter = Inter({ subsets: ["latin"] });

interface RootLayoutProps {
  children: React.ReactNode;
  params: {
    locale: string;
  };
}

export default async function RootLayout({
  children,
  params: { locale },
}: Readonly<RootLayoutProps>) {
  const messages = await getMessages();

  if (!messages) {
    return null; // or a loading spinner
  }

  return (
    <html suppressHydrationWarning lang={locale}>
      <head />
      <body className={`bg-[#FCFCFC] dark:bg-black ${inter.className}`}>
        <NextIntlClientProvider locale={locale} messages={messages}>
          <Providers>
            <Header />
            {children}
            <Footer />
            <ScrollToTop />
          </Providers>
        </NextIntlClientProvider>
      </body>
    </html>
  );
}

import { Providers } from "./providers";
