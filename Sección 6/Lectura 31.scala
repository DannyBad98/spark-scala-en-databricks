// Almacenamiento en caché
// Podemos almacenar RDD como objetos Java deserializados en la JVM

val sc = spark.sparkContext

val rdd = sc.parallelize(1 to 10)

import org.apache.spark.storage.StorageLevel

// Niveles de almacenamiento

// Memory Only. Si el RDD no cabe en la memoria, algunas particiones no se almacenaran y se volveran a calcular cada vez que se necesiten
// Esta es la opcion mas rapida para el rendimiento de ejecucion
rdd.persist(StorageLevel.MEMORY_ONLY) 

rdd.unpersist()

// Disk Only
// No debe usarse a menos que sus calculos sean costosos
rdd.persist(StorageLevel.DISK_ONLY)

rdd.unpersist()

// Memory and disk. Si el RDD no cabe en la memoria, almacena el resto en el disco y las lee de alli cuando sea necesario

rdd.persist(StorageLevel.MEMORY_AND_DISK)

rdd.unpersist()

// Tolerancia a fallos
// Podemos usar MEMORY_ONLY_2, MEMORY_AND_DISK_2,etc para replicar en dos nodos del cluster

// cache()
// es un sinonimo de persist(StorageLevel.MEMORY_ONLY)
rdd.cache()
