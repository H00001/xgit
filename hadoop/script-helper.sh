#!/usr/bin/env bash

declare -i sum=$1
declare -i now=0

function info() {
    now+=1
    echo -e "$@\t(${now}/${sum})"
}

function nullInstall() {
    echo -e "install $@...\t"
    yum -y install $@  >> /dev/null
}

function createMap() {
    touch /home/rwshare/${1}
    ln -s /home/rwshare/${1} /home/share/${1}
}