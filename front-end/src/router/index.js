import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: 'auth',
      path: '/auth',
      meta:{
        title: '验证页面',
      },
      component: () => import('@/views/Auth.vue'),
    }
  ]
})

router.beforeEach((to, from, next) => {
  if(to.meta.title){
    document.title = 'DevBlog'
  }else{
    document.title = to.meta.title
  }
  next()
})
export default router
