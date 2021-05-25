package pl.edu.wat.shop

class Client constructor(
    private var id:Int,
    private var timeOfService:Double,
    private var creationTime:Double) {

    private var startOfServiceTime:Double = 0.0;

    fun getId(): Int {
        return id
    }

    fun getServiceTime(): Double {
        return timeOfService;
    }



    fun setStartOfServiceTime(time: Double){
        startOfServiceTime = time
    }

    fun getCreationTime(): Double {
        return creationTime
    }

    fun getStartOfService(): Double{
        return startOfServiceTime
    }




}