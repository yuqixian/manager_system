<template>

  <div class="login_container">
    <img src="../../assets/images/user/login.png" />
    <div>
      <mt-field placeholder="请输入用户名" v-model="username" >
        <img src="../../assets/images/user/account.png" />
      </mt-field>
      <mt-field placeholder="请输入密码" type="password" v-model="password" >
        <img src="../../assets/images/user/password.png" />
      </mt-field>
      <mt-checklist
        v-model="isCookie"
        :options="['记住密码']">
      </mt-checklist>
    </div>
    <div class="button_container">
      <mt-button type="primary" size="large" @click="login()">登录</mt-button>
    </div>
    <a class="to_register" @click="toRegister()" >没有账号？点击注册</a>
  </div>

</template>
<script>

// 引入js文件中暴露出来的对象
import {post} from "@/assets/js/request.js";
import { Toast } from 'mint-ui';

export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: '',
      isCookie: [false]
    }
  },
  methods: {
    login() {// 登录方法

      var _that = this;

      post("/user/login", {
        username: this.username,
        password: this.password
      }).then(res => {
				var flag = res.flag;
        if(flag == 1) {
          Toast({
            message: '登录成功！',
            position: 'top',
            duration: 3000
          });
          _that.toIndex();
        } else {
          Toast({
            message: '用户名或密码错误，请重新输入！',
            position: 'top',
            duration: 3000
          });
        }
      }).catch(err => {
        console.log(err)
      })
    },
    toRegister() {// 跳转登录界面
      this.$router.push('/register');
    },
    toIndex() {// 进入首页
      this.$router.push('/home'); 
    }
  }
}
</script>

<style>

  .login_container {
    background-image: url("../../assets/images/user/login_bg.png");
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
  }

  .login_container .mint-cell {
    background-color: transparent;
  }

  .login_container .mint-cell-text {
    color: #fff;
  }

  .login_container .mint-field-other {
    width: 100%;
    height: 100%;
    position: absolute;
  }

  .login_container .mint-field-other img {
    position: absolute;
    left: 15px;
    top: 50%;
    transform: translate(0,-50%);
  }

  .login_container input[type="text"], .login_container input[type="password"] {
    border-bottom: solid 1px #D3D3D3;
    text-indent: 40px;
    background-color: transparent;
    line-height: 2.5;
    z-index: 9999;
    color: #D3D3D3;
  }

  .login_container .mint-checklist-label {
    text-align: left;
  }

  .login_container .mint-field .mint-cell-value {
    color: #fff;
  }

  .login_container .mint-field-clear {
    opacity: .8;
  }

  .button_container {
    padding: 0 10px;
    margin-top: 30px;
  }

  .to_register {
    font-size: 12px;
    text-decoration: underline;
    float: right;
    margin-right: 10px;
    margin-top: 5px;
    color: #D3D3D3;
  }

  .login_container .mint-checkbox-label {
    color: #D3D3D3;
  }

</style>
