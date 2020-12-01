# rn-numberpicker-android

> Display a number picker for Android

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
