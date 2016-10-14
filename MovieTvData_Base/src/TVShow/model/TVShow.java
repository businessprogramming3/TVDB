/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TVShow.model;

/**
 *
 * @author jacqu_000
 */
public class TVShow {
    

    private int TVShowId;
    private String TVShowGenera;
   // private String DirectorsName;
    private double Rating;
    private String Writer;

    public TVShow() {
        TVShowId = 0;
        TVShowGenera = "";
       // DirectorsName = "";
        Writer = "";
        Rating = 0;
   
    }

    public TVShow(int TvShowId, String TVShowGenera, String DirectorsName, double Rating, String Writer) {
        this.TVShowId = TvShowId;
        this.TVShowGenera = TVShowGenera;
      //  this.DirectorsName = DirectorsName;
        this.Rating = Rating;
        this.Writer = Writer;
     
    }

    public TVShow(int aInt, String string, String string0, double aDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // public String GetDirectorsName() {
   //     return DirectorsName;
   // }

   // public void setDirectorsName(String DirectorsName) {
     //   this.DirectorsName = DirectorsName;
   // }

    public int getTvShowId() {
        return TVShowId;
    }

    public void setTvShowID(int TvShowID) {
        this.TVShowId = TvShowID;
    }

    public String getTVShowGenera() {
        return TVShowGenera;
    }

    public void setTVShowGenera(String TVShowGenera) {
        this.TVShowGenera = TVShowGenera;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }

     public double getRating() {
        return Rating;
    }
    public void setRating(double Rating) {
        this.Rating = Rating;
    }

  
    @Override
    public String toString() {
        return String.format("%5d : %s, %s, %s, %.2f", this.getTvShowId(), this.getTVShowGenera(),
                this.getWriter(), this.getRating());
    //this.getDirectorsName() still working on this...
    }
} 


