

    **Criterios de evaluación:** 



*   1 punto calidad (nombrado de variables, métodos, clases, indentación, etc), 
*   9 puntos el Ejercicio 1. Se adjunta puntuación en cada uno de los apartados.
1. La Asociación de Juegos de Cartas Española (AJCE), nos ha solicitado el desarrollo de una aplicación para dar soporte a diferentes juegos de cartas. Teniendo en cuenta sus requisitos, necesitamos implementar las siguientes clases y métodos (piensa que esta solución está pensada para en un futuro dar soporte a la baraja francesa, y todos aquellos juegos que utilizan esta baraja, pero por falta de tiempo, solo implementaremos una pequeña parte):
    1. **Clase Baraja (0,5 puntos)**: se caracteriza por tener un <span style="text-decoration:underline;">número total de cartas, y un número total de cartas por palo</span>. Además, incluirá un método que inicializará la baraja, y que será de obligada implementación en las clases especializadas de Baraja (aquí no se implementará*). Incluirá el constructor vacío, getters/setters y un método que mostrará el valor de sus atributos.
    2. **Clase Carta (0,5 puntos)**: se caracteriza por tener <span style="text-decoration:underline;">un número de carta</span>. Además, incluirá un método que <span style="text-decoration:underline;">mostrará la carta</span> **(0,25 puntos)**, y que será de obligada implementación en las clases especializadas de Carta. Incluirá el constructor vacío, <span style="text-decoration:underline;">constructor copia</span>, getters/setters.
    3. **Clase CartaEspañola (0,5 puntos)**: se caracteriza por ser una especialización de Carta, y tendrá los palos de las cartas españolas. Incluirá el constructor vacío, <span style="text-decoration:underline;">constructor copia,</span> getters/setters y el método que <span style="text-decoration:underline;">mostrará la carta</span>. El método de mostrar carta, para la baraja española debe mostrar el número de carta y el palo; ejemplo: 1 de OROS, SOTA de BASTOS, REY de ESPADAS.
    4. Debes tener en cuenta que los **Palos (0,25 puntos) **para el caso de una baraja española son oros, copas, bastos y espadas.
    5. **Clase BarajaEspañola (0,5 puntos)**, que tendrá dos listas <span style="text-decoration:underline;">una lista de carta repartidas y otras lista de cartas sin repartir</span>.  Además, deberás implementar el método de <span style="text-decoration:underline;">inicializar baraja*</span> especificado en el apartado a), que básicamente lo que hará será rellenar la lista de cartas sin repartir, con todas las cartas posibles de **la baraja española**. El número de cartas para la baraja española es de 10 cartas por palo (del 7 se pasa a la sota, caballo y rey). 
    6. Implementa un método para barajar **(0,5 puntos)**, que básicamente desordena la lista de cartas sin repartir. Para ello, apóyate en el siguiente método que genera números aleatorios:

        ```
         //genera un número aleatorio entre 0 y max
            public static int generarAleatorio(int max) {
        // Instanciamos la clase Random
                Random random = new Random();
                return random.nextInt(max);
            }
        ```


    7. Llegado a este punto, estamos en disposición de jugar a un juego en este caso **la Escoba **

        **(6 puntos en total)**

*   **1 punto clase/s necesarias para dar soporte al juego**
*   **1 punto el método que inicia el juego (apartado 1 de abajo)**
*   **2 puntos el método desarrollo del juego (apartado 2 y 3 de abajo)**
*   **1 punto el método que finaliza el juego** **(apartado 4 y 5 de abajo)**

    Para simplificar diremos que la Escoba se juega únicamente entre <span style="text-decoration:underline;">dos personas y con la baraja española</span>. La dinámica del juego es la siguiente:

        1. Inicialmente hay 4 cartas aleatorias en el centro de la mesa y cada jugador, 
        tiene tres cartas en la mano. Obviamente antes de repartir se debe barajar
        2. En cada turno, un jugador seleccionar obligatoriamente una carta de la mano, 
        y junto con una o varias cartas que hay encima de la mesa. **El objetivo es sumar 15**,
        teniendo en cuenta que el valor de las cartas viene representado por su número, y 
        en el caso de las figuras, la sota vale 8, caballo 9 y rey 10.  
        3. Si un jugador en su turno deja la mesa sin cartas, es decir, seleccionando una de 
        las cartas de la mano, y una o varias de la mesa suma 15, y la mesa queda vacía, 
        entonces suma **una escoba**. Si con las cartas que tiene en la mano, no tiene ninguna
        combinación para sumar 15, deja una de las cartas que tiene en la mano encima de la mesa. 
        Por simplificación, asumimos que si el usuario selecciona una carta e intenta coger 
        cartas del centro, pero no suman 15, la carta seleccionada se queda en centro. 
        También, asumimos que el usuario introduce correctamente los datos, por tanto, 
        no hay que controlar las excepciones.
        4. El juego finaliza cuando los dos jugadores se quedan sin cartas en la mano y no hay ninguna carta que repartir en el mazo de la baraja. Llegado este punto, si quedan cartas en el centro, se llevará las cartas que quedan en el centro de la mesa (si hay), el último que se llevó la última “mano”. 
        5. Cuando el juego ha finalizado teniendo en cuenta las condiciones del punto anterior, es el momento de saber quién ha ganado. Ganará quien más puntos tenga, teniendo en cuenta los siguientes casos: 
            1. Un punto por cada escoba (en el punto iii se explica que es una escoba.
            2. Un punto quien más cartas tenga.
    8. Teniendo en cuenta este juego realiza el desarrollo más conveniente, para dar solución al problema. Crea las clases y métodos que consideres oportunos.
