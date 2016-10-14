
package TVShow.model.datastore.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author jacqu_000
 */


import TVShow.model.TVShow;
import TVShow.model.ITVShowDAO;
import java.io.Writer;
import javax.swing.JOptionPane;


public class TVShowDAO implements ITVShowDAO {
    
   
    
    protected String fileName = null;
    protected final List<TVShow> myList;

    public TVShowDAO() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("res/file/db.properties"));
            this.fileName = props.getProperty("DB_FILENAME");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    @Override
    public void createRecord(TVShow tvshow) {
        myList.add(tvshow);
        writeList();
    }

    @Override
    public TVShow retrieveRecordById(int id) {
        for (TVShow tvshow : myList) {
            if (tvshow.getTvShowId() == id) {
                return tvshow;
            }
        }
        return null;
    }

    @Override
    public List<TVShow> retrieveAllRecords() {
        return myList;
    }

@Override

    public void updateRecord(TVShow updatedtvshow) {
        for (TVShow tvshow : myList) {
            if (tvshow.getTvShowId() == updatedtvshow.getTvShowId()) {
                tvshow.setTVShowGenera(updatedtvshow.getTVShowGenera());
                //tvshow.setDirectorsName(updatedTVShow.getDirectorsName());
                tvshow.setWriter(updatedtvshow.getWriter());
                tvshow.setRating(updatedtvshow.getRating());
                break;
            }
        }
        writeList();
    }

    @Override
    public void deleteRecord(int id) {
        for (TVShow TVShow : myList) {
            if (TVShow.getTvShowId() == id) {
                myList.remove(TVShow);
                break;
            }
        }
        writeList();
    }

 

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String Genera = data[1];
                String Directors = data[2];
                String Writer = data[3];
                double Rating = Double.parseDouble(data[4]);
                TVShow TVShow = new TVShow(id, Genera, Writer, Rating);
                myList.add(TVShow);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (TVShow tvshow : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        tvshow.getTvShowId(),
                        tvshow.getTVShowGenera(),
                        //TVShow.getDirectorsName(),
                        tvshow.getWriter(),
                        tvshow.getRating()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (TVShow tvshow: myList) {
            sb.append(String.format("%5d : %s, %s, %s, %.2f\n",
                    tvshow.getTvShowId(),
                    tvshow.getTVShowGenera(),
                    //tvshow.getDirectorsName(),
                    tvshow.getWriter(),
                    tvshow.getRating()));
        }

        return sb.toString();
    }

    @Override
    public void deleteRecord(TVShow tvshow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


