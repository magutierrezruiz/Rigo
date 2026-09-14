# AlgebrAventura — Android Studio 4.x

Versión del videojuego educativo de productos notables preparada específicamente para Android Studio 4.x.

## Configuración

- Android Gradle Plugin: 4.0.2
- Gradle: 6.1.1
- Código: Java 8
- compileSdkVersion: 29
- targetSdkVersion: 29
- minSdkVersion: 21
- Sin Jetpack Compose
- Sin AndroidX
- Sin Material 3
- Sin dependencias externas de interfaz

La aplicación usa únicamente componentes clásicos del SDK de Android para maximizar la compatibilidad con Android Studio 4.0, 4.1 y 4.2.

## Generar el APK

1. Descomprime el archivo ZIP.
2. Abre Android Studio 4.
3. Selecciona **Open an Existing Project** y abre la carpeta `AlgebrAventura_AS4`.
4. Si solicita Android SDK 29, instálalo desde **SDK Manager > SDK Platforms > Android 10.0 (Q) / API 29**.
5. Espera a que termine **Gradle Sync**.
6. Ve a **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
7. Encontrarás el APK en:

   `app/build/outputs/apk/debug/app-debug.apk`

## JDK recomendado

Usa el JDK integrado de Android Studio 4 o Java 8. No aceptes una actualización automática del proyecto a AGP 7, 8 o 9.

## Contenido pedagógico

- 4 mundos.
- 12 retos.
- 3 vidas.
- 100 puntos por acierto.
- Retroalimentación explicativa.
- Cuadrado de una suma: `(a + b)²`.
- Cuadrado de una diferencia: `(a - b)²`.
- Binomios conjugados: `(a + b)(a - b)`.
- Binomios con término común: `(x + a)(x + b)`.
- Reto final aplicado al área.

## Primera sincronización

Gradle y el Android Gradle Plugin pueden requerir Internet la primera vez que abras el proyecto si aún no están descargados en ese computador.
