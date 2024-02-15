<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <EstudiantePagina/>
</template>

<script>
import EstudiantePagina from '../src/pages/EstudiantePagina.vue'

export default {
  name: 'App',
  components: {
    EstudiantePagina
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
