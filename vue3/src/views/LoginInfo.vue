<template>
    <div>
        <el-container>
            <el-main>
                <h1>注册/登录 页面</h1>
            </el-main>
        </el-container>

        <div class="collapse-box">
            <el-collapse accordion>
                <el-collapse-item title="未有账号？点击注册" name="1">
                    <div class="input-box">
                        <span>昵称</span><input type="text" v-model="reg_user.nickName" id="reg_nickname">
                    </div>
                    <div class="input-box">
                        <span>账号</span><input type="text" v-model="reg_user.loginName" id="reg_loginname">
                    </div>
                    <div class="input-box">
                        <span>密码</span><input type="password" v-model="reg_user.loginPwd" ud="reg_loginpwd">
                    </div>
                    <div class="input-box">
                        <span>上传头像</span><input type="file" @change="chooseImg">
                    </div>
                    <el-button tag="div" role="button" tabindex="0" @click="regUser" class="send-button">注册</el-button>
                </el-collapse-item>

                <el-collapse-item title="已有账号？点击登录" name="2">
                    <div class="input-box">
                        <span>账号</span><input type="text" v-model="login_user.loginName" id="login_loginname">
                    </div>
                    <div class="input-box">
                        <span>密码</span><input type="password" v-model="login_user.loginPwd" id="login_loginpwd">
                    </div>
                    <el-button tag="div" role="button" tabindex="0" @click="loginUser"
                        class="send-button">登录</el-button>
                </el-collapse-item>

                <el-collapse-item title="关于注册" name="3">
                    <div>
                        <b>昵称</b>：作为用户名显示，用户名可以随意更改。
                        <b>账号</b>：作为登录的账号使用，不可修改。
                        <b>密码</b>：作为登录的密码使用，可在登陆后进行修改。
                    </div>
                </el-collapse-item>
            </el-collapse>
        </div>
    </div>
</template>
<script>
import axios from '@/plugins/axios';
export default {
    data() {
        return {
            imgFile:null,
            activeName:'1',
            reg_user: { //成员传参，需要保证成员变量与后端参数保持一致
                nickName: "",
                loginName: "",
                loginPwd: ""
            },
            login_user: { // 不分开好像会有隐患
                loginName: "",
                loginPwd: ""
            }
        }
    },

    methods: {
        regUser: async function () {
            //打包符合http上传文件的数据包，准备上传混合了文件和数据的信息，不适合用json格式，因此接口要改
            var formData=new FormData();
            formData.append("imgFile",this.imgFile);
            formData.append('nickName',this.reg_user.nickName);
            formData.append('loginName',this.reg_user.loginName);
            formData.append('loginPwd',this.reg_user.loginPwd);

            var resp = await axios.post(
                    "http://localhost:11011/start/user/register",
                    formData,
                    {headers:{'Content-Type':'multipart/form-data'}}
                );
            if(resp.data.code==2000){
                var user=resp.data.data;
                alert(user.nickName+ " 注册成功!");
                this.$router.push('/loginInfo');
            }else{
                alert(resp.data.msg);
            }
        },
        loginUser: async function () {
            const resp = await axios.post(
                "http://localhost:11011/start/user/login",
                this.login_user
            );
            if(resp.data.code==2000){
                const user = resp.data.data;
                sessionStorage.setItem("user", JSON.stringify(user));
                alert(user.nickName + " 登录成功!");
                //用vuex方案，vuex缓存池作为公共资源来控制离散组件之间的相互响应，对应配置文件在store文件夹
                this.$store.commit("addUser", user);
                //this.$store.state.current_user = user; 这样的改动不会触发其他组件的响应，但是值依然可以修改（悄悄改）
                
                //从响应头获取服务器派发的jwt防篡改凭证，记录在本地存储里面
                var jwt=resp.headers.authorization;
                alert(jwt);
                sessionStorage.setItem("jwttoken", jwt);
                this.$router.push('/ai/boy')
            }
            else {
                alert(resp.data.msg);
            }
        },
        chooseImg(event){
            this.imgFile=event.target.files[0];
        }
    }
}
</script>
<style scoped>
.collapse-box{
    width:70%;
    margin: 0 auto;
}
.send-button {
    margin-top: 10px;
}
.el-collapse{
    background-color: rgba(25, 25, 255, 0.7);
}
.el-collapse-item {
    padding-left: 20px;
}

.el-collapse-item.is-active {
    background-color: rgba(213, 175, 118, 0.522);
}

.input-box>span {
    color: #E6A23C;
    font-size: 20px;
    font-weight: bold;
    font-family: '微软雅黑';
    margin-right: 7px;
}
</style>