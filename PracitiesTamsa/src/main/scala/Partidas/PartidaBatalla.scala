package Partidas
import Items._
import Campeones._
import Enemigos._
import Lugares._
import Dados._
import scala.io.StdIn

class PartidaBatalla() {
    var dados       : List[Dado] = List()
    var jugadores   : List[Campeon] = List()
    var enemigos    : List[Enemigo] = List()

    // private def botinXP() : Int = {}
    private def lanzarDado() : Int = {
        println("Seleccione el dado a lanzar: ")
        var counter : Int = 0
        for (i <- dados) {println(counter + " -> Dado de " + i.limite + " caras"); counter += 1}
        dados(readInt()).lanzar()
    }

    def pelear() : Unit = {
        var finish  : Boolean = false
        var gm      : Boolean = true
        var turno   : Int = 0
        while(finish != true) {
            if (gm != false) {
                println("Tunrno del GM\nSeleccione una accion:\n" + 
                        "0 -> Atacar\n" +
                        "1 -> Revivir Jugador\n" +
                        "2 -> Terminar partida\n")
                var op : Int = readInt()
                println("\n")
                op match {
                    case 0 => {
                        var enemigosVivos : List[Enemigo] = enemigos.filter(_.vidaAct != 0)
                        var jugadoresVivos : List[Campeon] = jugadores.filter(_.vidaAct != 0)
                        if (enemigosVivos != Nil && jugadoresVivos != Nil){
                            var counter : Int = 0
                            println("Seleccione un enemigo:")
                            for (i <- enemigosVivos) {println(counter + " -> " + i.raza); counter += 1}
                            var enemigo : Enemigo = enemigosVivos(readInt())
                            println("\n")
                            counter = 0
                            println("\nSeleccione un jugador:")
                            for (i <- jugadoresVivos) {println(counter + " -> " + i.name); counter += 1}
                            var jugador : Campeon = jugadoresVivos(readInt())
                            println("\n")
                            var res : Int = lanzarDado()
                            println("La suerte de Odin fue dada... " + res + "\n")
                            if (res > jugador.resistencias(enemigo.atributo))
                                jugador.vidaAct_(jugador.vidaAct - enemigo.valAtributo)
                                if (jugador.vidaAct < 0) jugador.vidaAct_(0)
                            println("Vida restante del jugador: " + jugador.vidaAct + "\n")
                        }
                        else println("No hay enemigos vivos con los cuales atacar o no hay jugadores vivos a atacar\n")
                    }
                    
                    case 1 => {
                        var counter : Int = 0
                        var muertos : List[Campeon] = jugadores.filter(_.vidaAct == 0)
                        if (muertos != Nil){
                            println("\nSeleccione un jugador:")
                            for (i <- muertos) {
                                if (i.vidaAct == 0)
                                    println(counter + " -> " + i.name)
                                counter += 1
                            }
                            var jugador : Campeon = muertos(readInt())
                            jugador.vidaAct_(jugador.vidaT)
                            println(jugador.name + " ha sido revivido con exito!\n")
                        }
                        else println("No hay campeones muertos para revivir!\n")
                    }
                    case _ => finish = true
                }
                gm = false
            }
            else {
                val jugador : Campeon = jugadores(turno)
                println("Turno de " + jugador.name + "\nSeleccione una accion:\n" + 
                        "0 -> Atacar\n" +
                        "1 -> Tomar pocion\n")
                var op : Int = readInt()
                if (jugador.vidaAct == 0) op = -1
                println("\n")
                op match {
                    case 0 => {
                        var vivos : List[Enemigo] = enemigos.filter(_.vidaAct != 0)
                        if (vivos != Nil){
                            var counter : Int = 0
                            println("Seleccione un enemigo:")
                            for (i <- enemigos) {println(counter + " -> " + i.raza); counter += 1}
                            var enemigo : Enemigo = enemigos(readInt())
                            println("\n")
                            println("Ingrese el codigo del ataque a realizar (1-4):")
                            var ataque : (String, Int) = ("", 0)
                            var opA : Int = readInt()
                            opA match {
                                case 1 => ataque = jugador.ataque1()
                                case 2 => ataque = jugador.ataque2()
                                case 3 => ataque = jugador.ataque3()
                                case 4 => ataque = jugador.ataque4()
                            }
                            var res : Int = lanzarDado()
                            println("La suerte de odin fue dada... " + res + "\n")
                            if (res > enemigo.resistencias(ataque._1))
                                enemigo.vidaAct_(enemigo.vidaAct - ataque._2)
                                if (enemigo.vidaAct < 0) enemigo.vidaAct_(0)
                            println("Vida restante del enemigo: " + enemigo.vidaAct + "\n")
                        }
                        else println("No hay enemigos vivos a los cuales atacar\n")
                    }
                    case 1 => jugador.tomarPocion()
                    case -1 => println("Jugador muerto, no puede realizar acciones\n")
                }
                turno += 1
                turno = turno % jugadores.length
                gm = true
            }
        }
    }
}