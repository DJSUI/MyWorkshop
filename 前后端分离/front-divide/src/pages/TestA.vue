<template>
  <div>
    <h1>{{ data1 }}</h1>
  </div>
</template>


<script setup>
import axios from "axios";
import { ref } from "vue"
let data1 = ref("caixukun")
axios.get("http://localhost:8080/test/hello").then(res => {
  console.log("res!!", res);

  data1.value = res.data
}).catch(err => {
  alert(err)
})
</script>