import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet } from 'react-native';
import url from './url'
const RequestListScreen = () => {
  const [requestsData, setRequestsData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`${url}/demands`);
        const data = await response.json();
        setRequestsData(data);
        console.log(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  const renderItem = ({ item }) => (
    <View style={styles.item}>
      <Text style={styles.subject}>{item.sujet}</Text>
      <Text style={styles.description}>{item.description}</Text>
      <Text style={styles.date}>{item.date}</Text>
      <Text style={styles.state}>{item.etat}</Text>
    </View>
  );

  return (
    <View style={styles.container}>
      <FlatList
        data={requestsData}
        renderItem={renderItem}
        keyExtractor={item => item.id.toString()}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  item: {
    padding: 20,
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
  },
  subject: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  description: {
    fontSize: 16,
  },
  date: {
    fontSize: 14,
    fontStyle: 'italic',
  },
  state: {
    fontSize: 14,
    fontWeight: 'bold',
    marginTop: 5,
  },
  username: {
    fontSize: 14,
    marginTop: 5,
  },
});

export default RequestListScreen;