<script setup>
import {reactive, ref} from "vue";
import {ElMessage} from "element-plus";
const props = defineProps(['isLoginComponent'])
const emits = defineEmits(["update:isLoginComponent"]);
const goAnotherForm = () => {
  emits('update:isLoginComponent',true)
}
const a = ref('123')
const loginForm = reactive({
  username: '',
  password: ''
})

const loginHandler = () => {
  if(loginForm.username === '123' && loginForm.password === '456'){
    ElMessage.success('nihaoo')
  }else{
    ElMessage.warning('密码错了')
  }
}
</script>
<script>

</script>
<template>
  <div class="flex justify-center items-center h-screen bg-gray-100">
    <div class="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-center">Register</h2>
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
          <a class="select-none">已有账号？</a><a @click="goAnotherForm" class="text-gray-700 hover:text-blue-500 hover:underline cursor-pointer">马上登陆</a>
        </div>
      </div>
    </div>
  </div>
</template>



<style scoped>
/* 你可以在这里添加额外的样式 */
</style>