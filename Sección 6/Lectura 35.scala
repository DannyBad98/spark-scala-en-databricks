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
