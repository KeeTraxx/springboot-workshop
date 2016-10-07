FROM openshift/base-centos7

EXPOSE 8080

# Install Java
RUN INSTALL_PKGS="tar unzip bc which lsof java-1.8.0-openjdk java-1.8.0-openjdk-devel" && \
    yum install -y $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum clean all -y && \
    mkdir -p /opt/s2i/destination

USER 1001

# add application source

ADD . /opt/app-root/src

# build
RUN sh /opt/app-root/src/gradlew build

CMD java -Xmx64m -Xss1024k -jar /opt/app-root/src/build/libs/*.jar
