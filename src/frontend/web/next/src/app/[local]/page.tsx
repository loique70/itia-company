import AboutSectionOne from "@/components/About/AboutSectionOne";
import AboutSectionTwo from "@/components/About/AboutSectionTwo";
import Blog from "@/components/Blog";
import Brands from "@/components/Brands";
import ScrollUp from "@/components/Common/ScrollUp";
import Contact from "@/components/Contact";
import Hero from "@/components/Hero";
import Pricing from "@/components/Pricing";
import Testimonials from "@/components/Testimonials";

export default function Home() {
  return (
    <>
      <ScrollUp />
      <Hero />
      <Brands />
      <AboutSectionOne />
      <AboutSectionTwo />
      <Pricing />
      <Testimonials />
      <Contact />
      <Blog />
    </>
  );
}
