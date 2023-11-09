INSERT INTO pessoa (tipo,crm, nome) VALUES ('medico','123', 'Doutor Eliel')
INSERT INTO pessoa (tipo,crm, nome) VALUES ('medico', '99999767','Machado de Assis')

INSERT INTO pessoa (tipo,telefone, nome) VALUES ('paciente', '99999999','Maria da Silva')
INSERT INTO pessoa (tipo,telefone, nome) VALUES ('paciente', '99999090','Jose dias')
INSERT INTO pessoa (tipo,telefone, nome) VALUES ('paciente', '99998787','Daniel')

INSERT INTO CONSULTA (data, observacao, valor, id_medico, id_paciente) VALUES (current_date, 'Observação aleatoria', 550.50, 1, 3)
INSERT INTO CONSULTA (data, observacao, valor, id_medico, id_paciente) VALUES (current_date, 'Observação unica', 950.50, 1, 4)
-- INSERT INTO CONSULTA (data, observacao, valor, id_medico, id_paciente) VALUES (current_date, 'Observação diferente', 750.50, 2, 1)
-- INSERT INTO CONSULTA (data, observacao, valor, id_medico, id_paciente) VALUES (current_date, 'Observação destinada ao paciente', 150.50, 2, 1)