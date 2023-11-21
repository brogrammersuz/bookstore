
INSERT INTO `bookstore`.`publisher` (`id`, `name`, `city`, `state`) VALUES (1, 'SFG Publishing', 'St Petersburg', 'FL');

INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (1, 'Eric', 'Evans');
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (2, 'Rod', 'Johnson');

INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (1, 1, 'J2EE Development without EJB', '3939459459');
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (2, 1, 'Domain Driven Design', '242121212');

INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (1, 1);
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (2, 2);