<template>
    <div  class="container-fluid">
        <div v-for="(photo, index) in photoArray" :key="index" class="card w-50 p-5 my-5 mx-auto">
          
            <div class="d-flex justify-content-between align-items-center">
                <h4>{{photo.title}}</h4>
                <span v-if="photo.tag">Tag: {{photo.tag}}</span>
            </div>

            <img src="../assets/logo.png" :alt="photo.title" class="w-50 m-auto my-2" />

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
    
            <div>
                <div v-if="photo.comments" class="comment-section">
                    <h4 class="py-3">Commenti:</h4>
                    <p v-for="(comment, index) in photo.comments" :key="index" class="card">
                        {{ comment.content }}
                    </p>
                </div>
                <form action="">
                    <input type="text" name="comment" style="min-height: 120px;" class="d-block w-75 mx-auto my-3 p-1 form-control" placeholder="Inserici un nuovo commento" />
                    <a type="submit" class="btn btn-primary my-3">Invia</a>
                </form>
            </div>

            
        </div>
    </div>    
</template>

<script>

    import axios from 'axios';
    
    export default {
        name: 'indexPhoto',
        data() {
            return {
                apiUrl:"http://localhost:8080/api/1/photo/index",
                photoArray: []
            }
        },
        mounted() {
            axios.get(this.apiUrl)
                .then(response => {
                    const photoList = response.data;
                    if (photoList == null) return;

                    this.photoArray = photoList;
                })
                .catch(err => {
                    console.log("errore" + err);
                });
        },
        methods:{
            
        }
    }
</script>

<style scoped lang="scss">

</style>
