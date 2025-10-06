<template>
  <div>
    hello this is Base
    data


  </div>
</template>

<script>//如果将setup 写入script标签里 例如：<script setup> 那么就不用return  和export和defaults  
import { ref } from 'vue';  //基本数据类型「数值，字符串」定义使用ref 
import { reactive } from 'vue';  // 复杂类型数据使用reactive 

export default {
  name: 'Base',    //如果是<script setup>  那么 name 是无法被定义的 
  setup() {




    return {}    // 定义变量，方法都需要放入return 里 ，符合组合式API写法 区别 选项API写法 

  }

}




</script>