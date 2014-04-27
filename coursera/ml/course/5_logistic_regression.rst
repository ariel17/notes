=====================
 Logistic Regression
=====================

Classification
==============

.. math::
   y \in {0, 1}

Using plain linear regression applied to a classification problem usually is
not a good idea.

Consecuences
------------

:math:`h_{\theta}(x)` can be > 1 or < 0.

A Logistic Regression alternative must be used to contain:
        
.. math::
   0 \leq h_{\theta}(x) \leq 1
          
Hypothesis Representation
=========================

Logistic Regression Model
-------------------------

Want :math:`0 \leq h_{\theta}(x) \leq 1`:

.. math::
   h_{\theta}(x) = g(\theta^{T}x) \wedge g(z) = \frac{1}{1+e^{-z}} \Rightarrow
   g(z) = \frac{1}{1+e^{-\theta^{T}x}}

:math:`g(z)` is the **Sigmoid function** or **Logistic function**.

Interpretation of Hypothesis Output
-----------------------------------

:math:`h_{\theta}(x)` = estimated probability that y = 1 on input x

Decision boundary
=================

TODO

Cost function
=============

TODO

Simplified cost function and gradient descent
=============================================

TODO

Advanced optimization
=====================

TODO

Multiclass classification: One-vs-all
======================================

TODO
