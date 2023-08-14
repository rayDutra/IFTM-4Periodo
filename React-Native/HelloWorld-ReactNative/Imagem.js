import React from 'react';
import { View, Image } from 'react-native';

const Imagem = () => {
  return (
    <View>
      <Image source={require('./casa.png')}
       style={{ width: 200, height: 200 }} />
    </View>
  );
};

export default Imagem;
