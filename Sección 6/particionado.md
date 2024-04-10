# Particionado

Los RDD operan con datos no como una sola masa de datos, sino que administran y operan los datos en particiones repartidas por todo el cluster

Las operaciones de los datos se realizan dentro de las particiones, sin embargo, operaciones como las agregaciones no pueden realizarse aisladas de los datos, por lo que se realiza el shuffle, que es la etapa en la que los datos se mueven a traves del cluster.

El numero de particiones es importante porque influye en el numero de tareas que ejecutan transformaciones en el RDD.

- Si la cantidad de particiones es demasiado pequeña, usaremos solo unas pocas CPU/nucleos en una gran cantidad de datos, por lo que tendremos un rendimiento mas lento y dejaremos el cluster subutilizado
- Si la cantidad de particiones es demasiado grande, utilizara mas recursos de los que realmente necesita y, en un entorno de multiples procesos, podria estar provocando la falta de recursos para otros procesos que usted u otros miembros de su equipo ejecutan.

## Particionadores

Asignan un indice de particion a los elementos del RDD. Todos los elementos de la misma particion tendran el mismo indice de particion.

Spark cuenta con dos particionadores:
- HashPartitiones
- RangePartitioner
- Adicional, puede implementar uno personalizado

💡 **Tip**: El numero ideal de particiones con las que debes trabajar depende del numero de core que tengamos disponibles en nuestro entorno de trabajo
