<template>
  <main class="container-fluid">
    <div v-for="(category, index) in categoriesArray" :key="index" class="card w-50 p-5 my-5 mx-auto">

      <div class="d-flex justify-content-between align-items-center">
        <p class="h5">Nome: {{ category.name }}</p>
      </div>

      <div class="my-4">
        <span class="text-start">Id: {{ category.id }}</span>
      </div>

      <div class="category-section" >
        <h4 class="py-3">Foto collegate:</h4>
        <hr />
        <ul>
          <li v-for="(photo, index) in category.photos" :key="index">
            {{ photo.title }}
          </li>
        </ul>

      </div>
    </div>
  </main>
</template>

<script>

import axios from 'axios';

export default {
  name: 'indexCategory',
  data() {
    return {
      apiUrl: "http://localhost:8080/api/1",
      categoriesArray: []
    }
  },
  mounted() {
    axios.get(this.apiUrl + "/categories/all")
      .then(response => {
        this.categoriesArray = response.data;
        console.log(response.data)

        for (let i = 1; i <= response.data.length; i++) {
          this.getCategoriesPhoto(i);
        }
      })
      .catch(err => {
        console.log("errore: " + err);
      });
  },
  methods: {
    getCategoriesPhoto(id) {
      axios.get(this.apiUrl + "/photo/get/" + id)
        .then(response => {
          const pht = response.data;
          const indx = this.getCategoryIndexById(id);

          if (pht !== null) {
            this.categoriesArray[indx].photos = pht;
            console.log(pht)
          } else {
            return;
          }
        });
    },
    getCategoryIndexById(id) {
      for (let i = 0; i < this.categoriesArray.length; i++) {
        const cat = this.categoriesArray[i];
        
        if (cat.id == id) {
          return i;
        }
      }
      return -1;
    }
  }
}
</script>

<style scoped lang="scss">
  
  main {
    min-height: 30vh;
  }

</style>