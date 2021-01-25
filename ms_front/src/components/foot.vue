<template>
  <div class="foot">
    <ul class="foot-box">
        <li v-for="item in nav"  @click="selectNav(item.title)"> 
            <img :src="isSelect == item.title ? item.url_one : item.url" > 
            <span :class="isSelect == item.title ? 'active' : ''">{{item.title}}</span> 
        </li> 
    </ul>
  </div>
</template>

<script>
    export default {
        name: 'foot',
        data:function(){
            return {
                isSelect: '首页',
                nav: [ 
                    {title: '首页', url: require('../assets/images/nav/hPage_active.png'), url_one:require('../assets/images/nav/hPage.png')},
                    {title: '监测', url: require('../assets/images/nav/monitor.png'), url_one: require('../assets/images/nav/monitor_active.png')}, 
                    {title: '用户', url: require('../assets/images/nav/message.png'), url_one: require('../assets/images/nav/message_active.png')}, 
                    {title: '我的', url: require('../assets/images/nav/me.png'), url_one: require('../assets/images/nav/me_active.png')} 
                ] 
            }
        },
        mounted () { 
            this.isSelect = this.$route.name;
        }, 
        methods:{
            selectNav (title) { 
                if(this.isSelect != title) {// 避免重复点击
                    this.isSelect = title;
                    switch (title) { 
                        case '首页': this.$router.push('/home') 
                        break
                        case '监测': this.$router.push('/monitor') 
                        break
                        case '用户': this.$router.push('/user') 
                        break
                        case '我的': this.$router.push('/mine') 
                        break
                    } 
                }
            } 
        } 
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
*{
    margin: 0;
    padding: 0;
}
.foot {
    width: 100%;
    height: 60px;
    background: #3D5671;
    border:1px solid #000;
    box-shadow: 0px -2px 3px rgba(0,0,0,0.16);
    position: fixed;
    bottom: 0px;
    left: 0px;
}
.foot ul{
    width: 100%;
    height: 100%;
    list-style: none;
    display: flex;
    flex-direction:row ; /* 默认子元素水平靠左排列 */
    flex-wrap:nowrap;/* 默认子元素不换行 */
    margin: 0;
    padding: 0;
    margin-top: 6px;
}
.foot ul li{
    width: 100%;
    height: 100%;
    /* border: 1px solid red; */
    text-align: center;
}
.foot ul li img{
    width: 25px;
    height: 25px;
}
.foot ul li span{
    display: block;
    color: #74A7BC;
    font-size: 14px;
} 
.foot ul li .active{
    color: #04ECF0
} 
</style>
