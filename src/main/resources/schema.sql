create table if not exist product(
    productId INTEGER PRIMARY KEY AUTO_INCREMENT,
    productName TEXT,
    price DOUBLE
);
create table if not exist review(
    reviewId INT PRIMARY KEY AUTO_INCREMENT,
    reviewContent TEXT,
    rating INTEGER,
    productId INTEGER,
    FOREIGN KEY (productId) REFERENCES product(productId)
);
