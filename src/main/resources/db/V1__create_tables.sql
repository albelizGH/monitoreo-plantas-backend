CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rol ENUM('ADMIN', 'USER') DEFAULT 'USER',
    CONSTRAINT users_pk PRIMARY KEY (id),
    CONSTRAINT unique_username UNIQUE (username),
    CONSTRAINT unique_email UNIQUE (email)
);

CREATE TABLE countries (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    image_url VARCHAR(255),
    CONSTRAINT countries_pk PRIMARY KEY (id),
    CONSTRAINT unique_country_name UNIQUE (name)
);

CREATE TABLE plants (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    country_id BIGINT NOT NULL,
    CONSTRAINT plants_pk PRIMARY KEY (id),
    CONSTRAINT plants_country_fk FOREIGN KEY (country_id) REFERENCES countries(id),
    CONSTRAINT unique_plant_name_country UNIQUE (name, country_id)
);
CREATE TABLE readings (
    id BIGINT AUTO_INCREMENT,
    plant_id BIGINT NOT NULL,
    reading_type ENUM(
        'ENERGÍA',
        'MONÓXIDO_DE_CARBONO',
        'NIVELES',
        'OTROS_GASES',
        'PRESIÓN',
        'TEMPERATURA',
        'TENSIÓN',
        'VIENTO'
    ) NOT NULL,
    readings_ok INT NOT NULL DEFAULT 0,
    medium_alerts INT NOT NULL DEFAULT 0,
    red_alerts INT NOT NULL DEFAULT 0,
    disabled BOOLEAN DEFAULT FALSE,  -- 'disabled' ahora es FALSE por defecto
    CONSTRAINT readings_pk PRIMARY KEY (id),
    CONSTRAINT fk_readings_plant FOREIGN KEY (plant_id) REFERENCES plants(id) ON DELETE CASCADE,
    CONSTRAINT unique_plant_reading_type UNIQUE (plant_id, reading_type)
);


INSERT INTO countries (name, image_url) VALUES ('Argentina', 'https://flagcdn.com/ar.svg');
INSERT INTO countries (name, image_url) VALUES ('Brasil', 'https://flagcdn.com/br.svg');

INSERT INTO plants (name, country_id) VALUES ('Quilmes', 1);
INSERT INTO plants (name, country_id) VALUES ('Brasilia', 2);

INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Energía', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Monóxido_de_Carbono', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Niveles', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Otros_gases', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Presión', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Temperatura', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Tensión', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (1, 'Viento', 100, 10, 1);

INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Energía', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Monóxido_de_Carbono', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Niveles', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Otros_gases', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Presión', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Temperatura', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Tensión', 100, 10, 1);
INSERT INTO readings (plant_id, reading_type, readings_ok, medium_alerts, red_alerts) VALUES (2, 'Viento', 100, 10, 1);


#admin1234! como contraseña
INSERT INTO users (username, email, password) VALUES ('admin', 'admin@email.com','$2a$10$6RwTb8wXavUayDjJ47UScO14uwWPUUXSNIfqvBj4G6eRsB0wAb4ue!')