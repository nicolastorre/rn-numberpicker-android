import React from 'react';
import {requireNativeComponent} from 'react-native';
import PropTypes from 'prop-types';

NumberPicker.propTypes = {
  items: PropTypes.array,
  selectedItem: PropTypes.number,
  onChange: PropTypes.func,
  textColor: PropTypes.string,
  fontSize: PropTypes.number,
  style: PropTypes.Object
};

NumberPicker.defaultProps = {
  items: [],
  onChange: () => {},
};

function NumberPicker(props) {
  return (
    <RCTNumberPickerView
      items={props.items}
      selectedItem={props.selectedItem}
      onChange={event => props.onChange(parseInt(event?.nativeEvent?.value))}
      style={props.style}
    />
  );
}

const RCTNumberPickerView = requireNativeComponent(
  'RCTNumberPickerView',
  NumberPicker,
);

export default NumberPicker;
