package service;

import bi.Util;
import dao.ProjectDAO;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Altay on 30.06.17.
 */
public class ProjectService extends Util implements ProjectDAO {


    Connection connection = getConnection();

    @Override
    public void add(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO PROJECT (ID,TITLE) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }if (preparedStatement != null){
            preparedStatement.close();
        }if (connection != null){
            connection.close();
        }


    }

    @Override
    public List<Project> getAll() throws SQLException {

        List<Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM PROJECT";

        Statement statement = null;

        try {

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Project project = new Project();

                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                projectList.add(project);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }if (statement != null){
            statement.close();
        }if (connection != null){
            connection.close();
        }
        return projectList;
    }

    @Override
    public Project getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM PROJECT WHERE ID=?";

        Project project = new Project();

        try {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));


        }catch (SQLException e ){
            e.printStackTrace();
        }if (preparedStatement != null){
            preparedStatement.close();
        }if (connection != null){
            connection.close();
        }
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UDDATE PROJECT SET ID=?, TITLE=? WHERE ID=? ";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }if (preparedStatement != null){
            preparedStatement.close();
        }if (connection != null){
            connection.close();
        }

    }

    @Override
    public void remove(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PROJECT WHERE ID=?";

        try {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,project.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }if (preparedStatement != null){
            preparedStatement.close();
        }if (connection != null){
            connection.close();
        }

    }
}
