# Compilar AlgebrAventura en línea con Codemagic

Este proyecto incluye `codemagic.yaml` para compilar un APK de depuración sin Android Studio.

## Pasos
1. Crea un repositorio en GitHub.
2. Sube **el contenido de la carpeta `AlgebrAventura_AS4`** a la raíz del repositorio.
3. En Codemagic, crea/inicia sesión y selecciona **Add application**.
4. Conecta tu cuenta de GitHub y selecciona el repositorio.
5. Selecciona configuración mediante `codemagic.yaml`.
6. Ejecuta el workflow **AlgebrAventura APK Debug**.
7. Al terminar, descarga el archivo `app-debug.apk` desde **Artifacts**.

## Toolchain fijado
- Java 8
- Android Gradle Plugin 4.0.2
- Gradle 6.1.1
- compileSdk 29
- build-tools 29.0.3
- minSdk 21
- targetSdk 29

El APK generado es de depuración y queda firmado automáticamente con la clave debug de Android, suficiente para instalarlo manualmente en un dispositivo compatible.
