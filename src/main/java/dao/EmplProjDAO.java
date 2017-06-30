package dao;

import entity.EmplProj;

import java.util.List;

/**
 * Created by Rashid on 28.06.2017.
 */
public interface EmplProjDAO {

    //create
    void add(EmplProj emplProj);

    //read
    List<EmplProj> getAll();

    EmplProj getByEmployeeAndProjectId(Long employeeId, Long projectId);

    //update
    void update(EmplProj emplProj);

    //delete
    void delete(EmplProj emplProj);
}
