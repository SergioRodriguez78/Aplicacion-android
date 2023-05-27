package com.example.primerospasos

fun main() {
    variablesAlfanumericas()
    showAge(23)
    var suma = sumarNumeros(4, 5)
    println("la suma es $suma")
    Listas()

}
fun Listas(){
    var lista:List<String> = listOf("luens","martes","miercoles")


    var filterr= lista.filter { it.contains("a") }
    println(filterr)

    var dias:MutableList<String> = mutableListOf("martes","miercoles")
    dias.add("jueves")
    dias.add(0,"lunes")
    
}

fun arraysYloops(){
    val dias= arrayOf("luens","martes","miercoles")
    print(dias[0])
    for(posicion in dias.indices){
        print(dias[posicion])
    }
    for ((posicion,value) in dias.withIndex()){
        print("la posicion es $posicion y el valor es $value")
    }
    for(valor in dias){}
}

fun valorAleatorio(vari: Any): Any {
    return when (vari) {
        is Int -> vari + vari
        is String -> print("hola")
        else -> 1
    }
    val result = when (vari) {
        is Int -> vari + vari
        is String -> print("hola")
        else -> 1
    }

}

fun semestreWhen(mont: Int) {
    when (mont) {
        in 1..6 -> print("Rango de 1 a 6")
        in 7..12 -> print("Rango de 7 a 12")
        !in 1..12 -> print("mal valor")
    }
}

fun getTrimestre(month: Int) {
    when (month) {
        1, 2, 3 -> print("primer trimestre")
        4, 5, 6 -> print("segundo trimestre")
        7, 8, 9 -> print("tercer trimestre")
        10, 11, 12 -> print("cuarto trimestre")
    }
}

fun whenFunctionGetMont(month: Int) {
    when (month) {
        1 -> print("enero")
        2 -> print("febrero")
        3 -> print("marzo")
        4 -> print("abril")
        5 -> print("mayo")
        6 -> print("junio")
        7 -> print("julio")
        8 -> print("agosto")
        9 -> print("septiembre")
        10 -> print("octubre")
        11 -> print("noviembre")
        12 -> {
            print("dicimebre")
            print("mes de cumpleee")
        }

        else -> print("No es valido")
    }
}

fun iflese() {
    var name: String = "Aris"
    if (name.uppercase() == "ARIS") {
        println("Se puede comparar con = strings")
    } else if (name == "coyote") {
        print("Es coyote")
    }
}

fun showAge(currentAge: Int) {
    println("TEngo $currentAge")
}

fun sumarNumeros(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun variablesNumericas() {
    //Int
    val edad: Int = 40
    //Long
    val largo: Long = 32424
    //float
    val decimales: Float = 45.46f //debe tener letra f
    //Double
    val oubleExample = 6546.6465
}

fun variablesAlfanumericas() {

    //Alfanumericas
    //char
    val letra: Char = 's'
    //String
    val nombre: String = "SErgio"
    //BOOLEAN
    val estado: Boolean = true

    val edad: Int = 40
    var texto: String = "Hola me llamo $nombre y tengo $edad años"
    println(texto)
}