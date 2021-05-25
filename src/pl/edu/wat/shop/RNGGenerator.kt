package pl.edu.wat.shop

import kotlin.random.Random

class RNGGenerator constructor(
    private val fromServiceTime:Double,
    private val toServiceTime:Double,
    private val fromArrivalTime:Double,
    private val toArrivalTime:Double
):IRNGGenerator {

    override fun getServiceInterval(): Double {
        return Random.nextDouble(fromServiceTime,toServiceTime)
    }

    override fun getArrivalInterval(): Double {
        return Random.nextDouble(fromArrivalTime,toArrivalTime)
    }
}