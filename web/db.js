var mysql = require('mysql');

var pool;

exports.connect = ()=>{
	pool = mysql.createPool({
		connectionLimit: 100,
		host	: 'localhost',
		user	: 'root',
		password: 'kangsy9797',
		database: 'baromukza'
	});
}

exports.get = ()=>{
	return pool;
}