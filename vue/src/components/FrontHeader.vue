<template>
  <div style="heiht: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue">校园互助中心</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown>
              <span class="el-dropdown-link">
                  {{user.username}}

                <!--           {{ user.nickName }}-->
          <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  // props: ['user'],
  // username: JSON.parse(sessionStorage.getItem("user")).username,
  data() {
    return {
      user:{}
    }
  },
  created() {
  }
}
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.15.6/lib/theme-chalk/index.css");
</style>