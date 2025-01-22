package Model;

import java.io.Serializable;

public class Sector implements Serializable {
    private static final long serialVersionUID = 6L;

    //private String sectorName;
    private String sectorCode;
    private String username;

    public Sector(String sectorCode, String username) {

    }

    public String getSectorCode() {return sectorCode;}
    public void setSectorCode(String sectorCode) {this.sectorCode = sectorCode;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

}