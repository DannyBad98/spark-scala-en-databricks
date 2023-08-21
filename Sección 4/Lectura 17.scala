// Función flatMap

val sc = spark.sparkContext

val rdd = sc.parallelize(Seq(1,2,3,4,5))

rdd.collect

// Por cada elemento del rdd devuelve una lista con el numero y su cuadrado
val rddCuadrado = rdd.map(x => List(x, x * x))

rddCuadrado.collect

// Por cada elemento del rdd devuelve el numero y su cuadrado
val rddCuadradoFlat = rdd.flatMap(x => List(x, x * x))

rddCuadradoFlat.collect

val rddTexto = sc.parallelize(Seq("azul rojo verde", "morado amarillo negro"))

// Por cada elemento del rdd separa en un array las palabras cuando encuentres un espacio, dado el flat, todo se queda en un solo array
val rddColores = rddTexto.flatMap(_.split(" "))

rddColores.collect
