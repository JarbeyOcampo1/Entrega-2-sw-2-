# ** Api rest de la primera entrega del bakend 
Esta es una Api rest relacionada con motos 

# Carpeta src main 
-En esta carpeta se encuentra el codigo para ejercutar el Api en este caso es Backends2Application
-Despues creamos en esta carpeta 

* Config
* controllers
* models
* repository

-En la caprta models contiene lo siguiente:

# Entidad y atributos 
``` Java 
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Marca;
    private String Modelo;
    private String placa;
}
```
---
-En la carpeta resources encontramos application.properties donde conectamos con la base de datos en  MYSQL con nuestro backend 

## Conexion con la base de datos de nuestro bakend con MYSQL 

```Java 
spring.datasource.url=jdbc:mysql://localhost:3306/ejercicios2bd
spring.datasource.username=root
spring.datasource.password=cuervo1
spring.jpa.hibernate.ddl-auto=update

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

-En la carpeta repository se encuentra el repositorio en una interface que extiende de JpaRepository donde llamamos a la entidad y el tipo de dato de la llave primaria

## Repository 
```Java 
@Repository
public interface CarRepository extends JpaRepository<Car,Long >{

}
```
---

-La carpeta controller contiene la estructura de nuestro archivo contigo la funciones 

 # Controlador 
```Java
 //obtener todos los carros
    @GetMapping()
    public List<Car> getAll(){
        return carrepository.findAll();
    }
 ```
 ---
 ```Java
 //obtener por una Id
    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") Long id){
        return carrepository.findById(id).orElse(null);
    }
 ```
 ---
  ```Java
//crear un carro
    @PostMapping()
    public Car CreateCar(@RequestBody Car car){
        return carrepository.save(car);
    }
 ```
 ---
```Java
//Actualizar carros
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        return carrepository.save(car);
    }
 ```
 ---
```Java
//Borrar carros
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carrepository.deleteById(id);
    }
```   
 ---

 - Carpeta config contiene la estructura de nuestro archivo que estara relacionado con la otra parte de backend 

 ## En la extesion THUNDER encuentra los metodos 

 * GET () para obtener todos los carros
 ```Java 
http://localhost:8080/api/Car
 ```
 * GET (/id) para obtener un carro por su id
 ```Java
 http://localhost:8080/api/Car/2
 {
  "id": 2,
  "placa": "IHF287",
  "marca": "CHEVROLET",
  "modelo": "CAMARO 2024"
}
 ```
 * POST () para crear un carro
 ```Java
 http://localhost:8080/api/Car
 {
  "placa": "ADF245",
  "modelo": "XT4 2024",
  "marca": "CADILLAC"
}
 ```
 * PUT para actualizar un carro
 ```Java
 {
  "placa": "ADF245",
  "modelo": "XT4 2025",
  "marca": "CADILLAC"
}
{
  "id": 9,
  "placa": "ADF245",
  "modelo": "XT4 2025",
  "marca": "CADILLAC"
}
 ```
 * DELETE para eliminar un carro
 ```Java
 http://localhost:8080/api/Car/8
 [
  {
    "id": 1,
    "placa": "AER23",
    "modelo": "MUSTANG 2003",
    "marca": "FORD"
  },
  {
    "id": 2,
    "placa": "IHF287",
    "modelo": "CAMARO 2024",
    "marca": "CHEVROLET"
  },
  {
    "id": 9,
    "placa": "ADF245",
    "modelo": "XT4 2025",
    "marca": "CADILLAC"
  }
]
 ```

* Esta es mi api sobre carros // tuve una falencia a la hora de crear el proyecto, con la tabla de bd de datos entonces para la siguiente entrega hare el mismo concepto pero con la tabla de id, modelo, marca , placa, precio , estado, kilometraje 
