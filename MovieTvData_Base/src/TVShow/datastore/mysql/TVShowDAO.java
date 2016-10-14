apackage TVShow.datastore.mysql;

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

    /**
     *
     * @param tvshow
     */
    @Override
    public void createRecord(TVShow tvshow) {
        final String QUERY = "insert into tvshow "
                + "( tvshowid, TVShowGenera, Writer, DirectorsName, Rating ) "
                + "VALUES (null, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setString(1, tvshow.getTVShowGenera());
            stmt.setString(3, tvshow.getWriter());
           // stmt.setString(2, tvshow.getDirectorsName());
            stmt.setDouble(4, tvshow.getRating());
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
        final String QUERY = "select TVShowID, TVShowGenera, DirectorsName,, "
                + "Rating from TVShow where TVShowID= " + id;
        
        TVShow emp = null;

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            if (rs.next()) {
                emp = new TVShow(
                        rs.getInt("tvshowid"), 
                        rs.getString("tvshowgenera"),
                        rs.getString(""),
                        rs.getDouble("rating"));
                        rs.getString("writer");
                       
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
        final String QUERY = "select tvshowid, tvshowgenera, directorsname, rating, "
                + "rating from tvshow";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new TVShow(
                        rs.getInt("TvShowid"), 
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
                + "DirectorsName=?, rating=? where ShowId=?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setString(1, updatedTVShow.getTVShowGenera());
           // stmt.setString(2, updatedTVShow.getDirectorsName());
            stmt.setString(3, updatedTVShow.getWriter());
            stmt.setDouble(4, updatedTVShow.getRating());
            stmt.setInt(5, updatedTVShow.getTvShowId());
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

    /**
     *
     * @param ID
     */
 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (TVShow tvshow : retrieveAllRecords()) {
            sb.append(tvshow.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void deleteRecord(TVShow employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
 



