const express = require('express'), 
  wsConnections = require('../../services/wsConnections'),
  router = express.Router();

router.ws('/', (ws, req) => {
  ws.on('message', (msg) => {
    const message = JSON.parse(msg);

    if (message.event == 'init') {
      wsConnections.add(ws);    
    }
  });
});

module.exports = router;

