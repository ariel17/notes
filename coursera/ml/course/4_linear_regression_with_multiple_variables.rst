===========================================
 Linear regression with multiple variables
===========================================

Multiple features
=================

==================================== ==================== ================== ===================== ===============================
 Size in :math:`feet^2` (:math:`x`)   Number of bedrooms   Number of floors   Age of home (years)   Price in \$1000's (:math:`y`)
==================================== ==================== ================== ===================== ===============================
 2104                                 5                    1                  45                    460
 1416                                 3                    2                  40                    232
 1534                                 3                    2                  30                    315
 852                                  2                    1                  36                    178
 ...                                  ...                  ...                ...                   ...
==================================== ==================== ================== ===================== ===============================

Notation
  * :math:`n` = number of features
  * :math:`x^{(i)}` = input (features) of :math:`i^{th}` training example.
  * :math:`x^{(i)}_{j}` = value of feature :math:`j` in :math:`i^{th}` training
    example.

.. math::
      n = 4

      m = 47

      x^{(2)} = \begin{bmatrix}
                  1416 \\
                  3 \\
                  2 \\
                  40 \\
                \end{bmatrix}

      x^{(2)}_3 = 2

Hypothesis
----------

.. math::
   h_{\theta}(x) = \theta_{0} + \theta_{1}x_{1} + \theta_{2}x_{2} + \ldots +
   \theta_{n}x_{n}

For convenience of notation, define :math:`x_{0} = 1`.

.. math::
   x = \begin{bmatrix}
         x_{0} \\
         x_{1} \\
         x_{2} \\
         \vdots \\
         x_{n} \\
       \end{bmatrix} \in \mathbb{R}^{n+1} \ \ \ \ \ 
       \theta = \begin{bmatrix}
                  \theta_{0} \\
                  \theta_{1} \\
                  \theta_{2} \\
                  \vdots \\
                  \theta_{n} \\
                \end{bmatrix} \in \mathbb{R}^{n+1}

   h_{\theta}(x) = \theta_{0}x_{0} + \theta_{1}x_{1} + \ldots +
   \theta_{n}x_{n} = \theta^{T}x =
   \begin{bmatrix}
     \theta_{0} & \theta_{1} & \theta_{2} & \vdots & \theta_{n}
   \end{bmatrix}
   \begin{bmatrix}
     x_{0} \\
     x_{1} \\
     x_{2} \\
     \vdots \\
     x_{n} \\
   \end{bmatrix}

Also named **Multivariate linear regression**.

Gradient descent for multiple variables
=======================================

* **Hypothesis:** :math:`h_{\theta}(x) = \theta^{T}x = \theta_{0}x_{0} +
  \theta_{1}x_{1} + \ldots + \theta_{n}x_{n}`
* **Parameters:** :math:`\theta_{0}, \theta_{1}, \ldots, \theta_{n}`
* **Cost function:** :math:`J(\theta_{0}, \theta_{1}, \ldots, \theta_{n}) =
  J(\theta) = \frac{1}{2m}\sum\limits_{i=1}^{m}(h_{\theta}(x^{(i)}) -
  y^{(i)})^{2}`
* **Gradient descent:**

.. math::  
   Repeat \{

   \ \ \theta_{j} := \theta_{j} -
                     \alpha\frac{\partial}{\partial\theta_{j}}
                     J(\theta_{0}, \ldots, \theta_{n}) =
                     \theta_{j} - \alpha\frac{\partial}{\partial\theta_{j}}
                     J(\theta) =
                     \theta_{j} - \alpha\frac{1}{m}
                     \sum\limits_{i=1}^{m}(h_{\theta}(x^{(i)})) - y^{(i)})x^{(i)}_{j}

   \} \ \ (simultaneously update for every j = 0, \ldots, n)

Developing the derivate for :math:`n \geq 1`:

.. math::
   Repeat \{
   \ \ \theta_{j} := \theta_{j} - \alpha\frac{1}{m}
                     \sum\limits_{i=1}^{m}(h_{\theta}(x^{(i)}) - y^{i}x^{(i)}_{j}

   \} \ \ \ (simultaneously update \theta_{j} for j = 0, \ldots, n)

Gradient descent in practice I: Feature scaling
===============================================

Make sure features are on similar scale
---------------------------------------

Example:

.. math::
   x_{1} = size (0-2000 feet^{2})

   x_{2} = number of bedrooms (1-5)

The elipses can be very skiny and gradient descent can take a lot of time to
reach the local minimum.

.. math::
   x_{1} = \frac{size (feet^{2})}{2000} \implies 0 \leq x_{1} \leq 1

   x_{2} = \frac{number of bedrooms}{5} \implies 0 \leq x_{2} \leq 1

The elipses are now less tall and the convergence can be reached much faster.

Get every feature approximately a :math:`-1 \leq x_{i} \leq 1`
--------------------------------------------------------------

.. math::
   0 \leq x_{1} \leq 3 \checkmark

   -2 \leq x_{1} \leq 0.5 \checkmark

   -100 \leq x_{1} \leq 100 \text{\sffamily X}

Mean normalization
------------------

Replace :math:`x_{i}` with :math:`x_{i} - \mu_{i}` to make features have
approximately zero mean (do not apply to :math:`x_{0} = 1`).

Example:

.. math::
   x_{1} = \frac{size - 1000}{2000} \ \ Average: size = 100
   
   x_{2} = \frac{\#bedrooms - 2}{5} \ \ 1 - 5 bedrooms
   
   -0.5 \leq x_{1} \leq 0.5, -0.5 \leq x_{2} \leq 0.5

Generally:

.. math::
   x_{i} = \frac{x_{i} - \mu{i}}{s_{i}}
   
   \mu_{i} = average value of x_{i} in training set.
   
   s_{i} = range of values (max - min, or standard deviation).

Gradient descent in practice II: learning rate
==============================================

Making sure gradient descent is working correctly
-------------------------------------------------

Example automatic convergence test:

Declare convergence if :math:`J(\theta)` decrases by less than :math:`10^{-3}`
in one iteration.

If plot graphic is increasing, then the algorithm is not working. **Use a
smaller :math:`\alpha`**.

Facts
'''''

* For sufficiently small :math:`\alpha`, :math:`J(\theta)` should decrease on
  every iteration.
* But if :math:`\alpha` is too small, gradient descent can be slow to converge.

Recomendation
'''''''''''''

To choose :math:`\alpha`, try: :math:`\ldots, 0.001, 0.01, 0.1, 1, \ldots`
Factors of it

To make sure that a value is too short or a value is too large.

Features and polynomial regression
==================================

Changing to new features
------------------------

.. math::
   h_{\theta}(x) = \theta_{0} + \theta_{1} \times frontage + \theta_{2} \times
   depth

   frontage = x_{1}, depth = x_{2} \implies area = frontage \times depth

   h_{\theta}(x) = \theta_{0} + \theta_{1}area

Polynomial regression
---------------------

.. math::
   Price = y
   Size = x

Using :math:`\theta_{0} + \theta_{1}x + \theta_{2}x^{2}` may match the initial
value but the cuadratic function tends to back to zero, so it is not the
behavior expected for increasing values.

Changing the model to a cubic function:

.. math::
   h_{\theta}(x) = \theta_{0} + \theta_{1}x + \theta_{2}x^{2} + \theta_{3}x_{3}
                 = \theta_{0} + \theta_{1}(size) + \theta_{2}(size)^{2} +
                   \theta_{3}(size)^{3}

Scaling features is important because values can be increase quickly.

Other solution can be:

.. math::
   h_{\theta}(x) = \theta_{0} + \theta_{1}(size) + \theta_{2}\sqrt{size}

Normal equation
===============

It is a method to solve for :math:`\theta` analytically.

Intuition
---------

If 1D (:math:`\theta \in \mathbb{R}`)
'''''''''''''''''''''''''''''''''''''

.. math::
   J(\theta) = a\theta^{2} + b\theta + c

Obtaining the minimum: solve for
:math:`\frac{\partial}{\partial\theta}J(\theta) = \ldots = 0`

If nD (:math:`\theta \in \mathbb{R}^{n+1}`)
'''''''''''''''''''''''''''''''''''''''''''

.. math::
   J(\theta_{0}, \theta_{1}, \ldots, \theta_{m}) =
   \frac{1}{2m}\sum\limits_{i=1}^{m}(h_{\theta}(x^{(i)})-y^{(i)})^{2}

Obtaining the minimum: solve for
:math:`\frac{\partial}{\partial\theta}J(\theta) = \ldots = 0` (for every
:math:`j`)

Solve for :math:`\theta_{0}, \theta_{1}, \ldots, \theta_{n}`

Example
'''''''

:math:`m = 4`

+---------------+-------------------------+--------------------+------------------+---------------------+----------------+
|               | Size (:math:`feet^{2}`) | Number of bedrooms | Number of floors | Age of home (years) | Price (\$1000) |
+---------------+-------------------------+--------------------+------------------+-------------------+------------------+
| :math:`x_{0}` | :math:`x_{1}`           | :math:`x_{2}`      | :math:`x_{3}`    | :math:`x_{4}`     | :math:`y`        |
+===============+=========================+====================+==================+===================+==================+
| 1             | 2104                    | 5                  | 1                | 45                | 460              |
+---------------+-------------------------+----------------------+------------------+-------------------+----------------+
| 1             | 1416                    | 3                  | 2                | 40                  | 232            |
+---------------+-------------------------+----------------------+------------------+-------------------+----------------+
|       1       | 1534                    | 3                  | 2                | 30                  | 315            |
+---------------+-------------------------+----------------------+------------------+-------------------+----------------+
|       1       | 852                     | 2                  | 1                | 36                  | 178            |
+---------------+-------------------------+--------------------+------------------+---------------------+----------------+

Using the values from features to create the :math:`X` matrix:

.. math::
   X = \begin{bmatrix}
         1 & 2104 & 5 & 1 & 45 \\
         1 & 1416 & 3 & 2 & 40 \\
         1 & 1534 & 3 & 2 & 30 \\
         1 & 852 & 2 & 1 & 36  \\
       \end{bmatrix} \ \ \ m \times (n+1)

And using the values on last column to create the vector :math:`y`:

.. math::
   X = \begin{bmatrix}
         460 \\
         232 \\
         315 \\
         178 \\
       \end{bmatrix} \ \ \ m-dimensional vector

:math:`\theta = (X^{T}X)^{-1}X^{T}y \ \ \Leftarrow` The value of :math:`\theta`
that minimize the cost function.

When to use Gradient Descent or Normal Ecuation
'''''''''''''''''''''''''''''''''''''''''''''''

For :math:`m` training examples, :math:`n` features:

Gradient Descent
  - Need to choose :math:`\alpha`.
  - Needs many iterations.
  - Works well even when :math:`n` is large.

Normal Ecuation
  - No need to choose :math:`\alpha`.
  - Don't need toiterate.
  - Slow if :math:`n` is very large.

Normal equation and non-invertibility
=====================================

What if :math:`X^{T}T` is non-invertible?
-----------------------------------------

* Redundant features (linearly dependent): e.g.
  :math:`x_{1} = size in feet^{2}; x_{2} = size in m^{2}`
* Too many features (e.g. :math:`m \leq n`): delete some features or use
  regularization.
