var Observer = function() {
}

Observer.prototype.connect = function() {
  var _this = this;

  _this.connection = new WebSocket('ws://localhost:5000/ws/notify');
  _this.connection.onopen = function() {
    var message = JSON.stringify({'event': 'init'});
    _this.connection.send(message);  
  }

  _this.connection.onmessage = function(message) {
    var content = JSON.parse(message.data);
    if (_this.onReceiveMessage) {
      _this.onReceiveMessage(message);
    }
  }

}

