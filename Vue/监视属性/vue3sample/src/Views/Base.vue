<template>
  <div>
    hello this is Base
    data
    <p> {{ counter }}</p>
    <button @click="changeCounter"> change counter </button>
    <p> {{ person.name }} {{ person.age }}</p>
    <button @click="changeAge"> change age </button>
    <p> {{ person2.name }} {{ person2.age }}</p>
    <button @click="changeAge2"> change age2 </button>
    <button @click="changeName2"> change name2 </button>
  </div>
</template>

<script>//如果将setup 写入script标签里 例如：<script setup> 那么就不用return  和export和defaults  
import { watch } from 'vue';
import { ref } from 'vue';  //基本数据类型「数值，字符串」定义使用ref 
import { reactive } from 'vue';  // 复杂类型数据使用reactive 

export default {
  name: 'Base',    //如果是<script setup>  那么 name 是无法被定义的 
  setup() {
    let counter = ref(0)
    let person = reactive({ name: 'zhangsan', age: 10 })
    let person2 = reactive({ name: 'lisi', age: 10 })
    function changeAge() {
      person.age += 1
    }
    function changeAge2() {
      person2.age += 1
    }
    function changeCounter() {
      counter.value += 1
    }
    function changeName2() {
      person2.name = 'wangwu'
    }

    //  监视基本类型数据 
    watch(counter, (newValue, oldValue) => {
      console.log('change!!!', newValue, oldValue);
      if (newValue > 5) {
        console.log('stop counter');
        stopwatch();
      }    // watch 函数不用被return 
    })

    // 监视对象类型数据  默认卡其深度监视 
    watch(person, (newValue, oldValue) => {
      console.log('person change!!!', newValue, oldValue);

    })
    // 监视对象类型数据，可以只监视其中一个属性 
    watch(() => {
      return person2.age
    }, (newValue, oldValue) => {
      console.log('person2 change!!!', newValue, oldValue);

    })



    return { counter, person, person2, changeCounter, changeAge, changeAge2, changeName2 }    // 定义变量，方法都需要放入return 里 ，符合组合式API写法 区别 选项API写法 

  }

}




</script>