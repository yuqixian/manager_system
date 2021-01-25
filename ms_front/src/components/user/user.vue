<template>
  <div class="user_container">
    <div class="user_container_title">
      用户管理
    </div>
    <div class="user_container_search">
      <input type="text" placeholder="请输入要查询的用户" v-model="username" />
      <input type="button" value="搜索" @click="queryUsers()" />
    </div>
    <div class="user_container_main">
      <table border='1px' borderColor='#D3D3D3' cellspacing='0' cellpadding='5'>
        <tr>
          <td>序号</td>
          <td>名称</td>
          <td>等级</td>
          <td>操作</td>
        </tr>
        <tr v-if="userList.length > 0"  v-for="(item,index) in userList" :key="index">
          <td>{{ index }}</td>
          <td>{{ item.username }}</td>
          <!-- 管理员判断 -->
          <td v-if="item.level == 0">
            普通用户
          </td>
          <td v-if="item.level == 1">
            管理员
          </td>
          <td>
            <img src="../../assets/images/operation/edit.png" />
            <img src="../../assets/images/operation/delete.png" />
          </td>
        </tr>
      </table>
    </div>

    <foot></foot>
  </div>
</template>
<script>

  import foot from '../foot.vue'
  // 引入js文件中暴露出来的对象
  import {post} from "@/assets/js/request.js";

  export default {
    components: {
      'foot':foot,
    },
    data () {
      return {
        username: "",// 查询的条件
        userList: [],// 查询的所有用户
      }
    },
    mounted() {
      this.queryUsers();
    },
    methods: {// 声明方法
      queryUsers() {
      var _that = this;

      post("/user/queryUsers", {
        username: this.username,
      }).then(res => {
				_that.userList = res.list;
      }).catch(err => {
        console.log(err)
      })
      }
    }
  }
</script>
<style>
  .user_container_title {
    background: #2b2b2b;
    color: #fff;
    font-size: 14px;
    width: 100%;
    height: 40px;
    line-height: 40px;
  }
  .user_container_search {
    text-align: left;
    margin-top: 5px;
    padding: 0 5px;
    display: flex;
  }
  .user_container_search input[type="text"] {
    font-size: 14px;
    border: solid 1px #D3D3D3;
    height: 30px;
    border-radius: 5px 0 0 5px;
    text-indent: 5px;
    flex: 1;
    margin-right: 5px;
  }
  .user_container_search input[type="button"] {
    font-size: 14px;
    border: solid 1px #D3D3D3;
    height: 30px;
    padding: 0 5px;
    border-radius: 0 5px 5px 0;
  }

  .user_container_main {
    padding: 0 5px;
    margin-top: 5px;
    position: absolute;
    top: 80px;
    bottom: 60px;
    left: 0px;
    right: 0px;
    overflow-y: auto;
  }
  .user_container_main table {
    width: 100%;
  }
  .user_container_main table tr td {
    height: 30px;
    font-size: 12px;
    padding: 0 5px;
    border-collapse: border-collapse;
  }
</style>