<script setup>
import {reactive, ref} from "vue";
import { message } from 'ant-design-vue';
import {post} from "@/net/index.js";
import router from "@/router/index.js";

const [messageApi, contextHolder] = message.useMessage();
const props = defineProps(['isLoginComponent'])
const emits = defineEmits(["update:isLoginComponent"]);
const goAnotherForm = () => {
  emits('update:isLoginComponent',false)
}
const a = ref('123')
const loginForm = reactive({
  username: '',
  password: ''
})

const loginHandler = () => {
  post('/api/auth/login', {
    username: loginForm.username,
    password: loginForm.password
  },(message,data) => {
    messageApi.success(message + '3s后为您转到首页')
    localStorage.setItem("authToken", data);
    setTimeout(()=>{
      router.push('/')
    },3000)
  },(message,data) => {
    messageApi.warning(message)
  },(message,data) => {
    messageApi.error("发生错误，请联系管理员")
  })
}
</script>
<script>

</script>
<template>
  <contextHolder/>
  <div class="flex justify-center items-center h-screen bg-gray-100">
    <div class="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-center">Login</h2>
      <div class="space-y-6">
        <div>
          <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
          <input type="text" id="username" v-model="loginForm.username" required class="w-full px-3 py-2 mt-1 border rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div>
          <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
          <input type="password" id="password" v-model="loginForm.password" required class="w-full px-3 py-2 mt-1 border rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div>
          <button @dblclick="loginHandler()" class="w-full px-4 py-2 text-white bg-indigo-600 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
            Login
          </button>
          <a class="select-none">还没有账号？</a><a @click="goAnotherForm" class="text-gray-700 hover:text-blue-500 hover:underline cursor-pointer">注册一个</a>
        </div>
      </div>
    </div>
  </div>
</template>



<style scoped>
/* 你可以在这里添加额外的样式 */
</style>