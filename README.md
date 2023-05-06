El objetivo de este proyecto es el desarrollo de una aplicación de cero que recoja los conocimientos adquiridos a lo 
largo del primer curso de DAW.

En primer lugar se desarrollará una interfaz dirigida a los administradores de un cine o de una cadena de cines, 
de manera que puedan agregar o eliminar cines, películas, salas o sesiones.

En segundo lugar, se desarrollará una interfaz de venta dirigida a los usuarios finales o vendedores, de manera que 
puedan seleccionar una sesión en base a las funciones creadas por el administrador para cada día. Además, dentro de cada
sesión el usuario/a tendrá que seleccionar las butacas que desee comprar y realizar el proceso de compra de las entradas.

Por lo tanto, nuestra aplicación se dividirá en una parte visual en la que desarrollaremos las interfaces para que tanto
los usuarios como los administradores puedan interactuar con la aplicación. Un controlador que gestionará la creación de
nuevos usuarios o administradores, la gestión por parte del administrador, las selecciones por parte de los usuarios y 
tratará la información que recupere de la capa de datos. Y una base de datos donde se almacenarán los datos de los 
usuarios, los cines, las salas, las películas y las sesiones disponibles.

Para llevar a cabo está aplicación y poder trabajar de una forma más concreta con las fechas y las horas, hemos 
planteado la posibilidad de trabajar con la librería java.time introducida a partir de Java 8.

```
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
```

A continuación, se presenta el diagrama de clases inicial para llevar a cabo la aplicación:

![Diagrama de clases](resources/Diagrama%20proyecto.drawio.svg)