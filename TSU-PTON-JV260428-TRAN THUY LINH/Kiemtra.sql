DROP DATABASE IF EXISTS db_library_management;
CREATE DATABASE db_library_management;
USE db_library_management;
CREATE TABLE borrow_cards ( 
card_id INT PRIMARY KEY AUTO_INCREMENT,
book_title VARCHAR(150) NOT NULL,
borrower_name VARCHAR(100) NOT NULL,
borrow_date TIMESTAMP NOT NULL,
return_deadline TIMESTAMP NOT NULL,
quantity INT NOT NULL,
status VARCHAR(30) NOT NULL
);

-- 1. LAY TAT CA PHIEU MUON
DROP PROCEDURE IF EXISTS sp_get_all_borrow_cards;
DELIMITER //
CREATE PROCEDURE sp_get_all_borrow_cards ()
BEGIN 
SELECT *
FROM borrow_cards
ORDER BY card_id;
END //
DELIMITER ;

-- 2. THEM PHIEU MUON
DROP PROCEDURE IF EXISTS sp_add_borrow_card;
DELIMITER //

CREATE PROCEDURE sp_add_borrow_card (
     IN p_book_title VARCHAR(150),
	 IN p_borrower_name VARCHAR(100),
	 IN p_borrow_date TIMESTAMP,
	 IN p_return_deadline TIMESTAMP,
	 IN p_quantity INT,
	 IN p_status VARCHAR(30)
)
BEGIN
    INSERT INTO borrow_cards (
        book_title,
	    borrower_name,
	    borrow_date,
	    return_deadline,
	    quantity,
		status
)
     VALUES(
	 p_book_title,
	 p_borrower_name,
	 p_borrow_date,
	 p_return_deadline,
	 p_quantity,
	 p_status
);
END //

DELIMITER ;

-- 3. TIM PHIEU THEO TEN DOC GIA
DROP PROCEDURE IF EXISTS sp_search_by_borrower_name;
DELIMITER //
CREATE PROCEDURE sp_search_by_borrower_name (
   IN p_borrower_name VARCHAR(100)
)
BEGIN
   SELECT *
   FROM borrow_cards
   WHERE LOWER(borrower_name)
         LIKE CONCAT ('%', LOWER(p_borrower_name),'%')
   ORDER BY card_id;
END //
DELIMITER ;

-- 4. CAP NHAT PHIEU MUON THEO CARD_ID
DROP PROCEDURE IF EXISTS sp_update_borrow_card;
DELIMITER //
CREATE PROCEDURE sp_update_borrow_card(
   IN p_card_id INT,
   IN p_book_title VARCHAR(150),
   IN p_borrower_name VARCHAR(100),
   IN p_borrow_date TIMESTAMP,
   IN p_return_deadline TIMESTAMP,
   IN p_quantity INT,
   IN p_status VARCHAR(30)
)
BEGIN
   UPDATE borrow_cards
   SET book_title = p_book_title,
       borrower_name = p_borrower_name,
       borrow_date = p_borrow_date,
       return_deadline = p_return_deadline,
       quantity = p_quantity,
       status = p_status
	WHERE card_id = p_card_id;
END //

DELIMITER ;

-- 5. XOA PHIEU MUON THEO CARD_ID
DROP PROCEDURE IF EXISTS sp_delete_borrow_card;
DELIMITER //
CREATE PROCEDURE sp_delete_borrow_card(
            IN p_card_id INT
)
BEGIN 
     DELETE FROM borrow_cards
     WHERE card_id = p_card_id;
END //
DELIMITER //

-- 6. TIM PHIEU TEN SACH 
-- TIM GAN DUNG. KHONG PHAN BIET HOA THUONG 
DROP PROCEDURE IF EXISTS sp_search_by_book_title;
DELIMITER //
CREATE PROCEDURE sp_search_by_book_title (
      IN p_book_title VARCHAR(150)
)
BEGIN
  SELECT *
  FROM borrow_cards
  WHERE LOWER(book_title)
       LIKE CONCAT('%',LOWER(p_book_title),'%')
  ORDER BY card_id;
END //
DELIMITER ;

CALL sp_add_borrow_card(
'Java Programing',
'Tran Thuy Linh',
'2026-09-09 10:00:00',
'2026-10-09 10:00:00',
2,
'Borrowing'
);
CALL sp_add_borrow_card(
'MySQL Programing',
'Nguyen Thuy Giang',
'2026-08-25 08:00:00',
'2026-10-01 10:00:00',
1,
'Borrowing'
);

CALL sp_add_borrow_card(
'MySQL Core',
'Nguyen Thanh Luan',
'2026-08-25 08:30:00',
'2026-10-05 10:30:00',
3,
'Returned'
);
SELECT *FROM borrow _cards;