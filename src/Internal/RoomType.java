package Internal;

public enum RoomType {
    Sea_View("Sea_View"),
    Family_Room("Family_Room"),
    Student_Room("Student_Room"),
    Party_Favor("Party_Favor"),
    Double_Room("Double_Room"),
    Private_Room("Private_Room"),
    Triple_Room("Triple_Room"),
    Quadratic_Room("Quadratic_Room");

    private final String description;

    RoomType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return this.name().toLowerCase(); // Return enum constant in lowercase
    }
}
