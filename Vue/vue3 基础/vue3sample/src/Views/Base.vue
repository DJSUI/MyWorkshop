<template>
  <div>
    hello this is Base
    data
    <!-- 属性定义 -->
    <h1>{{ dataA1 }}</h1>
    <h1>{{ dataA2 }}</h1>
    <h2>object data </h2>
    <span>
      {{ objectData.test1 }}
      <br>
      {{ objectData.test2 }}
    </span>
    <br>
    <button @click="changeData">changeData </button>
    <!-- 计算属性 -->
    <div style="background-color: greenyellow;">
      Firstname : <input v-model="firstName"> <br>
      Lastname : <input v-model="lastName"> <br>
      Fullname: <span>{{ fullName }}</span>
    </div>




  </div>
</template>

<script>//如果将setup 写入script标签里 例如：<script setup> 那么就不用return  和export和defaults  
import { computed, ref } from 'vue';  //基本数据类型「数值，字符串」定义使用ref 
import { reactive } from 'vue';  // 复杂类型数据使用reactive 

export default {
  name: 'Base',    //如果是<script setup>  那么 name 是无法被定义的 
  setup() {
    // 变量定义 
    let dataA1 = ref(0)  //使用ref 可以赋予相应式
    let dataA2 = 0
    let objectData = reactive({ test1: 'niao', test2: 3 })
    function changeData() {
      dataA2 = 5   // 当数值有变动因为没有ref 无法渲染到页面上
      dataA1.value = 5        // 当数值有变动可以渲染到页面上  有ref的属性需要通过value 来修改数值
      objectData.test1 = "再见"  // reactive 管理复杂数据时，不需要使用value 调整数值
      objectData.test2 = 10
    }
    // 计算属性&数据绑定 
    let firstName = ref("FirstName")   // v-modle 常被用到input 框中 
    let lastName = ref("LastName")     // 数据绑定分为 单向绑定和双向绑定  v-bind 常被用到图片和布尔类型数据的按钮上 
    let fullName = computed({
      get() {
        return firstName.value.slice(0, 1).toUpperCase() + firstName.value.slice(1) + lastName.value
      },
      set() { }
    })




    return { dataA1, dataA2, changeData, objectData, firstName, lastName, fullName }    // 定义变量，方法都需要放入return 里 ，符合组合式API写法 区别 选项API写法 

  }

}




</script>