<template>
    <el-menu class="el-menu-demo" mode="horizontal" v-on:select="handleSelect">
        <el-menu-item index="1">AI问答助手</el-menu-item>
        <el-menu-item index="2">AI图像生成助手</el-menu-item>
        <el-menu-item index="3">查询使用记录</el-menu-item>
        <el-menu-item index="4" style="float:right">
            <div>
                <el-avatar :src="this.$store.getters.userImg" class="avatar" />
                <span class="nickname" style="padding:2px">{{ this.$store.getters.nickName }}</span> 
            </div>
        </el-menu-item>
        <div v-if="this.$store.state.current_user!=null"> <!--检查状态，看是否需要显示登出按钮-->
            <el-menu-item index="5" style="float:right" @click="logOut">登出</el-menu-item>
        </div>
    </el-menu>
</template>

<script>
export default {
    data() {
        return {
            menuIndex: '1',
            // nickname: sessionStorage.getItem("user")?JSON.parse(sessionStorage.getItem("user")).nickName:"访客"
            //从sessionStorage中获取用户信息,需要刷新缓存才能获取到（需要当用户点击登录时，对网页缓存进行刷新操作）
            //nickname: JSON.parse(sessionStorage.getItem("user")).nickName 中的JSON.parse方法是把字符串换回对象，这样才可以进行.nickname操作
        }
    },
    // mounted() { //用定时器，每隔一段时间调用loadInfo()方法，检查一下用户信息。但是这个方法仍然有隐患(类似while循环，开销大）。（可以伪实时，解决了刷新缓存的问题）
    //     window.setInterval(this.loadInfo, 2000)
    // },
    methods: {
        // loadInfo() {
        //     let jsonString = JSON.parse(sessionStorage.getItem("user"));
        //     if (jsonString != null) {
        //         this.nickname = jsonString.nickName;
        //     }
        // },
        logOut(){
            if(window.confirm("确定要登出吗？")){
                sessionStorage.removeItem("user");
                sessionStorage.removeItem("jwttoken");
                this.$store.commit("removeUser");
            }
        },
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
            switch (key) {
                case '1':
                    this.$router.push('/ai/boy');
                    break;
                case '2':
                    this.$router.push('/ai/img');
                    break;
                case '3':
                    this.$router.push('/ai/record');
                    break;
                case '4':
                    {
                        if(this.$store.state.current_user==null){
                            this.$router.push('/loginInfo');
                        }else{//切换访问
                            this.$router.push('/loginPage');
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
</script>

<style scoped>
.el-menu-demo {
    background-color: rgba(255, 255, 255, 0.7);
}

.el-menu-demo .el-menu-item {
    font-size:17px;
    color: rgba(85, 31, 96, 0.506);
}

.el-menu-demo .el-menu-item:hover { 
    font-size: larger;
    font-weight: bold;
}

.avatar {
    vertical-align: middle;
}
</style>