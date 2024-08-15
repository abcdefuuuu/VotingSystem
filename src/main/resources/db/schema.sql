
-- 建立投票項目表
CREATE TABLE voting_item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- 建立投票表
CREATE TABLE vote (
   voter VARCHAR(255) NOT NULL,
   voting_item_id INT NOT NULL,
   FOREIGN KEY (voting_item_id) REFERENCES voting_item(id)
);
