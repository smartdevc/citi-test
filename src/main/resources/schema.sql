-- Crear tabla Tax
CREATE TABLE IF NOT EXISTS Tax (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   rate DOUBLE NOT NULL
);

-- Crear tabla Transaction
CREATE TABLE IF NOT EXISTS Transaction (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           amount DOUBLE NOT NULL,
                                           tax_id BIGINT,
                                           tax_amount DOUBLE NOT NULL,
                                           CONSTRAINT fk_transaction_tax FOREIGN KEY (tax_id) REFERENCES Tax(id)
    );
