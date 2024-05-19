"use client";
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";

import HeroReview from "./HeroReview";

const responsive = {
  desktop: {
    breakpoint: { max: 4000, min: 1024 },
    items: 1,
    slidesToSlide: 1,
  },
  tablet: {
    breakpoint: { max: 1024, min: 464 },
    items: 1,
    slidesToSlide: 1,
  },
  mobile: {
    breakpoint: { max: 464, min: 0 },
    items: 1,
    slidesToSlide: 1,
  },
};

const HeroSlider = () => {
  return (
    <Carousel
      additionalTransfrom={0}
      arrows={true}
      autoPlay={true}
      autoPlaySpeed={5000}
      centerMode={false}
      infinite
      responsive={responsive}
      itemClass="item"
    >
      <HeroReview
        image="/images/c1.jpg"
        title="Developpement des applications Web et Mobile"
        description="Conception adaptes a vos besoin uniques et specifiques"
      />
      <HeroReview
        image="/images/Logo ITIA/youn.jpg"
        title="Intelligence Artificielle et Big Data"
        description="Solutions d'Inteligence, Analyse et Sciences de donnees pour la croissance de votre entreprise"
      />
      <HeroReview
        image="/images/c1.jpg"
        title="Cyber Securite et Reseaux"
        description=""
      />
      <HeroReview
        image="/images/c2.jpg"
        title="Consultation et conseils avances"
        description=""
      />
    </Carousel>
  );
};

export default HeroSlider;
