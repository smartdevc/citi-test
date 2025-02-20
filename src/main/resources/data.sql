-- Insertar reglas de impuestos
INSERT INTO Tax (rate) VALUES (0.10);
INSERT INTO Tax (rate) VALUES (0.15);

-- Insertar transacciones
INSERT INTO Transaction (amount, tax_id, tax_amount) VALUES (100.0, 1, 10.0);
INSERT INTO Transaction (amount, tax_id, tax_amount) VALUES (200.0, 2, 30.0);
