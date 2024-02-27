// Función reduce

val sc = spark.sparkContext

val rdd = sc.parallelize(1 to 10)

// Se sumaran los numeros dando como resultado 55
rdd.reduce(_ + _)

// Otra forma de obtener la suma de todos los elementos, es obteniendo la formula de la suma de los n primeros numeros
// n*n+1 / 2
10*11/2

val rddP = sc.parallelize(1 to 3)

// En este ejemplo multiplicaremos todos los elementos del rdd dando como resultado 6
rddP.reduce(_ * _)
