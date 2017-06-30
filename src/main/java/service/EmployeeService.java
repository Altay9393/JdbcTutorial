package service;

import bi.Util;
import dao.EmployeeDAO;
import entity.Address;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid on 28.06.2017.
 */
public class EmployeeService extends Util implements EmployeeDAO {

    private Connection connection = getConnection();
    @Override
    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) " +
                "VALUES(?,?,?,?,?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(1,employee.getLastName());
            preparedStatement.setDate(1,employee.getBirthday());
            preparedStatement.setLong(1,employee.getAddressID());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, , POST_CODE FROM ADDRESS";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setBirthday(resultSet.getDate("BIRTHDAY"));
                employee.setAddressID(resultSet.getLong("ADDRESS_ID"));

                employeeList.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee getById(Long id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID,FIRST_NAME, LAST_NAME, BIRTHDAY,ADDRESS_ID FROM EMPLOYEE WHERE ID=?";
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setCountry(resultSet.getString("COUNTRY"));
            employee.setCity(resultSet.getString("CITY"));
            employee.setStreet(resultSet.getString("STREET"));
            employee.setPostCode(resultSet.getString("POST_CODE"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return address;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void remove(Employee employee) {

    }
}
