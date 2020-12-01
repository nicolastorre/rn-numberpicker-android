import React from 'react';
import {requireNativeComponent, ViewPropTypes} from 'react-native';
import PropTypes from 'prop-types';

NumberPicker.propTypes = {
  items: PropTypes.array,
  selectedItem: PropTypes.string,
  onChange: PropTypes.func,
  textColor: PropTypes.string,
  fontSize: PropTypes.number,
  style: ViewPropTypes.style,
};

NumberPicker.defaultProps = {
  items: [],
  onChange: () => {},
};

function NumberPicker(props) {
  const _onChange = (event) => {
    props.onChange(props.items?.[parseInt(event?.nativeEvent?.value, 10)]);
  };

  return (
    <RCTNumberPickerView
      items={props.items}
      selectedItem={props.items.indexOf(props.selectedItem)}
      onChange={_onChange}
      style={props.style}
    />
  );
}

const RCTNumberPickerView = requireNativeComponent(
  'RCTNumberPickerView',
  NumberPicker,
);

export default NumberPicker;
