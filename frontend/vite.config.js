import { resolve } from "path";
import { defineConfig } from "vite";

import handlebars from "vite-plugin-handlebars";

const commonData = {
  appName: "ゆるWeb202210",
};

const pageData = {
  "/templates/index.html": {
    title: "ログイン",
  },
  "/templates/general/mypage.html": {
    title: "一般ユーザーマイページ",
  },
  "/templates/admin/mypage.html": {
    title: "管理者ユーザーマイページ",
  },
};

export default defineConfig({
  root: "src",
  build: {
    outDir: "../../src/main/resources/",
    assetsDir: "static",
    rollupOptions: {
      input: {
        main: resolve(__dirname, "src/templates/index.html"),
        general: resolve(__dirname, "src/templates/general/mypage.html"),
        admin: resolve(__dirname, "src/templates/admin/mypage.html"),
      },
    },
  },
  resolve: {
    alias: {
      "~bootstrap": resolve(__dirname, "node_modules/bootstrap"),
    },
  },
  server: {
    port: 1234,
    hot: true,
  },
  plugins: [
    handlebars({
      partialDirectory: resolve(__dirname, "src/components"),
      context(pagePath) {
        return Object.assign(pageData[pagePath], commonData);
      },
    }),
  ],
});
