public interface IEducationInterface extends IOtherEducationInterface {
    // абстрактный класс для описания поведения
    // все переменные будут константными (public static final)
    void secondSomeMethod();
}
interface IOtherEducationInterface{
    void someMethod();
}

class EducationTwo implements IEducationInterface, IOtherEducationInterface {
    @Override
    public void someMethod(){

    };
    @Override
    public void secondSomeMethod(){

    };
}