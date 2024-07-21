<template>
  <el-carousel class="el-carousel" :interval="5000" arrow="never" trigger="click">
    <el-carousel-item class="el-carousel-item" v-for="(prompt,index) in prompts" :key="index">
      <img class="crl-imgs" :src="prompt" alt="Background Images">
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default{
  data(){
    return{
      prompts:[
        require('@/assets/ContBG.jpg'),
        require('@/assets/cropped-1920-1080-1112818.jpg'),
        require('@/assets/bg3.jpg'),
        require('@/assets/bg4.png'),
        require('@/assets/bg5.png')
      ]
    };
  }
}
</script>

<style scoped>
.el-carousel{
  background-blend-mode: multiply;

}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.crl-imgs{
  height:100%;
  width:100%;
  object-fit: cover;
}
</style>