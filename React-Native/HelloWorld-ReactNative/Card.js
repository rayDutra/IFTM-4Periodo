import React from 'react';
import { View, Text, Image } from 'react-native';

const Card = ({ titulo, texto, imagem }) => {
  return (
    <View style={{ borderWidth: 1, borderColor: 'gray', borderRadius: 10, padding: 10, marginBottom: 20 }}>
      <Text style={{ fontSize: 18, fontWeight: 'bold', marginBottom: 10 }}>{titulo}</Text>
      <Image source={{ uri: imagem }} style={{ width: 100, height: 200, marginBottom: 10 }} />
      <Text style={{ textAlign: 'justify' }}>{texto}</Text>
    </View>
  );
};

export default Card;
