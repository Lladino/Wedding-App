// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import VueResource from 'vue-resource'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import router from './router'
import '@mdi/font/css/materialdesignicons.css'

Vue.use(BootstrapVue)

Vue.config.productionTip = false
Vue.use(VueResource)

Vue.use(Vuetify)

const vuetify = new Vuetify({
  icons: {
    iconfont: 'mdi'
  }, theme: {
    dark: false
  }
})

new Vue({
  router,
  vuetify,
  render: h => h(App),
}).$mount('#app')
