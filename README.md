# Calculadora UTH

Aplicación Android en Java para sumar, restar, multiplicar y dividir dos números.

## Estructura

- `OperacionesMatematicas`: recibe los operandos por constructor y encapsula las cuatro operaciones. Rechaza división entre cero y resultados fuera de rango.
- `EntradaNumerica`: valida campos vacíos, números negativos, punto o coma decimal y límites numéricos.
- `MainActivity`: obtiene los números de los EditText, atiende los cuatro botones y envía los operandos, operación y resultado mediante un Intent.
- `ResultadoActivity`: muestra la operación y el resultado; permite regresar sin perder los números.
- Las interfaces se definen en XML y se adaptan mediante desplazamiento al teclado y a pantallas pequeñas.

El constructor transmite los operandos al objeto matemático. La comunicación entre actividades se realiza mediante Intent; Android administra el ciclo de vida de las actividades.

## Ejecutar

Abrir en Android Studio, sincronizar Gradle y ejecutar `app` en un dispositivo o emulador con Android 7.0 o posterior.

```sh
./gradlew testDebugUnitTest assembleDebug
./gradlew installDebug
```

## Marca UTH

La cabecera usa una marca tipográfica UTH en XML, no el archivo oficial. La descarga del logo no estuvo disponible en el entorno. Para sustituirla, guardar el logo en `app/src/main/res/drawable/logo_uth.png` y usar un ImageView en `uth_marca.xml` con `android:src="@drawable/logo_uth"`, `android:scaleType="fitCenter"` y descripción accesible.

Fuente del logo oficial: https://www.uth.hn/wp-content/uploads/2023/02/logowebblanco.png

Los cálculos usan `double`: algunas fracciones decimales pueden mostrar la aproximación propia de punto flotante.
