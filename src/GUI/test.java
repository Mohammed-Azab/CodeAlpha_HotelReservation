import Internal.DataRepo;
import Internal.room;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

DataRepo dataRepo = new DataRepo();
private DefaultTableModel model;
LinkedList<room> LR= dataRepo.getQ();


public void main() {
    Object[][] dataArray = new Object[LR.size()][7]; // Assuming there are 7 fields in your room object

    for (int i = 0; i < LR.size(); i++) {
        room currentRoom = LR.get(i);
        dataArray[i][0] = i + 1;
        dataArray[i][1] = currentRoom.getRoomNo();
        dataArray[i][2] = currentRoom.getType();
        dataArray[i][3] = currentRoom.getPrice();
        dataArray[i][4] = currentRoom.getNumberOfGuests();
        dataArray[i][5] = currentRoom.getAddress();
        dataArray[i][6] = currentRoom.getAvailability();
        System.out.println(dataArray[i][0]);
        System.out.println(dataArray[i][1]);
        System.out.println(dataArray[i][2]);
        System.out.println(dataArray[i][3]);
        System.out.println(dataArray[i][4]);
        System.out.println(dataArray[i][5]);
        System.out.println(dataArray[i][6]);

    }
}
