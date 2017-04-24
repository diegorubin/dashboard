const express = require('express'),
  wsConnections = require('../../services/wsConnections'),
  router = express.Router();

router.post('/', (req, res) => {
  wsConnections.notifyClients(req.body); 
  res.json({success: true});
});

module.exports = router;

