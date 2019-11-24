import Items._
import Campeones._
import Enemigos._

object main extends App {
    // var goblin = new Enemigo()
    // goblin.raza_("Goblin")
    // goblin.nivel_(10)
    // goblin.vidaT_(100)
    // goblin.vidaAct_(goblin.vidaT)
    // goblin.atributo_("Fuego")
    // goblin.resistencias_(Map("Fuego" -> 10, "Agua" -> 5))
    // goblin.lore_("I'm the Goblin")

    // var goblin2 = goblin.cloning()
    // // goblin2.info()

    // var dado10 = new Dado()
    // dado10.limite_(10)
    // println(dado10.lanzar())
    var rinzler = new Elfo()
    rinzler.raza_("Jotun")
    rinzler.nivel_(10)
    rinzler.atributos_(Map("Agua" -> 1, "Aire" -> 2, "Fuego" -> 3, "Tierra" -> 4))
    rinzler.resistencias_(Map("Agua" -> 5, "Aire" -> 6, "Fuego" -> 7, "Tierra" -> 8))
    rinzler.inventario_(List({var x = new Item; x.name = "Filo de Infinito"; x}))
    rinzler.lore_("Im the Elfo")
    rinzler.experiencia_(100)
    rinzler.vidaAct_(1500)
    rinzler.vidaT_(1499)
    // rinzler.info()
    var tron = rinzler.cloning()
    tron.info()
    println(tron.ataque1())
}