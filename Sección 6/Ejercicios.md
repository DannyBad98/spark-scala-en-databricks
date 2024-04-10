# Ejercicios Seccion 6

1. Cree un RDD importes a partir de los datos adjuntos a esta lección como recurso.

    a. ¿Cuál sería el número ideal de particiones para trabajar con este RDD?

    b. Emplee acumuladores para obtener el total de ventas realizadas y el importe total de las ventas.

2. Si se conoce que a cada venta hay que restarle un importe fijo igual a 10 pesos por temas de impuestos.

    a. ¿Cómo restaría este impuesto de cada venta utilizando una variable broadcast para acelerar el proceso?

    b. Cree un RDD llamado ventaReal a partir de la propuesta del inciso a que contenga el monto de las ventas después de aplicar los impuestos.

    c. Destruya la variable broadcast creada luego de emplearla para crear el RDD del inciso b.

3. Persista el RDD ventaReal en los siguientes niveles de persistencia.

    a. Memoria.

    b. Disco solamente.

    c. Memoria y disco.

## Solucion ejercicio 1

```scala

// 1. Crea un RDD a partir del archivo ventas.txt
val importes = sc.textFile("/FileStore/seccion6/ventas.txt")


// a. numero ideal de particiones
// El numero ideal de particiones con las que debes trabajar depende del numero de core que tengamos disponibles en nuestro entorno de trabajo

// Para conocer el numero de cores disponibles podemos usar la funcion defaultParallelism del sparkContext

sc.defaultParallelism


// b. total de ventas
val ventasRealizadas = sc.longAccumulator("longAccumulator")
importes.foreach(x => ventasRealizadas.add(1))
ventasRealizadas.value


// b. importe total
val importeTotal = sc.longAccumulator("longAccumulatorVentas")
importes.foreach(x => importeTotal.add(x.toLong))
importeTotal.value

```
## Solucion ejercicio 2

```scala

val brImpuesto = sc.broadcast(10)
val importeTotalSImpuesto = sc.longAccumulator("accumulatorVentasSinImpuesto")
importes.foreach(x => importeTotalSImpuesto.add(x.toLong - brImpuesto.value))
importeTotalSImpuesto.value

brImpuesto.destroy

```
## Solucion ejercicio 3
```scala

import org.apache.spark.storage.StorageLevel


val ventaReal = sc.parallelize(importeTotalSImpuesto.toString)


ventaReal.persist(StorageLevel.MEMORY_ONLY)

//Alternativa: ventaReal.cache()


ventaReal.unpersist()


ventaReal.persist(StorageLevel.DISK_ONLY)


ventaReal.unpersist()


ventaReal.persist(StorageLevel.MEMORY_AND_DISK)


ventaReal.unpersist

```


