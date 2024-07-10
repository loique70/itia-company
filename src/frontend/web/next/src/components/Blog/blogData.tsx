import { Blog } from "@/types/blog";

const getBlogData = (t: (key: string) => string): Blog[] => [
  {
    id: 1,
    title: t("bestUIComponents"),
    paragraph:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet dictum neque, laoreet dolor.",
    image: "/images/blog/blog-01.jpg",
    author: {
      name: "Samuyl Joshi",
      image: "/images/blog/author-01.png",
      designation: "Graphic Designer",
    },
    tags: [t("tags.creativity")],
    publishDate: "2025",
  },
  {
    id: 2,
    title: t("improveDesignSkills"),
    paragraph:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet dictum neque, laoreet dolor.",
    image: "/images/blog/blog-02.jpg",
    author: {
      name: "Musharof Chy",
      image: "/images/blog/author-02.png",
      designation: "Content Writer",
    },
    tags:[t("tags.computer")],
    publishDate: "2025",
  },
  {
    id: 3,
    title: t("improveCodingSpeed"),
    paragraph:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet dictum neque, laoreet dolor.",
    image: "/images/blog/blog-03.jpg",
    author: {
      name: "Lethium Deo",
      image: "/images/blog/author-03.png",
      designation: "Graphic Designer",
    },
    tags: [t("tags.design")],
    publishDate: "2025",
  },
];

export default getBlogData;
