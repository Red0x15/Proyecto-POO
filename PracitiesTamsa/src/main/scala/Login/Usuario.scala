package Login
import Partidas._

class Usuario(){
    //atributos
    private var _nombre : String = ""
    private var _id : Int = -1
    private var _contrasena : String = ""
    private var _historial : Map[String, Set[PartidaHistoria]] = Map("Victorias" -> Set() , "Derrotas" -> Set())

    // get & Set
    def nombre = _nombre
    def id = _id
    def contrasena = _contrasena
    def historial=_historial

    def nombre_( s : String ) = _nombre = s
    def historial_ ( m : Map[String, Set[PartidaHistoria]] ) = _historial = m
    def id_ ( i : Int) = _id = i
    def contrasena_( s : String) = _contrasena = s

    def verPerfil() : Unit ={
        println( "Nombre : " + this.nombre + 
                  "\nId : " + this.id + "\n"
        )
    }

    def verHistorial() : Unit ={
        val temp = this.historial("Victorias")
        val temp2 = this.historial("Derrotas")
        println("Partidas Ganadas ")
        for (i <- temp) {println(i.name)}
        println("Partidas Perdidas ")
        for (i <- temp2) {println(i.name)}
    }
}