var express = require('express');
var router = express.Router();
var db = require('../db');

/**
 * 멤버 즐겨찾기 목록 요청
 */
router.get('/:member_seq/', (req, res)=>{
	var member_seq = req.params.member_seq;

	var sql_select = "SELECT * " +
		"FROM restaurant_favorite " +
		"WHERE member_seq=?;";
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

/**
 * 즐겨찾기 등록
 */
router.post('/:member_seq/', (req, res)=>{
	var member_seq = req.params.member_seq;
	var restaurant_seq = req.body.restaurant_seq;

	var sql_count = "SELECT count(*) AS cnt " +
		"FROM restaurant_favorite " +
		"WHERE member_seq=?;";
	var sql_insert = "INSERT INTO restaurant_favorite(member_seq, restaurant_seq) " +
		"VALUES(?, ?);";
	db.get().query(sql_count, [member_seq], (err, rows)=>{
		console.log("sql_count : " + sql_count);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows[0].cnt > 0){
			return res.status(200);
		}
		else{

			db.get().query(sql_insert, [member_seq, restaurant_seq], (err, rows)=>{
				console.log("sql_insert : " + sql_insert);
				if(err) {
					console.log(err.message);
					return res.sendStatus(400);
				}

				res.contentType('application/json');
				return res.status(200).send(JSON.stringify(rows, null, 4));
			});

		}
	});
});

router.delete('/:member_seq')

module.exports = router;