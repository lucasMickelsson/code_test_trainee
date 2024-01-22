import org.example.MortageHandler;
import org.junit.Test;
import static org.junit.Assert.*;

public class MortageHandlerTest {
    @Test
    public void testCalculationOfMortage(){
        MortageHandler mortageHandler =
                new MortageHandler(2, 2000, 4);
        assertTrue((mortageHandler.calculate_mortage()>500));
    }
    @Test
    public void testCalculationOfMortgageWithDifferentValues() {
        MortageHandler mortgageHandler = new MortageHandler(3, 3000, 5);
        assertTrue(mortgageHandler.calculate_mortage() > 600);
    }
    @Test
    public void testCalculationOfMortgageWithAnotherSetOfValues() {
        MortageHandler mortgageHandler = new MortageHandler(1, 1000, 3);
        assertTrue(mortgageHandler.calculate_mortage() > 300);
    }
}
