import React from "react";
import { BackgroundGradientDemo } from "../ui/Card";
import { useTranslations, useLocale } from "next-intl";

const Service = () => {
  const locale = useLocale();
  const t = useTranslations("Service");

  const cardDataArray = [
    {
      imageSrc: "/images/Logo ITIA/service/web.png",
      altText: t("webDevelopment.altText"),
      title: t("webDevelopment.title"),
      description: t("webDevelopment.description"),
      link: `/${locale}/service/web-development`,
    },
    {
      imageSrc: "/images/Logo ITIA/service/cyber.jpg",
      altText: t("cybersecurity.altText"),
      title: t("cybersecurity.title"),
      description: t("cybersecurity.description"),
      link: `/${locale}/service/cybersecurity`,
    },
    {
      imageSrc: "/images/Logo ITIA/service/network.jpg",
      altText: t("networkTelecom.altText"),
      title: t("networkTelecom.title"),
      description: t("networkTelecom.description"),
      link: `/${locale}/service/network-telecom`,
    },
    {
      imageSrc: "/images/Logo ITIA/service/notes.3.png",
      altText: t("consulting.altText"),
      title: t("consulting.title"),
      description: t("consulting.description"),
      link: `/${locale}/service/consulting`,
    },
    {
      imageSrc: "/images/Logo ITIA/service/analysis.png",
      altText: t("dataScience.altText"),
      title: t("dataScience.title"),
      description: t("dataScience.description"),
      link: `/${locale}/service/data-science`,
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
