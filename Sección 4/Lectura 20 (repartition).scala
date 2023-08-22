// Función repartition

val sc = spark.sparkContext

val rdd = sc.parallelize(1 to 10), 5)

rdd.getNumPartitions

// Aumenta de 5 a 7 el numero de particiones de rdd
val rdd7 = rdd.repartition(7)

rdd7.getNumPartitions

// Reduce de 5 a 7 el numero de particiones de rdd (no recomendable, mejor usar coalesce para reducir particiones)
val rdd3 = rdd.repartition(3)

rdd3.getNumPartitions
