package TEMA8.piloto;
public class Piloto {
    private int driverId;
    private String code;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

    public Piloto(int driverId, String code, String forename, String surname,
                  String dob, String nationality, String url) {
        this.driverId=driverId;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
    }


    public int getDriverId() {
        return driverId;
    }

    public String getCode() {
        return code;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUrl() {
        return url;
    }

    // Setters
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "driverId=" + driverId +
                ", code='" + code + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", dob='" + dob + '\'' +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

