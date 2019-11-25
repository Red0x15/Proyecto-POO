import Items._
import Campeones._
import Enemigos._
import Lugares._
import Partidas._
import Dados._

object menuPrincipal extends App {
    var dados           : Map[Int, Dado] = Map(6 -> {var d6 = new Dado; d6.limite_(6); d6},
                                            10 -> {var d10 = new Dado; d10.limite_(10); d10},
                                            50 -> {var d50 = new Dado; d50.limite_(50); d50},
                                            100 -> {var d100 = new Dado; d100.limite_(100); d100})
    val elementos       : Map[String, Int] = Map("Oscuridad" -> 0, "Luz" -> 0, "Aire" -> 0, "Tierra" -> 0, "Fuego" -> 0,"Agua" -> 0)
    var tipos           : List[String] = List("Arco", "Escudo", "Espada", "Hacha", "Talisman", "Varita", "Pocion")
    var nCampeonesIds   : Int = 0
    var nEnemigosIds    : Int = 0

    var espada =  new Item()
    espada.name = "horricruz"
    espada.tipo = "Espada"
    espada.atributos = Map("Agua"-> 10, "Fuego" -> 10 , "Aire" -> 10, "Tierra"-> 10, "Luz"-> 10 ,"Oscuridad"-> 10)
    espada.resistencias = Map("Agua"-> 0, "Fuego" -> 0 , "Aire" -> 0 , "Tierra"-> 0, "Luz"-> 0 ,"Oscuridad"-> 0)

    var escudo = new Item()
    escudo.name = "Puerta Helada"
    escudo.tipo = "Escudo"
    escudo.atributos = Map("Oscuridad" -> 2, "Luz" -> 0, "Aire" -> 0, "Tierra" -> 0, "Fuego" -> 0,"Agua" -> 0)
    escudo.resistencias = Map("Oscuridad" -> 0, "Luz" -> 0, "Aire" -> 0, "Tierra" -> 0, "Fuego" -> 0,"Agua" -> 10)

    var pocion = new Item()
    pocion.name = "Regen"
    pocion.tipo = "Pocion"
    pocion.atributos = Map("Vida" -> 50)

    var e0 = new Enemigo()
    e0.raza_("Goblin")
    e0.atributo_("Agua")
    e0.resistencias_(Map("Oscuridad" -> 0, "Luz" -> 0, "Aire" -> 0, "Tierra" -> 0, "Fuego" -> 0,"Agua" -> 10))
    e0.vidaT_(50)
    e0.vidaAct_(50)
    e0.valAtributo_(10)

    var c0 = new Elfo()
    c0.name_("Legolas")
    c0.raza_("Elfo")
    c0.atributos_(Map("Oscuridad" -> 0, "Luz" -> 0, "Aire" -> 0, "Tierra" -> 10, "Fuego" -> 0,"Agua" -> 0))
    c0.resistencias_(elementos)
    c0.inventario_(List())
    c0.vidaT_(100)
    c0.vidaAct_(40)

    var c1 = new Valquiria()
    c1.name_("Kayle")
    c1.raza_("Valquiria")
    c1.atributos_(elementos)
    c1.resistencias_(elementos)
    c1.inventario_(List())
    c1.vidaT_(200)
    c1.vidaAct_(50)

    var partida = new PartidaHistoria()
    partida.jugadores = List(c0, c1)
    partida.enemigos = List(e0)
    partida.dados = List(dados(6), dados(10), dados(50), dados(100))
    partida.items = List(escudo, espada, pocion)
    partida.darItem()
    partida.iniciarBatalla()
    c1.info()
} 