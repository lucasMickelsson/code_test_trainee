import org.example.Customer;
import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {

    @Test
    public void createCustomer(){
        Customer customer = new Customer("James", 2000, 2, 4);

        assertEquals("James", customer.getName());
        assertEquals("Was wrong", 2000, customer.getTotal_loan(), 0);
        assertEquals("Interest was wrong", 2, customer.getInterest(), 0);
        assertEquals(4, customer.getYears());
    }
}
