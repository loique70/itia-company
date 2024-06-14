import Image from "next/image";
import SectionTitle from "../Common/SectionTitle";
import { AnimatedListDemo } from "../magicui/AnimatedList";

interface ServiceDetailsProps {
  title: string;
  imageLight: string;
  imageDark: string;
  detailedDescription: string;
  servicesIncluded: string[];
}

const checkIcon = (
  <svg width="16" height="13" viewBox="0 0 16 13" className="fill-current">
    <path d="M5.8535 12.6631C5.65824 12.8584 5.34166 12.8584 5.1464 12.6631L0.678505 8.1952C0.483242 7.99994 0.483242 7.68336 0.678505 7.4881L2.32921 5.83739C2.52467 5.64193 2.84166 5.64216 3.03684 5.83791L5.14622 7.95354C5.34147 8.14936 5.65859 8.14952 5.85403 7.95388L13.3797 0.420561C13.575 0.22513 13.8917 0.225051 14.087 0.420383L15.7381 2.07143C15.9333 2.26669 15.9333 2.58327 15.7381 2.77854L5.8535 12.6631Z" />
  </svg>
);

const ServiceDetails = ({
  title,
  imageLight,
  imageDark,
  detailedDescription,
  servicesIncluded,
}: ServiceDetailsProps) => {
  const List = ({ text }) => (
    <p className="mb-5 flex items-center text-lg font-medium text-body-color">
      <span className="mr-4 flex h-[30px] w-[30px] items-center justify-center rounded-md bg-primary bg-opacity-10 text-primary">
        {checkIcon}
      </span>
      {text}
    </p>
  );

  return (
    <section id="about" className="pt-16 md:pt-20 lg:pt-28">
      <div className="container">
        <div className="border-b border-body-color/[.15] pb-16 dark:border-white/[.15] md:pb-20 lg:pb-28">
          <div className="-mx-4 flex flex-wrap items-center">
            <div className="w-full px-4 md:w-1/2 lg:w-3/5">
              <div
                className="relative mx-auto mb-12 text-center md:mb-0"
                data-wow-delay=".15s"
              >
                <img
                  src={imageLight}
                  alt={title}
                  className="object-cover drop-shadow-three dark:hidden dark:drop-shadow-none md:w-full"
                />
                <img
                  src={imageDark}
                  alt={title}
                  className="hidden object-cover drop-shadow-three dark:block dark:drop-shadow-none md:w-full"
                />
              </div>

              <div className="mx-auto md:w-[90%] lg:w-[99%]">
                <h2 className="mt-4 text-lg font-semibold">{title}</h2>
                <div className="mb-6 mt-6 w-full text-lg font-normal text-body-color lg:text-left">
                  {detailedDescription}
                </div>
                <h4 className="mb-4 text-lg font-semibold">Services Inclus</h4>
                {servicesIncluded.map((service, idx) => (
                  <List text={service} key={idx} />
                ))}
              </div>
            </div>

            <div className="w-full px-4 md:w-1/2 lg:w-2/5">
              <SectionTitle
                title="Tous les services"
                paragraph="Chez ITIA Solution Consulting, nous transformons les idées en réalités."
                mb="40px"
              />

              <div
                className="mb-12 max-w-[570px] lg:mb-0"
                data-wow-delay=".15s"
              >
                <div className="mx-[-12px] flex flex-wrap">
                  <AnimatedListDemo />
                </div>
              </div>
              <div className="relative mt-6 flex max-h-[400px] min-h-[400px] w-full max-w-[32rem] flex-col overflow-hidden rounded-lg border bg-primary p-6 text-white shadow-lg">
                <div className="flex flex-col items-center gap-3">
                  <div className="flex h-[55px] w-[65px] items-center justify-center">
                    <img
                      src="/images/Logo ITIA/service/message.png"
                      alt=""
                      className="object-cover"
                    />
                  </div>
                  <div className="mb-4 text-xl">
                    <h3>
                      Vous avez des questions ou besoin d’aide ? N’hésitez pas à
                      nous contacter, notre équipe est toujours prête à vous
                      aider !
                    </h3>
                  </div>
                  <div className="mt-10">
                    <p className="text-center text-xl">Contactez nous via</p>
                    <h2 className="text-xl font-bold">
                      contact@itiasolutionsconsulting.com
                    </h2>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ServiceDetails;
