<template>
<div style="width: 100%; height: 100vh; background-color: darkslateblue; overflow: hidden">
  <div style="width: 400px; margin: 100px auto">
    <div style="color: #cccccc; font-size: 30px; text-align: center; padding: 30px 0" >欢迎注册</div>
    <el-form ref="form" :model="form" size="normal" :rules="rules">
      <el-form-item prop="username">
        <el-input  v-model="form.username" placeholder="请输入账号">
          <template #prefix>
            <el-icon class="el-input__icon"><avatar /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="form.password" placeholder="请输入密码" show-password>
          <template #prefix>
            <el-icon class="el-input__icon"><lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="confirm">
        <el-input v-model="form.confirm" placeholder="请输确认密码" show-password>
          <template #prefix>
            <el-icon class="el-input__icon"><lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 100%" type="primary" @click="register">注 册</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>

<script>
import { Avatar } from '@element-plus/icons-vue'
import { Lock } from '@element-plus/icons-vue'
import request from "@/utils/request";

export default {
    name: "Register",
  components:{
    Avatar,
    Lock

  },
  data() {
    return {
      form: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
        confirm: [
          {required: true, message: '请确认密码', trigger: 'blur'},
        ],
      }
    }
  },
  methods: {
    register() {
      if (this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: '两次密码输入不一致'
        })
        return
      }

      this.$refs['form'].validate((valid) => {
        if (valid) {
          // 向后台发送请求
          request.post("/user/register", this.form).then(res => {
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login")  //注册成功后进行页面跳转，跳转到登录界面
            } else{
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>