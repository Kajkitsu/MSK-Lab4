package pl.edu.wat.core

interface IManager {
    companion object {
    fun getInstance() {}
    }
    fun registerSimEvent(simEvent: ISimEvent): Boolean
    fun simTime():Double
    fun stopSimulation()
    fun startSimulation()
    fun setEndSimTime(time: Double)
    fun nextEvent(): ISimEvent?
}
