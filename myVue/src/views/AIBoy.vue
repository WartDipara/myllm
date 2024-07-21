<template>
<div class="container">
    <div class="Question_table">
        <span style="font-size: 20px;">你想问什么?</span>
        <br>
        <br>
        <textarea cols="50" rows="4" v-model="question" class="question-input"></textarea>
        <br>
        <button v-on:click="send()" class="send-button">发送</button>
        <!-- v-on 和 @一样 @是v-on简写 @click==v-on:onclick -->
    </div>

    <div class="np"></div>

    <div class="Response_table">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="date" label="Date" width="180" />
            <el-table-column prop="name" label="Name" width="180" />
            <el-table-column prop="quest" label="Quest" width="180" />
            <el-table-column prop="response" label="response" />
        </el-table>
    </div>
</div>
</template>

<script>
import axios from "../plugins/axios"

export default {
    data() {
        return {
            //临时数据存储，长久数据存储做法在java后端record表里，相关vue是Airecord
            question: "",
            answer: "",
            tableData: []
        }
    },

    methods: {
        send: function send() {
            var temp = JSON.parse(sessionStorage.getItem("user"));
            axios.post(//这里的this指向vue主体
                    "http://localhost:11011/start/llm/qianwen", "pmt=" + this.question)
                .then((resp) => {
                    if (resp.data.code == 2000) {
                        this.answer = resp.data.data;
                        this.tableData.push({
                            date: new Date().toLocaleString(),
                            name: this.$store.getters.nickName,
                            quest: this.question,
                            response: this.answer
                        });
                        this.question = "";
                    }
                })
        }
    }
}
</script>

<style scoped>
.container {
    display: flex;
    justify-content: space-between;
    height: 100%;
}

.Question_table {
    flex: 1;
    margin: 0 0 2px 20px;
}

.Response_table {
    flex: 3;
}

.np {
    width: 2px;
    background-color: black;
}

.question-table {
    padding: 20px;
    background-color: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 600px;
    margin: auto;
}

.question-table h2 {
    font-size: 1.5em;
    margin-bottom: 10px;
    color: #333;
}

.question-input {
    width: 70%;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-bottom: 10px;
    font-size: 1em;
}

.send-button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 1em;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.send-button:hover {
    background-color: #0056b3;
}
</style>
