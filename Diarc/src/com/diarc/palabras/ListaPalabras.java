package com.diarc.palabras;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * <p>Contiene las listas de palabras disponibles en el diccionario.</p>
 *
 * @author Luis Guillermo Gómez Galeano
 * @author Oscar Javier Gómez Sánchez
 * @author Jose Alirio Díaz Suarez
 * @version 1.0
 */

public final class ListaPalabras {
    // Atributos

    /**
     * Lista de palabras Generales.
     */
    private final ObservableList<Palabra> listGeneralWords;

    /**
     * Lista de palabras de Instrucciones Assembler.
     */
    private final ObservableList<Palabra> listAssemblerWords;

    /**
     * Lista de palabras de Interrupciones CPU.
     */
    private final ObservableList<Palabra> listCpuWords;

    /**
     * Lista de palabras totales del diccionario.
     */
    private final ObservableList<Palabra> finalList;

    // Constructor

    /**
     * Constructor de la clase el cual inicializa las listas con su contenido.
     */
    public ListaPalabras() {
        listGeneralWords = FXCollections.observableArrayList();
        listAssemblerWords = FXCollections.observableArrayList();
        listCpuWords = FXCollections.observableArrayList();
        finalList = FXCollections.observableArrayList();
        addWord();
        fillListTotalWords();
    }

    /**
     * Adiciona a la lista correspondiente un nuevo objeto de tipo {@link Palabra}.
     */
    private void addWord() {
        listGeneralWords.add(new Palabra("AGP", "(Accelerated Graphic Port: Puerto de gráficos acelerado). Es un tipo estándar de conexión para tarjetas de video internas. Especialmente se habla de la ranura de expansión que está en la placa base que acepta las tarjetas de video AGP. Permite conectar una tarjeta AGP u otra tarjeta de video con el fin de mejorar el rendimiento gráfico.", "/com/diarc/imagenPalabra/1.png"));
        listGeneralWords.add(new Palabra("ALU", "Unidad Aritmético Lógica. Es la encargada de las operaciones aritméticas: suma, resta, multiplicación, división; y encargada de las operaciones lógicas: Comparaciones, falso o verdadero etc", "/com/diarc/imagenPalabra/2.png"));
        listGeneralWords.add(new Palabra("AMD", "Advanced Micro Devices, Inc. (NYSE: AMD) o AMD es una compañía estadounidense de semiconductores que desarrolla procesadores de cómputo y productos tecnológicos relacionados para el mercado de consumo. Sus productos principales incluyen microprocesadores, chipsets para placas base, circuitos integrados auxiliares, procesadores embebidos y procesadores gráficos para servidores, estaciones de trabajo, computadores personales y aplicaciones para sistemas embebidos.", "/com/diarc/imagenPalabra/3.jpg"));
        listGeneralWords.add(new Palabra("ATX-Tarjeta Madre", "Advanced Technology Extend. Es un estándar sucesor del AT  en las tarjetas madres introducido en 1995 para mejorar la funcionalidad de los periféricos y reducir los costos de fabricación de sistema. Este estándar añade todo los conectores directamente a la tarjeta madre y ubica los componentes de una mejor manera.   ", "/com/diarc/imagenPalabra/4.png"));
        listGeneralWords.add(new Palabra("Berg", "A veces etiquetado en el cable como P7 , el conector Berg es una conexión de alimentación desarrollada por Berg Electronics. Se utiliza con fuentes de alimentación de computadora que se conectan a unidades de disquete, luces del panel frontal y botones de reinicio o turbo. La imagen es un ejemplo del conector Berg de 4 pines utilizado para alimentar las unidades de disquete en las computadoras.", "/com/diarc/imagenPalabra/5.png"));
        listGeneralWords.add(new Palabra("BIOS", "Basic Imput/Ouput System. Sistema de entrada y salida básico. Es un chip ROM que se encuentra en la placa base que permite acceder y configurar el sistema informático en el nivel más básico. Este contiene instrucciones sobre como cargar el software básico de la computadora e incluye una prueba denominada POST, (prueba automática de encendido) que ayuda a verificar que la computadora cumpla con los requisitos para iniciarse correctamente. Si la computadora no pasa el POST, recibirá una combinación de pitidos que indican qué está funcionando mal en la computadora.", "/com/diarc/imagenPalabra/6.png"));
        listGeneralWords.add(new Palabra("BITS", "Binary digit es una expresión inglesa que significa “dígito binario” y que da lugar al término bit, su acrónimo en nuestra lengua. El concepto se utiliza en la informática para nombrar a una unidad de medida de información que equivale a la selección entre dos alternativas que tienen el mismo grado de probabilidad. El bit, en otras palabras, es un dígito que forma parte del sistema binario.", "/com/diarc/imagenPalabra/7.png"));
        listGeneralWords.add(new Palabra("BUS", "El bus es la vía de comunicación para los datos y señales de control en la estructura de un computador, entre la cpu y los diferentes órganos que se le deben poner si se tratan de las pistas o cintas de cobre impresas en la placa principal se llama bus del sistema.", "/com/diarc/imagenPalabra/8.png"));
        listGeneralWords.add(new Palabra("Bus de control", "Es el encargado de conducir las señales IRQ de solicitud de interrupción que hacen los dispositivos al microprocesador.", "/com/diarc/imagenPalabra/9.png"));
        listGeneralWords.add(new Palabra("Bus de datos", "Es el encargado de transmitir los caracteres", "/com/diarc/imagenPalabra/10.png"));
        listGeneralWords.add(new Palabra("Bus de direcciones", "Es el encargado de direccionar los datos a su origen o destino", "/com/diarc/imagenPalabra/11.png"));
        listGeneralWords.add(new Palabra("Bus de expansión", "Se le llama al conjunto de líneas eléctricas y circuitos electrónicos de control encargados de conectar el bus del sistema de la tarjeta madre con los buses de dispositivos accesorios, tal como una tarjeta controladora de disco, una tarjeta de video  y MODEM.", "/com/diarc/imagenPalabra/12.png"));
        listGeneralWords.add(new Palabra("Byte", "Conjunto de 8 bits que recibe el tratamiento de una unidad y que constituye el mínimo elemento de memoria direccionable de una computadora.", "/com/diarc/imagenPalabra/13.png"));
        listGeneralWords.add(new Palabra("Chip de sonido", "Es un circuito integrado para la reproducción de sonidos.", "/com/diarc/imagenPalabra/14.png"));
        listGeneralWords.add(new Palabra("Chip Lan", "Es un circuito integrado para la conectividad (red, internet).", "/com/diarc/imagenPalabra/15.png"));
        listGeneralWords.add(new Palabra("Chipset", "Un conjunto de chips es un grupo de chips integrados de la placa base o circuitos integrados que controlan el flujo de datos e instrucciones entre la unidad de procesamiento central (CPU) o el microprocesador y los dispositivos externos. Un chipset controla los buses externos, la memoria caché y algunos periféricos. Una CPU no puede funcionar sin un tiempo de chipset impecable.", "/com/diarc/imagenPalabra/16.png"));
        listGeneralWords.add(new Palabra("Codificación", "Transformación de la representación de la información.", "/com/diarc/imagenPalabra/17.png"));
        listGeneralWords.add(new Palabra("COM1", "Es un puerto serial en una computadora, que es una ranura que permite que los dispositivos periféricos como un ratón o un módem se conecten a la computadora a través de un cable. Han sido reemplazados por los pequeños conectores USB (Universal Serial Bus). Las computadoras más nuevas no tienen puerto COM1. En su lugar, se conectan con los periféricos a través del puerto USB.", "/com/diarc/imagenPalabra/18.png"));
        listGeneralWords.add(new Palabra("Computadora de escritorio", "Las computadoras de escritorio son el tipo de computadora mas común que existe. Llamado generalmente como computadora de escritorio, de sobremesa, o simplemente PC, son equipos utilizados en mayoría en los hogares. Estos modelos incluyen un monitor, ratón, teclado y un envase donde aloja todos los componentes internos. Las computadoras de escritorio están principalmente diseñadas para aplicaciones de uso diario como jugar, navegar por Internet, procesamiento de textos, almacenamiento de fotos y vídeos, entre otras funciones básicas", "/com/diarc/imagenPalabra/19.png"));
        listGeneralWords.add(new Palabra("Conexión ATX", "Es la conexión que se hace de la fuente de poder a la board. Compuesta de 20 pines o 24 pines.", "/com/diarc/imagenPalabra/21.png"));
        listGeneralWords.add(new Palabra("Cooler", "Ventilador que tiene la función de disminuir la temperatura del procesador.", "/com/diarc/imagenPalabra/22.jpg"));
        listGeneralWords.add(new Palabra("CPU", "Unidad Central de Procesamiento. Es el procesador de los datos de entrada presentando una salida.", "/com/diarc/imagenPalabra/23.jpg"));
        listGeneralWords.add(new Palabra("Datos", "En informática, los datos son representaciones simbólicas (vale decir: numéricas, alfabéticas, algorítmicas, etc.) de un determinado atributo o variable cualitativa o cuantitativa, o sea: la descripción codificada de un hecho empírico, un suceso, una entidad.", "/com/diarc/imagenPalabra/24.png"));
        listGeneralWords.add(new Palabra("DDR", "Double Data Rate, significa memoria de doble tasa de transferencia de datos en castellano. Son módulos compuestos por memorias síncronas (SDRAM), disponibles en encapsulado DIMM, que permite la transferencia de datos por dos canales distintos simultáneamente en un mismo ciclo de reloj. Los módulos DDRs soportan una capacidad máxima de 1 GB.", "/com/diarc/imagenPalabra/25.png"));
        listGeneralWords.add(new Palabra("DDR2", "Es la evolución de la memoria DDR-SDRAM, de la que se diferencia por funcionar a mayor velocidad de reloj (hasta 400MHz), necesitar un menor voltaje (sólo 1,8 V en lugar de 2,5 V) y tener mayor latencias. Se montan en módulos de DIMM de 240 contactos.", "/com/diarc/imagenPalabra/26.png"));
        listGeneralWords.add(new Palabra("DDR3", "Es la evolución de la memoria DDR2, y al igual que en el caso anterior estas memorias tienen mayor velocidad de reloj (de 400 a 1066 MHz), menor voltaje (pasamos a 1,5 V) y nuevamente mayores latencias. Se montan en módulos de DIMM de 240 contactos, al igual que la memoria DDR2, sin embargo, no son compatibles pues funcionan a diferentes velocidades y voltajes.", "/com/diarc/imagenPalabra/27.png"));
        listGeneralWords.add(new Palabra("DDR4", "Se caracterizan por tener 288 contactos (en lugar de los 240 de las DDR3), velocidades que van desde los 2GHz hasta unos 4GHz y una reducción del consumo en torno al 20% respecto a las DDR3. La tensión es también menor a sus antecesoras (entre 1,2 y 1,05 para DDR4 frente a los 1,5 a 1,2 para DDR3). Además con DDR4 desaparece el uso de doble y triple canal, cada controlador de memoria está conectado a un módulo único.", "/com/diarc/imagenPalabra/28.png"));
        listGeneralWords.add(new Palabra("DIMM", "DIMM proviene de (\"Dual In line Memory Module\"), lo que traducido significa módulo de memoria de línea dual (este nombre es debido a que sus contactos de cada lado son independientes, por lo tanto el contacto es doble en la tarjeta de memoria): son un tipo de memorias DRAM (RAM de celdas construidas a base de capacitores), las cuáles pueden tener chips de memoria en ambos lados de la tarjeta ó solo de un lado, cuentan con un conector especial de 168 terminales para ranuras de la tarjeta principal (Motherboard). Cabe destacar que la característica de las memorias de línea dual, es precursora de los estándares modernos RIMM y DDR-X), por ello no es de extrañarse que también se les denomine DIMM - SDRAM tipo RIMM ó DIMM - SDRAM DDR-X.", "/com/diarc/imagenPalabra/29.png"));
        listGeneralWords.add(new Palabra("DIN (PS/1)", "DIN (Deutsches Institut für Normung) - PS/1 (Personal System 1): se trata de un conector cilíndrico de tipo F (female) con cinco terminales, el cuál fue implementado en las primeras computadoras personales comercializadas por la empresa IBM®, para interconectar periféricos con la computadora, principalmente teclados", "/com/diarc/imagenPalabra/30.png"));
        listGeneralWords.add(new Palabra("Disco duro", "Dispositivo del sistema de memoria del pc ,el cual es el encargado de almacenar información digital, se cataloga como memoria no volátil", "/com/diarc/imagenPalabra/31.png"));
        listGeneralWords.add(new Palabra("Disquete", "El disquete o disco flexible es un soporte de almacenamiento de datos de tipo magnético, formado por una fina lámina circular de material magnetizable y flexible, encerrada en una cubierta de plástico.", "/com/diarc/imagenPalabra/32.png"));
        listGeneralWords.add(new Palabra("Dispositivos de entrada", "Dispositivos externos del computador que reciben la información del usuario: Mouse, Teclado, Scanner.", "/com/diarc/imagenPalabra/33.png"));
        listGeneralWords.add(new Palabra("Dispositivos de salida", "Dispositivos externos del computador que envían la información  al usuario: Monitor, Parlantes, Impresora.", "/com/diarc/imagenPalabra/34.png"));
        listGeneralWords.add(new Palabra("DVI", "Digital Visual Interface. Es una interfaz de vídeo diseñada para obtener la máxima calidad de visualización posible en pantallas digitales.", "/com/diarc/imagenPalabra/35.png"));
        listGeneralWords.add(new Palabra("eSATA", "Estandarizado en 2004, eSATA ( e permanente para externo) proporciona una variante de SATA para conectividad externa. Utiliza un conector más robusto, cables blindados más largos y estándares eléctricos más estrictos (pero compatibles con versiones anteriores). El protocolo y la señalización lógica (capas de enlace / transporte y más) son idénticos a los SATA internos.", "/com/diarc/imagenPalabra/36.png"));
        listGeneralWords.add(new Palabra("Estaciones de Trabajo", "Las estaciones de trabajo son un tipo de computadora con grandes monitores, los cuales son capaces de presentar gráficos de alta calidad, este modelo contiene un procesador muy potente, memoria interna capaz de procesar datos de gran complejidad, y unidades de disco duro para almacenar gran cantidad de datos. Estas características hacen que las estaciones de trabajo sean especializadas para uso de profesionales matemáticos, ingenieros, arquitectos, y desarrolladores de software o de juegos que necesitan de una computadora que soporte grandes datos e imágenes de alta resolución.", "/com/diarc/imagenPalabra/37.png"));
        listGeneralWords.add(new Palabra("Exabyte", "Exabyte (EB) que equivale a 1024 TB.", ""));
        listGeneralWords.add(new Palabra("FireWire", "Es un tipo estándar de conexión para diferentes dispositivos como cámaras, escáner, discos duros, etc. Denominados así tanto los puertos como a los cables conectores. Es soportado por los S.O actuales.", "/com/diarc/imagenPalabra/39.png"));
        listGeneralWords.add(new Palabra("Fuente ATX", "La fuente ATX es un dispositivo que se acopla internamente en el gabinete de la computadora, la cuál se encarga básicamente de transformar la corriente alterna de la línea eléctrica  en corriente directa; así como reducir su voltaje. Otras funciones son  las de suministrar la cantidad de corriente y voltaje que los dispositivos requieren así como protegerlos de problemas en el suministro eléctrico como subidas de voltaje.", "/com/diarc/imagenPalabra/40.png"));
        listGeneralWords.add(new Palabra("Gigabytes", "Es una unidad de medida aproximadamente igual a 1 billón de bytes. El gigabyte se utiliza para cuantificar memoria o capacidad de disco. Un gigabyte es igual a 1024 megabytes.", ""));
        listGeneralWords.add(new Palabra("Hardware", "Parte tangible del computador.", "/com/diarc/imagenPalabra/42.jpg"));
        listGeneralWords.add(new Palabra("HDMI", "High Definition Multimedia Interface. Es una interfaz de audio y video digital como único cable.", "/com/diarc/imagenPalabra/43.png"));
        listGeneralWords.add(new Palabra("IDE", "Tecnología antigua para la conexión de dispositivos de almacenamiento como el disco duro y la unidad de CD mediante un bus de datos de 40 hilos.", "/com/diarc/imagenPalabra/44.png"));
        listGeneralWords.add(new Palabra("Informática", "Información automática. Tratamiento automático de la información por medio de un ordenador.", "/com/diarc/imagenPalabra/45.jpg"));
        listGeneralWords.add(new Palabra("Instrucciones", "Pasos a realizar por la computadora para la ejecución de un programa.", ""));
        listGeneralWords.add(new Palabra("Intel", "Intel Corporation es el mayor fabricante de circuitos integrados del mundo, según su cifra de negocio anual.4\u200B La compañía estadounidense es la creadora de la serie de procesadores x86, los procesadores más comúnmente encontrados en la mayoría de las computadoras personales. Intel fue fundada el 18 de julio de 1968 como Integrated Electronics Corporation (aunque un error común es el de que \"Intel\" viene de la palabra intelligence) por los pioneros en semiconductores Robert Noyce y Gordon Moore, y muchas veces asociados con la dirección ejecutiva y la visión de Andrew Grove.", "/com/diarc/imagenPalabra/47.jpg"));
        listGeneralWords.add(new Palabra("Jack 3.5", "Es un conector largo y redondo, con un diámetro aproximado de 3,5 mm que transmite señales analógicas. Algunos solo sirven para audio, pero otros llevan incluido el micrófono (conector TRRS), todo depende de la cantidad de anillos que tenga este. Es un estándar que ha permanecido por mucho tiempo.", "/com/diarc/imagenPalabra/48.png"));
        listGeneralWords.add(new Palabra("Kilobyte", "Abreviado como K , kB y KB , un kilobyte equivale a 1.024 bytes , sin embargo, también está definido por IEC como igual a 1.000 bytes. Por lo tanto, una KB podría ser realmente igual a cualquiera de estos valores. Cuando la \"b\" está en minúscula (Kb), esto se refiere a un kilobit.", ""));
        listGeneralWords.add(new Palabra("Lenguaje Assembler", "El lenguaje ensamblador, o assembler es un lenguaje de programación de bajo nivel para los computadores, microprocesadores, microcontroladores, y otros circuitos integrados programables. Implementa una representación simbólica de los códigos de máquina binarios y otras constantes necesarias para programar una arquitectura dada de CPU y constituye la representación más directa del código máquina específico para cada arquitectura legible por un programador. Esta representación es usualmente definida por el fabricante de hardware, y está basada en los mnemónicos que simbolizan los pasos de procesamiento (las instrucciones), los registros del procesador, las posiciones de memoria, y otras características del lenguaje. Un lenguaje ensamblador es por lo tanto específico a cierta arquitectura de computador física. Esto está en contraste con la mayoría de los lenguajes de programación de alto nivel, que, idealmente son portables.", "/com/diarc/imagenPalabra/50.png"));
        listGeneralWords.add(new Palabra("Lenguaje de alto nivel", "Son aquellos que se encuentran más cercanos al lenguaje natural que al lenguaje máquina. Se tratan de lenguajes independientes de la arquitectura del ordenador. Por lo que, en principio, un programa escrito en un lenguaje de alto nivel, lo puedes migrar de una máquina a otra sin ningún tipo de problema. Estos lenguajes permiten al programador olvidarse por completo del funcionamiento interno de la maquina/s para la que están diseñando el programa. Tan solo necesitan un traductor que entiendan el código fuente como las características de la maquina. Suelen usar tipos de datos para la programación y hay lenguajes de propósito general (cualquier tipo de aplicación) y de propósito especifico (como FORTRAN para trabajos científicos). Estos lenguajes permiten al programador olvidarse por completo del funcionamiento interno de la maquina/s para la que están diseñando el programa. Tan solo necesitan un traductor que entiendan el código fuente como las características de la maquina. Suelen usar tipos de datos para la programación y hay lenguajes de propósito general (cualquier tipo de aplicación) y de propósito especifico (como FORTRAN para trabajos científicos).", "/com/diarc/imagenPalabra/51.png"));
        listGeneralWords.add(new Palabra("Lenguaje de bajo nivel", "Son lenguajes totalmente dependientes de la máquina, es decir que el programa que se realiza con este tipo de lenguajes no se pueden migrar o utilizar en otras maquinas. Es difícil de aprender, debido a que no se asemeja al lenguaje natural.", "/com/diarc/imagenPalabra/52.png"));
        listGeneralWords.add(new Palabra("Lenguaje de programación", "Sentencias con símbolos determinados que siguen unas reglas precisas.", "/com/diarc/imagenPalabra/53.png"));
        listGeneralWords.add(new Palabra("LPT", "(Line Printer terminal).Conexión paralela porque envía simultáneamente grupos de datos. Tiene 25 terminales. La mayoría de las computadoras actuales están abandonando el puerto paralelo por los USB. Se usaba principalmente para la conexión con impresoras, escáneres y unidades de lectura para discos ZIP.", "/com/diarc/imagenPalabra/54.png"));
        listGeneralWords.add(new Palabra("Mainframes", "Son computadoras de gran tamaño, que ocupan el espacio de una habitación o incluso de una planta entera. Son equipos caros, que están diseñados principalmente para procesar múltiples  tareas realizadas por miles de usuarios al tiempo. Generalmente las empresas utilizan estos equipos para procesar aplicaciones que necesitan para su negocio, incluyendo transacciones financieras, y análisis estadísticos.", "/com/diarc/imagenPalabra/55.png"));
        listGeneralWords.add(new Palabra("Megabyte", "El megabyte (MB) o megaocteto (Mo) es una cantidad de datos informáticos. Es un múltiplo del byte u octeto que equivale a 106 B (un millón de bytes).", ""));
        listGeneralWords.add(new Palabra("Megahertz", "Parámetro que determina en frecuencia de reloj la velocidad de funcionamiento de la computadora.", ""));
        listGeneralWords.add(new Palabra("Memoria Auxiliar", "Dispositivos de almacenamiento externos: discos duros externos, USB, DVD, CD etc.", "/com/diarc/imagenPalabra/58.png"));
        listGeneralWords.add(new Palabra("Memoria Flash", "La memoria flash derivada de las siglas EEPROM permite la lectura y escritura de múltiples posiciones de memoria en la misma operación. Gracias a ello, la tecnología flash, siempre mediante impulsos eléctricos, permite velocidades de funcionamiento muy superiores frente a la tecnología EEPROM primigenia, que sólo permitía actuar sobre una única celda de memoria en cada operación de programación. Se trata de la tecnología empleada en los dispositivos denominados memoria USB.", "/com/diarc/imagenPalabra/59.png"));
        listGeneralWords.add(new Palabra("Minicomputadoras", "Las minicomputadoras, son en ocasiones llamados servidores de gama media, pues estos son menos potentes que los mainframes pero mas potentes que las computadoras de escritorio. Estos equipos cuentan con capacidad de cumplir varias tareas al tiempo, contiene un procesador rápido, y puede soportar cientos de usuarios a la vez.", "/com/diarc/imagenPalabra/60.jpg"));
        listGeneralWords.add(new Palabra("MiniDIN (PS/2)", "DIN era una especificación arquitectónica del Instituto Alemán de Estandarización. La palabra MiniDIN hace referencia a una versión de este de menor tamaño. Este tiene 6 pines conectores, es circular y tiene un diámetro de 9 mm. Es usado principalmente para la conexión de mouse y teclado los cuales tienen un color definido, el mouse es el puerto verde y el teclado el morado.", "/com/diarc/imagenPalabra/61.png"));
        listGeneralWords.add(new Palabra("Molex", "El conector Molex (elaborado por esta compañía) está conectado de la fuente de alimentación de la computadora a las unidades y dispositivos dentro de la computadora como el disco duro, unidades de disco y tarjetas de video.", "/com/diarc/imagenPalabra/62.png"));
        listGeneralWords.add(new Palabra("Netbooks", "Los netbooks son una versión mas pequeña, ligera y compacta que la computadora portátil. Estos dispositivos están diseñados principalmente para navegar por la web de forma inalámbrica. Debido a su tamaño, los notebooks generalmente tienen pantallas de muy poco tamaño, en promedio es de 10,1 pulgadas. Este tipo de computadora contiene una memoria con muy poco espacio de almacenamiento, no incluyen unidad de CD o DVD, no tienen puertos de conexión y son poco potentes. Cuando salieron al mercado lograron grandes ventas, pero estas han disminuido luego de la llegada de las tabletas.", "/com/diarc/imagenPalabra/63.png"));
        listGeneralWords.add(new Palabra("Panel frontal", "Conjunto de pines para conectar a la board: H.D. LED, Power led, Reset.", "/com/diarc/imagenPalabra/64.png"));
        listGeneralWords.add(new Palabra("Panel posterior", "Es la parte donde se conectan los periféricos al computador.", "/com/diarc/imagenPalabra/65.png"));
        listGeneralWords.add(new Palabra("PCI", "(Peripheral Component Interconnect: Interconexión de componentes periféricos).\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG).\nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", "/com/diarc/imagenPalabra/66.jpg"));
        listGeneralWords.add(new Palabra("PCIe", "PCI Express, técnicamente Peripheral Component Interconnect Express, pero a menudo abreviado como PCIe o PCI-E , es un tipo estándar de conexión para dispositivos internos en una computadora.\nEn general, PCI Express se refiere a las ranuras de expansión reales en la placa base que aceptan tarjetas de expansión basadas en PCIe y a los tipos de tarjetas de expansión en sí.\nPCI Express casi ha reemplazado a AGP y PCI, ambos reemplazaron el tipo de conexión más antiguo ampliamente utilizado llamado ISA.\nSi bien las computadoras pueden contener una combinación de varios tipos de ranuras de expansión, PCI Express se considera la interfaz interna estándar. Muchas motherboards de computadora hoy en día se fabrican solo con ranuras PCI Express.\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG). \nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", "/com/diarc/imagenPalabra/67.png"));
        listGeneralWords.add(new Palabra("Pendrive", "Memoria flash con conector macho USB. Es muy usada en la actualidad por su pequeño tamaño y por que puede almacenar mucha información. En general, PCI Express se refiere a las ranuras de expansión reales en la placa base que aceptan tarjetas de expansión basadas en PCIe y a los tipos de tarjetas de expansión en sí.\nPCI Express casi ha reemplazado a AGP y PCI, ambos reemplazaron el tipo de conexión más antiguo ampliamente utilizado llamado ISA.\nSi bien las computadoras pueden contener una combinación de varios tipos de ranuras de expansión, PCI Express se considera la interfaz interna estándar. Muchas motherboards de computadora hoy en día se fabrican solo con ranuras PCI Express.\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG). \nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", "/com/diarc/imagenPalabra/68.png"));
        listGeneralWords.add(new Palabra("Periféricos", "Los periféricos son una serie de dispositivos que conectan a la unidad central del sistema de la computadora con el exterior que permiten introducir datos, la comunicación entre el computador y el usuario y el envio de resultados. Se clasifican en dispositivos de entrada, salida y entrada/salida.\nPor ejemplo, son periféricos de entrada el mouse y teclado, y de salida la pantalla o parlantes. En general, PCI Express se refiere a las ranuras de expansión reales en la placa base que aceptan tarjetas de expansión basadas en PCIe y a los tipos de tarjetas de expansión en sí.\nPCI Express casi ha reemplazado a AGP y PCI, ambos reemplazaron el tipo de conexión más antiguo ampliamente utilizado llamado ISA.\nSi bien las computadoras pueden contener una combinación de varios tipos de ranuras de expansión, PCI Express se considera la interfaz interna estándar. Muchas motherboards de computadora hoy en día se fabrican solo con ranuras PCI Express.\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG).\nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", "/com/diarc/imagenPalabra/69.png"));
        listGeneralWords.add(new Palabra("Petabyte", "Un petabyte es una unidad de almacenamiento de información cuyo símbolo es PB, y equivale a 1024 Terabytes = 1.125.899.906.842.624 de bytes. Un Terabyte, por supuesto, son 1024 Gigabytes. 1 Gigabyte = 1024 Megabytes.\nPor ejemplo, son periféricos de entrada el mouse y teclado, y de salida la pantalla o parlantes. En general, PCI Express se refiere a las ranuras de expansión reales en la placa base que aceptan tarjetas de expansión basadas en PCIe y a los tipos de tarjetas de expansión en sí.\nPCI Express casi ha reemplazado a AGP y PCI, ambos reemplazaron el tipo de conexión más antiguo ampliamente utilizado llamado ISA.\nSi bien las computadoras pueden contener una combinación de varios tipos de ranuras de expansión, PCI Express se considera la interfaz interna estándar. Muchas motherboards de computadora hoy en día se fabrican solo con ranuras PCI Express.\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG).\nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", ""));
        listGeneralWords.add(new Palabra("Portátiles", "Su nombre en ingles “laptop”, que viene de la combinación de 2 palabras: lap (que significa “regazo”) y top (encima), de esta forma llamaron a estos dispositivos que pueden disponerse sobre las piernas. También los llaman notebooks (que significa cuaderno), por su gran parecido físico a estos objetos.\nEstos modelos contienen pantallas planas, un teclado, dispositivo señalador , memoria y procesador. Las computadoras portátiles son muy livianas pues su peso no supera los 3 kilos y son especializadas para usuarios móviles. Tienen la mismas funciones que las computadoras de escritorio, pero son mas caros debido a su tamaño reducido y compacto. Estos modelos son ideales para todo persona que necesita el poder, y el procesamiento de una computadora de escritorio combinado con la portabilidad.Por ejemplo, son periféricos de entrada el mouse y teclado, y de salida la pantalla o parlantes. En general, PCI Express se refiere a las ranuras de expansión reales en la placa base que aceptan tarjetas de expansión basadas en PCIe y a los tipos de tarjetas de expansión en sí.\nPCI Express casi ha reemplazado a AGP y PCI, ambos reemplazaron el tipo de conexión más antiguo ampliamente utilizado llamado ISA.\n" + "Si bien las computadoras pueden contener una combinación de varios tipos de ranuras de expansión, PCI Express se considera la interfaz interna estándar. Muchas motherboards de computadora hoy en día se fabrican solo con ranuras PCI Express.\nEs una interfaz de conexión común para conectar periféricos a la tarjeta madre.\nEstá siendo remplazado por conectores USB o PCIexpress.\nFue desarrollado por Intel y Arapaho Work Group (AWG).\nConectar tarjetas de sonido, video, red u otro dispositivo periférico que se adapte al slot.", "/com/diarc/imagenPalabra/71.jpg"));
        listGeneralWords.add(new Palabra("Procesador", "Es el cerebro del sistema, justamente procesa todo lo que ocurre en la PC y ejecuta todas las acciones que existen. Cuanto más rápido sea el procesador que tiene una computadora, más rápidamente se ejecutarán las órdenes que se le den a la máquina. Este componente es parte del hardware de muchos dispositivos, no solo de tu computadora.\nLos principales fabricantes son Intel y AMD.", "/com/diarc/imagenPalabra/95.jpg"));
        listGeneralWords.add(new Palabra("RAM", "La memoria de acceso aleatorio (Random-Access Memory, RAM) se utiliza como memoria de trabajo de computadoras para el sistema operativo, los programas y la mayor parte del software. En la RAM se cargan todas las instrucciones que ejecutan la unidad central de procesamiento (procesador) y otras unidades de cómputo. Se denominan «de acceso aleatorio» porque se puede leer o escribir en una posición de memoria con un tiempo de espera igual para cualquier posición, no siendo necesario seguir un orden para acceder (acceso secuencial) a la información de la manera más rápida posible.", "/com/diarc/imagenPalabra/72.jpg"));
        listGeneralWords.add(new Palabra("RCA", "(Desarrollado por la corporación de radio de américa para conectar una toca-disco con un amplificador).El conector cosiste en un pequeño orificio circular anillado con metal. Cada cable suele estar identificado con un color que indica donde debe ir conectado en los puestos RCA. El cable rojo y blanco representan los canales de audio derecho e izquierdo y el amarillo (cable compuesto) entrega la señal de video. Es usado para conectar fuentes de audio, receptores/amplificadores e incluso altavoces.", "/com/diarc/imagenPalabra/73.png"));
        listGeneralWords.add(new Palabra("Registro de acceso a memoria", "• Memory address register (MAR): registro de direcciones de memoria, donde ponemos la dirección de memoria a la que queremos acceder.\n• Memory buffer register (MBR): registro de datos de memoria; registro donde la memoria deposita el dato leído o el dato que queremos escribir.", "/com/diarc/imagenPalabra/74.png"));
        listGeneralWords.add(new Palabra("Registro de control", "• Memory address register (MAR): registro de direcciones de memoria, donde ponemos la dirección de memoria a la que queremos acceder.\n• Memory buffer register (MBR): registro de datos de memoria; registro donde la memoria deposita el dato leído o el dato que queremos escribir.", "/com/diarc/imagenPalabra/75.png"));
        listGeneralWords.add(new Palabra("Registro de estado", "Los bits del registro de estado son modificados por el procesador como resultado de la ejecución de algunos tipos de instrucciones, por ejemplo instrucciones aritméticas o lógicas, o como consecuencia de algún acontecimiento, como las peticiones de interrupción. Estos bits son parcialmente visibles para el programador, en algunos casos mediante la ejecución de instrucciones específicas", "/com/diarc/imagenPalabra/76.png"));
        listGeneralWords.add(new Palabra("Registro de propósito general", "Los registros de propósito general son los registros que suelen utilizarse como operandos en las instrucciones del ensamblador. Estos registros se pueden asignar a funciones concretas: datos o direccionamiento. En algunos procesadores todos los registros se pueden utilizar para todas las funciones.\nLos registros de datos se pueden diferenciar por el formato y el tamaño de los datos que almacenan; por ejemplo, puede haber registros para números enteros y para números en punto flotante.\nLos registros de direccionamiento se utilizan para acceder a memoria y pueden almacenar direcciones o índices. Algunos de estos registros se utilizan de manera implícita para diferentes funciones, como por ejemplo acceder a la pila,dirigir segmentos de memoria o hacer de soporte en la memoria virtual.", ""));
        listGeneralWords.add(new Palabra("Registros de instrucciones", "• Program counter(PC): registro contador del programa, contiene la dirección de la instrucción siguiente que hay que leer de la memoria.\n• Instruction register(IR): registro de instrucción, contiene la instrucción que hay que ejecutar. De la ejecución de algunos tipos de instrucciones, por ejemplo instrucciones aritméticas o lógicas, o como consecuencia de algún acontecimiento, como las peticiones de interrupción. Estos bits son parcialmente visibles para el programador, en algunos casos mediante la ejecución de instrucciones específicas", "/com/diarc/imagenPalabra/78.png"));
        listGeneralWords.add(new Palabra("RJ45", "(Registered Jack-45: Conector-45 registrado).\nEs una conexión de 8 pines utilizada para adaptadores de red Ethernet. Se asemeja al conector RJ-11 que tiene 6 pines y es usado para el teléfono. Esta tanto el conector como el puerto de este tipo para que sean compatibles. Es un puerto que viene integrado en la tarjeta principal, en la tarjeta de red o en una instalación de pared. Maneja velocidades de 10, 100, 1000 Mbps (1.25, 12.5, 125 MB/s) (Informática Moderna, s.f.)", "/com/diarc/imagenPalabra/79.png"));
        listGeneralWords.add(new Palabra("ROM", "Read Only Memory. Memoria (Chip ya integrado en la board) de solo lectura de datos. No se borra la información al perder la energía.", "/com/diarc/imagenPalabra/80.jpg"));
        listGeneralWords.add(new Palabra("SATA", "Serial Advanced Technology Atachment. Es la nueva forma de conexión para los dispositivos a la board. A diferencia de IDE en este hay una sola interfaz para cada dispositivo.", "/com/diarc/imagenPalabra/81.png"));
        listGeneralWords.add(new Palabra("Servidores", "Los servidores son otro tipo de computadora optimizado para ofrecer servicios a otras computadoras, todo a través de una red. Generalmente los servidores cuentan con potentes procesadores, memoria interna que pueda almacenar gran cantidad de información. Son equipos que están encendidos durante todo el día.\nEstos servidores tienen como función principal realizar la comunicaciones entre varios computadoras al tiempo.", "/com/diarc/imagenPalabra/82.png"));
        listGeneralWords.add(new Palabra("SIMM", "Single In-line Memory Module. Antiguas ranuras para insertar memorias RAM.", "/com/diarc/imagenPalabra/83.png"));
        listGeneralWords.add(new Palabra("Sistema Operativo", "Programa principal para controlar la ejecución de todos los programas.", "/com/diarc/imagenPalabra/84.png"));
        listGeneralWords.add(new Palabra("Slots", "Ranuras donde se insertan tarjetas de expansión: Sonido, Video, RAM.", "/com/diarc/imagenPalabra/85.png"));
        listGeneralWords.add(new Palabra("Socket", "Es un espacio en la board designado para insertar el procesador. Los procesadores AMD funcionan por pines y los procesadores Intel por LGA (Lang Gryd Array).", "/com/diarc/imagenPalabra/86.png"));
        listGeneralWords.add(new Palabra("Software", "Parte intangible y lógica del computador.", "/com/diarc/imagenPalabra/87.jpg"));
        listGeneralWords.add(new Palabra("Supercomputadoras", "Las supercomputadoras son utilizadas principalmente para realizar grandes cantidades de cálculos numéricos en periodos cortos de tiempo, las supercomputadoras cuentan con la mayor y mas costosa tecnología disponible. Estos equipos son solo empleados para aplicaciones especializados como investigaciones científicas, previsiones meteorológicas, análisis de datos geológicos, entre otras tareas que necesiten de grandes cantidades de procesamiento.\nLa supercomputadora ROadDrunner de IBM, es un claro ejemplo de lo potente que pueden llegar a ser estos equipos, pues tardaron 6 años en construirla y costó millones de dólares.", "/com/diarc/imagenPalabra/88.png"));
        listGeneralWords.add(new Palabra("S-video", "(Video Y/C, video separado, video simple). Es una interfaz de conector redondo que transmite señales de luminancia y cromancia de manera separada. Su uso ha disminuido siendo remplazado por el cable HDMI.", "/com/diarc/imagenPalabra/89.png"));
        listGeneralWords.add(new Palabra("Tarjeta grafica", "Una tarjeta gráfica es una tarjeta de expansión de la placa base del ordenador que se encarga de procesar los datos provenientes de la unidad central de procesamiento (CPU) y transformarlos en información comprensible y representable en el dispositivo de salida (por ejemplo: monitor, televisor o proyector). Estas tarjetas utilizan una unidad de procesamiento gráfico o GPU, que muchas veces se usa erróneamente para referirse a la tarjeta gráfica en sí.", "/com/diarc/imagenPalabra/90.png"));
        listGeneralWords.add(new Palabra("Terabyte", "Es una unidad de medida de memoria (2 elevado a 12) aproximadamente igual a un trillón de bytes (realmente 1.099.511.627.776 bytes).", ""));
        listGeneralWords.add(new Palabra("Unidad de control", "Su función es buscar las instrucciones en la memoria principal, decodificarlas (interpretación) y ejecutarlas, empleando para ello la unidad de proceso.\nEsta ubicado dentro del procesador.", "/com/diarc/imagenPalabra/92.png"));
        listGeneralWords.add(new Palabra("USB", "Se denomina USB a un tipo de conexión entre computadoras y distintos dispositivos asociados, tales como mouse, impresoras, teclados, cámaras, etc. El término es un acrónimo de la expresión “universal serial bus”. Se volvió masiva a comienzos del nuevo milenio, alcanzando la posibilidad de que todos estos periféricos usen un mismo tipo de conexión. En efecto, en el pasado era común que todos los elementos de entrada y salida que se adosaban a una computadora tuviesen una entrada de conexión distinta.", "/com/diarc/imagenPalabra/93.jpg"));
        listGeneralWords.add(new Palabra("VGA", "(Video Graphics Array). Tipo de conexión estándar desarrollado por IBM (1987) para dispositivos de video como monitores y proyectores.\nUtiliza señales analógicas, tiene 15 pines distribuidos en 3 filas, una resolución de 640 x 480 a 60Hz (frecuencia de actualización).\nSe utiliza para proyectar la pantalla de la computadora usando un TV o proyector.", "/com/diarc/imagenPalabra/94.jpg"));
        listGeneralWords.add(new Palabra("Yottabyte", "La unidad máxima inventada hasta ahora: el Yottabyte (YB) y equivale a 1024 ZB o a 1099 billones (1099.000.000.000) de GB.", ""));
        listGeneralWords.add(new Palabra("Zettabyte", "Zettabyte (ZB), equivale a 1024 EB o, si lo pasamos a GB, equivaldría a 1073 millones de estos.", ""));

        // Instrucciones Assembler
        listAssemblerWords.add(new Palabra("ADD", "Suma", ""));
        listAssemblerWords.add(new Palabra("Call", "Llamado a subrutina", ""));
        listAssemblerWords.add(new Palabra("DIV", "División", ""));
        listAssemblerWords.add(new Palabra("IN", "Entrada", ""));
        listAssemblerWords.add(new Palabra("JA", "Saltar si es superior", ""));
        listAssemblerWords.add(new Palabra("JAE", "Saltar si es superior o igual", ""));
        listAssemblerWords.add(new Palabra("JB", "Saltar si es inferior", ""));
        listAssemblerWords.add(new Palabra("JBE", "Saltar si es inferior o igual", ""));
        listAssemblerWords.add(new Palabra("JE", "Saltar si es igual", ""));
        listAssemblerWords.add(new Palabra("JG", "Saltar si es mayor", ""));
        listAssemblerWords.add(new Palabra("JGE", "Saltar si es mayor o igual", ""));
        listAssemblerWords.add(new Palabra("JL", "Saltar si es menor", ""));
        listAssemblerWords.add(new Palabra("JLE", "Saltar si es menor o igual", ""));
        listAssemblerWords.add(new Palabra("JMP", "Saltar", ""));
        listAssemblerWords.add(new Palabra("JN0", "Saltar si hay paridad impar", ""));
        listAssemblerWords.add(new Palabra("JNA", "Saltar si no es superior", ""));
        listAssemblerWords.add(new Palabra("JNAE", "Saltar si no es superior o igual", ""));
        listAssemblerWords.add(new Palabra("JNB", "Saltar si no es inferior", ""));
        listAssemblerWords.add(new Palabra("JNBE", "Saltar si no es inferior o igual", ""));
        listAssemblerWords.add(new Palabra("JNE", "Saltar si no es igual", ""));
        listAssemblerWords.add(new Palabra("JNG", "Saltar si no es mayor", ""));
        listAssemblerWords.add(new Palabra("JNGE", "Saltar si no es mayor o igual", ""));
        listAssemblerWords.add(new Palabra("JNL", "Saltar si no es inferior", ""));
        listAssemblerWords.add(new Palabra("JNLE", "Saltar si no es menor o igual", ""));
        listAssemblerWords.add(new Palabra("JNO", "Saltar si no hay Overflow", ""));
        listAssemblerWords.add(new Palabra("JNP", "Saltar si no hay paridad", ""));
        listAssemblerWords.add(new Palabra("JNZ", "Saltar si no es cero", ""));
        listAssemblerWords.add(new Palabra("JO", "Saltar si hay OverFlow", ""));
        listAssemblerWords.add(new Palabra("JP", "Saltar si hay paridad", ""));
        listAssemblerWords.add(new Palabra("JPE", "Saltar si hay paridad par", ""));
        listAssemblerWords.add(new Palabra("JZ", "Saltar si es cero", ""));
        listAssemblerWords.add(new Palabra("Mov", "Mover (copiar)", ""));
        listAssemblerWords.add(new Palabra("OUT", "Salida", ""));
        listAssemblerWords.add(new Palabra("SUB", "Resta", ""));

        // Interrupciones CPU
        listCpuWords.add(new Palabra("00h", "Generada por la CPU cuando se intenta hacer una división por cero", ""));
        listCpuWords.add(new Palabra("01h", "Utilizada para ir paso a paso por los programas (como DEBUG)", ""));
        listCpuWords.add(new Palabra("02h", "Interrupción no enmascarable", ""));
        listCpuWords.add(new Palabra("03h", "Utilizada para establecer puntos de ruptura en programas (igual que con DEBUG)", ""));
        listCpuWords.add(new Palabra("04h", "Generada cuando operaciones aritméticas dan operaciones de desbordamientos", ""));
        listCpuWords.add(new Palabra("05h", "Invoca la rutina de servicio de imprimir pantalla de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("06h", "Reservada para DOS", ""));
        listCpuWords.add(new Palabra("07h", "Reservada para DOS", ""));
        listCpuWords.add(new Palabra("08h", "Generada por el tic-tac del reloj del hardware", ""));
        listCpuWords.add(new Palabra("09h", "Generada por la acción del teclado", ""));
        listCpuWords.add(new Palabra("0Ah a 0Dh", "Reservada para BIOS", ""));
        listCpuWords.add(new Palabra("0Eh", "Señala la atención al diskette (por ejemplo, para señalar operación completada)", ""));
        listCpuWords.add(new Palabra("0Fh", "Utilizada para controlar la impresora", ""));
        listCpuWords.add(new Palabra("10h", "Invoca servicios de viideo de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("11h", "Invoca el servicio de lista de equipamiento de ROM BIOS", ""));
        listCpuWords.add(new Palabra("12h", "Invoca servicio de tamaño de memoria de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("13h", "Invoca servicios de disco de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("14h", "Invoca servicios de comunicaciones de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("15h", "Invoca servicios del sistema de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("16h", "Invoca los servicios estándar del teclado de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("17h", "Invoca los servicios de la impresora de la ROM BIOS", ""));
        listCpuWords.add(new Palabra("18h", "Activa el lenguaje BASIC de la ROM", ""));
        listCpuWords.add(new Palabra("19h", "Invoca la rutina cargadora de la secuencia de arranque de la ROM BIOS (equivale a hacer un RESET)", ""));
        listCpuWords.add(new Palabra("1Ah", "Invoca los servicios de hora y fecha de la ROM BIOS", ""));
    }

    /**
     * Agrega las tres listas de palabras a una lista general que contendrá las palabras totales del diccionario.
     */
    private void fillListTotalWords() {
        ObservableList<Palabra> temp = FXCollections.observableArrayList();
        temp.setAll(listAssemblerWords);
        temp.addAll(listCpuWords);
        finalList.setAll(listGeneralWords);
        finalList.addAll(temp);
    }

    /**
     * Retorna la lista de palabras Generales.
     *
     * @return Lista de palabras Generales.
     */
    public ObservableList<Palabra> getListGeneralWords() {
        return listGeneralWords;
    }

    /**
     * Retorna la lista de palabras de Instrucciones Assembler.
     *
     * @return Lista de palabras de Instrucciones Assembler.
     */
    public ObservableList<Palabra> getListAssemblerWords() {
        return listAssemblerWords;
    }

    /**
     * Retorna la lista de palabras de Interrupciones CPU.
     *
     * @return Lista de palabras de Interrupciones CPU.
     */
    public ObservableList<Palabra> getListCpuWords() {
        return listCpuWords;
    }

    /**
     * Retorna la lista que contiene las de palabras totales del diccionario.
     *
     * @return Lista de palabras totales.
     */
    public ObservableList<Palabra> getFinalList() {
        return finalList;
    }
}
