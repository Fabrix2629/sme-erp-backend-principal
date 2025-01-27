En el archivo application.properties se está usando la siguiente configuracion ddl para la base de datos:
# Configuración de JPA e Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
# SE UTILIZÓ EL create-drop PARA LA CREACION DE ROLES Y USARIOS TEMPORALES
# es necesario recargar el query nuevamente mietnras corre el programa
El motivo es por que su utilizó Spring Security para poder acceder a los endpoint con roles, contraseñas etc
Ejecutvar el query para poder visualizar los clientes.
