import Image from "next/image";

const AboutSectionTwo = () => {
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
                  Bug Free Code
                </h3>
                <p className="text-base font-medium leading-relaxed text-body-color sm:text-lg sm:leading-relaxed">
                  Nous nous engageons à fournir des solutions exemptes de bugs,
                  garantissant ainsi une performance optimale et une fiabilité
                  accrue de vos systèmes informatiques.
                </p>
              </div>
              <div className="mb-9">
                <h3 className="mb-4 text-xl font-bold text-black dark:text-white sm:text-2xl lg:text-xl xl:text-2xl">
                  Premier Support
                </h3>
                <p className="text-base font-medium leading-relaxed text-body-color sm:text-lg sm:leading-relaxed">
                  Notre équipe de support est toujours prête à vous assister,
                  assurant une réponse rapide et des solutions efficaces à tous
                  vos problèmes informatiques.
                </p>
              </div>

              <div className="mt-10 grid grid-cols-2 gap-6 md:grid-cols-2 lg:grid-cols-4">
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-black dark:text-white">
                    +12K
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    Membres Actifs
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-black dark:text-white">
                    +1.5K
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    Projets Totals
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-black dark:text-white">
                    +14
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    Récompenses Gagnées
                  </p>
                </div>
                <div className="text-center">
                  <h2 className="text-4xl font-bold text-black dark:text-white">
                    +50
                  </h2>
                  <p className="mt-2 text-lg font-medium text-body-color">
                    Membres de l'Équipe
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
