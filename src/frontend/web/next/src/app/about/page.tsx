import AboutSectionOne from "@/components/About/AboutSectionOne";
import AboutSectionTwo from "@/components/About/AboutSectionTwo";
import Breadcrumb from "@/components/Common/Breadcrumb";
import Testimonials from "@/components/Testimonials";

const AboutPage = () => {
  return (
    <>
      <Breadcrumb
        pageName="À propos de nous"
        image="/images/Logo ITIA/about.jpg"
      />
      <AboutSectionOne />
      <AboutSectionTwo />
      <Testimonials />
    </>
  );
};

export default AboutPage;
