import Vue from 'vue'
import Router from 'vue-router'
import Layout from '../Layout'
import axios from 'axios'

/* eslint-disable */
Vue.use(Router)

export default new Router({
  mode: 'history', // Use browser history
  routes: [
    {
      path: '/loginZwei',
      name: 'Login',
      component: () => import ('../components/Login'),
    },{
      path: '/login',
      name: 'LoginZwei',
      component: () => import ('../components/LoginZwei'),
    },
    {
      path: '/',
      component: Layout,
      // redirect: '/home',
      children: [{
        path: '/zusage',
        name: 'Zusage',
        component: () => import('../components/Zusage')
      },
        {
          path: '/zusage2',
          name: 'Zusage2',
          component: () => import('../components/Zusage2')
        },
        {
          path: '/zusage3',
          name: 'Zusage3',
          component: () => import('../components/Zusage3')
        },
        {
          path: '/teilnehmer',
          name: 'Teilnehmer',
          component: () => import('../components/Teilnehmer')
        },
        {
          path: '/home',
          name: 'Home',
          component: () => import('../components/Home')
        },
        {
          path: '/details',
          name: 'Details',
          component: () => import('../components/Details')
        },
        {
          path: '/feier',
          name: 'Feier',
          component: () => import('../components/Feier')
        },
        {
          path: '/',
          redirect: '/home'
        }],
      beforeEnter (to, from, next) {
        axios.post('/api/user/isLoggedIn').then(() => {
          // Benutzer ist angemeldet
          next()
        }, () => {
          // Benutzer ist nicht angemeldet
          next({
            path: '/login',
            query: {
              'redirectRoute': to.fullPath
            }
          })
        })
      },
    },

  ]
})

