<template>
<div style="width: 100%; height: 100vh; background-color: darkslateblue; overflow: hidden">
  <div style="width: 400px; margin: 150px auto">
    <div style="color: #cccccc; font-size: 30px; text-align: center; padding: 30px 0" >欢迎登录</div>
    <el-form ref="form" :model="form" size="normal">
      <el-form-item>
        <el-input prefix-icon="el-icon-s-custom" v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 100%" type="primary">登 录</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>

<script>
import {ArrowDown} from "@element-plus/icons";

export default {
  name: "Login",
  components: {

    ArrowDown

  },
  data() {
    return {
      form: {}
    }
  }
}
</script>

<style scoped>

</style>