<template>

    <main class="container-fluid">
        <div v-for="(photo, index) in photoArray" :key="index" class="card w-50 p-5 my-5 mx-auto">
        
            <div class="d-flex justify-content-between align-items-center">
                <h4 class="text-capitalize">{{photo.title}}</h4>
                <span v-if="photo.tag"><span class="fw-bold me-2">Tag:</span> {{photo.tag}}</span>
            </div>

            <img src="../assets/ph.svg" :alt="photo.title" class="w-100 m-auto my-2" />

            <div class="my-4">
                <h4>Descrizione</h4>
                <hr />
                <p class="text-start">{{photo.description}}</p>
            </div>
            
            <div class="mb-4">
                <span>
                    <span class="fw-bold me-2">Url:</span> 
                    <em>{{photo.url}}</em>
                </span>
            </div>

            <div class="category-section" v-if="photo.categories">

                <h4 class="py-3">Categorie:</h4>
                <hr/> 
                <ul >
                    <li v-for="(category, index) in photo.categories" :key="index">
                        {{ category.name }}
                    </li>
                </ul>

            </div>

            <div class="my-3" style="border: 2px solid black;border-radius:5px">
                <h4 class="bg-secondary text-light p-3">Commenti:</h4>
                <div v-if="photo.comments.length" class="px-4 py-2 comment-section">
                    <p v-for="(comment, index) in photo.comments" :key="index" class="bg-light p-3">
                        {{ comment.content }}
                    </p>
                </div>
                    <form class="text-center bg-secondary w-100 px-3 py-2">
                        <input type="text" name="comment" v-model="newCom" style="min-height: 120px;" class="d-block w-100 mx-auto my-3 p-1 form-control" placeholder="Inserici un nuovo commento" />
                        <button @click="sendComment(photo)" type="submit" class="btn btn-primary my-3">Invia</button>
                    </form>
            </div>

            
        </div>
    </main>    

</template>

<script>

    import axios from 'axios';

    export default {
        name: 'indexPhoto',
        data() {
            return {
                apiUrl:"http://localhost:8080/api/1",
                photoArray: [],
                newCom:"",
                activePhotoId: -1
            }
        },
        mounted() {
            axios.get(this.apiUrl +"/photo/index")
                .then(response => {
                    this.photoArray = response.data;

                    for (let i = 1; i <= response.data.length; i++) {
                        this.getPhotoCategories(i);
                    }
                })
                .catch(err => {
                    console.log("errore: " + err);
                });
        },
        methods:{
            getPhotoCategories(id) {
                axios.get(this.apiUrl + "/categories/get/" + id)
                    .then(response => {
                        const cat = response.data;
                        
                        const indx = this.getPhotoIndexById(id);

                        if (cat !== null) {
                            this.photoArray[indx].categories = cat;
                        } else {
                            return;
                        }
                    });
            },
            getPhotoComments(id) {
                axios.get(this.apiUrl + "/comments/get/" + id)
                    .then(response => {
                        const com = response.data;

                        const indx = this.getPhotoIndexById(id);

                        if (com !== null) {
                            this.photoArray[indx].comments = com;
                        } else {
                            return;
                        }
                    });
            },
            //  Trova Id foto
            getPhotoIndexById(id) {
                for (let i = 0; i < this.photoArray.length; i++) {
                    const photo = this.photoArray[i];

                    if (photo.id == id) {
                        return i;
                    }
                }
                return -1;
            },
            //  Trova foto
            getPhotoById(id) {
                return this.photoArray[this.getPhotoIndexById(id)];
            },
            getASize(array) {
                return array.length;
            }
        }
    }
</script>

<style scoped lang="scss">

</style>
