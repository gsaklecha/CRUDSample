DROP TABLE IF EXISTS BOOK;
 
CREATE TABLE BOOK (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  version_id VARCHAR,
  book_name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  book_content VARCHAR(500) DEFAULT NULL
);