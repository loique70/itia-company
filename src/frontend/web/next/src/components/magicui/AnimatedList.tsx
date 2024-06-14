"use client";

import { AnimatedList } from "@/components/magicui/animated-list";
import { cn } from "@/utils/cn";
import Link from "next/link";

interface Item {
  name: string;
  description: string;
  icon: string;
  color: string;
  link: string;
}

let notifications = [
  {
    name: "Développement Web et Mobile",
    icon: "💸",
    color: "#00C9A7",
    link: "/service/web-development",
  },
  {
    name: "Cybersécurité",
    icon: "👤",
    color: "#FFB800",
    link: "/service/cybersecurity",
  },
  {
    name: "Réseaux et Télécommunications",
    icon: "💬",
    color: "#FF3D71",
    link: "/service/network-telecom",
  },
  {
    name: "Consultation",
    icon: "🗞️",
    color: "#1E86FF",
    link: "/service/consulting",
  },
  {
    name: "Data science et IA",
    icon: "🗞️",
    color: "#1E86FF",
    link: "/service/data-science",
  },
];

notifications = Array.from({ length: 5 }, () => notifications).flat();

const Notification = ({ name, icon, color, link }: Item) => {
  return (
    <Link href={link}>
      <figure
        className={cn(
          "relative mx-auto min-h-fit w-full max-w-[400px] transform cursor-pointer overflow-hidden rounded-2xl p-4 ",

          "transition-all duration-200 ease-in-out hover:scale-[103%]",

          "bg-white [box-shadow:0_0_0_1px_rgba(0,0,0,.03),0_2px_4px_rgba(0,0,0,.05),0_12px_24px_rgba(0,0,0,.05)]",

          "transform-gpu dark:bg-transparent dark:backdrop-blur-md dark:[border:1px_solid_rgba(255,255,255,.1)] dark:[box-shadow:0_-20px_80px_-20px_#ffffff1f_inset]",
        )}
      >
        <div className="flex flex-row items-center gap-3">
          <div
            className="flex h-10 w-10 items-center justify-center rounded-2xl"
            style={{
              backgroundColor: color,
            }}
          >
            <span className="text-lg">{icon}</span>
          </div>
          <div className="flex flex-col overflow-hidden">
            <figcaption className="flex flex-row items-center whitespace-pre text-lg font-medium dark:text-white ">
              <span className="text-sm sm:text-lg">{name}</span>
              <span className="mx-1">·</span>
            </figcaption>
          </div>
        </div>
      </figure>
    </Link>
  );
};

export function AnimatedListDemo() {
  return (
    <div className="bg-background relative flex max-h-[400px] min-h-[400px] w-full max-w-[32rem] flex-col overflow-hidden rounded-lg border p-6 shadow-lg">
      <AnimatedList>
        {notifications.map((item, idx) => (
          <Notification description={""} {...item} key={idx} />
        ))}
      </AnimatedList>
    </div>
  );
}
