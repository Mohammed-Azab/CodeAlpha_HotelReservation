import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelReservationAppGUI extends JFrame {
    private JTextField locationTextField;
    private JSpinner checkInSpinner;
    private JSpinner checkOutSpinner;
    private JButton searchButton;

    public HotelReservationAppGUI() {
        setTitle("Hotel Reservation App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(4, 2));

        // Location
        JLabel locationLabel = new JLabel("Location:");
        locationTextField = new JTextField();
        searchPanel.add(locationLabel);
        searchPanel.add(locationTextField);

        // Check-in date
        JLabel checkInLabel = new JLabel("Check-in:");
        checkInSpinner = new JSpinner(new SpinnerDateModel());
        searchPanel.add(checkInLabel);
        searchPanel.add(checkInSpinner);

        // Check-out date
        JLabel checkOutLabel = new JLabel("Check-out:");
        checkOutSpinner = new JSpinner(new SpinnerDateModel());
        searchPanel.add(checkOutLabel);
        searchPanel.add(checkOutSpinner);

        // Search button
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle search action
                String location = locationTextField.getText();
                // Perform search logic here
                JOptionPane.showMessageDialog(HotelReservationAppGUI.this, "Searching for hotels in " + location);
            }
        });
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HotelReservationAppGUI();
            }
        });
    }
}
