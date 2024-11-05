import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameGUI extends JFrame {
    GameHandling gameHandling = new GameHandling(this);
    JTextField textField = new JTextField();
    JTextField textArea = new JTextField();


    {
        gameHandling.initWordAndFirstPlayerTurn();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textSetFontsAndSize(textField);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String str= textField.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textField.setText("");
                    gameHandling.gameLogic(str);
                }
            }
        });

        textArea.setEditable(false);
        textSetFontsAndSize(textArea);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(textArea);
        panel.add(textField);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void textSetFontsAndSize(JComponent component) {
        component.setFont(new Font("TimesRoman", Font.BOLD, 20));
    }
}







