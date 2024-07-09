import { Menu } from "@/types/menu";

const getMenuData = (t: (key: string) => string): Menu[] => [
  {
    id: 1,
    title: t("home"),
    path: "/",
    newTab: false,
  },
  {
    id: 2,
    title: t("aboutUs"),
    path: "/about",
    newTab: false,
    submenu: [
      {
        id: 45,
        title: t("serviceDetails"),
        path: "/service-details",
        newTab: false,
      },
    ],
  },
  {
    id: 22,
    title: t("ourServices"),
    path: "/service",
    newTab: false,
  },
  {
    id: 3,
    title: t("ourAchievements"),
    path: "/contact",
    newTab: false,
  },
  {
    id: 33,
    title: t("blog"),
    path: "/blog",
    newTab: false,
  },
];

export default getMenuData;
