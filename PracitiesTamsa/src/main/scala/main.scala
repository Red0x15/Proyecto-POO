import Items._
import Campeones._
import Enemigos._
import Lugares._
import Partidas._

object main extends App {
    var partida = new PartidaHistoria
    partida.lugares = List({var x = new Lugar; x.name_("Grieta del invocador"); x})
    partida.jugadores = List({var x = new Elfo; x.name_("Rinzler"); x})
    partida.moverJugador()
    println(partida.jugadores(0).ubicacion)
}