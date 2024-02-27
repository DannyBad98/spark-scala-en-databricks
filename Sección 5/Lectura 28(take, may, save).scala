// Funciones take, max y saveAsTextFile

val sc = spark.sparkContext

// take
// take: devuelve todos los registros especificados como argumento.
val rdd = sc.parallelize("La programación es bella".split(" "))

rdd.take(2) // Output:  Array(La, programación)

rdd.take(4) // Output:  Array(La, programación, es, bella)

// max 
//max: devuelve el registro máximo. En rdd de tipo string devuelve el registro con mas letras

val rddNumero = sc.parallelize(1 to 15)

rddNumero.max //Output: 15

val rddPar15 = rddNumero.filter(_ % 2 == 0)

rddPar15.max //

// min: devuelve el menor numero dentro del rdd. En rdd de tipo string devuelve el registro con menos letras

rddPar15.min //Output: 1

// saveAsTextFile
// saveAsTextFile: usando esta acción, podemos escribir el RDD en un archivo de texto.

// Se guarda el rdd en un archivo de texto particionandose en 8 particiones
rddPar15.saveAsTextFile("/FileStore/Seccion5/Lectura28")

// Con este comando podemos hacer un ls al databricks filesystem (dbfs)
dbutils.fs.ls("/FileStore/Seccion5/Lectura28")

// Reducimos el numero de particiones a 1 para posteriormente guardarlo en otra ubicacion
rddPar15.coalesce(1).saveAsTextFile("/FileStore/Seccion5/Lectura28/rdd1")

dbutils.fs.ls("/FileStore/Seccion5/Lectura28/rdd1")
