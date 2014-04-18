notes
=====

See it live on htto://www.ariel17.com.ar/notes/

My notes on different courses. I have used [Sphinx](http://sphinx-doc.org/) as
document generation tool, using
[reStructuredText](http://docutils.sourceforge.net/) as markup to format the
content output.

This is really an experiment; I've never have taken notes using the computer.

How to install
--------------

    ~$ virtualenv notes-env
    ~$ source notes-env/bin/activate
    (notes-env)~$ git clone git@github.com:ariel17/notes.git && cd notes
    (notes-env)~/notes$ pip install -r requirements.txt

Generating content
------------------

    (notes-env)~/notes$ make html
