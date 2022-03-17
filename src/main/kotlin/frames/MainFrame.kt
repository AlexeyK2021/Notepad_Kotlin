package frames

import controllers.SaveController
import java.awt.Dimension

import javax.swing.*

class MainFrame : JFrame() {
    private val textField = JTextArea()
    private var savedText = ""

    init {
        super.setTitle("Notepad")
        iconImage = ImageIcon("src/main/resources/notes.png").image
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(400, 400)
        isResizable = true
        contentPane.layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)

        val instrumentsPanel = JPanel()
        instrumentsPanel.layout = BoxLayout(instrumentsPanel, BoxLayout.X_AXIS)
        val openButton = JButton("open")
        val saveButton = JButton("save")
        val newButton = JButton("new")
        val scrollText = JScrollPane(textField)
        val language = JComboBox(arrayOf("Python", "Java"))
        language.maximumSize = Dimension(100, 50)

        scrollText.setBounds(10, 60, 780, 500)
        scrollText.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS

        newButton.addActionListener { new() }
        openButton.addActionListener { open() }
        saveButton.addActionListener { save() }

        instrumentsPanel.add(newButton)
        instrumentsPanel.add(openButton)
        instrumentsPanel.add(saveButton)
        instrumentsPanel.add(language)


        instrumentsPanel.alignmentX = LEFT_ALIGNMENT

        contentPane.add(instrumentsPanel)
        contentPane.add(scrollText)
        isVisible = true

    }

    private fun new() {
        if (savedText != textField.text) {
            val options = arrayOf<Any>("Да", "Нет")
            val answer = JOptionPane.showOptionDialog(
                null,
                "Вы не сохранили файл. Сохранить сейчас?",
                "Сохранение",
                JOptionPane.YES_NO_OPTION,
                0,
                null,
                options,
                0
            )
            if (answer == 0) save()
        }
        textField.text = ""
        savedText = ""
    }

    private fun save() {
        SaveController.Singleton.getInstance().save(textField.text)
        savedText = textField.text
    }

    private fun open() {
        textField.text = SaveController.Singleton.getInstance().open()
    }

}