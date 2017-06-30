package dao;

import entity.Project;

import java.util.List;

/**
 * Created by Rashid on 28.06.2017.
 */
public interface ProjectDAO {

    //create
    void add(Project project);

    //read
    List<Project> getAll();

    Project getById(Long id);

    //update
    void update(Project project);

    //delete
    void remove(Project project);

}
