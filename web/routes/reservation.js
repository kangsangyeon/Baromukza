var express = require('express');
var router = express.Router();
var db = require('../db');

router.get('/list/:member_seq', (req, res)=>{
	var member_seq = req.params.member_seq;

	var sql_select = "SELECT * " +
		"FROM reservation " +
		"WHERE member_seq=?";
	db.get().query(sql_select, [member_seq], (err, rows)=>{
		console.log("sql_select : " + sql_select);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

module.exports = router;
