import Image from "next/image";
import { useTranslations } from "next-intl";

const AboutSectionTwo = () => {
  const t = useTranslations("AboutUs");
  const h = useTranslations("Hero");

  return (
    <section className="py-16 md:py-20 lg:py-28">
      <div className="container">
        <div className="-mx-4 flex flex-wrap items-center">
          <div className="w-full px-4 lg:w-1/2">
            <div
              className="relative mx-auto mb-12 aspect-[25/24] max-w-[500px] text-center lg:m-0"
              data-wow-delay=".15s"
            >
              <Image
                src="/images/about/ab3.png"
                alt="about image"
                fill
                className="drop-shadow-three dark:hidden dark:drop-shadow-none"
              />
              <Image
                src="/images/about/ab5.jpeg"
                alt="about image"
                fill
                className="hidden drop-shadow-three dark:block dark:drop-shadow-none"
              />
            </div>
          </div>
          <div className="w-full px-4 lg:w-1/2">
            <div className="max-w-[470px]">
              <div className="mb-9">
                <h3 className="mb-4 text-xl font-bold text-black dark:text-white sm:text-2xl lg:text-xl xl:text-2xl">
                  {t("bugFreeCode.title")}
                </h3>
                <p className="text-base font-medium leading-relaxed text-body-color sm:text-lg sm:leading-relaxed">
                  {t("bugFreeCode.description")}
                </p>
              </div>
              <div className="mb-9">
                <h3 className="mb-4 text-xl font-bold text-black dark:text-white sm:text-2xl lg:text-xl xl:text-2xl">
                  {t("premierSupport.title")}
                </h3>
                <p className="text-base font-medium leading-relaxed text-body-color sm:text-lg sm:leading-relaxed">
                  {t("premierSupport.description")}
                </p>
              </div>

              <div className="mt-10 grid grid-cols-2 gap-6 md:grid-cols-2 lg:grid-cols-4">
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-[#f97d7f] dark:text-white">
                    100+
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    {h("actifMember")}
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-[#fbb132] dark:text-white">
                    20+
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    {h("projectCompleted")}
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-[#8956b3] dark:text-white">
                    10+
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    {h("awardsWinner")}
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-[#7dc370] dark:text-white">
                    50+
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    {h("teamMember")}
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AboutSectionTwo;
