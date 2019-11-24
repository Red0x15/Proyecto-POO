package Campeones
import Items._

abstract class Campeon(){
    // atributos
    protected var _id : Int = _
    protected var _raza : String = _
    protected var _nivel : Int =_
    protected var _experiencia : Double = _
    protected var _vidaT : Int = _
    protected var _vidaAct : Int = _
    protected var _atributos : Map[String,Int] = Map("Agua" -> 0, "Aire" -> 0, "Fuego" -> 0, "Tierra" -> 0)
    protected var _resistencias : Map[String,Int] = Map("Agua" -> 0, "Aire" -> 0, "Fuego" -> 0, "Tierra" -> 0)
    protected var _inventario : List[Item] =_
    protected var _lore: String = _

    // getter y setter
    def id = _id
    def raza = _raza
    def nivel = _nivel
    def experiencia = _experiencia
    def vidaT = _vidaT
    def vidaAct = _vidaAct
    def atributos =_atributos
    def resistencias= _resistencias
    def inventario = _inventario
    def lore = _lore

    def id_( i : Int ) = _id = i
    def raza_ ( s : String ) = _raza = s
    def nivel_ ( i : Int ) = _nivel = i
    def experiencia_ ( d : Double) = _experiencia = d
    def vidaT_ ( i : Int) = _vidaT = i
    def vidaAct_ ( i : Int) = _vidaAct = i
    def atributos_ ( m : Map[String,Int] ) = _atributos = m
    def resistencias_ ( m : Map[String,Int] ) = _resistencias = m
    def inventario_ ( i : List[Item] ) = _inventario = i 
    def lore_ ( l : String) = _lore = l

    def ataque1() : (String, Int)
    def ataque2() : (String, Int)
    def ataque3() : (String, Int)
    def ataque4() : (String, Int)

    def agregarItem(i : Item) : Unit = {
        // modifica todos los estats relacionados con la informacion del itme
    }
    def adquirirExp( i : Int) : Unit ={}
    private def subirNivel() : Unit = {}

    // Metodo para pruebas
    def info() : Unit = {
        println("Id " + id + "\n" +
                "Raza " + raza + "\n" +
                "Nivel " + nivel + "\n" +
                "Atributos " + atributos + "\n" +
                "Resistencias " + resistencias + "\n" +
                "Inventario " + inventario + "\n" +
                "Lore " + lore + "\n" +
                "Experiencia " + experiencia + "\n" +
                "Vida Total " + vidaT + "\n" +
                "Vida Actual " + vidaAct + "\n")
    }
}