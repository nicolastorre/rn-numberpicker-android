/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState} from 'react';
import {
  StyleSheet,
    View,
    Text
} from 'react-native';
import {NumberPicker} from 'rn-numberpicker-android';

const App: () => React$Node = () => {
  const [listNbs, setListNbs] = useState(['0','1','2','3','4','5','6','7','8','9']);
  const [nb, setNb] = useState('0');

  const onNbChange = nb => {
    setNb(nb);
  };

  return (
        <View style={styles.container}>
        <Text>Selected number: {nb}</Text>
        <NumberPicker
            items={listNbs}
            selectedItem={nb}
            onChange={onNbChange}
            style={styles.numberPickerAndroid}
        />
        </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },
  numberPickerAndroid: {
    left: 0,
    width: 100,
    height: 200,
  },
});

export default App;
