package pl.edu.wat.shop

import pl.edu.wat.core.IManager
import pl.edu.wat.core.ISimEvent

class StartServiceEvent(
    override var runTime: Double,
    override var simPriority: Int,
    override var simMgr: IManager, 
    private var surrounding: Surrounding
) : ISimEvent {
    init {
        simMgr.registerSimEvent(this)
    }
    
    override fun stateChange() {
        val client = surrounding.getFirstClient()
        println("%10.2f Rozpoczęto obsluge klienta %d".format(simMgr.simTime(),client.getId()))
        client.setStartOfServiceTime(simMgr.simTime())
        surrounding.addQueueTime(simMgr.simTime()-client.getCreationTime())
        surrounding.setClientService(true)
        surrounding.removeFromQueue(client)
        EndServiceEvent(client.getServiceTime()+simMgr.simTime(),10,simMgr,surrounding,client)

    }

}
