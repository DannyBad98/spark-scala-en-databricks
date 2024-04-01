// Broadcast Variable
// Las variables broadcast son variables compartidas entre todos los ejecutores. Estas se crean una vez en el controlador y luego se leen solo en los ejecutores.

val sc = spark.sparkContext

val uno = 1

// Se crea la variable broadcast con el nombre brUno y el valor de 1
val brUno = sc.broadcast(uno)

// con esta sentencia se puede visualizar el valor de la variable broadcast
brUno.value

// Le sumamos un uno a la variable broadcast
brUno.value + 1

// Destruimos la variable
brUno.destroy

// La siguiente linea marcaria error porque brUno se destruyo previamente.
brUno.value + 1
