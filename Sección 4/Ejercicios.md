# Ejercicio 1

 1. Cree un RDD llamado lenguajes que contenga los siguientes lenguajes de programación: Python, R, C, Scala, Rugby y SQL.
    
    a. Obtenga un nuevo RDD a partir del RDD lenguajes donde todos los lenguajes de programación estén en mayúsculas.
    
    b. Obtenga un nuevo RDD a partir del RDD lenguajes donde todos los lenguajes de programación estén en minúsculas.
    
    c. Cree un nuevo RDD que solo contenga aquellos lenguajes de programación que comiencen con la letra R.

## Solucion ejercicio 1
```scala
// Crea un rdd con los lenguajes
val lenguajes = sc.parallelize(Seq("Python", "R", "C", "Scala", "Rugby", "SQL"))

// Convierte todos los elementos del rdd lenguajes en mayusculas
val lenguajesMayusculas = lenguajes.map(_.toUpperCase)
lenguajesMayusculas.collect

// Convierte todos los elementos del rdd lenguajes en minusculas
val lenguajesMinusculas = lenguajes.map(_.toLowerCase)
lenguajesMinusculas.collect

// Obtiene un nuevo rdd con los lenguajes que empiezan con R
val lenguajesConR = lenguajes.filter(_.startsWith("R"))

lenguajesConR.collect
```
# Ejercicio 2

 1. Cree un RDD llamado pares que contenga los números pares existentes en el intervalo [20;30].
    
    a. Cree el RDD llamado sqrt, este debe contener la raíz cuadrada de los elementos que componen el RDD pares.
    
    b. Obtenga una lista compuesta por los números pares en el intervalo [20;30] y sus respectivas raíces cuadradas. Un ejemplo del resultado deseado para el intervalo [50;60] sería Array(50, 7.0710678118654755, 52, 7.211102550927978, 54, 7.3484692283495345, 56, 7.483314773547883, 58, 7.615773105863909, 60, 7.745966692414834).
    
    c. Eleve el número de particiones del RDD sqrt a 20.

    d. Si tuviera que disminuir el número de particiones luego de haberlo establecido en 20, ¿qué función utilizaría para hacer más eficiente su código?

    R = Con la funcion coalesce

## Solucion ejercicio 2

```scala
// Crea un rdd con los pares del 20 al 30
val pares = sc.parallelize(20 to 30).filter(_ % 2 == 0)

pares.collect

// Por cada elemento del rdd pares aplica la funcion raiz cuadrada
val sqrt = pares.map(Math.sqrt(_))
sqrt.collect

// Por cada elemento del rdd pares obtiene un par con el numero y su raiz cuadrada List(20.0, 4.47213595499958) 
val list = pares.map(x => List(x, Math.sqrt(x)))
list.collect

// Aumenta las particiones del rdd sqrt a 20
val sqrt20 = sqrt.repartition(20)
sqrt20.getNumPartitions

// Disminuye las particiones del rdd sqrt20 a 10
val sqrt10 = sqrt20.coalesce(10)
sqrt10.getNumPartitions
```
# Ejercicio 3

 1. Cree un RDD del tipo clave valor a partir de los datos adjuntos como recurso a esta lección. Tenga en cuenta que deberá procesar el RDD leído para obtener el resultado solicitado. Supongamos que el RDD resultante de tipo clave valor refleja las transacciones realizadas por número de cuentas. Obtenga el monto total por cada cuenta.

## Solucion ejercicio 3
```scala
val rddTransacciones = sc.textFile("/FileStore/seccion4/ejercicios/transacciones.txt")
rddTransacciones.collect

// Definicion de una funcion que toma como parametros un string y devuelve un Array de tipo String
def procesar(s: String): Array[String] = {
  // Toma un string y reemplaza todos los espacios por nada, reemplaza todos los ( por nada, reemplaza todos los ) por nada, separa el string cuando encuentra una coma, el resultado es Array(Array(clave, valor))
  s.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "").split(",")
}

rddTransacciones.map(procesar(_)).map(x => (x(0), x(1).toFloat)).reduceByKey(_ + _).collect
```
