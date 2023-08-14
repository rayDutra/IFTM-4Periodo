import React from 'react';
import { View, Text } from 'react-native';

const Paragrafo = ({ texto }) => {
  return (
    <View style={{ paddingHorizontal: 20 }}>
      <Text style={{ textAlign: 'justify' }}>{texto}</Text>
    </View>
  );
};

export default Paragrafo;
