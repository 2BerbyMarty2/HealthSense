public class HospitalData {
    // Attributes
    private String hospitalName;
    private String hospitalLocation;
    private String hospitalContact;
    private DiseaseList diseaseList;

    // Constructor
    public HospitalData(String hospitalName, String hospitalLocation, String hospitalContact, DiseaseList diseaseList) {
        if (hospitalName == null || hospitalName.trim().isEmpty()) {
            throw new IllegalArgumentException("Hospital name cannot be null or empty.");
        }
        this.hospitalName = hospitalName.trim();
        this.hospitalLocation = hospitalLocation != null ? hospitalLocation.trim() : "Unknown";
        this.hospitalContact = hospitalContact != null ? hospitalContact.trim() : "N/A";
        this.diseaseList = diseaseList != null ? diseaseList : new DiseaseList(); // prevent null
    }

    // Getters
    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public String getHospitalContact() {
        return hospitalContact;
    }

    public DiseaseList getDiseaseList() {
        return diseaseList;
    }

    // Setters
    public void setHospitalName(String hospitalName) {
        if (hospitalName == null || hospitalName.trim().isEmpty()) {
            throw new IllegalArgumentException("Hospital name cannot be null or empty.");
        }
        this.hospitalName = hospitalName.trim();
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation != null ? hospitalLocation.trim() : "Unknown";
    }

    public void setHospitalContact(String hospitalContact) {
        this.hospitalContact = hospitalContact != null ? hospitalContact.trim() : "N/A";
    }

    public void setDiseaseList(DiseaseList diseaseList) {
        this.diseaseList = diseaseList != null ? diseaseList : new DiseaseList();
    }

    @Override
    public String toString() {
        return "HospitalData{" +
                "name='" + hospitalName + '\'' +
                ", location='" + hospitalLocation + '\'' +
                ", contact='" + hospitalContact + '\'' +
                ", diseaseCount=" + (diseaseList != null ? diseaseList.size() : 0) +
                '}';
    }
}
