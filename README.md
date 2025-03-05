# Squirrel Games

Este proyecto es un sistema de gestión para los juegos organizados por **Squirrel Games**. Su propósito es controlar todos los aspectos relacionados con los eventos, incluyendo la administración de concursantes, la simulación de pruebas y la gestión del personal encargado.

## Funcionalidades Principales

- **Gestión de Concursantes:**  
  Permite registrar y administrar la información de los participantes, tanto concursantes regulares como infiltrados. Se controlan datos personales, fecha de nacimiento, deuda acumulada, y se gestionan restricciones específicas (por ejemplo, no se pueden eliminar concursantes infiltrados).

- **Simulación de Pruebas:**  
  Cada edición de los juegos incluye diversas pruebas en las que participan los concursantes. El sistema permite simular estas pruebas, eliminando aleatoriamente jugadores hasta alcanzar un porcentaje dado y calculando el porcentaje de éxito de la prueba.

- **Gestión de Pink Guards:**  
  Se definen tres tipos de personal:
  - **Worker:** Realiza tareas logísticas y de mantenimiento, asignado a un departamento específico.
  - **Soldier:** Encargado de mantener el orden, utiliza armas específicas y cuenta con una cantidad de munición determinada.
  - **Manager:** De mayor rango, supervisa tanto a los Pink Guards como el desarrollo de las pruebas. Siempre porta una *Smith & Wesson Model 10* y gestiona su propio equipo.
  La jerarquía se respeta mediante validaciones que lanzan excepciones personalizadas en caso de asignar supervisores de igual o menor rango.

## Colaboradores
- **Alberto:** Desarrollo y documentación de los módulos de Concursantes y sus excepciones.
- **Carolina:** Desarrollo y documentación de los módulos de Pruebas, Ediciones y sus excepciones.
- **Mikael:** Desarrollo y documentación de los módulos de Pink Guards y sus excepciones.
