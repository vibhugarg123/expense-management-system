CREATE TABLE User
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(100) NOT NULL,
    email     VARCHAR(150) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX     idx_username (username),
    INDEX     idx_email (email)
);

CREATE TABLE Expenses
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    currency       VARCHAR(10),
    category       VARCHAR(50),
    status         VARCHAR(50),
    description    TEXT,
    createdById    BIGINT,
    approvedById   BIGINT,
    reviewComments TEXT,
    createdAt     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (createdById) REFERENCES User (id),
    FOREIGN KEY (approvedById) REFERENCES User (id),
    INDEX          idx_createdById (createdById),
    INDEX          idx_category (category),
    INDEX          idx_createdBy_category (createdById, category)
);

ALTER TABLE User RENAME COLUMN "updatedAt" TO "lastModifiedAt";
ALTER TABLE "Expense" RENAME COLUMN "updatedAt" TO "lastModifiedAt";