package Partidas
import Items._
import Campeones._
import Enemigos._
import Lugares._
import scala.io.StdIn

class PartidaHistoria() {
    // Atributos
    var items       : List[Item] = List()
    var lugares     : List[Lugar] = List()
    var enemigos    : List[Enemigo] = List()
    var nJugadores  : Int = 0
    var jugadores   : List[Campeon] = List()

    // Funciones
    private def seleccionarJugador() : Campeon = {
        var counter = 0
        for (i <- jugadores) {println(counter + " -> " + i.name); counter += 1}
        println("Selecione el jugador a mover: ")
        jugadores(readInt())
    }

    def moverJugador() : Unit = {
        var jugador = seleccionarJugador()
        var counter = 0
        for (i <- lugares) {println(counter + " -> " + i.name); counter += 1}
        println("Selecione el lugar destino del jugador: ")
        var lugar = lugares(readInt()).name
        jugador.ubicacion_(lugar)
    }

    def usarPocion() : Unit = {
        var jugador = seleccionarJugador()
        jugador.tomarPocion()
    }

    def darItem() : Unit = {
        var jugador = seleccionarJugador()
        var counter = 0
        for (i <- items) {println(counter + " -> " + i.name); counter += 1}
        var item = items(readInt())
        jugador.agregarItem(item)
    }

    def tradeo() : Unit = {
        var jugador1 = seleccionarJugador()
        var jugador2 = seleccionarJugador()
        var counter = 0
        for (i <- jugador1.inventario) {println(counter + " -> " + i.name); counter += 1}
        var item1 = jugador1.inventario(readInt())
        counter = 0
        for (i <- jugador1.inventario) {println(counter + " -> " + i.name); counter += 1}
        var item2 = jugador2.inventario(readInt())

        jugador1.eliminarItem(item1)
        jugador2.eliminarItem(item2)
        jugador1.agregarItem(item2)
        jugador2.agregarItem(item1)
    }
}