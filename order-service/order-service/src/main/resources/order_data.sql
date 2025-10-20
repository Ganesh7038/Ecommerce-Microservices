
-- Insert dummy Orders
INSERT INTO orders (total_price, order_status) VALUES (120000.0, 'PLACED');
INSERT INTO orders (total_price, order_status) VALUES (45000.0, 'SHIPPED');
INSERT INTO orders (total_price, order_status) VALUES (8000.0, 'DELIVERED');

-- Insert dummy OrderItems for Order 1
INSERT INTO order_item (product_id, quantity, order_id) VALUES (1, 1, 1);
INSERT INTO order_item (product_id, quantity, order_id) VALUES (2, 2, 1);
INSERT INTO order_item (product_id, quantity, order_id) VALUES (3, 3, 1);

-- Insert dummy OrderItems for Order 2
INSERT INTO order_item (product_id, quantity, order_id) VALUES (4, 1, 2);
INSERT INTO order_item (product_id, quantity, order_id) VALUES (5, 2, 2);

-- Insert dummy OrderItems for Order 3
INSERT INTO order_item (product_id, quantity, order_id) VALUES (6, 1, 3);
INSERT INTO order_item (product_id, quantity, order_id) VALUES (7, 1, 3);
INSERT INTO order_item (product_id, quantity, order_id) VALUES (8, 2, 3);
