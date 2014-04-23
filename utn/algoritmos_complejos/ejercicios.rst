============
 Ejercicios
============

Fibonacci
=========

#. ¿Por qué tarda tanto una clase que calcula la serie de Fibonacci?
#. ¿Cómo se podría resolver para que no tarde tanto?
#. Implementar Fibonacci.
#. ¿Cuánto tiempo tardaría la ejecución si se pide un Fibonacci de 100? Estimar.

Implementación de Fibonacci
---------------------------

.. literalinclude:: _src/fibonacci/src/ar/com/ariel17/fibonacci/Fibonacci.java
   :language: java
   :linenos: 

Permutaciones
=============

Hacer un programa que realice todas las permutaciones de una cadena.

Implementación de permutación de cadenas
----------------------------------------

.. literalinclude:: _src/permutation/src/ar/com/ariel17/permutation/Permutation.java
   :language: java
   :linenos: 

Árboles
=======

Desarrollar una clase que implementa un árbol n-ario para descomponer cadenas
de caracteres.

Cada nodo debe almacenar un carácter (info) más un conjunto de n nodos del
mismo tipo.

El árbol (o clase que lo administre) deberá tener un método procesarCadena que
reciba una cadena de caracteres y posicione cada uno de sus caracteres según se
observa en la planilla que adjunto.

La clase debe tener un segundo método llamado obtenerResultados que, reciba
parte un prefijo y retorne todas las cadenas que comienzan con dicho prefijo.

Según los datos del ejemplo que pueden ver en el excel adjunto, si se invoca al
método obtenerResultados pasándole el prefijo "PA" entonces el método debe
retornar un conjunto de datos conteniendo las cadenas "PABLO", "PAULA" y
"PAULINA". Y si el prefijo fuese "P" entonces a la lista resultante se
agregaría "PEDRO".

:download:`Descargar la estructura de árbol a cumplir <_static/doc/Ejemplo-Arbol-n-ario.xls>`

Implementación de árbol
-----------------------

.. literalinclude:: _src/tree/src/ar/com/ariel17/tree/Node.java
   :language: java
   :linenos: 

.. literalinclude:: _src/tree/src/ar/com/ariel17/tree/Tree.java
   :language: java
   :linenos: 

