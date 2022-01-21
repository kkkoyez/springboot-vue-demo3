<template>
    <div>
        <el-menu
                style="width: 180px; min-height: calc(100vh - 50px)"
                default-active="user"
                class="el-menu-vertical-demo">
            <el-sub-menu index="1-4">
                <template #title>系统管理</template>
                <el-menu-item index="1-4-1">用户管理</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <template #title>导航二</template>
            </el-menu-item>

            <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <template #title>导航四</template>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>

</style>