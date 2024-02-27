// Función count. Cuenta el numero de elementos de un rdd

val sc = spark.sparkContext

val rdd = sc.parallelize(Seq("j", "o", "s", "e"))

rdd.count

val rddN = sc.parallelize(1 to 50)

rddN.count
