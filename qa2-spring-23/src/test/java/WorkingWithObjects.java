import model.Car;
import model.Student;
import org.junit.jupiter.api.Test;

public class WorkingWithObjects {
    @Test
    public void creatingAndUsingObjects() {
        Student dima = new Student();
        dima.setFirstName("Dmitry");
        dima.setLastName("Tester");
        dima.setEmail("tester@test.lv");
        dima.setAge(81);

        Student misha = new Student();
        misha.setFirstName("Mihailina");
        misha.setLastName("The Test Girl");
        misha.setEmail("trololo@misha.lv");
        misha.setAge(18);

// System.out.println(misha.getFirstName() + " " + misha.getLastName());
//        System.out.println();  = sout

        misha.setLastName("different");
        //       System.out.println(misha.getLastName());
        misha.printFullName();
    }
}
