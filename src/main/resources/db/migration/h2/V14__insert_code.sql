SET @CODE_CATEGORY_CONTENT_TYPE_NAME = '컨텐츠종류';

SET @CODE_CATEGORY_CONTENT_TYPE_ID = SELECT code_category_id FROM `code_category`
    WHERE code_category_name = @CODE_CATEGORY_CONTENT_TYPE_NAME;

INSERT INTO `code_item`(`code_category_id`, `code_item_name`, `code`) VALUES
    (@CODE_CATEGORY_CONTENT_TYPE_ID, '영화', 0);

SET @CODE_CATEGORY_GENRE_NAME = '장르';

SET @CODE_CATEGORY_GENRE_ID = SELECT code_category_id FROM `code_category`
    WHERE code_category_name = @CODE_CATEGORY_GENRE_NAME;

INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Comedy',35);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Drama',18);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Science Fiction',878);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Crime',80);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Romance',10749);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Thriller',53);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Action',28);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Adventure',12);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Fantasy',14);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Horror',27);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Mystery',9648);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Animation',16);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Family',10751);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'War',10752);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Music',10402);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Western',37);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'History',36);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'TV Movie',10770);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_GENRE_ID,'Documentary',99);

SET @CODE_CATEGORY_RELEASE_STATUS_NAME = '개봉상태';

SET @CODE_CATEGORY_RELEASE_STATUS_ID = SELECT code_category_id FROM `code_category`
    WHERE code_category_name = @CODE_CATEGORY_RELEASE_STATUS_NAME;

INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_RELEASE_STATUS_ID,'Released',0);
INSERT INTO code_item(code_category_id,code_item_name,code) VALUES (@CODE_CATEGORY_RELEASE_STATUS_ID,'Planned',1);
