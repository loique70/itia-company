// src/app/service/[service]/page.tsx
import Breadcrumb from "@/components/Common/Breadcrumb";
import ServiceDetails from "@/components/Services/ServiceDetail";
import { notFound } from "next/navigation";
import React from "react";

const serviceData = {
  "web-development": {
    title: "Développement Web et Mobile",
    description:
      "Nous offrons des solutions de développement web et mobile sur mesure adaptées aux besoins de votre entreprise...",
    image: "/images/Logo ITIA/about.jpg",
    detailedDescription:
      "Le service de développement web et mobile consiste à concevoir, créer et mettre en place des applications, des sites web et d’autres solutions numériques. Il englobe le développement d’applications mobiles pour les plateformes iOS et Android, la création de sites web réactifs et personnalisés, ainsi que le développement de logiciels sur mesure pour répondre aux besoins spécifiques d’une entreprise. Ce service inclut la programmation, la conception de l’interface utilisateur (UI), la gestion de bases de données, la sécurité, les tests et la mise en production. L’objectif principal est de fournir des solutions numériques robustes, performantes et conviviales qui répondent aux besoins de l’entreprise et de ses utilisateurs, tout en utilisant les technologies les plus appropriées pour chaque projet.",
    servicesIncluded: [
      "Création d’applications web réactives",
      "Développement d’applications mobiles",
      "Développement d’applications sur mesure",
    ],
    imageLight: "/images/Logo ITIA/service/dev2.jpeg",
    imageDark: "/images/Logo ITIA/service/dev1.jpeg",
  },
  cybersecurity: {
    title: "Cybersécurité",
    description:
      "Protégez vos systèmes et données contre les cybermenaces grâce à nos services avancés de cybersécurité...",
    image: "/images/Logo ITIA/about.jpg",
    detailedDescription:
      "Le service de cybersécurité vise à protéger les systèmes informatiques, les réseaux et les données contre les attaques et les accès non autorisés. Il inclut l’évaluation des risques, la mise en œuvre de solutions de sécurité, la surveillance continue et la réponse aux incidents. Nos experts travaillent pour identifier les vulnérabilités, mettre en place des mesures de protection adaptées, et assurer la continuité et la sécurité de vos opérations. Ce service est essentiel pour prévenir les cyberattaques, protéger les informations sensibles et garantir la conformité avec les réglementations en vigueur.",
    servicesIncluded: [
      "Évaluation des risques de sécurité",
      "Mise en place de solutions de sécurité",
      "Surveillance et réponse aux incidents",
    ],
    imageLight: "/images/Logo ITIA/service/cyber.jpeg",
    imageDark: "/images/Logo ITIA/service/cyber1.jpeg",
  },
  "network-telecom": {
    title: "Réseaux et Télécommunications",
    description:
      "Optimisez votre infrastructure réseau et vos télécommunications avec nos services spécialisés...",
    image: "/images/Logo ITIA/about.jpg",
    detailedDescription:
      "Le service de réseaux et télécommunications comprend la conception, la mise en œuvre et la gestion des infrastructures réseau et de communication. Il s’agit de créer des réseaux robustes et fiables, d’assurer la connectivité des différentes parties d’une organisation et de garantir une communication fluide et sécurisée. Ce service couvre également la configuration des équipements réseau, la gestion des systèmes de télécommunication et le dépannage. L’objectif est d’optimiser la performance du réseau et de réduire les temps d’arrêt, tout en offrant des solutions évolutives pour répondre aux besoins futurs.",
    servicesIncluded: [
      "Conception et mise en œuvre de réseaux",
      "Configuration des équipements réseau",
      "Gestion des systèmes de communication",
    ],
    imageLight: "/images/Logo ITIA/service/network.jpeg",
    imageDark: "/images/Logo ITIA/service/network1.jpg",
  },
  consulting: {
    title: "Consultation",
    description:
      "Obtenez des conseils d’experts pour vos projets technologiques avec nos services de consultation...",
    image: "/images/Logo ITIA/about.jpg",
    detailedDescription:
      "Nos services de consultation vous aident à planifier, développer et mettre en œuvre des projets technologiques. Nos consultants apportent une expertise approfondie et des conseils stratégiques pour vous aider à atteindre vos objectifs commerciaux. Nous travaillons en étroite collaboration avec vous pour comprendre vos besoins, définir des stratégies efficaces et mettre en place des solutions technologiques adaptées. Ce service inclut l’évaluation des besoins, la planification de projets, l’assistance technique et la gestion de la mise en œuvre. L’objectif est de maximiser le retour sur investissement et de garantir le succès de vos initiatives technologiques.",
    servicesIncluded: [
      "Conseil stratégique",
      "Planification de projet",
      "Assistance technique",
    ],
    imageLight: "/images/Logo ITIA/service/consulting3.jpeg",
    imageDark: "/images/Logo ITIA/service/consulting1.jpeg",
  },
  "data-science": {
    title: "Data Science et IA",
    description:
      "Exploitez la puissance des données et de l’intelligence artificielle pour prendre des décisions éclairées...",
    image: "/images/Logo ITIA/about.jpg",
    detailedDescription:
      "Le service de Data Science et IA propose des solutions basées sur l'analyse des données et l'intelligence artificielle pour aider les entreprises à prendre des décisions éclairées. Il inclut l’analyse de données pour découvrir des tendances et des informations utiles, le développement de modèles prédictifs pour anticiper les comportements futurs, et l’intégration de solutions d’IA pour automatiser et optimiser les processus. Nos experts utilisent des techniques avancées de machine learning, de deep learning et d’analyse statistique pour transformer les données brutes en informations exploitables. Ce service vise à améliorer la prise de décision, à optimiser les opérations et à créer de nouvelles opportunités de croissance.",
    servicesIncluded: [
      "Analyse des données",
      "Développement de modèles prédictifs",
      "Intégration de solutions d'IA",
    ],
    imageLight: "/images/Logo ITIA/service/ds4.jpeg",
    imageDark: "/images/Logo ITIA/service/ds2.jpeg",
  },
};

export async function generateStaticParams() {
  return Object.keys(serviceData).map((key) => ({
    service: key,
  }));
}

const ServiceDetailPage = ({ params }: { params: { service: string } }) => {
  const serviceKey = params.service;

  const serviceInfo = serviceData[serviceKey];

  if (!serviceInfo) {
    notFound();
  }

  return (
    <div>
      <Breadcrumb pageName={serviceInfo.title} image={serviceInfo.image} />
      <ServiceDetails
        title={serviceInfo.title}
        imageLight={serviceInfo.imageLight}
        imageDark={serviceInfo.imageDark}
        detailedDescription={serviceInfo.detailedDescription}
        servicesIncluded={serviceInfo.servicesIncluded}
      />
    </div>
  );
};

export default ServiceDetailPage;
