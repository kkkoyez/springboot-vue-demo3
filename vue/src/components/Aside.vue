<template>
    <div>
        <el-menu
                style="width: 200px; min-height: calc(100vh - 50px)"
                :default-active="path"
                router
                class="el-menu-vertical-demo">
          <el-menu-item index="/user">用户管理</el-menu-item>
          <el-menu-item index="/announcement">公告管理</el-menu-item>
          <el-menu-item index="/lost">失物管理</el-menu-item>
          <el-menu-item index="/pick">拾物管理</el-menu-item>
          <el-menu-item index="/recruitment">招聘管理</el-menu-item>
          <el-menu-item index="/study">资源管理</el-menu-item>
        </el-menu>
    </div>
</template>

<script>

export default {
  name: "Aside",
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