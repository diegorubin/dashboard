$(document).ready(function(){
  var charts = {
    orders: new SimpleChart('orders', 'Pedidos')
  };

  charts['orders'].loadInitialData();
  var observer = new Observer();
  observer.onReceiveMessage = function(message) {
    var data = JSON.parse(message.data);
    var chart = charts[data.chart];
    chart.update(data.point, data.value);
  }
  observer.connect();
});

