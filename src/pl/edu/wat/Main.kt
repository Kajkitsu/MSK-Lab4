package pl.edu.wat

import pl.edu.wat.core.Manager
import pl.edu.wat.shop.ClientArrivalEvent
import pl.edu.wat.shop.RNGGenerator
import pl.edu.wat.shop.Surrounding
import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val simManager = Manager.getInstance()
        val surrounding = Surrounding(RNGGenerator(3.0,10.0,6.0,20.0),simManager)
        simManager.setEndSimTime(1000.0)
        simManager.registerSimEvent(ClientArrivalEvent(0.0,3,simManager,surrounding))
        simManager.startSimulation()
        surrounding.printStats()
    }
}