// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import $ from './assets/js/jquery-3.4.1.min'

// 引入min-ui，需要在项目下执行npm install mint-ui -S安装
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'
Vue.use(Mint)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
