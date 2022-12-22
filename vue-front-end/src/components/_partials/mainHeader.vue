
<template>
    <header class="p-2 bg-dark">
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand  text-light" href="#">Spring Foto</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-around" id="navbarNavAltMarkup">
                    <div class="navbar-nav w-50 justify-content-around align-items-center">
                        <router-link class="nav-link mx-2 text-light" to="/">Home</router-link> 
                        <router-link aria-current="page" class="nav-link active mx-2 text-light" to="/foto">Foto</router-link>
                        <router-link class="nav-link mx-2 text-light" to="/categories">Categorie</router-link>
                    </div>
                </div>
            </div>
        </nav>
    </header>
</template>

<script>

    export default {
        name: "mainFooter"
    }

</script>

<style lang="scss" scoped>
.active {
    color:red;
}
</style>