import controllers.FrameController

fun main() {
    val frameController = FrameController.Singleton.getInstance()
    frameController.exec()

}