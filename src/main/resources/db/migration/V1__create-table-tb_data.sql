CREATE TABLE tb_user (
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE tb_data (
    id_data BIGINT AUTO_INCREMENT PRIMARY KEY,
    content mediumtext NOT NULL
);

CREATE TABLE tb_answer(
    id_answer BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_user BIGINT NOT NULL,
    answer LONGTEXT NOT NULL
);

ALTER TABLE tb_answer ADD CONSTRAINT fk_id_user
FOREIGN KEY(id_user) REFERENCES tb_user(id_user);



INSERT INTO tb_data (content) VALUES
('John Doe é o gerente de vendas e tem 10 anos de experiência na empresa. Ele é responsável pela coordenação da equipe de vendas e pela estratégia de crescimento de mercado.'),
('Jane Smith é uma analista de marketing com especialização em campanhas digitais. Ela lidera projetos para aumentar a visibilidade da marca e engajamento com o público-alvo.'),
('Michael Johnson é o diretor de TI e supervisiona todas as operações tecnológicas da empresa. Ele gerencia a equipe de suporte técnico e desenvolvimento de software.'),
('A política de férias da empresa permite que os funcionários solicitem até 20 dias de férias por ano. As solicitações devem ser feitas com pelo menos 30 dias de antecedência.'),
('O procedimento para relatórios de despesas exige que todos os recibos sejam anexados ao formulário de solicitação e enviados para o departamento de contabilidade.'),
('A empresa realiza avaliações de desempenho anuais para todos os funcionários. A avaliação é baseada em metas estabelecidas no início do ano e no feedback contínuo.'),
('O Projeto Alpha visa desenvolver uma nova plataforma de e-commerce até o final do trimestre. O objetivo é melhorar a experiência do usuário e aumentar as vendas online.'),
('O Projeto Beta está focado na implementação de um sistema de gerenciamento de inventário. A conclusão está prevista para o próximo semestre e deve reduzir o tempo de processamento de pedidos em 25%.'),
('O Projeto Gamma é uma iniciativa para atualizar a infraestrutura de TI da empresa. Inclui a migração para servidores baseados em nuvem e a modernização dos sistemas existentes.'),
('Cliente XYZ é uma empresa de tecnologia com sede em São Francisco. Eles estão interessados em soluções de software personalizadas e em contratos de longo prazo.'),
('Cliente ABC é uma cadeia de lojas de varejo que busca melhorar suas operações logísticas. Eles estão interessados em um sistema integrado de gestão de inventário.'),
('Cliente DEF é uma instituição financeira que requer serviços de consultoria em segurança cibernética e conformidade regulatória.'),
('O relatório do segundo trimestre mostrou um aumento de 15% nas vendas em comparação com o trimestre anterior, impulsionado por campanhas promocionais bem-sucedidas.'),
('O relatório de satisfação do cliente revelou uma melhoria na pontuação média de satisfação, com um aumento de 10% em feedbacks positivos.'),
('O relatório de eficiência operacional destacou uma redução de 20% no tempo de processamento de pedidos devido à otimização de processos internos.');
