// Función map

val sc = spark.sparkContext

val rdd = sc.parallelize(Seq(1,2,3,4,5))

// Resta uno a todos los elementos del RDD
val rddResta = rdd.map(_ - 1)

rddResta.collect

// Devuelve un rdd con un true o false si el elemento es par
val rddPar = rdd.map(_ % 2 == 0)

rddPar.collect

val rddTexto = sc.parallelize(Seq("juan", "pedro", "katia"))

// Convierte todos los elementos a mayusculas
val rddMayuscula = rddTexto.map(_.toUpperCase)

rddMayuscula.collect

// Concatena un hola mas el elemento del rdd
val rddHola = rddTexto.map("Hola " + _ + "!")

rddHola.collect
