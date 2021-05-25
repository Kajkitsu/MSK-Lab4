package pl.edu.wat.core

class Manager private constructor() : IManager {
    private var simCalendar = SimCalendar()
    private var currentSimTime = 0.0
    private var endSimTime = 0.0
    private var ifSimulation = false

    companion object {
        private var manager: Manager? = null
        fun getInstance(): IManager {
            return if (manager == null) {
                manager = Manager()
                manager as Manager
            } else {
                manager as Manager
            }
        }
    }



    override fun simTime(): Double {
        return currentSimTime
    }

    override fun stopSimulation() {
        ifSimulation = false
        return
    }

    override fun startSimulation() {
        ifSimulation = true
        var event = nextEvent()
        while (event != null && ifSimulation) {
            event.stateChange();
            event = nextEvent()
        }
    }

    override fun setEndSimTime(time: Double) {
        endSimTime = time
    }

    override fun nextEvent(): ISimEvent? {
        val event = simCalendar.getFirst() ?: return null
        if (event.runTime > endSimTime) {
            simCalendar.add(event)
            currentSimTime = endSimTime
            return null
        }
        currentSimTime = event.runTime
        return event
    }

    override fun registerSimEvent(simEvent: ISimEvent): Boolean {
        return simCalendar.add(simEvent)
    }
}