import Link from "next/link";
import Image from "next/image";
import "./hero.css";
import { useTranslations } from "next-intl";

const Hero = () => {
  const t = useTranslations('Hero');
  return (
    <>
      <section
        id="home"
        className="relative z-10 overflow-hidden bg-white pb-16 pt-[120px] dark:bg-gray-dark md:pb-[120px] md:pt-[150px] xl:pb-[160px] xl:pt-[180px] 2xl:pb-[200px] 2xl:pt-[210px]"
      >
        <div className="container mx-auto px-4">
          <div className="flex flex-wrap items-center">
            {/* Colonne de texte */}
            <div className="w-full px-4 md:w-1/2">
              <div className="mb-8 text-center md:mb-0 md:text-left">
                <div className="content">
                  <div className="title flex items-center dark:text-black">
                    <div className="icon mr-2 flex items-center justify-center">
                      <svg
                        width="22"
                        height="22"
                        viewBox="0 0 22 22"
                        fill="none"
                        xmlns="http://www.w3.org/2000/svg"
                      >
                        <g id="Like">
                          <g id="Group">
                            <g id="Group_2">
                              <path
                                id="Vector"
                                d="M20.1743 13.6211C20.4811 13.2786 20.668 12.8266 20.668 12.332C20.668 11.266 19.8004 10.3984 18.7344 10.3984H14.9815C15.3532 9.27051 15.5117 7.77391 15.5117 7.13238V6.48828C15.5117 5.06687 14.355 3.91016 12.9336 3.91016H12.2891C11.9934 3.91016 11.7356 4.11125 11.6639 4.39828L11.3128 5.80293C10.8208 7.77004 9.25891 9.94039 7.64242 10.3348C7.35926 9.61812 6.66016 9.10938 5.84375 9.10938H1.97656C1.62078 9.10938 1.33203 9.39813 1.33203 9.75391V21.3555C1.33203 21.7113 1.62078 22 1.97656 22H5.84375C6.61246 22 7.27762 21.5493 7.58914 20.8979L9.80375 21.6361C10.5278 21.8775 11.2823 22 12.0459 22H17.4453C18.5114 22 19.3789 21.1325 19.3789 20.0664C19.3789 19.815 19.3308 19.5744 19.2431 19.354C20.063 19.1301 20.668 18.3786 20.668 17.4883C20.668 16.9937 20.4811 16.5417 20.1743 16.1992C20.4811 15.8568 20.668 15.4047 20.668 14.9102C20.668 14.4156 20.4811 13.9636 20.1743 13.6211ZM6.48828 20.0664C6.48828 20.4218 6.1991 20.7109 5.84375 20.7109H2.62109V10.3984H5.84375C6.1991 10.3984 6.48828 10.6876 6.48828 11.043V20.0664ZM17.4453 14.2656H18.7344C19.0897 14.2656 19.3789 14.5548 19.3789 14.9102C19.3789 15.2655 19.0897 15.5547 18.7344 15.5547H17.4453C17.0895 15.5547 16.8008 15.8434 16.8008 16.1992C16.8008 16.555 17.0895 16.8438 17.4453 16.8438H18.7344C19.0897 16.8438 19.3789 17.1329 19.3789 17.4883C19.3789 17.8436 19.0897 18.1328 18.7344 18.1328H17.4453C17.0895 18.1328 16.8008 18.4216 16.8008 18.7773C16.8008 19.1331 17.0895 19.4219 17.4453 19.4219C17.8007 19.4219 18.0898 19.7111 18.0898 20.0664C18.0898 20.4218 17.8007 20.7109 17.4453 20.7109H12.0459C11.4211 20.7109 10.8036 20.6108 10.2111 20.4132L7.77734 19.6019V11.6265C8.7884 11.4344 9.77797 10.7942 10.6713 9.74617C11.5436 8.72266 12.2508 7.3657 12.5632 6.11574L12.7922 5.19922H12.9336C13.6443 5.19922 14.2227 5.77758 14.2227 6.48828V7.13238C14.2227 7.99777 13.952 9.65766 13.6056 10.3984H12.2891C11.9333 10.3984 11.6445 10.6872 11.6445 11.043C11.6445 11.3987 11.9333 11.6875 12.2891 11.6875H18.7344C19.0897 11.6875 19.3789 11.9767 19.3789 12.332C19.3789 12.6874 19.0897 12.9766 18.7344 12.9766H17.4453C17.0895 12.9766 16.8008 13.2653 16.8008 13.6211C16.8008 13.9769 17.0895 14.2656 17.4453 14.2656Z"
                                fill="white"
                              />
                            </g>
                          </g>
                          <g id="Group_3">
                            <g id="Group_4">
                              <path
                                id="Vector_2"
                                d="M4.55469 19.4219C4.91065 19.4219 5.19922 19.1333 5.19922 18.7773C5.19922 18.4214 4.91065 18.1328 4.55469 18.1328C4.19872 18.1328 3.91016 18.4214 3.91016 18.7773C3.91016 19.1333 4.19872 19.4219 4.55469 19.4219Z"
                                fill="white"
                              />
                            </g>
                          </g>
                          <g id="Group_5">
                            <g id="Group_6">
                              <path
                                id="Vector_3"
                                d="M13.5781 0C13.2222 0 12.9336 0.288578 12.9336 0.644531V1.97656C12.9336 2.33252 13.2222 2.62109 13.5781 2.62109C13.9341 2.62109 14.2227 2.33252 14.2227 1.97656V0.644531C14.2227 0.288578 13.9341 0 13.5781 0Z"
                                fill="white"
                              />
                            </g>
                          </g>
                          <g id="Group_7">
                            <g id="Group_8">
                              <path
                                id="Vector_4"
                                d="M10.8436 2.84222L9.93207 1.93073C9.6804 1.67902 9.27228 1.67902 9.02057 1.93073C8.76886 2.18244 8.76886 2.59051 9.02057 2.84222L9.93207 3.75372C10.1837 4.00539 10.5919 4.00543 10.8436 3.75372C11.0953 3.50201 11.0953 3.09393 10.8436 2.84222Z"
                                fill="white"
                              />
                            </g>
                          </g>
                          <g id="Group_9">
                            <g id="Group_10">
                              <path
                                id="Vector_5"
                                d="M18.1356 1.93073C17.8839 1.67902 17.4758 1.67902 17.2241 1.93073L16.3126 2.84218C16.0609 3.09389 16.0609 3.50197 16.3126 3.75368C16.5642 4.00539 16.9723 4.00543 17.2241 3.75372L18.1356 2.84222C18.3873 2.59051 18.3873 2.18244 18.1356 1.93073Z"
                                fill="white"
                              />
                            </g>
                          </g>
                        </g>
                      </svg>
                    </div>
                    <span>{t("title")}</span>
                  </div>
                  <div className="sub-title ">
                    <h2 className="dark:text-white">
                      {t('bestIT')}<span> {t('bestSolution')} </span> {t('bestBussiness')}
                    </h2>
                  </div>
                  <p>
                    {t('description')}
                  </p>
                  <div className="hero-btn">
                    <Link className="theme-btn" href="/about">
                      {" "}
                      {t('getStarted')}<i className="ti-arrow-right"></i>
                    </Link>
                  </div>
                </div>
              </div>
            </div>

            <div className="w-full px-4 md:w-1/2">
              <div className="relative mx-auto max-w-md lg:max-w-lg ">
                <Image
                  src="/images/about/test.png"
                  alt="Person"
                  width={500}
                  height={400}
                  className="rounded-lg object-cover drop-shadow-three dark:hidden dark:drop-shadow-none"
                />
                <Image
                  src="/images/hero/home.png"
                  alt="Person"
                  width={500}
                  height={500}
                  className="hidden rounded-lg  object-cover drop-shadow-three dark:block dark:drop-shadow-none"
                />
                <div className="bg-shape">
                  <svg
                    width="652"
                    height="668"
                    viewBox="0 0 652 668"
                    fill="none"
                  >
                    <path d="M0 367.646C0 360.448 3.86838 353.805 10.129 350.252L622.129 2.95135C635.462 -4.6148 652 5.01565 652 20.3457V648C652 659.046 643.046 668 632 668H20C8.95432 668 0 659.046 0 648V367.646Z"></path>
                  </svg>
                </div>
              </div>
            </div>
          </div>

          <section className="funfact-section mt-16">
            <div className="container">
              <div className="grid grid-cols-1 lg:grid-cols-4">
                <div className="">
                  <div className="item">
                    <h3>
                      <span>
                        <span>20</span>
                      </span>
                      +
                    </h3>
                    <h4>{t('projectCompleted')}</h4>
                  </div>
                </div>
                <div className="col col-lg-3 col-md-6 col-12">
                  <div className="item">
                    <h3>
                      <span>
                        <span>4</span>
                      </span>
                      +
                    </h3>
                    <h4>{t('industryExperience')}</h4>
                  </div>
                </div>
                <div className="col col-lg-3 col-md-6 col-12">
                  <div className="item">
                    <h3>
                      <span>
                        <span>20</span>
                      </span>
                      +
                    </h3>
                    <h4>{t('happyClients')}</h4>
                  </div>
                </div>
                <div className="col col-lg-3 col-md-6 col-12">
                  <div className="item">
                    <h3>
                      <span>
                        <span>10</span>
                      </span>
                      +
                    </h3>
                    <h4>{t('awardsWinner')}</h4>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
        <div className="absolute right-0 top-0 z-[-1] opacity-30 lg:opacity-100">
          <svg
            width="450"
            height="556"
            viewBox="0 0 450 556"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <circle
              cx="277"
              cy="63"
              r="225"
              fill="url(#paint0_linear_25:217)"
            />
            <circle
              cx="17.9997"
              cy="182"
              r="18"
              fill="url(#paint1_radial_25:217)"
            />
            <circle
              cx="76.9997"
              cy="288"
              r="34"
              fill="url(#paint2_radial_25:217)"
            />
            <circle
              cx="325.486"
              cy="302.87"
              r="180"
              transform="rotate(-37.6852 325.486 302.87)"
              fill="url(#paint3_linear_25:217)"
            />
            <circle
              opacity="0.8"
              cx="184.521"
              cy="315.521"
              r="132.862"
              transform="rotate(114.874 184.521 315.521)"
              stroke="url(#paint4_linear_25:217)"
            />
            <circle
              opacity="0.8"
              cx="356"
              cy="290"
              r="179.5"
              transform="rotate(-30 356 290)"
              stroke="url(#paint5_linear_25:217)"
            />
            <circle
              opacity="0.8"
              cx="191.659"
              cy="302.659"
              r="133.362"
              transform="rotate(133.319 191.659 302.659)"
              fill="url(#paint6_linear_25:217)"
            />
            <defs>
              <linearGradient
                id="paint0_linear_25:217"
                x1="-54.5003"
                y1="-178"
                x2="222"
                y2="288"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
              </linearGradient>
              <radialGradient
                id="paint1_radial_25:217"
                cx="0"
                cy="0"
                r="1"
                gradientUnits="userSpaceOnUse"
                gradientTransform="translate(17.9997 182) rotate(90) scale(18)"
              >
                <stop offset="0.145833" stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0.08" />
              </radialGradient>
              <radialGradient
                id="paint2_radial_25:217"
                cx="0"
                cy="0"
                r="1"
                gradientUnits="userSpaceOnUse"
                gradientTransform="translate(76.9997 288) rotate(90) scale(34)"
              >
                <stop offset="0.145833" stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0.08" />
              </radialGradient>
              <linearGradient
                id="paint3_linear_25:217"
                x1="226.775"
                y1="-66.1548"
                x2="292.157"
                y2="351.421"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
              </linearGradient>
              <linearGradient
                id="paint4_linear_25:217"
                x1="184.521"
                y1="182.159"
                x2="184.521"
                y2="448.882"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="white" stopOpacity="0" />
              </linearGradient>
              <linearGradient
                id="paint5_linear_25:217"
                x1="356"
                y1="110"
                x2="356"
                y2="470"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="white" stopOpacity="0" />
              </linearGradient>
              <linearGradient
                id="paint6_linear_25:217"
                x1="118.524"
                y1="29.2497"
                x2="166.965"
                y2="338.63"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
              </linearGradient>
            </defs>
          </svg>
        </div>
        <div className="absolute bottom-0 left-0 z-[-1] opacity-30 lg:opacity-100">
          <svg
            width="364"
            height="201"
            viewBox="0 0 364 201"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M5.88928 72.3303C33.6599 66.4798 101.397 64.9086 150.178 105.427C211.155 156.076 229.59 162.093 264.333 166.607C299.076 171.12 337.718 183.657 362.889 212.24"
              stroke="url(#paint0_linear_25:218)"
            />
            <path
              d="M-22.1107 72.3303C5.65989 66.4798 73.3965 64.9086 122.178 105.427C183.155 156.076 201.59 162.093 236.333 166.607C271.076 171.12 309.718 183.657 334.889 212.24"
              stroke="url(#paint1_linear_25:218)"
            />
            <path
              d="M-53.1107 72.3303C-25.3401 66.4798 42.3965 64.9086 91.1783 105.427C152.155 156.076 170.59 162.093 205.333 166.607C240.076 171.12 278.718 183.657 303.889 212.24"
              stroke="url(#paint2_linear_25:218)"
            />
            <path
              d="M-98.1618 65.0889C-68.1416 60.0601 4.73364 60.4882 56.0734 102.431C120.248 154.86 139.905 161.419 177.137 166.956C214.37 172.493 255.575 186.165 281.856 215.481"
              stroke="url(#paint3_linear_25:218)"
            />
            <circle
              opacity="0.8"
              cx="214.505"
              cy="60.5054"
              r="49.7205"
              transform="rotate(-13.421 214.505 60.5054)"
              stroke="url(#paint4_linear_25:218)"
            />
            <circle cx="220" cy="63" r="43" fill="url(#paint5_radial_25:218)" />
            <defs>
              <linearGradient
                id="paint0_linear_25:218"
                x1="184.389"
                y1="69.2405"
                x2="184.389"
                y2="212.24"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" />
              </linearGradient>
              <linearGradient
                id="paint1_linear_25:218"
                x1="156.389"
                y1="69.2405"
                x2="156.389"
                y2="212.24"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" />
              </linearGradient>
              <linearGradient
                id="paint2_linear_25:218"
                x1="125.389"
                y1="69.2405"
                x2="125.389"
                y2="212.24"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" />
              </linearGradient>
              <linearGradient
                id="paint3_linear_25:218"
                x1="93.8507"
                y1="67.2674"
                x2="89.9278"
                y2="210.214"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" stopOpacity="0" />
                <stop offset="1" stopColor="#4A6CF7" />
              </linearGradient>
              <linearGradient
                id="paint4_linear_25:218"
                x1="214.505"
                y1="10.2849"
                x2="212.684"
                y2="99.5816"
                gradientUnits="userSpaceOnUse"
              >
                <stop stopColor="#4A6CF7" />
                <stop offset="1" stopColor="#4A6CF7" stopOpacity="0" />
              </linearGradient>
              <radialGradient
                id="paint5_radial_25:218"
                cx="0"
                cy="0"
                r="1"
                gradientUnits="userSpaceOnUse"
                gradientTransform="translate(220 63) rotate(90) scale(43)"
              >
                <stop offset="0.145833" stopColor="white" stopOpacity="0" />
                <stop offset="1" stopColor="white" stopOpacity="0.08" />
              </radialGradient>
            </defs>
          </svg>
        </div>
      </section>
    </>
  );
};

export default Hero;
