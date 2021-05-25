package pl.edu.wat.core

interface ISimEvent {
    var runTime: Double
    var simPriority: Int
    var simMgr: IManager
    fun stateChange()

}
