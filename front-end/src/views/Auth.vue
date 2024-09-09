<script setup>

import LoginForm from "@/components/Auth/LoginForm.vue";
import RegisterForm from "@/components/Auth/RegisterForm.vue";
import {reactive} from "vue";
const options = reactive({
  isLoginComponent : true
})
</script>
<!--1.状态管理 全局变量 用户登陆的信息 主题-->
<!--组件props-->
<template>
  <div style="text-align: center" class="h-[70px]">
    <LoginForm v-model:isLoginComponent="options.isLoginComponent" v-if="options.isLoginComponent"/>
    <RegisterForm v-model:isLoginComponent="options.isLoginComponent" v-else/>
  </div>
</template>

<style scoped>

</style>