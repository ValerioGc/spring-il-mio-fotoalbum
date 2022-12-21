<template>
  <div id="appContainer" class="bg-light">
    <mainHeader />
    <indexPhoto />
    <mainFooter />
  </div>
</template>

<script>

  import indexPhoto from './components/indexPhoto.vue'

  import mainHeader from './components/_partials/mainHeader.vue'
  import mainFooter from './components/_partials/mainFooter.vue'
      
  export default {
    name: 'App',
    components: {
      indexPhoto,
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
