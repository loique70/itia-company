"use client";
import { useLocale, useTranslations } from "next-intl";
import { useRouter } from "next/navigation";
import React, { ChangeEvent, useTransition } from "react";

const locales = [
  { value: "en", label: "English" },
  { value: "fr", label: "Français" },
];

const LocaleSwitcher = () => {
  const t = useTranslations("Locale");
  const [isPending, startTransition] = useTransition();
  const router = useRouter();
  const localeActive = useLocale();

  const onSelectChange = (e: ChangeEvent<HTMLSelectElement>) => {
    const nextLocale = e.target.value;
    startTransition(() => {
      router.replace(`/${nextLocale}`);
    });
  };

  return (
    <div>
      <label className="rounded border-2">
        <p className="sr-only">{t("change")}</p>
        <select
          defaultValue={localeActive}
          className="bg-transparent py-2"
          onChange={onSelectChange}
          disabled={isPending}
        >
          {locales.map(({ value, label }) => (
            <option key={value} value={value}>
              {t(value)}
            </option>
          ))}
        </select>
      </label>
    </div>
  );
};

export default LocaleSwitcher;
