import { Menu } from "@/types/menu";

const menuData: Menu[] = [
  {
    id: 1,
    title: "Accueil",
    path: "/",
    newTab: false,
  },
  {
    id: 2,
    title: "À propos de nous",
    path: "/about",
    newTab: false,
    submenu: [
      {
        id: 45,
        title: "Service Details Page",
        path: "/service-details",
        newTab: false,
      },
    ],
  },
  {
    id: 22,
    title: "Nos services",
    path: "/service",
    newTab: false,
  },
  {
    id: 3,
    title: "Nos réalisations",
    path: "/contact",
    newTab: false,
  },
  {
    id: 33,
    title: "Blog",
    path: "/blog",
    newTab: false,
  },
];
export default menuData;
