# Shuffling (mexcla de datos)

Es el proceso de redistribuir o reorganizar data atraves de las particiones de un dataset distribuido.

Cualquiera que sea el particionador usado, muchas operaciones (tales como, groupBy, Join, repartition y distinct) provocaran el shuffling, en el shuffling se pueden crear nuevas particiones, fusionar o eliminar, todo movimiento necesario para el reparticionamiento se denomina shuffling. Este puede causar un gran impacto en el rendimiento. por dos razones principales, por la transferencia de datos a traves de la red y por la reorganizacion de registros. Es vital minimizar el numero de shuffles que ocurren en un job.

Recursos: 

https://www.youtube.com/watch?v=ffHboqNoW_A



 
