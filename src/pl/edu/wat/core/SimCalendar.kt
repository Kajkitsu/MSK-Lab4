package pl.edu.wat.core

import java.util.*


class SimCalendar: ISimCalendar {
    class EventComparator : Comparator<ISimEvent> {
        fun compare(var0: Int, var1: Int): Int {
            return if (var0 < var1) -1 else if (var0 == var1) 0 else 1
        }
        override fun compare(firstEvent: ISimEvent, secondEvent: ISimEvent): Int {
            val firstComp = if (firstEvent.runTime < secondEvent.runTime) -1 else if (firstEvent.runTime == secondEvent.runTime) 0 else 1
            if(firstComp == 0){
                return if (firstEvent.simPriority > secondEvent.simPriority) -1 else if (firstEvent.simPriority == secondEvent.simPriority) 0 else 1
            }
            return firstComp
        }
    }

    var simEventQueue: PriorityQueue<ISimEvent> = PriorityQueue(EventComparator())

    override fun add(simEvent: ISimEvent): Boolean {
        return simEventQueue.add(simEvent)
    }

    override fun remove(simEvent: ISimEvent): Boolean {
        return simEventQueue.remove(simEvent)
    }

    override fun getFirst(): ISimEvent? {
        return simEventQueue.poll()
    }
}