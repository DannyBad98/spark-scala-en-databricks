val sc = spark.sparkContext

// # Ejercicios
// 1. Cree un RDD llamado importes a partir del archivo adjunto a esta lección como recurso.


val importes = sc.textFile("/FileStore/Seccion5/numbers.txt")


// a. ¿Cuántos registros tiene el RDD importes?

val importesNumReg = importes.count

// b. ¿Cuál es el valor mínimo y máximo del RDD importes?

val importesMin = importes.max

val importesMax = importes.min

// c. Obtenga los 15 mayores valores del RDD importes. Tenga en cuenta que pueden repetirse los valores.

val importesMax15 = importes.top(15)

// d. Por último, escriba en la ruta /FileStore/seccion5 un fichero de texto con los importes mayores a 50. Asegúrese de que se escriba solo un fichero de texto en la dirección indicada.

val importes50 = importes.coalesce(1).map(_.toInt).filter(_ > 50)

val importes50dos = importes.filter(_.toInt > 50).coalesce(1).saveAsTextFile("/FileStore/seccion5/ejercicioRdd")

importes50.saveAsTextFile("/FileStore/seccion5/ejercicioRdd")

dbutils.fs.ls("/FileStore/seccion5/ejercicioRdd")

// 2. Cree una función llamada factorial que calcule el factorial de un número entero mayor o igual a cero que se le proporcione como parámetro. Utilice RDDs para el cálculo.

def factorial(num: Int): Int = {
  if (num == 0){
    1
  }else{
    sc.parallelize(1 to num).reduce(_ * _)
  }
}

factorial(0)

// 3. Cree una función llamada sumaImpar que dado un entero n > 1, devuelva la suma de los números impares en el intervalo [1, n]. Utilice RDDs para el cálculo.

def sumaImpar(num: Int): Int = {
  sc.parallelize(1 to num).filter(_%2 != 0).reduce(_ + _)
}

sumaImpar(0)
