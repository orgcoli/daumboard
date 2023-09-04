create table board_tbl(
                          no int(4) not null PRIMARY key AUTO_INCREMENT,
                          subject varchar(100),
                          bcontent varchar(200),
                          name varchar(20)
);

SELECT * FROM board_tbl
    INSERT INTO board_tbl (no, subject, bcontent, name)
VALUES (NULL, '연습1', '연습1내용', '홍길동');
DELETE FROM board_tbl WHERE 0
UPDATE board_tbl SET no='[value-1]',
                     subject='[value-2]',
                     bcontent='[value-3]',
                     name='[value-4]' WHERE 1
SELECT * FROM `board_tbl` WHERE 1

