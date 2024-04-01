// Acumuladores
//Los acumuladores son variables compartidas entre ejecutores que normalmente se utilizan para agregar contadores a su programa spark.

val sc = spark.sparkContext

// longAccumulator

val acumuladorLong = sc.longAccumulator("longAccumulator")

// Con esta linea por cada elemento del rdd se agregara su valor al acumulador, es decir, 1 + 2 + 3 + 4 + 5
sc.parallelize(1 to 5).foreach(x => acumuladorLong.add(x))

// Con esta linea se resetea el valor del acumulador
acumuladorLong.reset

// Con esta linea podemos conocer el valor del acumulador
acumuladorLong.value

acumuladorLong.isZero

// doubleAccumulator

val acumuladorDouble = sc.doubleAccumulator("doubleAccumulator")

// Con esta linea agregamos una unidad por cada elemento del rdd
sc.parallelize(1 to 50).foreach(x => acumuladorDouble.add(1))

// A diferencia de las variables regulares, los acumuladores pueden ser modificadas por los worker nodes pero solo pueden ser leidas por el driver. Esto las hace una herramienta invaluable para coleccionar y procesar informacion esencial a traves del cluster.

// Ejemplo practico: https://medium.com/@ARishi/mastering-accumulators-in-apache-spark-and-not-screwing-yourself-in-the-process-8708cdb4de27#:~:text=Real%2Dlife%20Example%3A%20Monitoring%20Data%20Quality

// Que es un driver?: https://keepcoding.io/blog/driver-apache-spark/
