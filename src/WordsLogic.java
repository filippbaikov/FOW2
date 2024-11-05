import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordsLogic {
    private final String[] words;
    public static String guessWord;

    public WordsLogic() {
        words = new String[]{"школа", "дом", "мама", "музыка", "машина",
                "телефон", "кровать", "стол", "горшок",
                "корова", "баран", "шкаф", "колбаса", "хлеб", "тумба", "собака",
                "кот", "ворона", "окно", "коляска", "танк", "корабль", "белка",
                "штаны", "шапка", "кукла", "шарик", "площадка", "качели", "трактор", "горка", "варежки", "стакан",
                "зеркало", "лекарство", "варенье", "котлета", "тарелка", "сковородка",
                "ковёр", "малина", "яблоко", "морковь", "макароны", "йогурт",
                "автобус", "такси", "вентилятор", "борьба", "танец", "компьютер",
                "книга", "карандаш", "фломастер", "розетка", "кофе", "сыр",
                "носорог", "тигр", "заяц", "петух", "человек", "велосипед",
                "самокат", "санки", "бабушка", "печень", "медаль", "пулемёт",
                "журнал", "игрушка", "гусеница", "подарок", "дверь", "куртка",
                "коробка", "одежда", "магазин", "кафе", "ракета", "артиллерия",
                "автоматон","киборг","фонарь","мышь","подушка","салфетка",
                "альбом","грешник","рука","нога","мозг","сумка",
                "кабачок","баклажан","солнце","планета","галактика","созвездие",
                "корзина","еда","ухо","огонь","мина","радиация","троллейбус","мультик","кино",
                "мститель","динозавр","пластилин","свет","тьма","волшебство",
                "кнопка","снег","птичка","батут","повязка","укол",
                "шприц","цирк","черепаха","ниндзя","цветок","колокол",
                "песня","гармонь","балалайка","барабан","орган","фотоаппарат",
                "чёрт","ёж","лиса","волк","крокодил","единорог",
                "портал","игра","фигня","цвет","серёжка","расчёска",
                "шампунь","паста","порошок","радуга","ванна","щётка",
                "мыло","вода","пузырь","пена","тыква","арбуз"};

    }

    private List<String> arrayToList(String[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
        //Arrays.stream(arr).toList();
    }

    public void randomWord() {
        Random random = new Random();
        guessWord = arrayToList(words).get(random.nextInt(arrayToList(words).size()));
    }

    public char[] wordInCharArray() {
        return guessWord.toCharArray();
    }

}




