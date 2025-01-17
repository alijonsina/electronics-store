package Model;

import java.io.Serializable;

public class Manager extends User {


    private static final long serialVersionUID = 2L;
    private Sector[] sectors;
    public Manager(Sector[] sectors) {
        this.sectors = sectors;
    }
}