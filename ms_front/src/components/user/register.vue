<template>

  <div class="register_container">
    <div class="register_top">欢迎注册</div>
    <div class="register_info">
      <mt-field placeholder="请输入用户名" v-model="username" >
        <img src="../../assets/images/user/account.png" />
      </mt-field>
      <mt-field placeholder="请输入密码" type="password" v-model="password" >
        <img src="../../assets/images/user/password.png" />
      </mt-field>
      <mt-field placeholder="请输入邮箱" v-model="email" >
        <img src="../../assets/images/user/email.png" />
      </mt-field>
      <mt-field placeholder="请输入手机号码" v-model="telephone" >
        <img src="../../assets/images/user/telephone.png" />
      </mt-field>
    </div>
    <div class="button_container">
      <mt-button type="primary" size="large" @click="register()">注册</mt-button>
    </div>
    <a class="to_login" @click="toLogin()" >已有账号？直接登录</a>
  </div>

</template>
<script>

// 引入js文件中暴露出来的对象
import {post} from "@/assets/js/request.js";
import { Toast } from 'mint-ui';

export default {
  name: 'register',
  data () {
    return {
      username: '',// 用户名
      password: '',// 密码
      email: '', // 邮箱
      telephone: ''// 手机号
    }
  },
  methods: {

    toLogin() {// 进入登录界面
      this.$router.push('/login'); 
    },

    register() {// 注册
      var _that = this;
      post("/user/register", {
        username: this.username,
        password: this.password,
        email: this.email,
        telephone: this.telephone,
      }).then(res => {
        var flag = res.flag;
        if(flag == 1) {
          Toast({
            message: '注册成功，请登录！',
            position: 'top',
            duration: 3000
          });
          _that.toLogin();
        } else {
          Toast({
            message: '用户名已存在，请重新输入！',
            position: 'top',
            duration: 3000
          });
        }
      }).catch(err => {
        console.log(err)
      })
    }

  }
}
</script>
<style>

  .register_container {
    background: #D3D3D3;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
  }

  .register_top {
    width: 100%;
    height: 80px;
    line-height: 80px;
    color: #fff;
    font-size: 18px;
    background-color: green;
    font-weight: bold;
  }

  .register_info {
    margin-top: 50px;
  }

  .register_container .mint-cell {
    background-color: transparent;
  }

  .register_container .mint-cell-text {
    color: #fff;
  }

  .register_container .mint-field-other {
    width: 100%;
    height: 100%;
    position: absolute;
  }

  .register_container .mint-field-other img {
    position: absolute;
    left: 15px;
    top: 50%;
    transform: translate(0,-50%);
  }

  .register_container input[type="text"], .register_container input[type="password"] {
    border-bottom: solid 1px #fff;
    text-indent: 40px;
    background-color: transparent;
    line-height: 2.5;
    z-index: 9999;
  }

  .button_container {
    padding: 0 10px;
    margin-top: 30px;
  }

  .to_login {
    font-size: 12px;
    text-decoration: underline;
    float: right;
    margin-right: 10px;
    margin-top: 5px;
    color: gray;
  }

</style>
