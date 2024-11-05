import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class RegistrationGUI extends JFrame {
  PlayerList playerList=new PlayerList();
    JTextField textField = new JTextField();
    int count = 1;

    {
        JButton startNewGame = new JButton("игра".toUpperCase());
        startNewGame.setVisible(false);
        textSetFontsAndSize(startNewGame);
        startNewGame.addActionListener(e -> {
            GameGUI gameGUI=new GameGUI();
            setVisible(false);
        });

        JButton createPlayerBut = new JButton("создать игрока "+count);
        textSetFontsAndSize(createPlayerBut);
        createPlayerBut.addActionListener(e -> {
            textField.setVisible(true);
            count++;
        });

        textSetFontsAndSize(textField);
        textField.setVisible(false);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String str=textField.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textField.setText("");
                    playerList.addPlayerToList(str);
                    textField.setVisible(false);
                    createPlayerBut.setText("создать игрока "+count);
                    if (count>=1){
                        startNewGame.setVisible(true);}
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(textField);
        panel.add(createPlayerBut);
        panel.add(startNewGame);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void textSetFontsAndSize(JComponent component) {
        component.setFont(new Font("TimesRoman", Font.BOLD, 20));
    }
}



