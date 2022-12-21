<template>
  <div>
    <mainHeader />
    <router-view/>
    <mainFooter />
  </div>
</template>

<script>


import mainHeader from './components/_partials/mainHeader.vue'
import mainFooter from './components/_partials/mainFooter.vue'

export default {
  name: 'App',
  components: {
    mainHeader,
    mainFooter
  }
}

</script>

<style lang="scss">

  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }

</style>
