package pl.edu.wat.core

interface ISimCalendar {
    fun add(simEvent: ISimEvent): Boolean
    fun remove(simEvent: ISimEvent): Boolean
    fun getFirst(): ISimEvent?
}