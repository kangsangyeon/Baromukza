var express = require('express');
var router = express.Router();
var db = require('../db');

router.get('/restaurant/:restaurant_seq', (req, res)=>{
	var restaurant_seq = req.params.restaurant_seq;

	var sql_select = "SELECT image " +
		"FROM restaurant " +
		"WHERE restaurant_seq=?";
	db.get().query(sql_select, [restaurant_seq], (err, rows)=>{
		console.log("sql_select : " + sql_select);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows.length > 0){
			res.contentType('text/plain');
			return res.status(200).send(rows[0].image);
		}
		else{
			return res.sendStatus(400);
		}
	});
});

module.exports = router;