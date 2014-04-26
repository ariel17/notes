========================================
 Exposición: Algoritmos de ordenamiento
========================================

Algoritmos que se expondrán
    + Quicksort_
    + Heapsort_
    + Mergesort_

Fecha de exposición
    2014-04-30

Introducción
============

- TODO: Qué son.
- TODO: Cuándo se aplica.

Quicksort_
==========

La función de este algoritmo es ordenar una lista de elementos del mismo tipo y
está basado en la técnica "divide y vencerás", de modo que convierte un
problema complicado, en muchos sencillos, pero además es el más rápido conocido
para hacer esta tarea. Está matemáticamente demostrado que no se puede hacer un
algoritmo de ordenación más rápido que Quicksort.

Su autor
--------

.. figure:: _static/img/CAR_Hoare.jpg
   :width: 300 px
   :align: center

   Charles Antony Richard Hoare

Su autor es **Charles Antony Richard Hoare** (Tony Hoare), nacido en Colombo,
Sri Lanka, el 11 de enero de 1934. Es un científico en computación que también
se lo conoce por otros trabajos:

* Desarrollo de la *Lógica de Hoare*.
* Creación del lenguaje formal CSP.

Descubrió el algoritmo Quicksort en 1960 intentando facilitar la búsqueda de
palabras en el diccionario. Actualmente trabaja como investigador senior para
Microsoft en Cambridge.

Estrategia
----------

El algoritmo trabaja de la siguiente forma:

* Elegir un elemento de la lista de elementos a ordenar, al que llamaremos
  **pivote**.
* Resituar los demás elementos de la lista a cada lado del pivote, de manera
  que a un lado queden todos los menores que él, y al otro los mayores. Los
  elementos iguales al pivote pueden ser colocados tanto a su derecha como a su
  izquierda, dependiendo de la implementación deseada. En este momento, el
  pivote ocupa exactamente el lugar que le corresponderá en la lista ordenada.
* La lista queda separada en dos sublistas, una formada por los elementos a la
  izquierda del pivote, y otra por los elementos a su derecha.
* Repetir este proceso de forma recursiva para cada sublista mientras éstas
  contengan más de un elemento. Una vez terminado este proceso todos los
  elementos estarán ordenados.

.. figure:: _static/img/Sorting_quicksort_anim.gif
   :width: 400 px
   :align: center

   Quicksort en acción

Escenarios
----------

La eficiencia del algoritmo depende de la posición en la que termine el pivote
elegido.

* En el mejor caso, el pivote termina en el centro de la lista, dividiéndola en
  dos sublistas de igual tamaño. En este caso, el orden de complejidad del
  algoritmo es :math:`O(n*log n)`.

.. figure:: _static/img/nlogn.png
   :width: 600 px
   :align: center

   Complejidad :math:`O(n*log n)`

* En el peor caso, el pivote termina en un extremo de la lista. El orden de
  complejidad del algoritmo es entonces de :math:`O(n^2)`. El peor caso
  dependerá de la implementación del algoritmo, aunque habitualmente ocurre en
  listas que se encuentran ordenadas, o casi ordenadas. Pero principalmente
  depende del pivote, si por ejemplo el algoritmo implementado toma como pivote
  siempre el primer elemento del array, y el array que le pasamos está
  ordenado, siempre va a generar a su izquierda un array vacío, lo que es
  ineficiente.

.. figure:: _static/img/n2.png
   :width: 600 px
   :align: center

   Complejidad :math:`O(n^2)`

Implementación
--------------

Eligiendo el Pivote
```````````````````

La elección del pivote ``v`` determina las particiones de la lista ``L`` de
datos; estas particiones van a estar conformadas de la siguiente manera:

* ``L1``: Contiene todos los elementos de ``L`` menos ``v`` que sean menores o
  iguales que ``v``.
* ``L2``: Contiene a ``v``.
* ``L3``: Contiene todos los elementos de ``L`` menos ``v`` que sean mayores o
  iguales que ``v``.

Es importante intentar que al seleccionar el pivote v las particiones ``L1`` y
``L3`` tengan un tamaño idéntico dentro de lo posible.

Elegir el primero o el último de la lista nunca es una buena idea ya que los
elementos de la lista no están uniformemente distribuidos. Por otro lado, si
contamos con un buen generador de números aleatorios, podemos elegir un pivote
al azar de entre todos los elementos de la lista. Esta estrategia es segura
puesto que es improbable que un pivote al azar de como resultado una partición
mala, pero tiene como contrapartida que en algunas ocasiones si puede arrojar
un resultado de :math:`O(n^2)`, además, la elección de números aleatorios puede
incrementar el tiempo de ejecución del algoritmo.

Una buena estrategia para solucionar la selección del pivote ámpliamente
extendida es la conocida como “a tres bandas”. En esta estrategia lo que se
persigue es hacer una media con los valores de tres de los elementos de la
lista. Por ejemplo si nuestra lista es ``[ 8, 4, 9, 3, 5, 7, 1, 6, 2 ]`` la
media sería :math:`( 8 + 2 + 5 ) / 3 = 5` lo que daría lugar a las siguientes
particiones::

   L1 = [ 8, 9, 7, 6 ]
   L2 = [ 5 ]
   L3 = [ 1, 2, 4, 3 ]

Esta estrategia no nos asegura que siempre nos dará la mejor selección del
pivote, sino que estadísticamente, la elección del pivote sea buena.

Implementación en Java
``````````````````````

- TODO ejemplo de implementación.

Having fun with Quicksort (?)
=============================



Heapsort_
=========

- TODO en qué consiste.
- TODO quién lo creó.
- TODO complejidad.
- TODO mejores escenarios.
- TODO peores escenarios.
- TODO ejemplo de implementación.

Mergesort_
==========

- TODO en qué consiste.
- TODO quién lo creó.
- TODO complejidad.
- TODO mejores escenarios.
- TODO peores escenarios.
- TODO ejemplo de implementación.

Bibliografía
============

#. Wikipedia

  + C. A. R. Hoare: http://es.wikipedia.org/wiki/C._A._R._Hoare
  + Quicksort: http://es.wikipedia.org/wiki/Quicksort

#. Blogs

  + Implementando el algoritmo Quicksort: http://www.genbetadev.com/algoritmos/implementando-el-algoritmo-quicksort 
