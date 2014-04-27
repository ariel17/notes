================================
 Machine learning system design
================================

Priorizing what to work on: Spam classification example
=======================================================

Building a spam classifier
--------------------------

Supervised learning. :math:`x =` features of email. :math:`y =` spam (1) or not
spam (0).

Features :math:`x`: Choose 100 words indicative of spam/not spam; example:
deal, buy, discount, andrew, now, ...

But in practice, take most frequently ocurring :math:`n` words (10000 to 50000)
in training set, rather than manually pick 100 words.

.. math::
   x \in \mathbb{R}^{100}

   x_{j} = 
     \left\{
       \begin{array}{ll}
         1 & \mbox{if word j appears in email} \\
         0 & \mbox{otherwise}
       \end{array}
     \right.

.. code:: text

   How many matches are in an incoming email?

        /  0  \  andrew
        |  1  |  buy
        |  1  |  deal
   x =  |  0  |  discount
        | ... |  ...
        |  1  |  now
        \ ... /  ...

        (^ array)

How to spend your time to make it have low error?

- Collect lots of data; example: "honeypot" project.
- Develop sophisticated features based on email routing information (from email
  header).
- Develop sophisticated features for message body, e.g. should "discount" and
  "discounts" be treated as the same word? How about "deal" and "Dealer"?
  Features about punctuation?
- Develop sophisticated algorithm to detect misspellings (e.g. m0rtagage,
  med1cine, w4tches).

Error analysis
==============

Recommended approach
--------------------

- Start with a simple algorithm that you can implement quickly (~24 hs).
  Implement it and test it on your cross-validation data.
- Plot learning curves to decide if more data, more features, etc. are likely
  to help.
- Error analysis: Manually examine the examples (in cross validation set) that
  your algorithm made errors on. See if you spot any systematic trend in what
  type of examples it is making errors on.

Error analysis
--------------

#. :math:`m_{cv} =` 500 examples in cross validation set
#. Algorithm misclassifies 100 emails.
#. Manually examine the 100 errors, and categorize them based on:

  + What type of email it is. Categorize them and count them.
  + What cues (features) you think would have helped the algorithm classify
    them correctly.

Possible result of this analysis:

#. Pharma: 12 :math:`\Rightarrow` Deliberate misspellings: 5
#. Replica/fake: 4 :math:`\Rightarrow` (m0rgage, med1cine, etc.)
#. Steal password: 53 :math:`\Rightarrow` Unusual email routing: 16
#. Other: 31 :math:`\Rightarrow` Unusual (spamming) punctuation: 32

The importance of numerical evaluation
--------------------------------------

Should discount/discounts/discounted/discounting be treated as the same word?
For acomplish this, you can use "stemming" software (E.g. "porter stemmer"),
but error analysis may not be helpful for deciding if this is likely to improve
performance. Only solution is **to try it and see if it works**. So you will
need numerical evaluation (e.g., cross validation error) of algorithm's
performance with and without stemming:

* Without stemming: 5% error; with stemming: 3% error
* Distinguish upper vs. lower case (Mom/mom): 3.2%

It is very recommended to run numerical evaluations on the cross validation
set.

Error metrics for skewed classes
================================

Cancer classification example
-----------------------------

Train logistic regression model :math:`h_{\theta}(x)` (:math:`y = 1` if cancer,
:math:`y = 0` otherwise).

Find that you got 1% error on test set (99% correct diagnoses)

Only 0.5% of patients have cancer.

.. code-block:: octave

   :linenos:

   function y = predictCancer(x)
       y = 0;  % ignore x! -> 0.5% error is better than 1% error as before
   return

The negative examples is very close to one extreme, so the positive examples
are very much smaller than the negative examples; this is a **skewed class**.

Precision/Recall
----------------

:math:`y = 1` in presence of rare class that we want to detect

.. code:: text

                                        
                     Actual class

                 |    1     |    0     |
              ---+----------+----------+
                 |   True   |  False   |
   Predicted   1 | positive | positive |
     class    ---+----------+----------+
                 |  False   |   True   |
               0 | negative | negative |
              ---+----------+----------+

Another way to calculate the preformance of the algorithm is to compute 2
numbers:

Precission
``````````

Of all patients where we predicted :math:`y = 1`, what fraction actually has
cancer?

.. code:: text

       True positives                 True positive
   ----------------------- = ----------------------------------
     #predicted positive       True positive + False positive

Recall
``````

Of all patients that actually have cancer, what fraction did we correctly
detect as having cancer?

.. code:: text

     True positives                  True positive
   --------------------- = ----------------------------------
     #actual positives       True positive + False negative

Backing to the algorithm :math:`y = 0`:

.. math::
   y = 0 \Rightarrow recall = 0

Trading off precision and recall
================================

Logistic regression: :math:`0 \leq h_{\theta}(x) \leq 1`

- Predict 1 if :math:`h_{\theta}(x) \geq 0.5`
- Predict 0 if :math:`h_{\theta}(x) < 0.5`

* Suppose we want to predict :math:`y = 1` (Cancer) only if very confident.

  - Predict 1 if :math:`h_{\theta}(x) \geq 0.7` (or 0.9)
  - Predict 0 if :math:`h_{\theta}(x) < 0.7` (or 0.9)

  Higher precision, lower recall.

* Suppose we want to avoid missing too many cases of cancer (avoid false
  negatives).

  - Predict 1 if :math:`h_{\theta}(x) \geq 0.3`
  - Predict 0 if :math:`h_{\theta}(x) < 0.3`

  Higher recall, lower precision.

More generally: Predict 1 if :math:`h_{\theta} \geq threshold`

:math:`F_{1}` Score (F score)
-----------------------------

Which is the best precision/recall numbers? The ones with highest :math:`F_{1}`
score:

+-------------+---------------+------------+---------------------+
|             | Precision (P) | Recall (R) | :math:`F_{1} score` |
+-------------+---------------+------------+---------------------+
| Algorithm 1 |    0.5        |   0.4      |       0.444         |
+-------------+---------------+------------+---------------------+
| Algorithm 2 |    0.7        |   0.1      |       0.175         |
+-------------+---------------+------------+---------------------+
| Algorithm 3 |    0.2        |   1.0      |       0.0392        |
+-------------+---------------+------------+---------------------+

:math:`F_{1}` Score = :math:`2\frac{P * R}{P + R}`
