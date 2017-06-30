package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rashid on 28.06.2017.
 */
public interface EmployeeDAO {

    //create
    void add(Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    Employee getById(Long id) throws SQLException;

    //update
    void update(Employee employee);

    //delete
    void remove(Employee employee);
}
