import Breadcrumb from "@/components/Common/Breadcrumb";
import Service from "@/components/Services/Service";

const ServicePage = () => {
  return (
    <>
      <Breadcrumb
        pageName="Les services que nous offrons"
        image="/images/Logo ITIA/about.jpg"
      />
      <Service />
    </>
  );
};

export default ServicePage;
