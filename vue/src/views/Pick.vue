<template>
  <div style="padding: 10px">
    <!--      功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

    <!--      搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>
      <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="id" label="ID" sortable> </el-table-column>
      <el-table-column prop="pickName" label="拾物者姓名"> </el-table-column>
      <el-table-column prop="pickThing" label="拾物名称"> </el-table-column>
      <el-table-column label="图片">
      <template #default="scope">
        <el-image
            style="width: 100px; height: 100px"
            :src="scope.row.pickPicture"
            :preview-src-list="[scope.row.pickPicture]"
        >
        </el-image>
      </template>
      </el-table-column>
      <el-table-column prop="pickCharacteristic" label="物品特征"> </el-table-column>
      <el-table-column prop="pickTime" label="拾物时间"></el-table-column>
      <el-table-column prop="pickPlace" label="拾物地点"></el-table-column>
      <el-table-column prop="pickContact" label="联系方式"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">
            编辑
          </el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="拾物者姓名">
          <el-input v-model="form.pickName" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="物品名称">
          <el-input v-model="form.pickThing" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="物品图片">
          <el-upload action="http://localhost:9090/files/upload" :on-success="filesUploadSuccess">
            <el-button type="primary">Click to upload</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="物品特征">
          <el-input v-model="form.pickCharacteristic" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="拾物时间">
          <el-date-picker v-model="form.pickTime" value-format="YYYY-MM-DD" type="date" style="width: 80%" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="拾物地点">
          <el-input type="textarea" v-model="form.pickPlace" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="form.pickContact" style="width: 80%"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import request from "../utils/request";

export default {
  name: 'Pick',
  components: {

  },
  data(){
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      total: 0,
      pageSize: 10,
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
      request.get("/pick", {
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
        request.put("/pick", this.form).then(res => {
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
        request.post("/pick", this.form).then(res => {
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
      request.delete("/pick/" + id).then(res => {
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
