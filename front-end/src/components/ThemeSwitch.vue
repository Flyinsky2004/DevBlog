<script setup>
import {useThemeStore} from "@/stores/theme.js";
import router from "@/router/index.js";
import {ElMessage} from "element-plus";
import {useUserStore} from "@/stores/userStore.js";

const userStore = useUserStore()
const themeStore = useThemeStore()
const toggleThemeHandler = () => {
  themeStore.toggleTheme()
}
</script>

<template>
  <button class="bg-blue-600 rounded-xl p-2" @click="toggleThemeHandler()">
    <svg v-if="themeStore.currentTheme === 'light'" xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
         viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-4 text-white">
      <path stroke-linecap="round" stroke-linejoin="round"
            d="M21.752 15.002A9.72 9.72 0 0 1 18 15.75c-5.385 0-9.75-4.365-9.75-9.75 0-1.33.266-2.597.748-3.752A9.753 9.753 0 0 0 3 11.25C3 16.635 7.365 21 12.75 21a9.753 9.753 0 0 0 9.002-5.998Z"/>
    </svg>
    <svg v-else xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF" viewBox="0 0 24 24" stroke-width="1.5"
         stroke="currentColor" class="size-4">
      <path stroke-linecap="round" stroke-linejoin="round"
            d="M12 3v2.25m6.364.386-1.591 1.591M21 12h-2.25m-.386 6.364-1.591-1.591M12 18.75V21m-4.773-4.227-1.591 1.591M5.25 12H3m4.227-4.773L5.636 5.636M15.75 12a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z"/>
    </svg>
  </button>
  <div class="relative flex flex-nowrap bg-blue-600 rounded-xl p-2 cursor-pointer"
       @click="router.push('/notification')">
    <svg v-if="themeStore.currentTheme === 'light'" xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
         viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-4 text-white">
      <path stroke-linecap="round" stroke-linejoin="round"
            d="M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0M3.124 7.5A8.969 8.969 0 0 1 5.292 3m13.416 0a8.969 8.969 0 0 1 2.168 4.5"/>
    </svg>
    <svg v-else xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF" viewBox="0 0 24 24" stroke-width="1.5"
         stroke="currentColor" class="size-4">
      <path stroke-linecap="round" stroke-linejoin="round"
            d="M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0M3.124 7.5A8.969 8.969 0 0 1 5.292 3m13.416 0a8.969 8.969 0 0 1 2.168 4.5"/>
    </svg>
    <div v-if="userStore.user.unReadNotiCnt !== 0"
         class="absolute -top-1 -right-1 p-1 h-2 w-2 rounded-full bg-red-600"></div>
  </div>
  <button @click="router.push('/new')"
          class="bg-[#e96140] text-white flex flex-nowrap p-2 rounded-xl hover:bg-[#e73b4c] active:bg-[#DC143C]">
    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
         class="size-5">
      <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v6m3-3H9m12 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"/>
    </svg>
    <span class="font-bold">发布</span>
  </button>
</template>

<style scoped>

</style>