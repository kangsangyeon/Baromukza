var mysql = require('mysql');

var pool;

exports.connect = ()=>{
	pool = mysql.createPool({
		connectionLimit: 100,
		host	: 'localhost',
		user	: 'root',
		password: 'password',
		database: 'baromukza',
		dateStrings: 'date'
	});
}

exports.get = ()=>{
	return pool;
}