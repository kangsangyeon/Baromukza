var express = require('express');
var router = express.Router();
var db = require('../db');

/**
 * 점장 정보 요청
 */
router.post('/:id/', (req, res)=>{
	var id = req.params.id;
	var password = req.body.password;

	var sql_count = "SELECT count(*) AS cnt " +
		"FROM owner " +
		"WHERE (id=? or email=?);"
	var sql_getuser = "SELECT * " +
		"FROM owner " +
		"WHERE (id=? or email=?) and password=?";
	db.get().query(sql_count, [id, id], (err, rows)=>{
		console.log("sql_count : " + sql_count);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows[0].cnt <= 0){
			console.log("해당하는 ID가 없습니다.");
			return res.status(200).send("해당하는 ID가 없습니다");
		}
		else{
			db.get().query(sql_getuser, [id, id, password], (err, rows)=>{
				console.log("sql_getuser : " + sql_getuser);
				if(err) {
					console.log(err.message);
					return res.sendStatus(400);
				}

				console.log("rows : " + JSON.stringify(rows[0]));
				console.log("row.length : " + rows.length);
				if(rows.length > 0){
					res.contentType('application/json');
					return res.status(200).send(JSON.stringify(rows[0], null, 4));
				}
				else{
					res.status(200).send("올바른 비밀번호를 입력해주세요");
				}

			});
		}
	});
});

/**
 * 점장 등록
 */
router.post('/', (req, res)=>{
	var id = req.body.id;
	var password = req.body.password;
	var name = req.body.name;
	var phone = req.body.phone;
	var email = req.body.email;
	var bank_account_seq = req.body.bank_account_seq;

	var sql_count = "SELECT count(*) AS cnt " +
		"FROM owner " +
		"WHERE id=?;";
	var sql_insert = "INSERT INTO owner(id, password, name, phone, email, bank_account_seq) " +
		"VALUES(?, ?, ?, ?, ?, ?);";
	db.get().query(sql_count, [id], (err, rows)=>{
		console.log("sql_count : " + sql_count);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows[0].cnt > 0){
			console.log(id + "이미 등록된 id 입니다 \n");
			return res.status(200).send('이미 등록된 id 입니다');
		}

		db.get().query(sql_insert, [id, password, name, phone, email, bank_account_seq], (err, rows)=>{
			console.log("sql_insert : " + sql_insert);
			if(err) {
				console.log(err.message);
				return res.sendStatus(400);
			}

			res.status(200).send(rows.insertId + " 점장 회원가입 완료");
		});
	});
});

/**
 * 점장 정보 수정
 */
router.put('/:id/', (req, res)=>{
	var id = req.params.id;
	var password = req.body.password;

	var name = req.body.name;
	var phone = req.body.phone;
	var email = req.body.email;
	var bank_account_seq = req.body.bank_account_seq;

	var sql_count = "SELECT count(*) AS cnt " +
		"FROM owner " +
		"WHERE (id=? or email=?) and password=?;"
	var sql_update = "UPDATE owner " +
		"SET password=?, name=?, phone=?, email=?, bank_account_seq=? " +
		"WHERE (id=? or email=?) and password=?;";
	db.get().query(sql_count, [id, id, password], (err, rows)=>{
		console.log("sql_count : " + sql_count);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		if(rows[0].cnt <= 0){
			console.log("해당하는 ID가 없습니다.");
			return res.status(200).send("해당하는 ID가 없습니다");
		}
		else{
			db.get().query(sql_update, [password, name, phone, email, bank_account_seq, id, id, password], (err, rows)=>{
				console.log("sql_update : " + sql_update);
				if(err) {
					console.log(err.message);
					return res.sendStatus(400);
				}

				console.log("rows : " + JSON.stringify(rows));
				console.log("row.affectedRows : " + rows.affectedRows);
				if(rows.affectedRows > 0){
					res.contentType('application/json');
					res.status(200).send(JSON.stringify(rows, null, 4))
				}
				else{
					res.status(400).send("점장 정보 업데이트에 실패했습니다");
				}

			});
		}
	});
});

/**
 * 점장 정보 삭제
 */
router.delete('/', (req, res)=>{
	var id = req.body.id;
	var password = req.body.password;

	var sql_delete = "DELETE FROM owner " +
		"WHERE (id=? or email=?) and password=?;";
	db.get().query(sql_delete, [id, id, password], (err, rows)=>{
		console.log("sql_delete : " + sql_delete);
		if(err) {
			console.log(err.message);
			return res.sendStatus(400);
		}

		res.contentType('application/json');
		return res.status(200).send(JSON.stringify(rows, null, 4));
	});
});

module.exports = router;