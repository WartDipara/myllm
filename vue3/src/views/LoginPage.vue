<template>
    <!--未实装-->
    <div class="body-container">
      <div class="container" :class="{ 'right-panel-active': isRightPanelActive }" id="container">
        <div class="form-container sign-up-container">
          <form @submit.prevent="regUser">
            <h1>创建账号</h1>
            <input type="text" placeholder="Nickname" v-model="reg_user.nickName" />
            <input type="text" placeholder="Name" v-model="reg_user.loginName" />
            <input type="password" placeholder="Password" v-model="reg_user.loginPwd" />
            <div class="btn-grad" @click="regUser">注册</div>
          </form>
        </div>
        <div class="form-container sign-in-container">
          <form @submit.prevent="loginUser">
            <h1>登录</h1>
            <input type="text" placeholder="LoginName" v-model="login_user.loginName" />
            <input type="password" placeholder="Password" v-model="login_user.loginPwd" />
            <div class="btn-grad" @click="loginUser">登录</div>
          </form>
        </div>
        <div class="overlay-container">
          <div class="overlay">
            <div class="overlay-panel overlay-left">
              <h1>欢迎回来!</h1>
              <p>看看有什么新变化</p>
              <div class="btn-grad" @click="showSignIn">前往登录</div>
            </div>
            <div class="overlay-panel overlay-right">
              <h1>嘿，伙计！</h1>
              <p>有没有兴趣加入我们</p>
              <div class="btn-grad" @click="showSignUp">前往注册</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from '../plugins/axios';
  
  export default {
    data() {
      return {
        reg_user: {
          nickName: "",
          loginName: "",
          loginPwd: ""
        },
        login_user: {
          loginName: "",
          loginPwd: ""
        },
        isRightPanelActive: false
      };
    },
    methods: {
        regUser: async function () {
            // try {
            //     var resp = await axios.post(
            //         "http://localhost:11011/start/user/register",
            //         this.reg_user
            //     );
            //     const user = resp.data;
            //     if (user) {
            //         alert(user.nickName + "注册成功!");
            //         this.$router.push("/loginInfo");
            //     } else {
            //         alert("注册失败!请检查注册信息");
            //     }
            // } catch (error) {
            //     console.error(error);
            //     alert("注册失败!请检查注册信息");
            // }
            var resp = await axios.post(
                    "http://localhost:11011/start/user/register",
                    this.reg_user
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
                this.$router.push('/ai/boy')
            }
            else {
                alert(resp.data.msg);
            }
        }
    }
  };
  </script>
  
<style scoped>
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Libre Franklin', sans-serif;
}

h1 {
    font-weight: bold;
    margin: 0;
    margin-bottom: 1rem;
}

p {
    font-size: 14px;
    font-weight: 100;
    line-height: 20px;
    letter-spacing: 0.5px;
    margin: 20px 0 30px;
}

span {
    font-size: 12px;
}

a {
    color: #333;
    font-size: 14px;
    text-decoration: none;
    margin: 15px 0;
}


.btn-grad {
    background-image: linear-gradient(to right, #6441A5 0%, #2a0845 51%, #6441A5 100%)
}

.btn-grad {
    margin: 10px;
    padding: 15px 45px;
    text-align: center;
    text-transform: uppercase;
    transition: 0.5s;
    background-size: 200% auto;
    color: white;
    border-radius: 10px;
    display: block;
    cursor: pointer;
}

.btn-grad:hover {
    background-position: right center;
    /* change the direction of the change here */
    color: #fff;
    text-decoration: none;
}

#signIn {
    background-image: linear-gradient(to right, #fff 0%, #f7f3f3 51%, #fff 100%);
    color: #6441A5;
}

#signUp {
    background-image: linear-gradient(to right, #fff 0%, #f7f3f3 51%, #fff 100%);
    color: #6441A5;
}

form {
    background-color: #ffffff;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 50px;
    height: 100%;
    text-align: center;
}

input {
    background-color: #eee;
    border: none;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}

/*  */
.body-container {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: #4568DC;
    /* fallback for old browsers */
    background: -webkit-linear-gradient(to right, #B06AB3, #4568DC);
    /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(to right, #B06AB3, #4568DC);
    /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}

.container {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.25), 0 5px 5px rgba(0, 0, 0, 0.22);
    position: relative;
    overflow: hidden;
    width: 768px;
    max-width: 100%;
    min-height: 480px;
}

/*  */


.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all 0.6s ease-in-out;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}

.sign-up-container {
    left: 0;
    width: 50%;
    opacity: 0;
    z-index: 1;
}

.container.right-panel-active .sign-in-container {
    transform: translateX(100%);
}

.container.right-panel-active .sign-up-container {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
    animation: show 0.6s;
}

@keyframes show {

    0%,
    49.99% {
        opacity: 0;
        z-index: 1;
    }

    50%,
    100% {
        opacity: 1;
        z-index: 5;
    }
}

.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform 0.6s ease-in-out;
    z-index: 100;
}

.container.right-panel-active .overlay-container {
    transform: translateX(-100%);
}

.overlay {
    background: #6441A5;
    background: -webkit-linear-gradient(to right, #6441A5, #2a0845);
    background: linear-gradient(to right, #6441A5, #2a0845);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: 0 0;
    color: #ffffff;
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
    transform: translateX(50%);
}

.overlay-panel {
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 40px;
    text-align: center;
    top: 0;
    height: 100%;
    width: 50%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.overlay-left {
    transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
    transform: translateX(0);
}

.overlay-right {
    right: 0;
    transform: translateX(0);
}

.container.right-panel-active .overlay-right {
    transform: translateX(20%);
}
</style>