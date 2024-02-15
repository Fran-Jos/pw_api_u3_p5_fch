import axios from "axios";

//objeto lambda que me permite obtener un  estudiante por su id
//axios ya viene incluido implicitamente un await
const consultarEstudiante = async (id) => {
    const data = axios.get(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${id}`).then(r=>r.data );
   console.log(data);
    return data;
}

const insertar = async (body) => {
  const data = axios.post('http://localhost:8080/API/v1.0/Matricula/estudiantes',body).then(r=>r.data);
console.log(data);
}



// tenemos que declara que el metodo es asincrono para que se pueda usar el await
// en los metodos facha de debe porner export para poder exportarlos
export const consutarEstudianteFachada = async (id)=>{
    return await consultarEstudiante(id);
}

 export const insertarFachada = async (body)=>{
     await insertar(body);
}
