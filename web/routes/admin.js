var express = require('express');
var router = express.Router();
var db = require('../db');

/**
 * 관리자용
 * 멤버 리스트 요청
 */
router.get('/member/list/', (req, res)=>{

	var sql_select = "SELECT * " +
		"FROM member;";
	db.get().query(sql_select, [], (err, rows)=>{
		console.log("sql_select : " + sql_select);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

/**
 * 관리자용
 * 점장 리스트 요청
 */
router.get('/owner/list/', (req, res)=>{

	var sql_select = "SELECT * " +
		"FROM owner;";
	db.get().query(sql_select, [], (err, rows)=>{
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