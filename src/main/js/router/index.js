import Vue from 'vue';
import VueRouter from 'vue-router';

import Basic from '@/views/Basic.vue';
import Editor from '@/views/Editor.vue';
import Home from '@/views/Home.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    component: Home,
  },
  {
    path: '/basic',
    component: Basic,
  },
  {
    path: '/editor',
    component: Editor,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
