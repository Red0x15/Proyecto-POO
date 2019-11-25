package Partidas
import Dados._
import Items._
import Campeones._
import Enemigos._
import Lugares._
import scala.io.StdIn

class PartidaHistoria() {
    // Atributos
    var id          : Int = -1
    var gm          : String = ""
    var dados       : List[Dado] = List()
    var items       : List[Item] = List()
    var lugares     : List[Lugar] = List()
    var enemigos    : List[Enemigo] = List()
    var nJugadores  : Int = 0
    var jugadores   : List[Campeon] = List()
    var terminada   : Boolean = false

    // Funciones
    private def seleccionarJugador() : Campeon = {
        var counter = 0
        println("Selecione el jugador: ")
        for (i <- jugadores) {println(counter + " -> " + i.name); counter += 1}
        jugadores(readInt())
    }

    def moverJugador() : Unit = {
        var jugador = seleccionarJugador()
        println("\n")
        var counter = 0
        for (i <- lugares) {println(counter + " -> " + i.name); counter += 1}
        println("Selecione el lugar destino del jugador: ")
        var lugar = lugares(readInt()).name
        jugador.ubicacion_(lugar)
        println("Movimiento exitoso!\n")
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
        var item = items(readInt())
        jugador.agregarItem(item)
        println("Adquisicion de item completada!\n")
    }

    def tradeo() : Unit = {
        var jugador1 = seleccionarJugador()
        println("\n")
        var jugador2 = seleccionarJugador()
        println("\n")
        if (jugador1.inventario != Nil && jugador2.inventario != Nil) {
            var counter = 0
            println("Seleccione el item del 1er jugador: ")
            for (i <- jugador1.inventario) {println(counter + " -> " + i.name); counter += 1}
            var item1 = jugador1.inventario(readInt())
            println("\n")
            counter = 0
            println("Seleccione el item del 2o jugador: ")
            for (i <- jugador2.inventario) {println(counter + " -> " + i.name); counter += 1}
            var item2 = jugador2.inventario(readInt())
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

    def iniciarBatalla() : Unit = {
        var batalla : PartidaBatalla = new PartidaBatalla
        batalla.dados = dados
        batalla.enemigos = enemigos
        batalla.jugadores = jugadores
        batalla.pelear()
        println("Una epica batalla")
    }

    // def jugar
    // def grabar
    // def terminar
}