import Vue from 'vue'
import Router from 'vue-router'

// 用户相关
// 登录
import login from '@/components/user/login'
// 注册
import register from '@/components/user/register'
// 用户列表
import user from '@/components/user/user'

// 首页
import home from '@/components/home/home'

// 监测
import monitor from '@/components/monitor/monitor'

// 我的
import mine from '@/components/mine/mine'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      component: login
    }, {
      path: '/login',
      name: '登录',
      component: login
    }, {
      path: '/register',
      name: '注册',
      component: register
    }, {
      path: '/home',// 登陆后默认进入的界面
      name: '首页',
      component: home
    }, {
      path: '/monitor',
      name: '监测',
      component: monitor
    }, {
      path: '/user',
      name: '用户',
      component: user
    }, {
      path: '/mine',
      name: '我的',
      component: mine
    }
  ]
})
