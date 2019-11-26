package Campeones
import Items._

abstract class Campeon(){
    // atributos
    protected var _id : Int = _
    protected var _name : String = _
    protected var _raza : String = _
    protected var _nivel : Int =_
    protected var _experiencia : Int = _
    protected var _ubicacion : String = _
    protected var _vidaT : Int = _
    protected var _vidaAct : Int = _
    protected var _atributos : Map[String,Int] = Map()
    protected var _resistencias : Map[String,Int] = Map()
    protected var _inventario : Set[Item] =_
    protected var _lore: String = _

    // getter y setter
    def id = _id
    def name = _name
    def raza = _raza
    def nivel = _nivel
    def experiencia = _experiencia
    def ubicacion = _ubicacion
    def vidaT = _vidaT
    def vidaAct = _vidaAct
    def atributos =_atributos
    def resistencias= _resistencias
    def inventario = _inventario
    def lore = _lore

    def id_( i : Int ) = _id = i
    def name_( s : String ) = _name = s
    def raza_( s : String ) = _raza = s
    def nivel_( i : Int ) = {if (i == 0) _nivel = 1 else _nivel = i}
    def experiencia_( d : Int ) = _experiencia = d
    def ubicacion_( s : String ) = _ubicacion = s
    def vidaT_( i : Int) = _vidaT = i
    def vidaAct_( i : Int) = _vidaAct = i
    def atributos_( m : Map[String,Int] ) = _atributos = m
    def resistencias_( m : Map[String,Int] ) = _resistencias = m
    def inventario_( i : Set[Item] ) = _inventario = i 
    def lore_( l : String) = _lore = l

    // Funciones
    protected def tomarE ( a : List[Item] , i : String) : List[Item] ={
        a match{
            case Nil => Nil
            case a::b => if (a.tipo == i ) a :: tomarE(b,i)  else tomarE(b,i)
        }
    }

    protected def elimE ( a : List[Item] , i : Item) : List[Item] ={
        a match{
            case Nil => Nil
            case a::b => if (a.tipo == i.tipo ) elimE(b,i) else a :: elimE(b,i)
        }
    }

    def ataque1() : (String, Int)
    def ataque2() : (String, Int)
    def ataque3() : (String, Int)
    def ataque4() : (String, Int)

    def agregarItem(i : Item) : Unit
    def eliminarItem(i : Item) : Unit

    def tomarPocion() : Unit ={
        var aux : List[Item] = tomarE(this.inventario.toList,"Pocion")
        if( aux != Nil){
            var i : Int = 0
            for( s <- aux ) { println(i + " -> " + s.name + " +(" + s.atributos("Vida") + "Hp)"); i += 1 }
            var temp : Item = aux(readInt()) // pocion a tomar
            if(this._vidaAct + temp.atributos("Vida") > this.vidaT ){
                this._vidaAct = this.vidaT
                eliminarItem(temp)
            }else{
                this._vidaAct = this._vidaAct + temp.atributos("Vida") 
                eliminarItem(temp)
            }
            println("Sus puntos de vida actuales son: " + this.vidaAct + "\n")
        }
        else{
            println("No hay pociones" + "\n")
        }
    }

    def adquirirExp( i : Int) : Unit ={}
    private def subirNivel() : Unit = {}

    // Metodo para pruebas
    def info() : Unit = {
        println("Raza " + _raza + "\n" +
                "Nivel " + _nivel + "\n" +
                "Vida Total " + _vidaT + "\n" +
                "Vida Actual " + _vidaAct + "\n" +
                "Experiencia " + _experiencia + "\n" +
                "Lore " + _lore + "\n"
        )
        println("Atributos:")
        for ((k, v) <- _atributos) {println(k + " -> " + v)}
        println("Resistencias:")
        for ((k, v) <- _resistencias) {println(k + " -> " + v)}
        println("Items:")
        for (i <- _inventario) {println(i.name) + " (" + i.tipo + ")"}
    }

    // IMPORTANTISIMO
    def cloning() : Campeon
}