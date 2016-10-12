/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TVShow.model;

import java.util.List;

/**
 *
 * @author jacqu_000
 */
public interface ITVShowDAO {


    void createRecord(TVShow employee);

    TVShow retrieveRecordById(int id);

    List<TVShow> retrieveAllRecords();

    void updateRecord(TVShow updatedEmployee);

    void deleteRecord(int id);

    void deleteRecord(TVShow employee);

    @Override
    String toString();

}
  

