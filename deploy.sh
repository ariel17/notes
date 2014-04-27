#!/bin/bash

# Very very simple deploy script using rsync to upload generated documentation
# into remote server.

BUILD_PATH='_build/html'
REMOTE_USER='ariel17'
REMOTE_PATH='~/www/notes'

make html
rsync -avp --delete --progress -r -e ssh $BUILD_PATH/* $REMOTE_USER:$REMOTE_PATH
