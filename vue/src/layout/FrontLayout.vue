<template>
  <div>
    <!--    头部-->
    <FrontHeader />

    <!--    主题-->
    <div style="display: flex">
      <!--      侧边栏-->
      <FrontAside />
      <!--      内容区域-->
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<script>

import FrontHeader from "@/components/FrontHeader";
import FrontAside from "@/components/FrontAside";

export default {
  name: "FrontLayout",
  components:{
    FrontAside,
    FrontHeader


  },
}
</script>

<style scoped>

</style>