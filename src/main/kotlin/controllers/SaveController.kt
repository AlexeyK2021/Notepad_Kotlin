package controllers

import frames.FileChooser
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class SaveController {
    object Singleton {
        private var saveController: SaveController? = null
        fun getInstance(): SaveController {
            if (saveController == null) {
                saveController = SaveController()
            }
            return saveController!!
        }
    }

    private var path: String = ""

    fun open(): String? {
        val fileChooser = FileChooser()
        if (fileChooser.showDialog(null, "Открыть файл") == 0) {
            path = fileChooser.getChosenFile()!!.path
            return path
        }
        return null
    }

    fun save(info: String): String? {
        val fileChooser = FileChooser()

        if (path == "") {
            if (fileChooser.showDialog(null, "Сохранить файл") == 0)
                path = fileChooser.getChosenFile()?.path!!
        }

        with(File(path)) {
            try {
                this.writeText(text = info, charset = Charset.defaultCharset())
            } catch (e: IOException) {
                return null
            }
        }
        return path
    }


}