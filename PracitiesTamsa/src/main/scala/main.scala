import Login._
import Items._
import Dados._
import Partidas._
import Enemigos._
import Campeones._
import Lugares._
import scala.io.StdIn

object prueba1 extends App {
    var usuarios    : Map[Int,Usuario] = Map() // cargarUsuarios()
    var items       : Set[Item] = Set() // cargaItem()
    var dados       : Set[Dado] = Set() // cargarDado()
    var lugares     : Set[Lugar] = Set() // cargarLugar()
    var enemigos    : Map[Int,Enemigo] = Map() // cargarEnemigo()
    var partidas    : Map[Int,PartidaHistoria] = Map() // cargarPartida()
    var campeones   : Map[String, Campeon] = Map(
                                                ("Vikingo" -> new Vikingo()),
                                                ("Valquiria" -> new Valquiria()),
                                                ("Jotun" -> new Jotun()),
                                                ("Elfo" -> new Elfo())
                                            )
    //  si existe el archivo de campeones txt lealo, sino , creelo le pone un Nil y luego lo lee
    var tipos : Set[String] = Set("Arco", "Escudo", "Espada", "Hacha", "Talisman", "Varita", "Pocion")

    //  si existe el archivo de campeones txt lealo, sino , creelo le pone un 0 y luego lo lee
    var nUsuariosIds    : Int = 0
    var nEnemigosIds    : Int = 0
    var nPartidasIds    : Int = 0
    var lobby : Map[Int, Set[Int]] = Map() // de id partida a ids de campeones

    println("1.) Si ya es todo un nordico \n2.) Si apenas comienza en esta sangrienta aventura\n3.) Salir")
    var option : Int = readInt()
    while(option != 3) {
        if(option == 2) crearUsuario()
        var break : Boolean = false
        var temp = ingresarUsuario()
        var a = temp._1
        var b = temp._2

        while(!break){
            if(b){
                while(!break){
                    println( "\nMenu Del Nordico : \n1.) Crear un Item \n2.) Eliminar un Item")
                    println( "3.) Crear un Enemigo \n4.) Eliminar un Enemigo")
                    println("5.) Crear un Lugar \n6.) Eliminar un Lugar" )
                    println("7.) Crear un Dado \n8.) Eliminar un Dado" )
                    println("9.) Agregar tipo de item\n10.) eliminar tipo de item" )
                    println("11.) Ver perfil\n12.) Ver historial de partidas" )
                    println("13.) Entrar en partida \n14.) Crear Partida" )
                    println("15.) Reanudar partida \n16.) Iniciar partida \n17.) Desconectarse" )
                    option = readInt()
                    option match{
                        case 1 => crearItem()
                        case 2 => eliminarItem()
                        case 3 => crearEnemigo()
                        case 4 => eliminarEnemigo()
                        case 5 => crearLugar()
                        case 6 => eliminarLugar()
                        case 7 => crearDado()
                        case 8 => eliminarDado()
                        case 9 => agregarTipo()
                        case 10 => eliminarTipo()
                        case 11 => a.verPerfil()
                        case 12 => a.verHistorial()
                        case 13 => entrarPartida(a)
                        case 14 => crearPartida(a)
                        // case 15 => reanudarPartida(a)
                        case 16 => iniciarPartida(a)
                        case 17 => {/*guardar();*/ break = true }
                        case _ => None
                    }
        

                }
            }
            else{
                println("Un verdadero nordico se conoce a si mismo. ¿Quieres volver a intentarlo? (1- Si, 2- No)")
                if(readInt() == 2) break = true
                else {
                    temp = ingresarUsuario()
                    a = temp._1
                    b = temp._2
                }
            }
        }
        println("Por las barbas de Thor tu otra vez, espero verte devuelta")
        println("\n1.) Si ya es todo un nordico \n2.) Si apenas comienza en esta sangrienta aventura\n3.) Salir")
        option = readInt()
    }
    
    // Afinar el retorno de esta funcion
    private def ingresarUsuario() :(Usuario,Boolean) ={
        // se confirma con un usuario existente
        println("\nMe enorgullece verte de nuevo")
        println("Ingresar nombre: ")
        var n : String = readLine()
        println("Ingresar contraseña: ")
        var m : String = readLine()
        for((k,v) <- usuarios) {
            if(v.nombre == n && v.contrasena == m) return(v,true)
        }
        return (new Usuario(),false)
    }

    private def crearUsuario() : Unit = {
        // se crea una cuenta
        var aux = new Usuario()
        println("Ingresar nombre: ")
        aux.nombre_(readLine()) 
        println("Ingresar contraseña: ")
        aux.contrasena_(readLine())
        aux.id_(nUsuariosIds)
        nUsuariosIds += 1
        usuarios += ( aux.id -> aux)
        println("Bienvenido a esta gran aventura " + aux.nombre)
    }

    // // traer del txt los datos del usuario
    // private def cargarUsuarios() : List[Usuario] ={}

    // private def cargarItem() : List[Item]={}

    // private def cargarEnemigo() : List[Enemigo]={}

    // private def cargarLugar() : List[Lugar]={}

    // private def cargarCampeon() : List[Campeon]={}

    // private def cargarPartida() : List[PartidaHistoria]={}

    // private def cargarDado() : List[Dado] ={}

    private def crearItem() : Unit = {
        var aux : Item = new Item()
        println("Ingrese el nombre de el item: ")
        aux.name = readLine()
        println("Ingrese el tipo de el item: ")
        aux.tipo = readLine()
        var nombres     : Set[String] = Set("Aire","Fuego","Agua","Tierra","Luz","Oscuridad")
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        for(i <- nombres) {
            println("Ingrese el valor del atributo de "+ i +" que aporta el item: ") 
            tempStats += ( i -> readInt())
            println("Ingrese el valor del resistencia de "+ i +" que aporta el item: ") 
            tempResist += ( i -> readInt())
        }
        aux.atributos = tempStats
        aux.resistencias = tempResist
        items += aux 
    }

    private def eliminarItem() : Unit = {
        println("Ingrese el nombre de el item: ")
        var x = readLine()
        var temp = items.toList.filter(_.name == x)
        if (temp != Nil) items -= temp(0)
        else println("Aun no hay Items para eliminar")
    }

    private def crearEnemigo() : Unit = {
        var aux : Enemigo =  new Enemigo()
        var counter : Int = 0
        var nombres : Set[String] = Set("Aire","Fuego","Agua","Tierra","Luz","Oscuridad")
        var tempResist  : Map[String, Int] = Map()

        aux.id_(nEnemigosIds)
        nEnemigosIds+=1
        println("Ingrese la raza del enemigo: ")
        aux.raza_(readLine())  
        println("Ingrese el nivel del enemigo: ")
        aux.nivel_(readInt())  
        println("Ingrese la vida del enemigo: ")
        aux.vidaAct_(readInt()) 
        aux.vidaT_(aux.vidaAct)
        println("Ingrese el atributo del enemigo:  ")
        for (i <- nombres) {println(counter + " -> " + i); counter += 1}
        aux.atributo_(nombres.toList(readInt))
        println("Ingrese el valor de "+ aux.atributo +" del enemigo: ")
        aux.valAtributo_(readInt())
        for( i <- nombres) {
            println("Ingrese el valor del resistencia de "+ i +" que tiene el enemigo: ") 
            tempResist += ( i -> readInt())
        }
        aux.resistencias_(tempResist)
        println("Ingrese el lore del enemigo: ")
        aux.lore_(readLine()) 
        enemigos += (aux.id -> aux)  
    }

    private def eliminarEnemigo() : Unit = {
        println("Ingrese el id del enemigo: ")
        var x = readInt()
        enemigos -= x
    }

    private def crearLugar() : Unit = {
        var aux : Lugar = new Lugar()
        println("Ingrese el nombre de el lugar: ")
        aux.name_(readLine())  
        println("Ingrese el nivel de el lugar: ")
        aux.nivel_(readInt())
        lugares += aux 
    }

    private def eliminarLugar() : Unit = {
        println("Ingrese el nombre del lugar: ")
        var x = readLine
        var temp = lugares.toList.filter(_.name == x )
        if (temp != Nil) lugares -= temp(0)
        else println("Aun no hay lugares para eliminar")
    }

    private def crearDado() : Unit = {
        var aux : Dado = new Dado()
        println("Ingrese cuantas caras desea que tenga el dado: ")
        aux.limite_(readInt())
        dados += aux 
    }

    private def eliminarDado() : Unit = {
        println("Ingrese cuantas caras tiene el dado: ")
        var x = readInt()
        var temp = dados.toList.filter(_.limite == x )
        if (temp != Nil) dados -= temp(0)
        else println("Aun no hay dados para eliminar")
    }

    private def crearCampeon(a:Usuario) : Campeon = {

        var nombres     : Set[String] = Set("Aire","Fuego","Agua","Tierra","Luz","Oscuridad")
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        
        println("Que tipo de campeon desea crear?:")
        for ((k, v) <- campeones) {println(k)}
        var aux = campeones(readLine()).cloning
        aux.id_(a.id)
        println("\nIngrese el nombre del campeon: ")
        aux.name_(readLine())  
        println("\nIngrese la raza del campeon: ")
        aux.raza_(readLine())  
        println("\nIngrese el nivel del campeon: ")
        aux.nivel_(readInt())  
        aux.experiencia_(0)
        // Se podría agregar un lugar que estuviera fuera de la partida
        // println("Ingrese la ubicacion del campeon: ")
        // aux.ubicacion_(readLine())  
        println("Ingrese la vida del campeon: ")
        aux.vidaAct_ (readInt()) 
        aux.vidaT_(aux.vidaAct)

        for(i <- nombres) {
            println("Ingrese el valor del atributo de "+ i +" que tiene el campeon: ") 
            tempStats += ( i -> readInt())
            println("Ingrese el valor del resistencia de "+ i +" que tiene el campeon: ") 
            tempResist += ( i -> readInt())
        }
        aux.atributos_(tempStats)
        aux.resistencias_(tempResist)
        println("Ingrese el lore del campeon: ")
        aux.lore_(readLine()) 
        aux.inventario_(Nil)
        return aux
    }

    private def agregarTipo() : Unit = {
        println("Ingrese el tipo de item que desea agregar: ")
        var x = readLine()
        tipos += x
    }

    private def eliminarTipo() : Unit = {
        println("Ingrese el tipo de item que desea eliminar: ")
        var x = readLine()
        var temp = tipos.toList.filter(_ == x)
        if (temp != Nil) tipos -= temp(0)
        else println("Aun no hay Tipos para eliminar")
    }


    private def crearPartida(a:Usuario) : Unit = {
        var aux : PartidaHistoria = new PartidaHistoria()
        aux.id= nPartidasIds
        nPartidasIds+=1
        aux.gm = a.nombre
        println("Ingrese la contraseña de su partida")
        aux.contrasena_(readLine())
        println("Dados para su partida:")
        var d : List[Dado] = Nil
        for( i <- dados ){
            println("Desea incluir el dado de " + i.limite +" caras?(1-Si,2-No)")
            if(readInt() == 1){
                d= i::d
            }
        }
        aux.dados = d
        println("Items para su partida:")
        var it : List[Item] = Nil
        for( i <- items ){
            println("Desea incluir el item"); i.info(); println(" ?(1-Si,2-No)")
            if(readInt() == 1){
               it= i::it
            }
        }
        aux.items = it
        println("Lugares para su partida:")
        var l : List[Lugar] = Nil
        for( i <- lugares ){
            println("Desea incluir el lugar " + i.name + " de nivel " + i.nivel +" ?(1-Si,2-No)")
            if(readInt() == 1){
                l= i::l
            }
        }
        aux.lugares = l
        println("enemigos para su partida:")
        var e : List[Enemigo] = Nil
        for((k, v) <- enemigos){
            println("Desea incluir el enemigo\n"); v.info(); println(" ?(1-Si,2-No)")
            if(readInt() == 1){
               e = v.cloning()::e
            }
        }
        aux.enemigos = e
        partidas += (aux.id -> aux)
        lobby += (aux.id -> Set())
    }

    private def entrarPartida(a:Usuario) : Unit = {
        imprimirLobby()
        println("\n\nA cual partida desea ingresar? ( -1.) si no desea ingresar a ninguna )")
        var aux : Int = readInt()
        if(aux != -1){
            println("Ingrese la contraseña: ")
            if(partidas(aux).ingresar(readLine())){
                var l: Set[Int] = lobby(aux)
                l += a.id
                lobby-= aux
                lobby+= (aux -> l )
                partidas(aux).jugadores = crearCampeon(a) :: partidas(aux).jugadores
            }
            else{
                println("No eres digno para tomar este camino")
            }
        }
        else{
            println("Animate a crear tu propio camino a Loki")
        }
    }

    private def iniciarPartida(a:Usuario) : Unit = {
        imprimirLobby()
        println("\n\nCual partida desea iniciar? ( -1.) si no desea iniciar ninguna )")
        var aux : Int = readInt()
        if(aux != -1){
            if(a.nombre == partidas(aux).gm){
                if(lobby(aux).size >= 2 ){
                    partidas(aux).jugar()
                    /* Hay que corregir este proceso */
                    if(partidas(aux).terminada){
                        if(partidas(aux).victoria ){
                            var tmp = partidas(aux)
                            for(i <- lobby(aux) ){
                                var v = usuarios(i).historial("Victorias")
                                var w = usuarios(i).historial
                                v = tmp :: v 
                                w -= "Victorias"
                                w += ("Victorias" -> v) 
                                usuarios(i).historial_(w)
                            }
                        }
                        else{
                            var tmp = partidas(aux)
                            for(i <- lobby(aux)  ){
                                var v = usuarios(i).historial("Derrotas")
                                var w = usuarios(i).historial
                                v= tmp :: v 
                                w -= "Derrotas"
                                w += ("Derrotas" -> v) 
                                usuarios(i).historial_(w)
                            }
                        }
                        lobby -= aux
                    }
                }
                else{
                    println("No apresureis querido nordico, espera para que la diversion sea aun mayor.")
                }
            }
            else{
                println("Crea tu propia partida *** Jörmundgander!!")
            }
        }
        else{
            println("Vamos nordico, no hay frio que congele las ganas de jugar que hay dentro de ti")
        }

    }

    // private def reanudarPartida(a:Usuario) : Unit {}

    // private def cargar() : Unit ={}

    // Revisar saturacion de informacion
    private def imprimirLobby() : Unit = {
        for((s,v) <- lobby ){
                println( " Informacion de la partida con id: "+ s)
                var partida : PartidaHistoria = partidas(s)
                println(" los dados que pertenecen a la partida son: ")
                for( i <- partida.dados) { println("dado de "+ i.limite + " caras")}
                println(" los items que pertenecen a la partida son: ")
                for( i <- partida.items) { i.info()}
                println(" los lugares que pertenecen a la partida son: ")
                for( i <- partida.lugares) { println(i.name + " nvl." + i.nivel)}
                println(" los enemigos que pertenecen a la partida son: ")
                for( i <- partida.enemigos) {i.info()}

                println( " Informacion de los nordicos ")
                for(k <- v ) {usuarios(k).verPerfil }
        }
    }

}