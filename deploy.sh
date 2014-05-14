#!/bin/bash

# Very very simple deploy script using rsync to upload generated documentation
# into remote server.

BUILD_PATH="_build"
BUILD_PATH_HTML="$BUILD_PATH/html"
REMOTE_USER="ariel17"
REMOTE_PATH="~/www/notes"

make html
rsync -avp --delete --progress -r -e ssh $BUILD_PATH_HTML/* $REMOTE_USER:$REMOTE_PATH


BUILD_PATH_SLIDES_ALGORITHMS="$BUILD_PATH/slides/utn-algorithms"
REMOTE_PATH="~/www/notes/utn/algoritmos_complejos/exposicion/presentacion"

make clean slides-utn-algorithms
rsync -avp --delete --progress -r -e ssh $BUILD_PATH_SLIDES_ALGORITHMS/* $REMOTE_USER:$REMOTE_PATH
