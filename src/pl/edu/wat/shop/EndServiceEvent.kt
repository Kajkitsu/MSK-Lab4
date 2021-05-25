package pl.edu.wat.shop

import pl.edu.wat.core.IManager
import pl.edu.wat.core.ISimEvent

class EndServiceEvent(
    override var runTime: Double,
    override var simPriority: Int,
    override var simMgr: IManager,
    private var surrounding: Surrounding,
    var client: Client
) : ISimEvent {
    init {
        simMgr.registerSimEvent(this)
    }
    
    override fun stateChange() {
        println("%10.2f Zakonczono obsluge klienta %d".format(simMgr.simTime(),client.getId()))
        surrounding.setClientService(false)
        surrounding.addServiceTime(simMgr.simTime()-client.getStartOfService())
        surrounding.incServicedClient()
        if(surrounding.getQueueSize() >= 1){
            StartServiceEvent(simMgr.simTime(),10,simMgr,surrounding)
        }
    }

}
