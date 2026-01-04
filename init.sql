-- Crear usuario si no existe
CREATE USER IF NOT EXISTS 'microserviceuser'@'%' IDENTIFIED BY 'microservice';

-- Dar permisos sobre la base
GRANT ALL PRIVILEGES ON microservicedb.* TO 'microserviceuser'@'%' WITH GRANT OPTION;

-- Aplicar cambios
FLUSH PRIVILEGES;