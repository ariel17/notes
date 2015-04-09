Diseño de Sistemas
==================

Data Warehouse
--------------

Almacén de datos históricos sumarizados.

.. code-block:: text

   Business Inteligence
          |
          +---- DW: - Indicadores: ¿Qué queremos medir?
          |         - Dimensiones (ventas, comisiones, etc)
          |
          +---- Data Mining


.. code-block:: text
                                                                     
      Sistemas
    operacionales                        E. T. L.           D.W.  <--
   --------------- ===============> ---------------  ====>        <-- OLAP
     datos fuente  Proceso de carga  - Extraen                    <-- 
                                     - Transforman
                                     - Cargan

Data Mining
-----------

Descubrir patrones de comportamiento en los datos aplicando algún algoritmo.

CRM
---

Es una estrategia que permite administrar todas las relaciones con los 
clientes.

.. code-block:: text

   Ventas ---------
                   \ +-------------+
   Servicio -------- |Cliente único|
                   / +-------------+
   Marketing ------     |
                        |
                   Multimedios

ERP
---

Da soporte a las operaciones de backoffice. 
