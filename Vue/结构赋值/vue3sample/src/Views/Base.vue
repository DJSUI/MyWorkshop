<template>
  <div>
    hello this is Base
    data
    <!-- 普通解构 -->
    <h4 style="background-color: aqua;">
      {{ name }}
      {{ gender }}
      {{ age }}
    </h4>
    <button @click="changeData">changeData </button>
    <!-- 响应式结构赋值 -->
    <h4 style="background-color: pink;">
      {{ name2 }}
      {{ gender2 }}
      {{ age2 }}
    </h4>


  </div>
</template>

<script>//如果将setup 写入script标签里 例如：<script setup> 那么就不用return  和export和defaults  
import { ref } from 'vue';  //基本数据类型「数值，字符串」定义使用ref 
import { reactive } from 'vue';  // 复杂类型数据使用reactive 
import { toRefs } from 'vue';   // 结构赋数值需要是响应式时 需要引入toRefs  

export default {
  name: 'Base',    //如果是<script setup>  那么 name 是无法被定义的 
  setup() {
    let objectdata1 = reactive({
      name: 'name',
      gender: 'gender',
      age: 10
    })
    let objectdata2 = reactive({
      name: 'name2',
      gender: 'gender2',
      age: 12
    })


    // 普通结构赋数值  --- 数值不结构后不是响应式 
    let { name, gender, age } = objectdata1;
    // 响应式构赋数值
    let { name: name2, gender: gender2, age: age2 } = toRefs(objectdata2);
    return { name, gender, age, objectdata1, objectdata2, name2, gender2, age2 }    // 定义变量，方法都需要放入return 里 ，符合组合式API写法 区别 选项API写法 

  }

}




</script>