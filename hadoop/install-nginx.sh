#!/usr/bin/env bash

history=$(pwd)

source script-helper.sh 10

nullInstall pcre-devel zlib-devel cmake gcc

info "downloading nginx"
curl -o nginx http://nginx.org/download/nginx-1.16.1.tar.gz 1>/dev/null 2>&1

tar -zxvf nginx && cd ./nginx-1.16.1

info "compiling file and install"
./configure 1>/dev/null 2>&1 && make 1>/dev/null 2>&1 && make install 1>/dev/null 2>&1

./objs/nginx

