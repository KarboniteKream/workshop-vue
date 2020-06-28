<template>
  <div>
    <h1 class="title">Hello!</h1>
    <router-link to="/basic">Basic</router-link>
    <router-link to="/editor">Editor</router-link>
  </div>
</template>

<script>
export default {
  name: 'Home',
}
</script>

<style lang="scss" scoped>
.title {
  color: orange;
}

a {
  display: block;
}
</style>
