<script setup>
import {ref} from 'vue';
import {MdPreview, MdCatalog} from 'md-editor-v3';
import 'md-editor-v3/lib/preview.css';
import {useThemeStore} from "@/stores/theme.js";

const themeStore = useThemeStore()
const id = 'preview-only';
const text = ref("# Hello Editor\n" +
    "### nihaohao\n" +
    "```language\n" +
    "#include<iostream>\n" +
    "using namespace std;\n" +
    "int main(){\n" +
    "  cout << \"Hello \" << endl ;\n" +
    "  return 0;\n" +
    "}\n" +
    "```\n" +
    "## nihao\n" +
    "1. zhehsiyi\n" +
    "2. zheshier\n" +
    "3. zheshisan\n");
const scrollElement = document.documentElement;
</script>

<template>
  <div class="flex h-screen">
    <aside class="w-2/12 text-white">
      <div class="p-5">
        <h2 class="font-bold">Sidebar</h2>
        <MdCatalog :editorId="id" :scrollElement="scrollElement"/>

      </div>
    </aside>
    <main class="flex-1">
      <div class="p-1">
        <MdPreview :theme="themeStore.currentTheme" :editorId="id" :modelValue="text"/>
      </div>
    </main>
  </div>

</template>

<style scoped>

</style>