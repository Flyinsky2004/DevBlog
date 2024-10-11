<script setup>
import {computed, onBeforeMount, onMounted, reactive, ref} from 'vue';
import {MdPreview, MdCatalog} from 'md-editor-v3';
import 'md-editor-v3/lib/preview.css';
import {useThemeStore} from "@/stores/theme.js";
import {useRoute} from "vue-router";
import {get, post} from "@/net/index.js";
import {message} from "ant-design-vue";

const [messageApi, contextHolder] = message.useMessage();

import {formatDate} from "@/util/DateFormattor.js";

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

const likeHandler = () => {
  if (options.data.isLiked) {
    post('/api/blog/unlike', {
      id: pid
    }, (message) => {
      options.data.blog.likes--
      options.data.isLiked = false
      messageApi.warning(message);
    }, (message) => {
      messageApi.warning(message)
    })
  } else {
    post('/api/blog/like', {
      id: pid
    }, (message) => {
      options.data.blog.likes++
      options.data.isLiked = true
      messageApi.success(message);
    }, (message) => {
      messageApi.warning(message)
    })
  }

}
</script>

<template>
  <contextHolder/>
  <div class="flex h-screen">
    <aside class="w-2/12 text-white">
      <div class="p-5">
        <h2 class="font-bold basic-color">Sidebar</h2>
        <MdCatalog class="basic-color" :editorId="id" :scrollElement="scrollElement"/>

      </div>
    </aside>
    <main class="w-full grid grid-cols-[5fr,1fr]">
      <div class="p-1">
        <h1 class="font-bold basic-color text-3xl">{{ options.data.blog.title }}</h1>
        <span class="text-md select-none"
              :class="options.data.blog.isPublic === 0 ? 'text-green-400' : 'text-red-400'">查看权限：{{
            options.data.blog.isPublic === 0 ? '公开' : '私密'
          }}</span>
        <div class="flex flex-nowrap select-none mt-2">
          <h1 class="basic-color text-md hover:underline hover:text-blue-500 cursor-pointer">
            {{ options.data.username }}
          </h1>
          <h1 class="basic-color text-md ml-2">
            最后修改日期:{{ formatDate(options.data.blog.updateDate) }}
          </h1>
        </div>
        <div class="flex flex-nowrap">
          <div class="flex flex-nowrap ml-2 clickEffect1 cursor-pointer p-2 rounded-xl" @click="likeHandler()">
            <svg xmlns="http://www.w3.org/2000/svg" :fill="options.data.isLiked ? '#ea333d' : 'none'"
                 viewBox="0 0 24 24" stroke-width="1.5"
                 stroke="currentColor" class="size-5">
              <path stroke-linecap="round" stroke-linejoin="round"
                    d="M6.633 10.25c.806 0 1.533-.446 2.031-1.08a9.041 9.041 0 0 1 2.861-2.4c.723-.384 1.35-.956 1.653-1.715a4.498 4.498 0 0 0 .322-1.672V2.75a.75.75 0 0 1 .75-.75 2.25 2.25 0 0 1 2.25 2.25c0 1.152-.26 2.243-.723 3.218-.266.558.107 1.282.725 1.282m0 0h3.126c1.026 0 1.945.694 2.054 1.715.045.422.068.85.068 1.285a11.95 11.95 0 0 1-2.649 7.521c-.388.482-.987.729-1.605.729H13.48c-.483 0-.964-.078-1.423-.23l-3.114-1.04a4.501 4.501 0 0 0-1.423-.23H5.904m10.598-9.75H14.25M5.904 18.5c.083.205.173.405.27.602.197.4-.078.898-.523.898h-.908c-.889 0-1.713-.518-1.972-1.368a12 12 0 0 1-.521-3.507c0-1.553.295-3.036.831-4.398C3.387 9.953 4.167 9.5 5 9.5h1.053c.472 0 .745.556.5.96a8.958 8.958 0 0 0-1.302 4.665c0 1.194.232 2.333.654 3.375Z"/>
            </svg>
            {{ options.data.blog.likes }}
          </div>

          <div class="flex flex-nowrap ml-2 p-2 select-none">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                 stroke="currentColor" class="size-5">
              <path stroke-linecap="round" stroke-linejoin="round"
                    d="M2.036 12.322a1.012 1.012 0 0 1 0-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178Z"/>
              <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"/>
            </svg>
            {{ options.data.blog.watches }}
          </div>

          <div class="flex flex-nowrap ml-2 p-2">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                 stroke="currentColor" class="size-5">
              <path stroke-linecap="round" stroke-linejoin="round"
                    d="M11.48 3.499a.562.562 0 0 1 1.04 0l2.125 5.111a.563.563 0 0 0 .475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 0 0-.182.557l1.285 5.385a.562.562 0 0 1-.84.61l-4.725-2.885a.562.562 0 0 0-.586 0L6.982 20.54a.562.562 0 0 1-.84-.61l1.285-5.386a.562.562 0 0 0-.182-.557l-4.204-3.602a.562.562 0 0 1 .321-.988l5.518-.442a.563.563 0 0 0 .475-.345L11.48 3.5Z"/>
            </svg>
            {{ options.data.blog.favourites }}
          </div>
        </div>
        <MdPreview :theme="themeStore.currentTheme" :editorId="id" :modelValue="options.data.blog.content"/>
      </div>
      <div>

      </div>
    </main>
  </div>
</template>

<style scoped>

</style>