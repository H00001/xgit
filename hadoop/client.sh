declare -i sum=$1
declare -i now=0

function info() {
    now+=1
    echo -e "$@\t(${now}/${sum})"
}

function nullInstall() {
    info "install $@..."
    yum -y install $@  >> /dev/null
}

mkdir /mnt/share 1>/dev/null 2>&1
mkdir /mnt/rwshare 1>/dev/null 2>&1
info "create directory succeed"
nullInstall showmount

info "install showmount succeed"
echo "$IP:/home/share        /mnt/share      nfs     defaults        0 0" >> /etc/fstab
echo "$IP:/home/rwshare      /mnt/rwshare    nfs     defaults        0 0" >> /etc/fstab

info "write mount file"
mount -a 1>/dev/null 2>&1
rm /etc/hosts
ln -s /mnt/share/hosts /etc/hosts

info "linked file succeed"
ln -s /mnt/.ssh/authorized_keys ~/.ssh/authorized_keys

nullInstall vim

alias vi=vim

export JAVA_HOME="/mnt/share/jdk-14.0.2"
export PATH=$PATH:${JAVA_HOME}/bin

read -p "input local ip address:" IPADDR
read -p "input local gateway:" GATEWAY
read -p "input local netmask:" NETMASK
read -p "input hostname" HOST_NAME

echo "${HOST_NAME}" > /etc/hostname
echo -e "IPADDR=${IPADDR}\nGATEWAY=${GATEWAY}\nNETMASK=${NETMASK}" >> /etc/sysconfig/network-script/ifcfg-ens33
echo -e "${HOST_NAME}\t${IPADDR}" >> /mnt/hosts

ssh-keygen -t ed25519
cat ~/.ssh/id_ed25519.pub >> /mnt/rwshare/authorized_keys

