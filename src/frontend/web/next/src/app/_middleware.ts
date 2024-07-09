// app/_middleware.ts
import { NextRequest, NextResponse } from 'next/server';

const PUBLIC_FILE = /\.(.*)$/;

export function middleware(request: NextRequest) {
  if (request.nextUrl.pathname.startsWith('/_next') || 
      request.nextUrl.pathname.includes('/api/') ||
      PUBLIC_FILE.test(request.nextUrl.pathname)) {
    return NextResponse.next();
  }

  const locale = request.cookies.get('NEXT_LOCALE') || 'en';
  return NextResponse.redirect(new URL(`/${locale}${request.nextUrl.pathname}`, request.url));
}
