-- 1. 建立投票項目表
CREATE TABLE IF NOT EXISTS voting_item (
                                           id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                           name VARCHAR(255) NOT NULL
);

-- 2. 建立投票表
CREATE TABLE IF NOT EXISTS vote (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    voter VARCHAR(255) NOT NULL,
                                    voting_item_id INT UNSIGNED NOT NULL,
                                    FOREIGN KEY (voting_item_id) REFERENCES voting_item(id) ON DELETE CASCADE
);

-- 3. 建立儲存過程：新增投票項目
DELIMITER //

CREATE PROCEDURE add_voting_item(IN itemName VARCHAR(255))
BEGIN
    INSERT INTO voting_item (name) VALUES (itemName);
END //

-- 4. 建立儲存過程：提交投票
CREATE PROCEDURE cast_vote(IN itemId INT UNSIGNED, IN voterName VARCHAR(255))
BEGIN
    INSERT INTO vote (voting_item_id, voter) VALUES (itemId, voterName);
END //

DELIMITER ;
