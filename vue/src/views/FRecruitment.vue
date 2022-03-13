<template>

  <!--    &lt;!&ndash;      搜索区域&ndash;&gt;-->
  <!--    <div style="margin: 10px 0">-->
  <!--      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>-->
  <!--      <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>-->
  <!--    </div>-->

  <div>
    <el-row :data="tableData">
      <el-col :span="8" v-for="(item) in tableData" :key="item.ID" :offset="2">

        <el-card style="margin: 20px" :body-style="{ padding: '10px', margin: '5px'}" shadow="hover">
          <div>
            <div >

              <strong>招聘单位:</strong>{{item.name}}<br/><br/>
              <strong>招聘职位:</strong>{{item.job}}<br/><br/>
              <strong>工作内容:</strong>{{item.content}}<br/><br/>
              <strong>发布时间:</strong>{{item.time}}<br/><br/>

            </div>
          </div>

        </el-card>


      </el-col>
    </el-row>


  </div>



</template>

<script>
import request from "@/utils/request";

export default {
  name: "FindLost",
  data(){
    return{
      tableData: [

      ]
    }
  },
  created() {
    this.load()
  },
  methods:{
    filesUploadSuccess(res) {
      console.log(res)
      this.form.pickPicture = res.data
    },
    load(){
      request.get("/recruitment", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }

      }).then(res =>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    add(){
      this.dialogVisible = true
      this.form = {}
    },
    save(){
      if(this.form.id){ //更新
        request.put("/recruitment", this.form).then(res => {
          console.log(res)
          if (res.code === '0'){
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else{
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() //刷新表格数据
          this.dialogVisible = false //关闭弹窗
        })
      } else{ //新增
        request.post("/recruitment", this.form).then(res => {
          console.log(res)
          if (res.code === '0'){
            this.$message({
              type: "success",
              message: "新增成功"
            })
          } else{
            this.$message({
              type: "error",
              message: res.msg
            })
          }

          this.load() //刷新表格数据
          this.dialogVisible = false //关闭弹窗
        })
      }

    },
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(id) {
      console.log(id)
      request.delete("/recruitment/" + id).then(res => {
        if (res.code === '0'){
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else{
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load()  //删除后重新加载表格数据
      })
    },
    handleSizeChange(pageSize){  //改变当前每页的个数触发
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){  //改变当前页码触发
      this.currentPage = pageNum
      this.load()
    },
  }
}
</script>

<style scoped>

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 60%;
  display: block;
}
</style>