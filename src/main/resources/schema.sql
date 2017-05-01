create table IF NOT EXISTS employees (
	id		integer primary key auto_increment,
	name	varchar(255),
	supervisor_id	integer references employees(id)
);
