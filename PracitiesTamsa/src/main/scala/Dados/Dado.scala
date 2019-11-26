package Dados
import java.util.Calendar
import scala.util.Random
import scala.util.Try

class Dado extends Serializable{
    // Atributos
    protected var _limite : Int = 0

    // Metodos
    // Getter
    def limite = _limite

    // Setter
    def limite_(nLimite : Int) : Unit = {_limite = nLimite}

    // Fuciones
    def lanzar() : Int = {
        var seed : Int = Calendar.getInstance().get(Calendar.MILLISECOND)
        return (Random.nextInt(seed) % limite)
    }
}