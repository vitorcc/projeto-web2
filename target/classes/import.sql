insert into marca (id, nome) values (1, 'Nike');
insert into marca (id, nome) values (2, 'Aleatory');
insert into marca (id, nome) values (3, 'Consul');
insert into marca (id, nome) values (4, 'Razer');
insert into marca (id, nome) values (5, 'C3Tech');

insert into categoria (id, nome) values (1, 'Sapatos');
insert into categoria (id, nome) values (2, 'Roupas');
insert into categoria (id, nome) values (3, 'Eletrodomésticos');
insert into categoria (id, nome) values (4, 'Informática');
insert into categoria (id, nome) values (5, 'Bebidas');


insert into produto (id, nome, id_marca, modelo, path, valor_unitario, id_categoria, quantidade) values (1, 'Tênis', 1, 'Zoom Winflo 5', '/images/nike.jpg', 250.00, 1, 2);
insert into produto (id, nome, id_marca, modelo, path, valor_unitario, id_categoria, quantidade) values (2, 'Camisa', 2, 'Teste', '/images/aleatory.jpg', 100.00, 2, 3);
insert into produto (id, nome, id_marca, modelo, path, valor_unitario, id_categoria, quantidade) values (3, 'Geladeira', 3, 'Master', '/images/consul.jpg', 3000.00, 3, 5);
insert into produto (id, nome, id_marca, modelo, path, valor_unitario, id_categoria, quantidade) values (4, 'Mouse', 4, 'M5', '/images/razer.jpg', 650.00, 4, 11);
insert into produto (id, nome, id_marca, modelo, path, valor_unitario, id_categoria, quantidade) values (5, 'Teclado', 5, 'C3Gamer', '/images/c3tech.jpg', 200.00, 4, 23);


