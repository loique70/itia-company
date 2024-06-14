import React from "react";
import { BackgroundGradientDemo } from "../ui/Card";

const Service = () => {
  const cardDataArray = [
    {
      imageSrc: "/images/Logo ITIA/service/web.png",
      altText: "web development",
      title: "Développement web et mobile",
      description:
        "Nous offrons des solutions de développement web et mobile sur mesure, adaptées aux besoins de votre entreprise, utilisant les dernières technologies pour garantir performance et fiabilité...",
      link: "/service/web-development",
    },
    {
      imageSrc: "/images/Logo ITIA/service/cyber.jpg",
      altText: "cybersecurity",
      title: "Cybersécurité",
      description:
        "Protégez vos systèmes et données contre les cybermenaces avec nos services de cybersécurité avancés. Nous offrons des évaluations de sécurité, des solutions de protection et des formations...",
      link: "/service/cybersecurity",
    },
    {
      imageSrc: "/images/Logo ITIA/service/network.jpg",
      altText: "network and telecommunications",
      title: "Réseaux et télécommunications",
      description:
        "Optimisez votre infrastructure réseau et télécommunications avec nos services spécialisés. Nous offrons des solutions de connectivité fiables et performantes pour améliorer votre communication...",
      link: "/service/network-telecom",
    },
    {
      imageSrc: "/images/Logo ITIA/service/notes.3.png",
      altText: "consulting",
      title: "Consultations",
      description:
        "Obtenez des conseils d'experts pour vos projets technologiques avec nos services de consultation. Nous vous aidons à définir des stratégies efficaces et à mettre en œuvre des solutions innovantes...",
      link: "/service/consulting",
    },
    {
      imageSrc: "/images/Logo ITIA/service/analysis.png",
      altText: "data science and AI",
      title: "Data Science et IA",
      description:
        "Exploitez la puissance des données et de l'intelligence artificielle pour prendre des décisions éclairées. Nos services de Data Science et IA vous permettent d'analyser et de visualiser vos données...",
      link: "/service/data-science",
    },
  ];

  return (
    <section id="about" className="pt-16 md:pt-20 lg:pt-28">
      <div className="container">
        <div className="border-b border-body-color/[.15] pb-16 dark:border-white/[.15] md:pb-20 lg:pb-28">
          <div className="grid grid-cols-1 gap-x-8 gap-y-10 md:grid-cols-2 lg:grid-cols-3">
            {cardDataArray.map((cardData, index) => (
              <BackgroundGradientDemo
                key={index}
                imageSrc={cardData.imageSrc}
                altText={cardData.altText}
                title={cardData.title}
                description={cardData.description}
                link={cardData.link}
              />
            ))}
          </div>
        </div>
      </div>
    </section>
  );
};

export default Service;
