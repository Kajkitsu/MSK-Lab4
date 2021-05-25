package pl.edu.wat.shop

import pl.edu.wat.core.IManager
import pl.edu.wat.core.ISimEvent

class ClientArrivalEvent constructor(override var runTime:Double, override var simPriority: Int, override var simMgr: IManager, private var surrounding: Surrounding) :ISimEvent {
    init {
        simMgr.registerSimEvent(this)
    }
    override fun stateChange() {
        var client = surrounding.clientGenerator()
        println("%10.2f Przybycie klienta %d".format(simMgr.simTime(),client.getId()))

        surrounding.addToQueue(client)
        if(!surrounding.isClientServiced()){
            StartServiceEvent(simMgr.simTime(),10,simMgr,surrounding)
        }
        ClientArrivalEvent(
            surrounding.getArrivalInterval()+simMgr.simTime(),2,simMgr,surrounding
        )


    }
}