<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="数据编号" width="180" />
        <el-table-column prop="userNickname" label="用户编号" width="180" />
        <el-table-column prop="token" label="消耗的Token" width="180" />
        <el-table-column prop="pay" label="支付积分" />
        <el-table-column prop="question" label="问题" />
        <el-table-column prop="response" label="回复" />
        <el-table-column prop="oprtime" label="消费时间" />
    </el-table>
</template>

<script setup>
import axios from '../plugins/axios'
import {onMounted,ref} from 'vue'
//组合式写法
const tableData = ref([]);
onMounted(function(){
    var cur = JSON.parse(sessionStorage.getItem("user"));
        axios.get("http://localhost:11011/start/record/list")
        .then((resp) => {
            if (resp.data.code == 2000) {
                this.tableData.value = resp.data.data;
            }else{
                alert(resp.data.msg);
            }
        })
});
</script>