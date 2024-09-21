<script setup>
import {onMounted, reactive} from "vue";
import {get} from "@/net/index.js";

const options = reactive({
  blogs: []
})
const initData = () => {
  get('/api/blog/getInroduce', {}, (message, data) => {
    options.blogs = data
  })
}
onMounted(() => {
  initData()
})
</script>
<template>
  <div class="flex">
    <div class="mx-auto hover:bg-[#fafafa] text-black rounded-xl p-4" v-for="blog in options.blogs">
      <h1>{{ blog.blog.title }}</h1>
      <h2>{{ blog.blog.content }}</h2>
      <h3>{{ blog.username }}</h3>
    </div>
  </div>
</template>

<style scoped>

</style>