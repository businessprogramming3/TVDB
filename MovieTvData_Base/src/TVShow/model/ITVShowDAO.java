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


    void createRecord(TVShow tvshow);

    TVShow retrieveRecordById(int id);

    List<TVShow> retrieveAllRecords();

    void updateRecord(TVShow updatedTVShow);

    void deleteRecord(int id);

    void deleteRecord(TVShow tvshow);

    @Override
    String toString();

}
  

