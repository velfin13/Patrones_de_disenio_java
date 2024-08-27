
# El patrón Builder 

Es un patrón de diseño creacional que se utiliza para construir objetos complejos paso a paso. En lugar de crear el objeto directamente en un único paso mediante un constructor, el patrón Builder permite la creación del objeto mediante la construcción incremental, separando el proceso de construcción de la representación final del objeto. Esto es especialmente útil cuando un objeto tiene muchas opciones o configuraciones posibles, lo que haría que un constructor tradicional fuera muy complejo o difícil de usar.

## Características clave del patrón Builder:

- **Separación de la construcción y la representación**: El proceso de construcción se realiza de manera independiente de la estructura del objeto, lo que permite construir diferentes representaciones de un objeto usando el mismo código de construcción.
- **Construcción paso a paso**: Permite configurar y construir un objeto a través de una serie de métodos (normalmente en una secuencia encadenada), mejorando la legibilidad y facilitando la construcción de objetos complejos.
- **Producto final inmutable**: El objeto construido suele ser inmutable, lo que significa que no se puede modificar una vez creado, proporcionando mayor seguridad y consistencia.

## Caso Práctico: Construcción de un Perfil de Usuario

Imagina que estás desarrollando un sistema de gestión de perfiles de usuario para una aplicación. Cada perfil de usuario (UserProfile) puede tener la siguiente información:

- username (nombre de usuario) - **Obligatorio**.
- email (correo electrónico) - **Obligatorio**.
- firstName (nombre) - **Opcional**.
- lastName (apellido) - **Opcional**.
- phoneNumber (número de teléfono) - **Opcional**.
- address (dirección) - **Opcional**.
- dateOfBirth (fecha de nacimiento) - **Opcional**.
- newsletterSubscribed (suscripción al boletín) - **Opcional  (booleano)**.

## Requisitos:

- Crea una clase **UserProfile** utilizando el patrón Builder.
- Asegúrate de que **username** y **email** sean **obligatorios** y que todos los demás atributos sean **opcionales**.
- Implementa una forma de construir un perfil de usuario con solo los datos esenciales o con todos los datos disponibles.
- Tu clase **UserProfile** debe ser inmutable y fácil de usar mediante el patrón Builder.
## Desafío adicional:
- Considera incluir validaciones en el constructor del Builder, como asegurarte de que el **email** tiene un formato válido o que el **username** no esté vacío.
