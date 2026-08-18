public class Medicine {

    private int medicineId;
    private String medicineName;
    private String dosage;
    private int quantity;

    public Medicine() {

    }

    public Medicine(int medicineId, String medicineName, String dosage, int quantity) {

        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.quantity = quantity;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}