import { createRouter, createWebHashHistory } from 'vue-router'
import indexPhoto from '../views/indexPhoto.vue'
import indexCategory from '../views/indexCategory.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: indexPhoto
  },
  {
    path: '/foto',
    name: 'foto',
    component: indexPhoto
  },
  {
    path: '/categories',
    name: 'categorie',
    component: indexCategory
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
