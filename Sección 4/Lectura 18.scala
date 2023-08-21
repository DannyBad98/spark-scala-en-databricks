// Función filter

val sc = spark.sparkContext

val rdd = sc.parallelize(1 to 10)

// Filtra los numeros que sean divisibles entre 3
val rddDivisible3 = rdd.filter(_ % 3 == 0)

rddDivisible3.collect

val rddTexto = sc.parallelize(Seq("juan", "julia", "pedro", "katia"))

// Filtra los nombres que empiecen con la letra J
val rddInicioJ = rddTexto.filter(_.startsWith("j"))

rddInicioJ.collect

// Filtra los nombres que empiecen con la letra j y terminen con la letra a
val rddInicioJFinA = rddTexto.filter(x => x.startsWith("j") & x.endsWith("a"))

rddInicioJFinA.collect

// Filtra los nombres que empiecen con la letra j o que empiecen la letra k
val rddOrNombre = rddTexto.filter(x => x.startsWith("j") | x.startsWith("k"))

rddOrNombre.collect
