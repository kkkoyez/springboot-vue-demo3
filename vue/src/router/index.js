import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout'
import FrontLayout from "@/layout/FrontLayout";

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/user",
    children: [
      {
        path: 'user',
        name: 'User',
        component: () => import("@/views/User"),
      },
      {
        path: 'announcement',
        name: 'Announcement',
        component: () => import("@/views/Announcement"),
      },
      {
        path: 'lost',
        name: 'Lost',
        component: () => import("@/views/Lost"),
      },
      {
        path: '/person',
        name: 'Person',
        component: () => import("@/views/Person")
      },
      {
        path: '/pick',
        name: 'Pick',
        component: () => import("@/views/Pick")
      },
      {
        path: '/recruitment',
        name: 'Recruitment',
        component: () => import("@/views/Recruitment")
      },
      {
        path: '/study',
        name: 'Study',
        component: () => import("@/views/Study")
      },

    ]
  },
  {
    path: '/',
    name: 'FrontLayout',
    component: FrontLayout,
    redirect: "/front",
    children: [
      {
        path: '/front',
        name: 'Front',
        component: () => import("@/views/Front")
      },
      {
        path: '/findLost',
        name: 'FindLost',
        component: () => import("@/views/FindLost")
      },
      {
        path: '/findPick',
        name: 'FindPick',
        component: () => import("@/views/FindPick")
      },
      {
        path: '/fRecruitment',
        name: 'FRecruitment',
        component: () => import("@/views/FRecruitment")
      },
      {
        path: '/test',
        name: 'Test',
        component: () => import("@/views/Test")
      },

    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import("@/views/Login")
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import("@/views/Register")
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
