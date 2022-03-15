package frames

import java.awt.Dimension
import java.io.File
import javax.swing.JFileChooser
import javax.swing.UIManager

class FileChooser : JFileChooser() {
    private var chosenFile: File? = null

    init {
        isVisible = true
        size = Dimension(400, 500)
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
    }

    override fun approveSelection() {
        super.approveSelection()
        chosenFile = super.getSelectedFile()
    }

    fun getChosenFile(): File? = chosenFile

}