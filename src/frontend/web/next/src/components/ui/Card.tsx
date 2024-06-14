"use client";
import React from "react";
import Image from "next/image";
import Link from "next/link";
import { BackgroundGradient } from "./backgroung-gradient";

export function BackgroundGradientDemo({
  imageSrc,
  altText,
  title,
  description,
  link,
}) {
  return (
    <div className="relative">
      <BackgroundGradient className="flex flex-col items-center rounded-[22px] bg-white p-4 dark:bg-zinc-900 sm:p-10">
        <Image
          src={imageSrc}
          alt={altText}
          height="100"
          width="100"
          className="object-contain "
        />
        <p className="mb-2 mt-4 text-base text-black dark:text-neutral-200 sm:text-xl">
          {title}
        </p>

        <p className="text-sm text-neutral-600 dark:text-neutral-400">
          {description}
        </p>
        <Link
          href={link}
          className="mt-4 flex items-center space-x-1 rounded-full py-1 text-xs font-bold text-white "
        >
          <span className="rounded-full bg-zinc-700 px-2 py-1 text-[0.6rem] text-white">
            En savoir plus
          </span>
        </Link>
      </BackgroundGradient>
    </div>
  );
}
