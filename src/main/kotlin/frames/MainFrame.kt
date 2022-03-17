package frames

import controllers.SaveController
import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.*

class MainFrame : JFrame() {
    init {
        super.setTitle("Notepad")
        iconImage = ImageIcon("src/main/resources/notes.png").image  //?????????????????????
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(400, 400)
        isResizable = true
        contentPane.layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)

        val instrumentsPanel = JPanel()
        instrumentsPanel.layout = BoxLayout(instrumentsPanel, BoxLayout.X_AXIS)
        val openButton = JButton("open")
        val saveButton = JButton("save")
        val newButton = JButton("new")
        val textField = JTextArea()
        val scrollText = JScrollPane(textField)
        scrollText.setBounds(10, 60, 780, 500);
        scrollText.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

        newButton.addActionListener { new() }
        openButton.addActionListener { open(textField) }
        saveButton.addActionListener { save(textField) }

        instrumentsPanel.add(newButton)
        instrumentsPanel.add(openButton)
        instrumentsPanel.add(saveButton)
        contentPane.add(instrumentsPanel)
        // contentPane.add(textField)
        contentPane.add(scrollText)
        isVisible = true

    }

    private fun new() {
        SaveController.Singleton.getInstance().new()
    }

    private fun save(textField: JTextArea) {
        SaveController.Singleton.getInstance().save(textField.text)
    }

    private fun open(textField: JTextArea) {
        textField.text = SaveController.Singleton.getInstance().open()
    }

}