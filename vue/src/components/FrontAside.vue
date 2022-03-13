<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        :default-active="path"
        router
        class="el-menu-vertical-demo">
      <el-menu-item index="/front">公告</el-menu-item>
      <el-menu-item index="/findLost">失物招领</el-menu-item>
      <el-menu-item index="/findPick">拾物招领</el-menu-item>
      <el-menu-item index="/fRecruitment">招聘信息</el-menu-item>
      <el-menu-item index="/test">测试</el-menu-item>
    </el-menu>
  </div>
</template>

<script>

export default {
  name: "FrontAside",
  data() {
    return {
      path: this.$route.path  //设置默认高亮的菜单
    }
  },
  created() {
    console.log()
  }
}
</script>

<style scoped>

</style>