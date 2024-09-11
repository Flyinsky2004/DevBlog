<script setup>
import {ref} from 'vue';
import {MdEditor} from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import {useThemeStore} from "@/stores/theme.js";

const themeStore = useThemeStore();
const text = ref('# Hello Editor');
</script>

<template>
  <div class="w-11/12 h-screen mx-auto">
    <MdEditor v-model="text" :theme="themeStore.currentTheme" :toolbarsExclude="['github']"/>
  </div>
</template>

<style scoped>

</style>