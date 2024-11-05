import javax.swing.*;
import java.awt.*;



public class GameHandling extends JFrame {
    WordsLogic wordsLogic = new WordsLogic();
    private int turn = 0;
    JButton[] button;
    GameGUI gameGUI;
    private boolean symbolIsTrue;
    private boolean wordIsTrue;
    JButton startAgain=new JButton("restart");

    public GameHandling(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public void getStartBut(JButton button){
       button.addActionListener(e -> {
            GameGUI gameGUI1=new GameGUI();
           gameGUI.setVisible(false);
        });
    }


    private void nextTurn() {
        if (turn < PlayerList.getListOfPlayers().size() - 1) {
            turn++;
            if (PlayerList.getListOfPlayers().get(turn).getName() == null) {
                turn++;
            }
        } else {
            turn = 0;
        }
    }

    private String getPlayerByTurn() {
        return "ходит " + PlayerList.getListOfPlayers().get(turn).getName();
    }

    private void createButtonArray(int size) {
        JPanel panel = new JPanel(new GridLayout(1, size));
        button = new JButton[size];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(" ");
            gameGUI.textSetFontsAndSize(button[i]);
            panel.add(button[i]);
        }
        JPanel panel1=new JPanel();
        getStartBut(startAgain);
        panel1.add(startAgain);
        panel.add(panel1, BorderLayout.AFTER_LAST_LINE);
        gameGUI.add(panel, BorderLayout.SOUTH);
    }

    public void initWordAndFirstPlayerTurn() {
        wordsLogic.randomWord();
        int size = wordsLogic.wordInCharArray().length;
        createButtonArray(size);
        gameGUI.textArea.setText(getPlayerByTurn());
    }

    private void guessSymbol(char c) {
        for (int i = 0; i < WordsLogic.guessWord.length(); i++) {
            if (WordsLogic.guessWord.charAt(i) == c) {
                gameGUI.textArea.setText("есть такая буква! " + getPlayerByTurn());
                button[i].setText("" + c);
                symbolIsTrue = true;
            } else
                symbolIsTrue = false;
        }
    }

    private void notGuessSymbol(char c) {
        String str = String.valueOf(c);
        if (!WordsLogic.guessWord.contains(str)) {
            nextTurn();
            gameGUI.textArea.setText("нет такой буквы! " + getPlayerByTurn());
        }
    }

    private void guessWord(String str) {
        if (str.equals(WordsLogic.guessWord)) {
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < button.length; j++) {
                    button[i].setText(String.valueOf(ch[i]));
                }
            }
            gameGUI.textArea.setText("ура!!! победил " + PlayerList.getListOfPlayers().get(turn).getName());
            wordIsTrue = true;
        } else
            wordIsTrue = false;
    }

    private void notGuessWord(String str) {
        if (!str.equals(WordsLogic.guessWord)) {
            nextTurn();
            gameGUI.textArea.setText("неверное слово!!! " + getPlayerByTurn());
        }
    }

    public void gameLogic(String str) {
        if (str.length() > 1) {
            gameGUI.textField.getText();
            guessWord(str);
            if (!wordIsTrue)
                notGuessWord(str);
        }
        if (str.length() == 1) {
            char c = str.charAt(0);
            guessSymbol(c);
            if (!symbolIsTrue) {
                notGuessSymbol(c);
            }
        }
    }

}



