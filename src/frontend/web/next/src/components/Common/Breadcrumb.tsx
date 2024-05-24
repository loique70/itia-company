import Link from "next/link";

const Breadcrumb = ({
  pageName,
  image,
}: {
  pageName: string;
  image: string;
}) => {
  return (
    <>
      <section className="relative z-10 h-[70vh] overflow-hidden pt-28 lg:pt-[150px] ">
        <img
          src={image}
          alt={pageName}
          className="absolute left-0 h-full w-full object-cover  dark:opacity-70"
        />
        <div className="container flex h-full items-center justify-center">
          <div className="z-20 -mx-4  flex flex-wrap items-center justify-center">
            <div className="w-full">
              <div className="mb-8">
                <h1 className="mb-5 text-3xl font-bold text-white dark:text-white md:text-[60px]">
                  {pageName}
                </h1>
              </div>
            </div>
            <div className="w-full ">
              <div className="">
                <ul className="flex justify-center">
                  <li className="">
                    <Link
                      href="/"
                      className="pr-1 font-medium text-white  hover:text-[#EF8223]"
                    >
                      Home
                    </Link>
                    <span className="text-[#EF8223]"> | </span>
                  </li>
                  <li className="text-base font-medium text-white">
                    {pageName}
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div>
          <span className="absolute left-0 top-0 z-[-1]">
            <svg
              width="287"
              height="254"
              viewBox="0 0 287 254"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                opacity="0.1"
                d="M286.5 0.5L-14.5 254.5V69.5L286.5 0.5Z"
                fill="url(#paint0_linear_111:578)"
              />
              <defs>
                <linearGradient
                  id="paint0_linear_111:578"
                  x1="-40.5"
                  y1="117"
                  x2="301.926"
                  y2="-97.1485"
                  gradientUnits="userSpaceOnUse"
                >
                  <stop stopColor="#4A6CF7" />
                  <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
                </linearGradient>
              </defs>
            </svg>
          </span>
          <span className="absolute right-0 top-0 z-[-1]">
            <svg
              width="628"
              height="258"
              viewBox="0 0 628 258"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                opacity="0.1"
                d="M669.125 257.002L345.875 31.9983L524.571 -15.8832L669.125 257.002Z"
                fill="url(#paint0_linear_0:1)"
              />
              <path
                opacity="0.1"
                d="M0.0716344 182.78L101.988 -15.0769L142.154 81.4093L0.0716344 182.78Z"
                fill="url(#paint1_linear_0:1)"
              />
              <defs>
                <linearGradient
                  id="paint0_linear_0:1"
                  x1="644"
                  y1="221"
                  x2="429.946"
                  y2="37.0429"
                  gradientUnits="userSpaceOnUse"
                >
                  <stop stopColor="#4A6CF7" />
                  <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
                </linearGradient>
                <linearGradient
                  id="paint1_linear_0:1"
                  x1="18.3648"
                  y1="166.016"
                  x2="105.377"
                  y2="32.3398"
                  gradientUnits="userSpaceOnUse"
                >
                  <stop stopColor="#4A6CF7" />
                  <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
                </linearGradient>
              </defs>
            </svg>
          </span>
        </div>
      </section>
    </>
  );
};

export default Breadcrumb;
