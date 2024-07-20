<template>
  <div>
    <el-row>
      <el-col :span="24">
        <myheader>
          <mu/>
        </myheader>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <crl/>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <router-view/> <!--这是一套组件，包含了aiboy和aiimg等view文件夹下的组件-->
      </el-col>
    </el-row>


  </div>
</template>

<script>
import carousel from './components/carousel.vue'
import menu from './components/menu.vue'
import table from './components/table.vue'
import AiBoy from './views/AIBoy.vue';
import AiImg from './views/Txt2Img.vue'


export default {
  name: 'App',
  components: {
    mu:menu,
    crl:carousel,
    tb:table,
    aiboy:AiBoy,
    aiimg:AiImg,
  }
}
</script>

<style>
*{
  margin:0;
  padding:0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
