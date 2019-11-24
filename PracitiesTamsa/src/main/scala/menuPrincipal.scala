import Items._
import Campeones._
import Enemigos._
import Lugares._

object menuPrincipal extends App {
    val dados           : Map[Int, Dado] = Map(6 -> {var d6 = new Dado; d6.limite_(6); d6},
                                            10 -> {var d6 = new Dado; d6.limite_(10); d6},
                                            50 -> {var d6 = new Dado; d6.limite_(50); d6},
                                            100 -> {var d6 = new Dado; d6.limite_(100); d6})
    val elementos       : Map[String, Int] = Map("Agua" -> 0, "Aire" -> 0, "Fuego" -> 0, "Luz" -> 0, "Oscuridad" -> 0,"Tierra" -> 0)
    val tipos           : List[String] = List("Arco", "Escudo", "Espada", "Hacha", "Talisman", "Varita", "Pocion")
    var nCampeonesIds   : Int = 0
    var nEnemigosIds    : Int = 0

    var e0 = new Enemigo()
    e0.id_(nEnemigosIds)
    nEnemigosIds += 1
    e0.raza_("Goblin")
    e0.nivel_(10)
    e0.vidaT_(100)
    e0.vidaAct_(e0.vidaT)
    e0.atributo_("Fuego")
    var resist = elementos
    resist -= "Fuego"
    resist += ("Fuego" -> 10)
    e0.resistencias_(resist)
    e0.lore_("I'm the Goblin")
    var e1 = e0.cloning()
    e1.id_(nEnemigosIds)
    nEnemigosIds += 1

    var c0 = new Elfo()
    c0.id_(nCampeonesIds)
    nCampeonesIds += 1
    c0.raza_("Jotun")
    c0.nivel_(10)
    c0.atributos_(Map("Agua" -> 1, "Aire" -> 2, "Fuego" -> 3, "Tierra" -> 4))
    c0.resistencias_(Map("Agua" -> 5, "Aire" -> 6, "Fuego" -> 7, "Tierra" -> 8))
    c0.inventario_(List({var x = new Item; x.name = "Filo de Infinito"; x}))
    c0.lore_("Im the Elfo")
    c0.experiencia_(100)
    c0.vidaAct_(1500)
    c0.vidaT_(1499)

    var l0 = new Lugar()
    l0.name_("Ruinas del triunfo")
    l0.nivel_(1)

    // l0.entrarCampeon(c0)
    // println(l0.campeones)
    // l0.salirCampeon(0)
    // println(l0.campeones)
}