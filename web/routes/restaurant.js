var express = require('express');
var router = express.Router();
var db = require('../db');

/**
 * 레스토랑의 목록을 요청
 * FIXME: 조건에 맞는 레스토랑의 목록을 요청하는 기능을 추후에 추가하자
 */
router.get('/list/', (req, res)=>{

	var sql_select = "SELECT * " +
		"FROM restaurant;"
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
 * 레스토랑 정보 요청
 */
router.get('/:restaurant_seq/', (req, res)=>{
	var restaurant_seq = req.params.restaurant_seq;

	var sql_select = "SELECT * " +
		"FROM restaurant " +
		"WHERE restaurant_seq=?";
	db.get().query(sql_select, [restaurant_seq], (err, rows)=>{
		console.log("sql_select : " + sql_select);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows.length > 0){
			res.contentType('application/json');
			return res.status(200).send(JSON.stringify(rows[0], null, 4));
		}
		else{
			return res.sendStatus(400);
		}
	});
});

/**
 * 레스토랑 정보 등록
 */
router.post('/', (req, res)=>{
	var owner_seq = req.body.owner_seq;
	var name = req.body.name;
	var description = req.body.description;
	var image = req.body.image;
	var category_seq = req.body.category_seq;
	var start_time = req.body.start_time;
	var end_time = req.body.end_time;
	var phone = req.body.phone;
	var address_1 = req.body.address_1;
	var address_2 = req.body.address_2;
	var address_3 = req.body.address_3;

	var sql_insert = "INSERT INTO restaurant(owner_seq, name, description, image, category_seq, start_time, end_time, phone, address_1, address_2, address_3) " +
		"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	db.get().query(sql_insert, [owner_seq, name, description, image, category_seq, start_time, end_time, phone, address_1, address_2, address_3], (err, rows)=>{
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
 * 레스토랑 정보 삭제
 */
router.delete('/', (req, res)=>{
	var owner_seq = req.body.owner_seq;
	var restaurant_seq = req.body.restaurant_seq;

	var sql_delete = "DELETE FROM restaurant " +
		"WHERE owner_seq=? and restaurant_seq=?;";
	db.get().query(sql_delete, [owner_seq, restaurant_seq], (err, rows)=>{
		console.log("sql_delete : " + sql_delete);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

/**
 * 레스토랑 정보 수정
 */
router.put('/', (req, res)=>{
	var restaurant_seq = req.body.restaurant_seq;
	var owner_seq = req.body.owner_seq;
	var name = req.body.name;
	var description = req.body.description;
	var image = req.body.image;
	var category_seq = req.body.category_seq;
	var start_time = req.body.start_time;
	var end_time = req.body.end_time;
	var phone = req.body.phone;
	var address_1 = req.body.address_1;
	var address_2 = req.body.address_2;
	var address_3 = req.body.address_3;

	var sql_update = "UPDATE restaurant " +
		"SET name=?, owner_seq=?, name=?, description=?, image=?, category_seq=?, start_time=?, end_time=?, phone=?, address_1=?, address_2=?, address_3=? " +
		"WHERE restaurant_seq=? AND owner_seq=?;";
	db.get().query(sql_update, [name, owner_seq, name, description, image, category_seq, start_time, end_time, phone, address_1, address_2, address_3, restaurant_seq, owner_seq], (err, rows)=>{
		console.log("sql_update : " + sql_update);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows.affectedRows > 0){
			res.contentType('application/json');
			return res.status(200).send(JSON.stringify(rows, null, 4));
		}
		else{
			return res.status(400).send('레스토랑 정보 업데이트에 실패했습니다');
		}
	});
});

module.exports = router;