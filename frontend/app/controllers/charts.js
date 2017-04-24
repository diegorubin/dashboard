const express = require('express'),
  restClient = require('../services/restClient'),
  router = express.Router();

router.get('/orders', (req, res) => {
  restClient.request({
    url: 'http://localhost:8080/charts/orders',
    method: 'get'
  }).then((result) =>{
    res.json(result.data);
  });
});

module.exports = router;

