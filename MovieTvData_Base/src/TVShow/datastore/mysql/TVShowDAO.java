/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TVShow.datastore.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqu_000
 */

    


import TVShow.model.TVShow;
import TVShow.model.ITVShowDAO;


public class TVShowDAO implements ITVShowDAO {

    protected final static boolean DEBUG = true;

    @Override
    public void createRecord(TVShow TVShow) {
        final String QUERY = "insert into TVShowID "
                + "(TVShowID, Writer, TVShowGenera, DirectorsName) "
                + "VALUES (null, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setString(1, TVShow.getTVShowGenera());
            //stmt.setString(2, TVShow.getDirectorsName;
            stmt.setString(3, TVShow.getWriter());
            stmt.setDouble(4, TVShow.getRating());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("createRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public TVShow retrieveRecordById(int id) {
        final String QUERY = "select TVShowID, TVShowGenera, DirectorsName, homePhone, "
                + "Rating from TVShow where TVShowID= " + id;
        
        TVShow emp = null;

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            // stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            if (rs.next()) {
                emp = new TVShow(
                        rs.getInt("TVShowID"), 
                        
                        rs.getString("TVShowGenera"),
                        rs.getString("DirectorsName"),
                      
                        rs.getDouble("Rating"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveRecordById SQLException: " 
                    + ex.getMessage());
        }

        return emp;
    }

    @Override
    public List<TVShow> retrieveAllRecords() {
        final List<TVShow> myList = new ArrayList<>();
        final String QUERY = "select empId, lastName, firstName, homePhone, "
                + "salary from employee";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new TVShow(
                        rs.getInt("TvShowID"), 
                        rs.getString("TVShowGenera"), 
                        rs.getString("Writer"), 
                        
                        
                        rs.getDouble("Rating")));
                rs.getString("DirectorsName");
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public void updateRecord(TVShow updatedTVShow) {
        final String QUERY = "update TVShow set TVShowGenera=?, Writer=?, "
                + "DirectorsName=?, salary=? where ShowID=?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setString(1, updatedTVShow.getTVShowGenera());
            //*stmt.setString(2, updatedTVShow.getDirectorsName());
            stmt.setString(3, updatedTVShow.getWriter());
            stmt.setDouble(4, updatedTVShow.getRating());
            stmt.setInt(5, updatedTVShow.getTvShowID());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("updateRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteRecord(int id) {
        final String QUERY = "delete from employee where empId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteRecord(TVShow TVShow) {
        final String QUERY = "delete from employee where empId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, TVShow.getTvShowID());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (TVShow TVShow : retrieveAllRecords()) {
            sb.append(TVShow.toString()).append("\n");
        }

        return sb.toString();
    }
}


