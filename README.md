# rn-numberpicker-android

> Display a number picker for Android

![Test e2e](https://github.com/Merlier/rn-numberpicker-android/workflows/Test%20e2e/badge.svg?branch=main)

<img src="./screenshots/screen_1.png" width="150">

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
