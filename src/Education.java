import java.io.*;

public class Education {
    byte b = 0; // 2^7 или -128 до 127 = 1 Byte
    short s = 0; // 2 Byte = 2^15 или -32768 до 32767
    int i = 0; // 4 Byte = 2^31 или -2 147 483 648 до 2 147 483 647
    long l = 0; // 8 Byte = 2^63 или -9*10^18 до 9*10^18
    float f = 0; // 4 Byte
    double d = 0; // 8 Byte

    static strictfp class Education0 {
        // класс для лучшего расчета float переменных
    }
    abstract static class Education01 {
        // класс, который не когда не будет существовать, потому что имеет абстрактные методы и память под них не выдилиться, но вормирует наследников
    }
    static final class Education03 {
        // класс, от которого не получиться наследоваться и переопределять их методы или переменные
    }

    // модификаторы переменных
    /*
    volatile - для многопоточности
    transient - убирает из сирализации какое то поле
    static - поле помечается как общее для всех классов, не требует создания класса
    final - определяет поле как константу
    */
    // Модификаторы методов
    /*
    * static - метод использует только статические поля классов
    * final - этот метод не может быть переопределен
    * abstract - метод, который используется в абстрактном классе и переопределяется в наследниках
    * native - данный метод реализован на другом языке, допустим на C++
    * strictfp - для более точного расчета float
    * synchronized - этот метод выполняется в строгой очереди, сначала в одном потоке, потом в следующем и т.д
    *
    * При переопределении методов наследниками можно сохранять или расширять видимость модификаторами, но не уменьшать её
    * При использовании у родителя модификатора final переопределение на этом методе не будет использоваться у наследников
    * При использовании у родителя и наследника модификатора static на одном методе переопределение не будет использоваться, у каждого будет свой метод
    *
    * */

    // массивы
    int[] arr = {1,2,3};
    int[] arr2 = new int[5];
    int[] arr3 = new int[]{1,2,3};
    int[][] multiarr = {{} , {}};
    int[][] multiarr2 = new int[3][];
    // multiarr2[0] = arr2;
    void arrPrintMethod(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    // Enum
    enum Days {MONDAY, TUESDAY, WEDNESDAY};
    enum CoffeeSize {
        SMALL(100),
        MEDIUM(250),
        BIG(500){
            String getCoffeeType(){return "B";}
        };

        String coffeeType = "A"; // Переменная применяется ко всем значениям энумерации
        int ml;
        CoffeeSize(int i){
            ml = i;
        }

        public int getMl() {
            return ml;
        }
        String getCoffeeType(){return "coffeeType";}
    };

    // Конструкторы, наследование, переопределение
    static class Myparent{
        static int INT_TEST;
        static {System.out.print("Run static initializer \n");}// статический инициализатор, выполняется до конструктора
        {System.out.print("Run static initializer \n");} // инициализатор, выполняется до конструктора
        Myparent(int i){
            System.out.print("Run Parent Constructor \n");
        } // Конструктор

        int method(){return 1;}
        Myparent getRef(){return new Myparent(3);} // метод с возвращением ссылки

    }
    static public class FirstInheritor extends Myparent{
        FirstInheritor(){
            super(4); // тут подаем в конструктор родителя значение
            System.out.print("Run FirstInheritor Constructor \n");
        }
        @Override
        int method(){return 2;}
        FirstInheritor getRef(){return new FirstInheritor();} // переопределение метода с возвращением ссылки
    }
    /*
        Education.Myparent parent = new Education.Myparent(5);
        Education.Myparent child = new Education.FirstInheritor();
    * */

    // StringBuilder - для изменения строк
    static StringBuilder stringBuild = new StringBuilder("abc");
    StringBuffer SBuff;
    /* для использования в Main
     Education.stringBuild.append("def");
     */

    // Файлы и дериктории

    public static void FileCreated(String message){
    try {
            File file = new File("temp.txt"); // не физический файл, не создается на диске
            if(!file.exists()) {
            file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file); // позволяет записывать в File
            fileWriter.write(message + "\n");
            fileWriter.flush();
            // fileWriter.close();

            FileReader fileRideader = new FileReader(file); // позволяет читать File, но читает он массив байт, это не всегда удобно
            BufferedWriter bW = new BufferedWriter(fileWriter); // позволяет дописывать File
            bW.write(message);
            bW.newLine();
            bW.flush();
            bW.close();

            BufferedReader bufferedReader = new BufferedReader(fileRideader); // позволяет читать File
            while(bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }

            throw new Exception();
        } catch (Exception e) {}

    }

    // Сериализация
}
