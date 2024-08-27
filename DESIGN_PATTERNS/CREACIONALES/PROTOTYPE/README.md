
# El patrón Builder 

El patrón Prototipo (Prototype) es un patrón de diseño creacional que permite crear nuevos objetos copiando una instancia existente. Es útil cuando crear una nueva instancia desde cero puede ser costoso en términos de tiempo o recursos, o cuando se quiere evitar una gran cantidad de subclases para objetos que solo tienen pequeñas diferencias

## Características clave del patrón Builder:

- **Clonación de Objetos**: Permite crear nuevos objetos copiando una instancia existente en lugar de crearlos desde cero.
- **Reducción de Costos de Creación:** Evita el alto costo asociado con la creación de objetos complejos al reutilizar un prototipo.
- **Evita la Subclase Extensa:** Reduce la necesidad de crear múltiples subclases para variaciones menores de un objeto.
- **Flexibilidad en la Creación:** Permite modificar solo las partes necesarias del objeto clonado, mientras que el prototipo permanece sin cambios.
- **Posibilidad de Clonación Profunda:** Puede realizar una clonación profunda, creando una copia completamente independiente del prototipo.seguridad y consistencia.

## Caso Práctico: Construcción de Habitaciones

Necesitas crear varias configuraciones de habitaciones con muebles y decoraciones predeterminados. En lugar de crear cada configuración desde cero, puedes utilizar un objeto base (un prototipo) y clonarlo para crear variaciones personalizadas.

