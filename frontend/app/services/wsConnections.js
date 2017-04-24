const connections = [];
const wsConnections = {

  add: (connection) => {
    connections.push(connection);
  },
  notifyClients: (message) => {
    for (const index in connections) {
      const connection = connections[index];
      try {
        connection.send(JSON.stringify(message));
      } catch(err) {
      }
    }
  }

};

module.exports = wsConnections;

