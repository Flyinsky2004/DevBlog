import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            name: 'auth',
            path: '/auth',
            meta: {
                title: '验证页面',
            },
            component: () => import('@/views/Auth.vue'),
        }, {
            name: 'test',
            path: '/test',
            meta: {
                title: '开发测试页面',
            },
            component: () => import('@/views/Test.vue')
        }, {
            name: 'framework',
            path: '/',
            component: () => import('@/views/Framework.vue'),
            children: [
                {
                    name: 'index',
                    path: '/',
                    component: () => import('@/views/Common/Index.vue')
                },
                {
                    name: 'editBlog',
                    path: '/new',
                    component: () => import('@/views/Common/EditBlog.vue')
                }, {
                    name: 'viewBlog',
                    path: '/view/:id',
                    component: () => import('@/views/Common/ViewBlog.vue')
                }
            ]
        }
    ]
})

router.beforeEach((to, from, next) => {
    if (to.meta.title === undefined) {
        document.title = 'DevBlog'
    } else {
        document.title = to.meta.title
    }
    next()
})
export default router
