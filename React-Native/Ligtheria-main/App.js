import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, Image, FlatList } from "react-native";
import { useFonts } from "expo-font";

const DATA = [
  { id: 1, name: "Abajur", image: require("./assets/images/01-tablelamps.png") },
  { id: 2, name: "Lâmpada de Teto", image: require("./assets/images/02-ceilinglamps.png") },
  { id: 3, name: "Arandela", image: require("./assets/images/03-sconces.png") },
  { id: 4, name: "Luminária de Chão", image: require("./assets/images/04-floorlamps.png") },
  { id: 5, name: "Guirlandas", image: require("./assets/images/05-lightdecor.png") },
  { id: 6, name: "Decoração de Luz", image: require("./assets/images/06-garlands.png") },
];
export default function App() {
  const [fontsLoaded] = useFonts({
    "OpenSans-Regular": require("./assets/fonts/OpenSans-Regular.ttf"),
    "OpenSans-Bold": require("./assets/fonts/OpenSans-Bold.ttf"),
  });

  if (!fontsLoaded) return null;
  return (
    <View style={styles.container}>
      <View style={{ flexDirection: "row", alignItems: "center", justifyContent: "space-between", marginBottom: 20 }}>
        <Text style={{ fontSize: 30, fontFamily: "OpenSans-Bold" }}>Lighteria</Text>
        <View style={{ backgroundColor: "#fff", padding: 16, borderRadius: 30 }}>
          <Image source={require("./assets/images/icone-sacola.png")} style={{ width: 30, height: 30 }} />
        </View>
      </View>
      <View style={{ flexDirection: "row", alignItems: "center", justifyContent: "center", marginBottom: 20 }}>
        <View style={{ borderBottomWidth: 1, flexGrow: 1 }} />
        <Text style={{ position: "absolute", paddingHorizontal: 20, backgroundColor: "#ccc", fontSize: 18 }}>Categorias</Text>
      </View>
      <FlatList
        numColumns={2}
        data={DATA}
        columnWrapperStyle={{ justifyContent: "space-between" }}
        renderItem={({ item }) => {
          return (
            <View
              style={{
                justifyContent: "center",
                alignItems: "center",
                backgroundColor: "#fff",
                marginVertical: 8,
                borderRadius: 16,
                paddingHorizontal: 40,
                width: 180,
                height:260
              }}
            >
              <Image source={item.image} style={{ width: 80, height: 80 }} resizeMode="contain" />
              <Text style={{justifyContent: "center", fontSize: 20, marginTop: 15 }}>{item.name}</Text>
            </View>
          );
        }}
      />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#ccc",
    marginTop: 30,
    paddingHorizontal: 12,
    paddingTop: 30,
  },
});
