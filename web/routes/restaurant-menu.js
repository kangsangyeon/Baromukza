var express = require('express');
var router = express.Router();
var db = require('../db');


/**
 * 레스토랑 메뉴 정보 요청
 */
router.get('/menu/:menu_seq/', (req, res)=>{
	var menu_seq = req.params.menu_seq;

	var sql_select = "SELECT * " +
		"FROM restaurant_menu " +
		"WHERE menu_seq=?";
	db.get().query(sql_select, [menu_seq], (err, rows)=>{
		console.log("sql_select : " + sql_select);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows[0], null, 4));
	});
});

/**
 * 레스토랑 메뉴 정보 등록
 */
router.post('/menu/', (req, res)=>{
	var restaurant_seq = req.body.restaurant_seq;
	var name = req.body.name;
	var image = req.body.image;
	var price = req.body.price;

	var sql_insert = "INSERT INTO restaurant_menu(restaurant_seq, name, image, price) " +
		"VALUES(?, ?, ?, ?);";
	db.get().query(sql_insert, [restaurant_seq, name, image, price], (err, rows)=>{
		console.log("sql_insert : " + sql_insert);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

/**
 * 레스토랑 메뉴 정보 수정
 */
router.put('/menu/:menu_seq', (req, res)=>{
	var menu_seq = req.params.menu_seq;
	var name = req.body.name;
	var image = req.body.image;
	var price = req.body.price;

	var sql_update = "UPDATE restaurant_menu " +
		"SET name=?, image=?, price=? " +
		"WHERE menu_seq=?;";
	db.get().query(sql_update, [name, image, price, menu_seq], (err, rows)=>{
		console.log("sql_update : " + sql_update);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

module.exports = router;