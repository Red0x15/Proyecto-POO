import Items._
import Campeones._
import Enemigos._
import Lugares._
import Partidas._
import Dados._

import scala.io.Source
import java.io._

object Game extends App {
    var path : String = "moo.txt"
    var exist = new java.io.File(path).exists
    if (exist){
        var reader : ObjectInputStream = new ObjectInputStream(new FileInputStream(path))
        var juego : PracticitiesTamsa = reader.readObject.asInstanceOf[PracticitiesTamsa]
        reader.close()
        juego.elInicioDelFin()

        var writer : ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(path))
        writer.writeObject(juego)
        writer.close()
    }
    else {
        var juego : PracticitiesTamsa = new PracticitiesTamsa()
        juego.elInicioDelFin()

        var writer : ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(path))
        writer.writeObject(juego)
        writer.close()
    }
}