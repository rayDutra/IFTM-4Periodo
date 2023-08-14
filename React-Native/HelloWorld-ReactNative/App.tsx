import React from 'react';
import { View } from 'react-native';
import Titulo from './Titulo';
import Card from './Card';

const YourApp = () => {
  return (
    <View style={{ flex: 1, justifyContent: 'flex-start', alignItems: 'center', paddingTop: 50 }}>
      <Titulo />
      <View style={{ marginBottom: 20 }} />
      <Card
        titulo="Título do Cartão"
        texto="Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elit"
        imagem={require('./casa.png')}
      /> 
    </View>
  );
};

export default YourApp;
