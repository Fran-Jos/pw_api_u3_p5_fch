<template>
  <h1>Componente Estudiante</h1>
  <div class="container">
    <div class="GET">
      <h2>Buscar por ID:</h2>
      <input id="id" v-model="id" type="text" />
      <button @click="consultarPorId">CONSULTAR</button>
      <form class="form" action="">
        <p type="DATOS DEL ESTUDIANTE:"></p>
        <p type="Nombre: "><input v-model="nombre" type="text" /></p>
        <p type="Apellido: "><input v-model="apellido" type="text" /></p>
        <p type="Genero: "><input v-model="genero" type="text" /></p>
        <p type="Fecha Nacimiento: ">
          <input v-model="fechaNacimiento" type="text" />
        </p>
      </form>
    </div>
    <div class="POST">
      <h2 id="titulo2">INGRESAR DATOS:</h2>
      <form class="form2" action="">
        <p type="DATOS DEL INGRESO DE ESTUDIANTE:"></p>
        <p type="Nombre: "><input v-model="nombreI" type="text" /></p>
        <p type="Apellido: "><input v-model="apellidoI" type="text" /></p>
        <p type="Genero: "><input v-model="generoI" type="text" /></p>
        <p type="Fecha Nacimiento: ">
          <input v-model="fechaNacimientoI" type="datetime" />
        </p>
      </form>
      <button @click="insertar">Insertar</button>
    </div>
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
      genero: null,
      fechaNacimiento: null,
      nombreI: null,
      apellidoI: null,
      generoI: null,
      fechaNacimientoI: null,
    };
  },
  methods: {
    async consultarPorId() {
      const data = await consutarEstudianteFachada(this.id);
      this.nombre = data.nombre;
      this.apellido = data.apellido;
      this.genero = data.genero;
      this.fechaNacimiento = data.fechaNacimiento;

      console.log("desde componente", data);
    },

    async insertar() {
      const estuBody = {
        nombre: this.nombreI,
        apellido: this.apellidoI,
        genero: this.generoI,
        fechaNacimiento: this.fechaNacimientoI,
      };

      await insertarFachada(estuBody);
    },
  },
};
</script>

<style>
.container {
  display: grid;

  align-content: center;
  justify-content: center;
}
.GET {
  display: grid;
  align-content: center;
  justify-content: center;
}
.POST {
  display: grid;
  align-content: center;
  justify-content: center;
}
form {
  width: 340px;
  height: 300px;
  background-color: #0a735c;
  border-radius: 8px;
  padding: 10px 30px;
  margin: 5px;
  font-family: "Times New Roman", Times, serif;
  box-shadow: 0px 0px 40px -10px #000;
}

p:before {
  content: attr(type);
  display: block;
  margin: 3px 2px;
  font-size: 16px;
  color: #fffdfd;
}
button{
  margin: 10px;
}
#id{
  margin-left: 150px;
  width: 100px;
}
#titulo2{
  margin-bottom: 50px;
}
</style>