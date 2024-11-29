import kotlin.random.Random

fun main() {
    val cities = listOf("Бийск", "Барнаул", "Москва", "Санкт-Петербург", "Красноярск", "Новосибирск", "Омск", "Томск", "Кемерово", "Новокузнецк", "Ленинск-Кузнецкий", "Междуреченск", "Прокопьевск", "Киселевск", "Юрга")

    while (true) {
        println("Введите любой символ для продолжения рабоыт программы или (EXIT) для того, чтобы закончить работу")
        val input = readLine()?: ""
        if (input.uppercase() == "EXIT") break

        println()
        val from = cities.random()
        var to = cities.random()
        while (to == from)
        {
            to = cities.random()
        }
        println("ШАГ 1 - Создано направление: $from - $to")
        println()

        println("ШАГ 2 - Продать билеты")
        val tickets = Tickets()
        var passengersCount = tickets.sellTickets()
        println("Продано билетов: $passengersCount")

        println()
        println("ШАГ 3 - Собрать состав")
        var CountCarriages=0
        val carriages = mutableListOf<Carriage>()
        var remainingPassengers = passengersCount
        while (remainingPassengers > 0) {
            val carriage = Carriage()
            carriage.passengers = if (remainingPassengers >= carriage.capacity) carriage.capacity else remainingPassengers
            remainingPassengers -= carriage.passengers
            carriages.add(carriage)
            CountCarriages++
        }

        println("Пассажиров: $passengersCount")
        for (i in carriages.indices) {
            println("Вагон ${i + 1}: ${carriages[i]}")
            if (carriages[i].passengers < carriages[i].capacity) {
                println("В вагоне ${i + 1} едет ${carriages[i].passengers} человек из ${carriages[i].capacity}")
            } else {
                println("Вагон ${i + 1} заполнен полностью")
            }
        }
        println()

        println("ШАГ 4 - Отправить состав")
        val train = Train(from, to, CountCarriages)
        train.sendTrain()

    }
}