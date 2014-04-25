==============
 Installation
==============

The following is a *as easy as it can be* document about installing all
needed requirements to make this project build the different output formats.
Let's begin :)

Installing basic requirements
=============================

Assuming the operative system is Debian-like, the global requirements will be
obtained using package manager.

Installing git and pip
----------------------

.. code-block:: bash
   :linenos:

   sudo apt-get install git pip

Installing virtualenv
---------------------

.. code-block:: bash
   :linenos:

   sudo pip install virtualenv

Repository
==========

The source code repository can be found in GitHub_. You can cloning it running
this commands:

.. code-block:: bash
   :linenos:

   $ git clone git@github.com:ariel17/notes.git && notes

Installing dependencies
=======================

.. code-block:: bash
   :linenos:

   mkdir ~/envs
   virtualenv ~/envs/notes
   source ~/env/notes/bin/activate
   pip install -r requirments.txt

Generating the content
======================

.. code-block:: bash
   :linenos:

   make clean html  # HTML output format, doh
   make clean epub  # epub format

.. _GitHub: https://github.com/ariel17/notes
