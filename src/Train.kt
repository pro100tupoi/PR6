class Train {
    private val from: String
    private val to: String
    private val countCarriages: Int

    constructor(from: String, to: String, countCarriages: Int) {
        this.from = from
        this.to = to
        this.countCarriages = countCarriages
    }

    fun sendTrain() {
        println("Поезд $from - $to, состоящий из $countCarriages вагонов отправлен")
    }
}