package Internal;
import javax.swing.*;
import java.util.LinkedList;

public class DataRepo {
    LinkedList<room> Q;

    public DataRepo() {
        Q = new LinkedList<>();
        RoomGenerator();
    }

    public LinkedList<room> getQ() {
        return Q;
    }

    public void setQ(LinkedList<room> Q) {
        this.Q = Q;
    }

    public void addRoom(room Room){
        Q.add(Room);
    }

    public void removeRoom(room Room){
        Q.remove(Room);
    }

    public void RoomGenerator() {

        addRoom(new room(RoomType.Sea_View.getDescription(), 150.0, "Calle de Gran Vía, Madrid", 2, 2, 4, "Hotel Room 1", true, true));
        addRoom(new room(RoomType.Private_Room.getDescription(), 80.0, "Carrer de Ferran, Barcelona", 1, 2, 3, "Hostel Room 1", true, true));
        addRoom(new room(RoomType.Family_Room.getDescription(), 120.0, "Calle de San Miguel, Sevilla", 2, 1, 3, "Apartment Room 1", true, true));
        addRoom(new room(RoomType.Private_Room.getDescription(), 100.0, "Calle del Pez, Madrid", 1, 1, 2, "Shared Apartment Room 1", true, true));
        addRoom(new room(RoomType.Double_Room.getDescription(), 90.0, "Carrer de València, Barcelona", 1, 1, 2, "Shared Apartment Room 2", true, true));
        addRoom(new room(RoomType.Quadratic_Room.getDescription(), 110.0, "Calle de las Huertas, Madrid", 1, 1, 2, "Sharepartment Room 1", true, true));
        addRoom(new room(RoomType.Triple_Room.getDescription(), 180.0, "Carrer de la Princessa, Barcelona", 3, 1, 4, "Triple Room 1", true, true));
        addRoom(new room(RoomType.Party_Favor.getDescription(), 200.0, "Calle del Arenal, Madrid", 4, 1, 5, "Quadric Room 1", true, true));
        addRoom(new room(RoomType.Double_Room.getDescription(), 160.0, "Paseo de Gracia, Barcelona", 2, 2, 4, "Hotel Room 2", true, true));
        addRoom(new room(RoomType.Family_Room.getDescription(), 85.0, "Calle de la Montera, Madrid", 1, 2, 3, "Hostel Room 2", true, true));
        addRoom(new room(RoomType.Sea_View.getDescription(), 130.0, "Calle de Tetuán, Valencia", 2, 1, 3, "Apartment Room 2", true, true));
        addRoom(new room(RoomType.Party_Favor.getDescription(), 110.0, "Carrer de Balmes, Barcelona", 1, 1, 2, "Shared Apartment Room 3", true, true));
    }

}
