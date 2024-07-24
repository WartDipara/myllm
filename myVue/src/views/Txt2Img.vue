<template>
    <div>
        你想生成的图片数量:<input type="number" value="1" id="nums" v-model="nums" />
        <br>
        你想生成什么图片（输入特征）:
        <br>
        <textarea cols="50" rows="5" v-model="question"></textarea>
        <br>
        <button id="send" @click="send">发送</button>
        <hr>
        生成的图片:
        <div id="imgs">
            <img v-bind:src="url" height="250px" v-for="url in urls" v-bind:key="url" >
        </div>
    </div>
</template>

<script>
import axios from "../plugins/axios";

export default {
    data() {
        return {
            nums: 1,
            question: "",
            urls: []
        };
    },
    methods: {
        send:async function(){ //同步机制写法 关键字await，必须包含在 async内使用。await关键字会一直等到axios.post有结果返回才会接着往下走。
            var resp=await axios.post(
                "http://localhost:11011/start/llm/wanx",
                "pmt=" + this.question + "&nums=" + this.nums
            );
            if(resp.data.code==2000)
                this.urls=resp.data.data;
            else{
                alert(resp.data.msg);
            }
        }
        // send() { //异步机制写法
        //     axios.post(
        //         "http://localhost:11011/start/llm/wanx",
        //         "pmt=" + this.question + "&nums=" + this.nums
        //     )
        //         .then((response) => {
        //             // 处理返回的图片数据
        //             this.urls = response.data;
        //         })
        //         .catch((error) => {
        //             console.error(error);
        //             alert('发送错误');
        //         });
        // }
    }
};
</script>

<style></style>
