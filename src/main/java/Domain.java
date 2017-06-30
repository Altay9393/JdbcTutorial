import bi.Util;
import entity.Address;
import entity.Employee;
import service.AddressService;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rashid on 28.06.2017.
 */
public class Domain {
    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();

        Address address =  new Address();
        address.setId(2L);
        address.setCountry("RUSSIAN");
        address.setCity("MOSCOW");
        address.setStreet("Lenin 1");
        address.setPostCode("555555");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Altay");
        employee.setLastName("Moldahmetov");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1993,Calendar.JANUARY, 13);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressID(address.getId());

        try{
         //   addressService.add(address);
          //  employeeService.add(employee);
            List<Address> addressList = addressService.getAll();
            for (Address a : addressList){
                System.out.println(a);
            }

            List<Employee> employeeList = employeeService.getAll();
            for (Employee e : employeeList ){
                System.out.println(e);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
