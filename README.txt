POST EN ESTUDIANTE:{
  "nroDocumento": 12345678,
  "nombre": "Juan",
  "apellido": "Pérez",
  "edad": 25,
  "genero": "Masculino",
  "ciudad": "Buenos Aires",
  "nroLibreta": 987654
}

POST EN CARRERA:{
  "idCarrera": 1,
  "nombre": "Ingeniería en Sistemas"
}

POST EN ESTUDIANTE_CARRERA:{   
  "id": 1,
  "estudiante": {
    "nroDocumento": 12345678
  },
  "carrera": {
    "idCarrera": 1
  },
  "seGraduo": false,
  "antiguedad": 3
}