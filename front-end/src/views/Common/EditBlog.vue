<script setup>
import {reactive, ref} from 'vue';
import {MdEditor} from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import {useThemeStore} from "@/stores/theme.js";
import {post} from "@/net/index.js";
import {message} from 'ant-design-vue';

const [messageApi, contextHolder] = message.useMessage();

const themeStore = useThemeStore();
const blogForm = reactive({
  title: '',
  content: ''
})

const submitHandler = () => {
  post('/api/blog/addNew', {
    title: blogForm.title,
    content: blogForm.content
  }, (message) => {
    messageApi.success(message);
  }, (message) => {
    messageApi.warning(message)
  }, (message) => {
    messageApi.error(message)
  })
}
</script>

<template>
  <contextHolder/>
  <div class="w-11/12 h-screen mx-auto">
    <div>
      <span class="text-xl font-bold">标题：</span>
      <input v-model="blogForm.title" class="animatedInput w-full mt-2"/>
    </div>
    <MdEditor class="mt-2" v-model="blogForm.content" :theme="themeStore.currentTheme" :toolbarsExclude="['github']"/>
    <div class="w-full justify-center text-center mt-4">
      <button @click="submitHandler"
              class="bg-green-500  p-2 rounded-xl hover:bg-green-600 active:bg-green-700 font-bold">提交
      </button>
    </div>
  </div>
</template>

<style scoped>

</style>