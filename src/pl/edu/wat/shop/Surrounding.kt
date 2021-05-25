package pl.edu.wat.shop

import pl.edu.wat.core.IManager
import pl.edu.wat.core.ISimEvent

class Surrounding constructor(
    private var rngGenerator: IRNGGenerator,
    private var simManager: IManager
) {
    private var numberOfClients = 0
    private var isClientServiced = false
    private var queue: MutableList<Client> =mutableListOf()
    private var queueTime: MutableList<Double> = mutableListOf()
    private var serviceTime: MutableList<Double> = mutableListOf()
    private var servicedClientCounter: Int = 0;


    fun clientGenerator(): Client {
        return Client(numberOfClients++,rngGenerator.getServiceInterval(),simManager.simTime())
    }



    fun getQueueSize(): Int {
        return queue.size
    }

    fun getArrivalInterval(): Double {
        return rngGenerator.getArrivalInterval()
    }

    fun getFirstClient(): Client {
        return queue[0]
    }
    fun addToQueue(client: Client): Boolean {
        return queue.add(client)
    }
    fun removeFromQueue(client: Client): Boolean {
        return queue.remove(client)
    }

    fun isClientServiced(): Boolean {
        return isClientServiced
    }

    fun setClientService(isServiced: Boolean) {
        isClientServiced = isServiced
    }

    fun addServiceTime(time: Double) {
        serviceTime.add(time)
    }

    fun addQueueTime(time: Double) {
        queueTime.add(time)
    }

    fun incServicedClient(){
        servicedClientCounter++;
    }

    fun printStats(){
        println("\n\nStatystyka: ")
        println("\tObsluzeni klienci: %d".format(servicedClientCounter))
        println("\tSredni czas w obslugi: %f".format(serviceTime.average()))
        println("\tSredni czas w kolejce: %f".format(queueTime.average()))
    }
}