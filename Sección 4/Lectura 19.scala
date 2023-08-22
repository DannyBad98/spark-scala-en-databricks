// Función coalesce

val sc = spark.sparkContext

val rdd = sc.parallelize(Seq(1 to 10), 10)

rdd.getNumPartitions

// Reduce el numero de particiones del rdd a 5
val rdd5 = rdd.coalesce(5)

rdd5.getNumPartitions
