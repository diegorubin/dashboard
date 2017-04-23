const application = {
  gateway: {
    ordersApi: 'http://localhost:8080/orders'
  },
  server: {
    port: process.env.PORT || 5000
  }
};

module.exports = application;
