import kotlin.random.Random

class Carriage {
    var capacity: Int = 0
    var passengers: Int = 0

    init {
        capacity = Random.nextInt(5, 25) // рандомная вместимость от 5 до 25
    }

    override fun toString(): String {
        return "Вагон вместимостью $capacity пассажиров"
    }
}