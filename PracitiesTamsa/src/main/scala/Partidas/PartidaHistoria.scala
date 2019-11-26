package Partidas
import Dados._
import Items._
import Campeones._
import Enemigos._
import Lugares._
import scala.io.StdIn

class PartidaHistoria() extends Serializable{
    // Atributos
    var id          : Int = -1
    var gm          : String = ""
    var name        : String = ""
    var lore        : String = ""
    private var _contrasena : String = ""
    var dados       : Set[Dado]    = Set()
    var items       : Set[Item]    = Set()
    var lugares     : Set[Lugar]   = Set()
    var enemigos    : Set[Enemigo] = Set()
    var jugadores   : Set[Campeon] = Set()
    var terminada   : Boolean = false
    private var _victoria    : Boolean = false

    def victoria = _victoria
    // Funciones contrasena
    def contrasena_(nContrasena : String) {_contrasena = nContrasena}
    def ingresar(intento : String) : Boolean = {intento == _contrasena}

    // Funciones
    private def seleccionarJugador() : Campeon = {
        var counter = 0
        println("Selecione el jugador: ")
        for (i <- jugadores) {println(counter + " -> " + i.name); counter += 1}
        jugadores.toList(readInt())
    }

    private def lanzarDado() : Int = {
        println("Seleccione el dado a lanzar: ")
        var counter : Int = 0
        for (i <- dados) {println(counter + " -> Dado de " + i.limite + " caras"); counter += 1}
        dados.toList(readInt()).lanzar()
    }

    def moverJugador() : Unit = {
        var jugador = seleccionarJugador()
        println("\n")
        var counter = 0
        for (i <- lugares) {println(counter + " -> " + i.name); counter += 1}
        println("Selecione el lugar destino del jugador: ")
        var lugar = lugares.toList(readInt()).name
        jugador.ubicacion_(lugar)
        println("Ahora " + jugador.name + " esta en " + lugar +"!\n")
    }

    def usarPocion() : Unit = {
        var jugador = seleccionarJugador()
        println("\n")
        jugador.tomarPocion()
        println("Curacion completada!\n")
    }

    def darItem() : Unit = {
        var jugador = seleccionarJugador()
        println("\n")
        var counter = 0
        println("Seleccione el item a dar:")
        for (i <- items) {println(counter + " -> " + i.name); counter += 1}
        var item = items.toList(readInt())
        jugador.agregarItem(item)
        println("Adquisicion de item completada!\n")
    }

    def tradeo() : Unit = {
        var jugador1 = seleccionarJugador()
        println("\n")
        var jugador2 = seleccionarJugador()
        println("\n")
        if (jugador1.inventario != Set() && jugador2.inventario != Set()) {
            var counter = 0
            println("Seleccione el item del 1er jugador: ")
            for (i <- jugador1.inventario) {println(counter + " -> " + i.name); counter += 1}
            var item1 = jugador1.inventario.toList(readInt())
            println("\n")
            counter = 0
            println("Seleccione el item del 2o jugador: ")
            for (i <- jugador2.inventario) {println(counter + " -> " + i.name); counter += 1}
            var item2 = jugador2.inventario.toList(readInt())
            println("\n")

            jugador1.eliminarItem(item1)
            jugador2.eliminarItem(item2)
            jugador1.agregarItem(item2)
            jugador2.agregarItem(item1)
            println("Tradeo exitoso!\n")
        }
        else{
            println("Alguno de los jugadores no tiene items para tradear!\n")
        }
    }

    def jugadorInfo() : Unit = {
        var counter : Int = 0
        for(i <- jugadores) {println(counter + " -> " + i.name); counter += 1}
        jugadores.toList(readInt()).info()
    }

    def iniciarBatalla() : Unit = {
        var batalla : PartidaBatalla = new PartidaBatalla
        println("Seleccione el lugar de la batalla:")
        var counter : Int = 0
        for (i <- lugares) {println(counter + " -> " + i.name); counter += 1}
        var lugar : String = lugares.toList(readInt()).name
        var jugadoresEnLugar : List[Campeon] = jugadores.toList.filter(_.ubicacion == lugar)
        var enemigosBatalla : List[Enemigo] = List()
        var jugadoresBatalla : Set[Campeon] = Set()
        
        if (jugadoresEnLugar != Nil) {
            counter = 0
            println("Ingrese el numero del molde de enemigo a agregar a la batalla (-1 para terminar):")
            for (i <- enemigos) {println(counter + " -> " + i.raza); counter += 1}
            var op : Int = readInt()
            while(op != -1) {
                enemigosBatalla = enemigosBatalla ::: List(enemigos.toList(op).cloning())
                op = readInt()
            }

            counter = 0
            println("Ingrese el numero del jugador a agregar a la batalla (-1 para terminar):")
            for (i <- jugadoresEnLugar) {println(counter + " -> " + i.name); counter += 1}
            op = readInt()
            while(op != -1) {
                jugadoresBatalla += jugadoresEnLugar(op)
                op = readInt()
            }

            if (jugadoresBatalla != Set()) {
                batalla.dados = dados.toList
                batalla.enemigos = enemigosBatalla
                batalla.jugadores = jugadoresBatalla.toList
                batalla.pelear()
                println("Una epica batalla termina...\n")
            }
            else println("Una batalla debe tener almenos un campeon para actuar\n")
        }
        else println("No se encuentran jugadores para pelear en este lugar :(\n")
    }

    def jugar() : Unit = {
        var finish : Boolean = false
        while (finish != true) {
            println("Opciones:\n" +
                    "0 -> Lanzar dados\n" + 
                    "1 -> Mover un jugador\n" + 
                    "2 -> Dar un item a un jugador\n" + 
                    "3 -> Usar una pocion\n" +
                    "4 -> Iniciar un tradeo\n" +
                    "5 -> Iniciar una batalla\n" +
                    "6 -> Ver informacion de un jugador\n" +
                    "7 -> Guardar y salir\n" +
                    "8 -> Terminar Partida\n")
            var op : Int = readInt()
            op match {
                case 0 => println("La suerte de Odin fue dada... " + lanzarDado() + "\n")
                case 1 => moverJugador()
                case 2 => darItem()
                case 3 => usarPocion()
                case 4 => tradeo()
                case 5 => iniciarBatalla()
                case 6 => {println("\n"); jugadorInfo(); println("\n");}
                case 7 => {finish = true; println("Continuara...\n")}
                case 8 => {
                    println("Los jugadores vencieron al GM? (Si / No)")
                    if (readLine().toLowerCase == "si") _victoria = true
                    finish = true; terminada = true; println("Una historia epica termina...\n")
                }
            }
        }
    }
}