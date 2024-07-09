// app/[locale]/about/page.tsx
import AboutSectionOne from "@/components/About/AboutSectionOne";
import AboutSectionTwo from "@/components/About/AboutSectionTwo";
import Breadcrumb from "@/components/Common/Breadcrumb";
import Testimonials from "@/components/Testimonials";
import { useTranslations } from "next-intl";

const AboutPage = () => {
  const t = useTranslations("Navigation");
  return (
    <>
      <Breadcrumb pageName={t("about")} image="/images/Logo ITIA/about.jpg" />
      <AboutSectionOne />
      <AboutSectionTwo />
      <Testimonials />
    </>
  );
};

export default AboutPage;
