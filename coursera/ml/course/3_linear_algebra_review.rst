=======================
 Linear algebra review
=======================

Matrices and vectors
====================

Matrix
------

**Definition**
  Rectangular array of numbers.

.. math::
   A = \begin{bmatrix}
         1 & 2 & 3 \\
         4 & 5 & 6 \\
       \end{bmatrix}

**Dimension of matrix**
  Number of rows :math:`\times` number of columns.
        
This example has **2 rows** and **3 columns** and it contains Real numbers, so
it can be represented as :math:`\mathbb{R}^{2\times3}`.

Matrix elements
```````````````

:math:`A_{ij} = i,j \ entry`; in the :math:`i` row, :math:`j` column. Examples:

.. math::

   A_{11} = 1

   A_{23} = 6

Vector
------

Definition
  An :math:`n \times 1` matrix.

.. math::
   y = \begin{bmatrix}
         460 \\
         232 \\
         315 \\
         178 \\
       \end{bmatrix}

A 4-dimensional vector; :math:`\mathbb{R}^4`

Vector elements
```````````````

.. math::
   y_{i} = i element

Example:

.. math::
   y_{1} = 460

   y_{3} = 315


Conventions for the course
==========================
          
Naming
  Uppercase letters for matrix naming and lowercase letter for vectors.
1-indexed vs 0-indexed
  The course will use \textbf{1-indexed} vectors unless other condition is
  indicated.

Addition and scalar multiplication
==================================

Matrix addition
---------------

.. math::
   \begin{bmatrix}
     1 && 0 \\
     2 && 5 \\
     3 && 1 \\
   \end{bmatrix} + \begin{bmatrix}
                     4 && 0.5 \\
                     2 && 5 \\
                     0 && 1 \\
                   \end{bmatrix} = \begin{bmatrix}
                                     5 && 0.5 \\
                                     4 && 10 \\
                                     2 && 3 \\
                                   \end{bmatrix}

Both matrix participating on addition matchs on dimension and the result is
another matrix with the same dimention.

.. math::
   \mathbb{R}^{3\times2} + \mathbb{R}^{3\times2} = \mathbb{R}^{3\times2}

Addition between matrix of different dimension cannot be done:

.. math::
   \mathbb{R}^{3\times2} + \mathbb{R}^{2\times2} = Error

Scalar multiplication
---------------------

Scalar = Real number.

.. math::
   3 \times \begin{bmatrix}
              1 && 0 \\
              2 && 5 \\
              3 && 1 \\
            \end{bmatrix} = \begin{bmatrix}
                              3 && 0 \\
                              6 && 15 \\
                              9 && 3 \\
                            \end{bmatrix}

   \begin{bmatrix}
     4 && 0 \\
     6 && 3 \\
   \end{bmatrix} \div 4 = \begin{bmatrix}
                            1 && 0 \\
                            3/2 && 3/4 \\
                          \end{bmatrix}

   \mathbb{R} \times \mathbb{R}^{n \times m} = \mathbb{R}^{n \times m}

Matrix-vector multiplication
----------------------------

.. math::
   \begin{bmatrix}
     1 && 3 \\
     4 && 0 \\
     2 && 1 \\
   \end{bmatrix}
   \begin{bmatrix}
     1 \\
     5 \\
   \end{bmatrix} =  \begin{bmatrix}
                      16 \\
                      4 \\
                      7 \\
                    \end{bmatrix} = r

   r_{11} = 1 \times 1 + 3 \times 5 = 16
   
   r_{21} = 4 \times 1 + 0 \times 5 = 4

   r_{31} = 2 \times 1 + 1 \times 5 = 7

The multiplication of matrix with different dimensions produces another matrix
with a mix of them:

.. math::
   \mathbb{R}^{\textbf{3} \times 2} \times \mathbb{R}^{2 \times \textbf{1}} =
   \mathbb{R}^{\textbf{3} \times \textbf{1}}

Generalizing:

.. math::
   \mathbb{R}^{\textbf{a} \times b} \times \mathbb{R}^{c \times \textbf{d}} =
   \mathbb{R}^{\textbf{a} \times \textbf{d}}

   Matrix \times vector = vector

Performing a function as a matrix multiplication
------------------------------------------------

Function:

.. math::
   h_{\theta}(x) = -40 + 0.25x

Function domain:

.. math::
   D_{h_{\theta}} = {2104, 1416, 1534, 852}

As a matrix multiplication:

.. math::
   \begin{bmatrix}
     1 & 2104 \\
     1 & 1416 \\
     1 & 1534
     1 & 852 \\
   \end{bmatrix} \times \begin{bmatrix}
                          -40 \\
                          0.25 \\
                        \end{bmatrix} = \begin{bmatrix}
                                          -40 \times 1 + 0.25 \times 2104 \\
                                          -40 \times 1 + 0.25 \times 1416 \\
                                          -40 \times 1 + 0.25 \times 1534 \\
                                          -40 \times 1 + 0.25 \times 852 \\
                                        \end{bmatrix}

This is computationally more efficient to resolve this kind of problems this
way:

.. line-block::
   prediction = DataMatrix * parameters

than this way:

.. line-block::
   for i:=1, 1000, ...,
       prediction = ...

Matrix-matrix multiplication
----------------------------

.. math::
   \begin{bmatrix}
     1 & 3 & 2 \\
     4 & 0 & 1 \\
   \end{bmatrix}
   \begin{bmatrix}
     1 & 3 \\
     0 & 1 \\
     5 & 2 \\
   \end{bmatrix} = \begin{bmatrix}
                     11 & 10 \\
                     9 & 14 \\
                   \end{bmatrix}

   \mathbb{R}^{2 \times 3} \times \mathbb{R}^{3 \times 2} =
   \mathbb{R}^{2 \times 2}

   \begin{bmatrix}
     1 & 3 & 2 \\
     4 & 0 & 1 \\
   \end{bmatrix}
   \begin{bmatrix}
     1 \\
     0 \\
     5 \\
   \end{bmatrix} = \begin{bmatrix}
                     11 \\
                     9 \\
                   \end{bmatrix}

   \begin{bmatrix}
     1 & 3 & 2 \\
     4 & 0 & 1 \\
   \end{bmatrix}
   \begin{bmatrix}
     3 \\
     1 \\
     2 \\
   \end{bmatrix} = \begin{bmatrix}
                     10 \\
                     14 \\
                   \end{bmatrix}

   A \times B = C

* :math:`A` is a :math:`m \times n` matrix.
* :math:`B` is a :math:`n \times o` matrix.
* :math:`C` is a :math:`m \times o` matrix.

To be able to multiply, the number :math:`n` or rows on :math:`B` matrix must
match the number of columns :math:`n` on :math:`A` matrix.

.. math::
   C_{i} = A \times B_{i}

Performing multiple functions as a matrix multiplication
--------------------------------------------------------

Functions
  * :math:`h_{\theta}(x) = -40 + 0.25x`
  * :math:`h_{\theta}(x) = 200 + 0.1x`
  * :math:`h_{\theta}(x) = -150 + 0.4x`

Function domain:
  :math:`D_{h_{\theta}} = {2104, 1416, 1534, 852}`

As a matrix multiplication:
  .. math::
     \begin{bmatrix}
       1 & 2104 \\
       1 & 1416 \\
       1 & 1534
       1 & 852 \\
     \end{bmatrix} \times \begin{bmatrix}
                            -40 & 200 & -150 \\
                            0.25 & 0.1 & 0.4 \\
                          \end{bmatrix} = \begin{bmatrix}
                                            486 & 410 & 692 \\
                                            314 & 342 & 416 \\
                                            344 & 353 & 464 \\
                                            173 & 285 & 191 \\
                                          \end{bmatrix}

Matrix multiplication properties
--------------------------------

* **Not conmutative:** :math:`A, B`; matrices. In general, :math:`A \times B
  \neq B \times A`.
* **Associative:** :math:`A \times (B \times C) = (A \times B) \times C`
* **Identity matrix:** Denoted by :math:`I` or :math:`I_{n \times n}`. It has
  :math:`1` in the diagonal and :math:`0` on any other position. Example of a
  :math:`I_{3 \times 3}`:

.. math::
   \begin{bmatrix}
     1 & 0 & 1 \\
     0 & 1 & 0 \\
     0 & 0 & 1 \\
   \end{bmatrix}

For any matrix A: :math:`A \times I = I \times A = A`

Inverse and transpose
=====================

Inverse
-------

.. math::
   1 = Identity

Given a number, multiply it to another one to obtain the identity:

.. math::
   3 \times (3^{-1}) = 3 \times \frac{1}{3} = 1

Not all numbers have an inverse: :math:`0^{0} = undefined`

Matrix inverse
--------------

If A is a :math:`m \times m` matrix (square matrix), and if it has an inverse:

.. math::
   A(A^{-1}) = A^{-1}A = I

* Only square matrix can have an inverse.
* Matrices that don't have an inverse are some kind too close to zero.
* Matrices that don't have an inverse are "singular" or "degenerate".

Matrix transpose
----------------

.. math::
   A = \begin{bmatrix}
         1 & 2 & 0 \\
         3 & 5 & 9 \\
       \end{bmatrix} \Rightarrow A^{T} = \begin{bmatrix}
                                           1 & 3 \\
                                           2 & 5 \\
                                           0 & 9 \\
                                         \end{bmatrix}

Let :math:`A` be an :math:`m \times n` matrix, and let :math:`B = A^{T}`. Then
:math:`B` is an :math:`n \times m` matrix and :math:`B_{ij} = A_{ji}`.

Example:

.. math::
   B_{12} = A_{21} = 2
