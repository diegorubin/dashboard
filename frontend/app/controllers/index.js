const express = require('express'), 
  router = express.Router();

// add new contollers here
router.use('/api/notify', require('./api/notify'));
router.use('/ws/notify', require('./ws/notify'));
router.use('/charts', require('./charts'));

router.get('/', (req, res) => {
  res.render('index');
});

module.exports = router;

