#!/usr/bin/env bash
# create share directory
fstab=/etc/exports
roshare=/home/share
rwshare=/home/rwshare
null=/dev/null
IP="192.168.31.184"

source script-helper.sh 10

# clean
info "cleaning file..."
rm -rf ${roshare} ${rwshare} ${fstab} >> ${null}

# create share file
info "creating file..."
mkdir ${roshare} ${rwshare} >> ${null}

# close firewall service
info "closing firewall and iptables..."
systemctl stop firewalld 1>${null} 2>&1

info "writing share file..."
echo -e "/home/share    *(ro,async)\n/home/rwshare  *(rw,sync)" >> ${fstab}
if [[ 0 -ne $? ]]; then
    echo "writing share file failed"
fi

nullInstall nfs-utils

info "restarting share service..."
service nfs restart > ${null}

info "install nginx"
./install-nginx.sh

sed "1i #!/usr/bin/env bash\nIP=${IP}" client.sh > client1.sh

mv client1.sh /usr/local/nginx/html

info "create file mapping"
createMap authorized_keys
createMap hosts

info "downloading hadoop"
curl -o hadoop.tar.gz https://mirror.bit.edu.cn/apache/hadoop/common/hadoop-3.3.0/hadoop-3.3.0.tar.gz

echo "curl http://${IP}/client1.sh | sh"
