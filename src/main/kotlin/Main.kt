import controllers.FrameController
import controllers.RunController
import languages.Language

fun main() {
    val frameController = FrameController.Singleton.getInstance()
    frameController.exec()


}