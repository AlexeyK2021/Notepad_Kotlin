package frames

import java.awt.Dimension
import java.awt.Image
import java.awt.Toolkit
import java.io.File
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JTextField

class MainFrame : JFrame() {
    init {
        super.setTitle("Notepad")
        iconImage = ImageIcon("src/main/resources/notes.png").image  //?????????????????????
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(200, 200)
        isResizable = true
        isVisible = true
    }
}