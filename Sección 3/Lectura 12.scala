// Diferentes formas de crear un RDD

// Crear un sparkContext y asignarlo a sc
val sc = spark.sparkContext

// Crear un RDD vacío
val rddVacio = sc.emptyRDD

// Crear un RDD vacio con parallelize e indicando el numero de particiones
val rddVacio1 = sc.parallelize(Seq(), 3)

// Obtener los elementos del rdd
rddVacio1.getNumPartitions

// Creando un RDD con datos
val rdd = sc.parallelize(Seq(1,2,3,4,5))

// Obteniendo los elementos del RDD
rdd.collect

// Crear un RDD desde un archivo de texto
val rddTexto = sc.textFile("/FileStore/Section3/Lecture12/rdd_source.txt")

rddTexto.collect

val rddTextoCompleto = sc.wholeTextFiles("/FileStore/Section3/Lecture12/rdd_source.txt")

rddTextoCompleto.collect

// Operaciones sencillas con RDD

// A cada elemento del RDD le sumamos uno
val rddSuma = rdd.map(x => x + 1)

rddSuma.collect

// Crear un RDD a partir de un DataFrame

// Importando libreria spark implicits
import spark.implicits._

// Creando un dataframe
val df = Seq((1, "jk"), (2, "ki")).toDF("id", "letras")

// Mostrando el dataframe
df.show()

// Convirtiendo el dataframe a un RDD
val rddDataFrame = df.rdd

rddDataFrame.collect
