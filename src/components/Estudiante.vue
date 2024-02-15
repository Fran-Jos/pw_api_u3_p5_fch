<template>
  <div>
    <h1>Componente Estudiante</h1>
    <input type="text" v-model="id" />
    <button @click="consultarPorId">Consultar</button>
    <input type="text" v-model="nombre" />

    <input type="text" v-model="apellido" />
    <button @click="insertar">insertar</button>
  </div>
</template>

<script>
import {
  consutarEstudianteFachada,
  insertarFachada,
} from "../assets/helpers/clienteEstudiante.js";

export default {
  data() {
    return {
      id: null,
      nombre: null,
      apellido: null,
    };
  },
  methods: {
    async consultarPorId() {
      const data = await consutarEstudianteFachada(this.id);
     this.nombre = data.nombre;
      
     console.log("desde componente", data);

    },

    async insertar() {
      const estuBody = {
        nombre: "Juan",
        apellido: this.apellido,
        edad: 20,
        genero: "M",
      };

      await insertarFachada(estuBody);
    },
  },
};
</script>

<style>
</style>