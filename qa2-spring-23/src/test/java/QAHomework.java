import model.Car;
import model.House;
import org.junit.jupiter.api.Test;

public class QAHomework {
    @Test
    public void usingObjectCar() {
        Car audi = new Car();
        audi.setUsed(true);
        audi.isItUsed();
    }
    @Test
    public void usingObjectHouse() {
        House theBestHouse = new House();
        theBestHouse.setPrice(1690490L);
        theBestHouse.setTotalArea(100L);
        theBestHouse.getPricePerSquareMeter();
        theBestHouse.printPricePerSquareMeter();
    }
}
