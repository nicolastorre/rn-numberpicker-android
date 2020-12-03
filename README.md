# rn-numberpicker-android

> Display a number picker for Android

![Test e2e](https://github.com/Merlier/rn-numberpicker-android/workflows/Test%20e2e/badge.svg?branch=main)
[![npm version](https://badge.fury.io/js/rn-numberpicker-android.svg)](https://www.npmjs.com/package/rn-numberpicker-android)

<p align="center">
    <img src="https://raw.githubusercontent.com/Merlier/rn-numberpicker-android/main/screenshots/screen_1.png" width="200">
</p>

## Requirements

* react-native >= 0.57.

## Install

```bash
$ npm install rn-numberpicker-android --save
```

## Usage

```javascript
import {NumberPicker} from 'rn-numberpicker-android';

...

<NumberPicker
    items={['0', '1', '2', '3']}
    selectedItem={'1'}
    onChange={nb => console.log(nb)}
    style={{
        left: 0,
        width: 100,
        height: 200,
    }}
/>

```


## Example

See inside `example` folder for a demo app showcasing the android number picker.

## License

[MIT](https://github.com/merlier/httpdumper/blob/main/LICENSE)
