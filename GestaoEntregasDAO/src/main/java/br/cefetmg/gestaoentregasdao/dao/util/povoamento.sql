-- OBSERVAÇÃO
-- Nome do banco de dados: gestaoentregas
-- Usuário: postgres
-- Senha: 123456

INSERT INTO public.empresa (cnpj, cpf, nome, porcentagemcomissaoentregador)
VALUES 
('12345678901234', '12345678901', 'Empresa Exemplo', 10),
('98765432109876', '98765432109', 'Empresa Teste', 15);

-- Senhas: 123456, senha, admins
INSERT INTO public.funcionario (nome, senha, telefone, id_empresa)
VALUES 
('hernanes', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '11912345678', 1),
('greg', 'b7e94be513e96e8c45cd23d162275e5a12ebde9100a425c4ebcdd7fa4dcd897c', '11987654321', 1),
('ismael', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '11923456789', 2);


INSERT INTO public.cliente (cnpj, cpf, bairro, logradouro, nome, telefone, id_empresa)
VALUES 
('12345678901234', '12345678901', 'Bairro Exemplo', 'Rua Exemplo', 'Cliente Exemplo', '11912345678', 1),
('98765432109876', '98765432109', 'Bairro Teste', 'Rua Teste', 'Cliente Teste', '11987654321', 2);

INSERT INTO public.pedido (datapedido, formapagamento, observacao, status, valortotal, id_cliente, id_funcionario)
VALUES 
('2024-08-09 12:00:00', 'CREDITO', 'Pedido de teste', 'ENTREGUE', 100.0, 1, 1),
('2024-09-09 13:00:00', 'FISICO', 'Pedido de exemplo', 'ENTREGUE', 200.0, 2, 2);

INSERT INTO public.item_pedido (quantidade, valorunitario, id_pedido)
VALUES 
(2, 50.0, 1),
(3, 75.0, 2);

INSERT INTO public.produto (localizacao, marca, nome, id_item_pedido)
VALUES 
('Estoque 1', 'Marca Exemplo', 'Produto Exemplo', 1),
('Estoque 2', 'Marca Teste', 'Produto Teste', 2);

INSERT INTO public.perfil (tipoperfil, id_funcionario)
VALUES 
('ADMINISTRADOR', 1),
('ENTREGADOR', 2);