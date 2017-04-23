var express = require('express'), 
  router = express.Router();

// add new contollers here
// router.use('/users', require('./users'));

router.get('/', (req, res) => {
  res.render('index');
});

module.exports = router;
