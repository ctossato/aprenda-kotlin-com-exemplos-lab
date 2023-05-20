

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno (val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }

    override fun toString(): String {
        return "Nome=$nome,  Conteudo=$conteudos, Nível=$nivel, Inscritos=$inscritos"
    }
}

fun main() {

    val jose = Aluno("Jose Peçanha")
    val miriam = Aluno("Miriam Leitão")

    val cursoProcessoDesenvolvimentoSoftware = ConteudoEducacional("Processo de Desenvolvimento de Software", 120)
    val cursoGit = ConteudoEducacional("Git")
    val cursoJavaBasico = ConteudoEducacional("Java Básico", 180)
    val cursoTestesUnitarioEmJava = ConteudoEducacional("Testes Unitarios em Java", 180)
    val mentoriaPlantaoDuvidas = ConteudoEducacional("Mentoria de plantao de Duvidas", 90)
    val cursoSpring = ConteudoEducacional("Spring Boot com Java", 160)
    val cursoInjecaoDependencias = ConteudoEducacional("Injeção de dependencias com Dart", 90)

    val javaBasicoFormacao = Formacao("Java Basico", listOf(cursoProcessoDesenvolvimentoSoftware, cursoGit, cursoJavaBasico, cursoTestesUnitarioEmJava, mentoriaPlantaoDuvidas), Nivel.BASICO)
    val javaAvancadoFormacao = Formacao("Java Avancado", listOf(cursoTestesUnitarioEmJava, cursoSpring, cursoInjecaoDependencias, mentoriaPlantaoDuvidas), Nivel.DIFICIL)

    println(javaBasicoFormacao)
    println(javaAvancadoFormacao)

    javaBasicoFormacao.matricular(jose)
    javaAvancadoFormacao.matricular(miriam)

    println(javaBasicoFormacao.inscritos)
    println(javaAvancadoFormacao.inscritos)

    println(javaBasicoFormacao)
    println(javaAvancadoFormacao)


}
