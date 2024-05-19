import React from "react";
import Image from "next/image";
type Props = {
  title: string;
  description: string;
  image: string;
};

const HeroReview = (props: Props) => {
  return (
    <div className="flex  justify-center text-center">
      <div>
        <h1 className="className=mb-5 text-3xl font-bold leading-tight text-black dark:text-white sm:text-4xl sm:leading-tight md:text-5xl md:leading-tight">
          {props.title}{" "}
        </h1>
        <p className="mb-12 text-base !leading-relaxed text-body-color dark:text-body-color-dark sm:text-lg md:text-xl">
          {props.description}
        </p>
      </div>
      <Image
        src={props.image}
        alt={props.title}
        width={100}
        height={100}
        objectFit="contain"
        className="w-full"
      />
    </div>
  );
};

export default HeroReview;
