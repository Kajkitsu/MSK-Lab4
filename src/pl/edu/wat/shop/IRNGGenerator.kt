package pl.edu.wat.shop

import kotlin.random.Random

interface IRNGGenerator {
    fun getServiceInterval(): Double
    fun getArrivalInterval(): Double
}
