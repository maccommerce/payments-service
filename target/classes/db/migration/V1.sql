CREATE TABLE cartao_credito (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    numero VARCHAR(16) UNIQUE NOT NULL,
    vencimento DATE NOT NULL
);
