<script setup>
import yjm from '@/assets/images/img.png'
import {ref} from "vue";
import ThemeSwitch from "@/components/ThemeSwitch.vue";

const a = ref('User Avatar')
</script>

<template>
  <div>
    <header class="basic-color fixed top-0 left-0 right-0 shadow-md z-50 dark:shadow-blue-700">
      <div class="container mx-auto px-4 py-2 flex justify-between items-center">
        <div class="flex items-center">
          <img src="https://imgs.flyinsky.xyz/file/bfce749c59dadda9e24ef.png" alt="Website Logo" class="h-8 w-auto">
        </div>
        <div class="flex items-center gap-1">
          <ThemeSwitch/>
          <img :src="yjm" :alt="a" class="h-8 w-8 rounded-full">
        </div>
      </div>
    </header>
    <main class="basic-color mt-16"> <!-- Adjust margin-top based on the height of your header -->
      <router-view/>
    </main>
  </div>
</template>

<style scoped>

</style>