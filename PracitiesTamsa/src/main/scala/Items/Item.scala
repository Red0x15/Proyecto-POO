package Items

class Item extends Serializable{
    // Atributos
    var name            : String = ""
    var tipo            : String = ""
    var atributos       : Map[String, Int] = Map()
    var resistencias    : Map[String, Int] = Map()

    def info() : Unit = {
        println(name + " -- (" + tipo + ")")
        println("Atributos:")
        for ((k, v) <- atributos) {println(k + " -> " + v)}
        println("Resistencias:")
        for ((k, v) <- resistencias) {println(k + " -> " + v)}
    }
}