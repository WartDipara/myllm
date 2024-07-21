import { createRouter, createWebHashHistory } from 'vue-router'
import AiBoy from '../views/AIBoy.vue'
import AiImg from '../views/Txt2Img.vue'
import LoginInfo from '../views/LoginInfo.vue'
import LoginPage from '../views/LoginPage.vue'
import AiRecord from '../views/AIRecord.vue'
const routes = [
  {
    path: '/ai/boy',
    name: 'aiboy',
    component: AiBoy,
    meta:{
      needLogin:true
    }
  },
  {
    path: '/ai/img',
    name: 'aiimg',
    component: AiImg,
    meta:{
      needLogin:true
    }
  },
  {
    path: '/loginInfo',
    name: 'loginInfo',
    component: LoginInfo
  },
  {
    path: '/loginPage',
    name: 'loginPage',
    component: LoginPage
  },
  {
    path: '/ai/record',
    name: 'aiRecord',
    component: AiRecord,
    meta:{
      needLogin:true
    }
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if(!to.meta.needLogin){
    next();
  }else if(to.meta.needLogin==true && sessionStorage.getItem("user")){
    next();
  }else{
    next('/loginInfo');
  }
});

export default router
