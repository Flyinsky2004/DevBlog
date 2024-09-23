<script setup>
import {computed, onBeforeMount, onMounted, reactive, ref} from 'vue';
import {MdPreview, MdCatalog} from 'md-editor-v3';
import 'md-editor-v3/lib/preview.css';
import {useThemeStore} from "@/stores/theme.js";
import {useRoute} from "vue-router";
import {get} from "@/net/index.js";
import {message} from "ant-design-vue";

const route = useRoute()
const pid = route.params.id
const themeStore = useThemeStore()
const id = 'preview-only';
const options = reactive({
  data: {
    blog: {
      content: '123'
    }
  }
})
const fetchBlogContent = () => {
  get('/api/blog/getBlog',
      {id: pid},
      (message, data) => {
        options.data = data
        console.log(options.data.blog.content)
      })
}
onBeforeMount(() => {
  fetchBlogContent();
})

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
        <MdPreview :theme="themeStore.currentTheme" :editorId="id" :modelValue="options.data.blog.content"/>
      </div>
    </main>
  </div>
</template>

<style scoped>

</style>