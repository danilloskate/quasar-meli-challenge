DROP TABLE IF EXISTS satellites;

CREATE TABLE satellites (
    NAME VARCHAR(50) PRIMARY KEY,
    DISTANCE DOUBLE,
    X DOUBLE,
    Y DOUBLE,
    MESSAGE VARCHAR(500)
);

INSERT INTO satellites(NAME, X, Y) VALUES
('kenobi',-500,-200),
('skywalker',100,-100),
('sato',500,100)
