import { createStore } from 'vuex'

export default createStore({
  state: { //初始化
    current_user: sessionStorage.getItem("user")?JSON.parse(sessionStorage.getItem("user")):null
  },
  getters: {
    //计算属性，封装在前台的this.$store.state.current_user?this.$store.state.current_user.nickName:"访客" 
    nickName:function(state){
      return state.current_user?state.current_user.nickName:"访客"
    },
    userImg:function(state){
      return (state.current_user==null || state.current_user.img==" " || state.current_user.img==null)?
      "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
      :"http://localhost:11011/start/images/user/"+state.current_user.img
    }
  },
  mutations: {
    /**
     * 添加用户信息到当前状态
     * 
     * 此函数用于更新状态中的当前用户信息。它接受两个参数：
     * - state: 一个包含应用程序当前状态的对象。在这个函数中，我们将会修改这个对象的current_user属性。
     * - user: 一个对象，代表要添加或更新的用户信息。这个对象应该包含用户的相关属性，比如用户名、用户ID等。
     * 
     * 这个函数不返回任何值，它的作用是直接修改传入的state对象。
     * 使用这个函数可以动态地更新应用程序的状态，以反映当前操作的用户信息。
     * stare参数必须作为第一个参数传入，但是不需要手动管理。
     */
    addUser(state, user) {
      state.current_user = user
    },
    /**
   * 移除当前用户信息
   * 
   * 该函数用于将状态对象中的当前用户设置为null，从而实现当前用户信息的移除。
   * 这可能是为了登录状态的注销或者为了在切换用户之前清空当前用户的信息。
   * 
   * @param {Object} state - Vuex的状态对象。这个对象包含了应用中所有状态的副本。
   *                        在这个函数中，我们直接修改了current_user属性，将其设为null。
   */
    removeUser(state) {
      state.current_user = null
    }
  },
  actions: {
  },
  modules: {
  }
})
