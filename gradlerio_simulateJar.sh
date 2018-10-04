./gradlew simulateJar

export HALSIM_EXTENSIONS="/home/stephen/code/FRC-Robot/lib/libhalsim_lowfi.so":$HALSIM_EXTENSIONS
export HALSIM_EXTENSIONS="/home/stephen/code/FRC-Robot/lib/libhalsim_ds_socket.so":$HALSIM_EXTENSIONS
export HALSIM_EXTENSIONS="/home/stephen/code/FRC-Robot/lib/libhalsim_ds_nt.so":$HALSIM_EXTENSIONS

export LD_LIBRARY_PATH=/home/stephen/code/FRC-Robot/robot/build/tmp/jniExtractDir
export DYLD_FALLBACK_LIBRARY_PATH=/home/stephen/code/FRC-Robot/robot/build/tmp/jniExtractDir

/usr/lib/jvm/java-8-openjdk-amd64/bin/java "-Djava.library.path=/home/stephen/code/FRC-Robot/robot/build/tmp/jniExtractDir" "-jar" "/home/stephen/code/FRC-Robot/robot/build/libs/robot.jar"
