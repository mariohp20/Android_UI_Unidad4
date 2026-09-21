# Unidad 4: Navegación y arquitectura de la app

Repositorio con los entregables de las 3 rutas de aprendizaje de la Unidad 4 del curso, incluyendo proyectos clonados y el desafío final.

## Estructura del repositorio

```
├── Ruta1_ArquitecturaComponentes/
│   ├── DessertClickerApp/   (ciclo de vida de la actividad y Logcat)
│   └── UnscrambleApp/       (ViewModel, StateFlow y patrón UDF)
│
├── Ruta2_Navegacion/
│   └── CupcakeApp/          (NavController, NavHost y rutas de navegación)
│
└── Ruta3_DisenoAdaptable/
    ├── ReplyApp/            (WindowSizeClass, navegación y contenido adaptable)
    └── LugaresApp/          (desafío final: app propia de lugares recomendados)
```

## Ruta 1 — Arquitectura de Componentes

- **DessertClickerApp**: explora el ciclo de vida de una actividad (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`) registrando cada estado en Logcat.
- **UnscrambleApp**: juego de adivinar palabras desordenadas que usa `ViewModel` y `StateFlow` para centralizar el estado, siguiendo el patrón UDF (Flujo de Datos Unidireccional).

## Ruta 2 — Navegación en Jetpack Compose

- **CupcakeApp**: app de pedidos de cupcakes con varias pantallas, usando `NavController`, `NavHost` y rutas definidas con un enum para navegar hacia adelante (`navigate()`) y hacia atrás (`popBackStack()`), incluyendo pruebas de navegación.

## Ruta 3 — Diseño adaptable para distintos tamaños de pantalla

- **ReplyApp**: app tipo cliente de correo que usa `calculateWindowSizeClass()` para adaptar tanto el tipo de navegación (barra inferior, navigation rail, panel lateral permanente) como el tipo de contenido (lista sola o lista y detalle lado a lado) según el tamaño de la ventana.
- **LugaresApp**: desafío final — app propia que muestra lugares recomendados para visitar en mi ciudad, combinando `ViewModel`/`StateFlow` (Ruta 1) con `WindowSizeClass` para un layout adaptable (Ruta 3).

## Autor

Mario Huarcaya — Ingeniería de Sistemas

## Curso

Navegación y arquitectura de la app — Unidad 4