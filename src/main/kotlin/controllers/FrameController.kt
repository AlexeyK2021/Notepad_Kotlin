package controllers

import frames.MainFrame

class FrameController {
    object Singleton {
        private var frameController: FrameController? = null
        fun getInstance(): FrameController {
            if (frameController == null) {
                frameController = FrameController()
            }
            return frameController!!
        }
    }

    private lateinit var mainFrame: MainFrame
    fun exec() {
        mainFrame = MainFrame()
    }

}