<template>
  <div>

      <router-view :key="$route.fullPath"/>


  </div>

</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>

<script>
export default {
  name: "App",


}
</script>



