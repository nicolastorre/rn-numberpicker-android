#!/bin/bash

cd .. || exit 1

npm i -g envinfo detox-cli && envinfo
npm install

echo fs.inotify.max_user_watches=524288 | tee -a /etc/sysctl.conf && sysctl -p
mkdir -p /root/.android && touch /root/.android/repositories.cfg
echo yes | $ANDROID_HOME/tools/bin/sdkmanager --channel=0 --verbose "system-images;android-28;default;x86_64"
echo no | $ANDROID_HOME/tools/bin/avdmanager --verbose create avd --force --name "Pixel_API_28" --package "system-images;android-28;default;x86_64" --sdcard 200M --device 11
adb start-server

npx jetify
npx detox build -c android.emu.release
npx detox test -c android.emu.release --artifacts-location="e2e/__screenshots__" --take-screenshots="all" --headless
# --updateSnapshot
