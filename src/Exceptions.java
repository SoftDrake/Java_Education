
public class Exceptions {

    void ExceptionFunc(){
        try{
            Object o = null;
            o.hashCode(); // специально сделанная ошибка
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}

// Assertions - нужен чтобы вырубать программу в определенных условиях
// Пример: assert (a > 0)


/* try - отслеживает ошибку
* catch - ловим (записываем) это ошибку
* e.printStackTrace(); - это просто пример обработки ошибки
* finally  - выполняется в любом случае - не обезательный
* Ловить ошибки следует от более мелких к более общим
* */