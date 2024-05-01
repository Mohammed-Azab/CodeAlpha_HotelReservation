package GUI;

import Internal.DataRepo;
import Internal.room;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.Objects;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class houseSelection extends javax.swing.JFrame {
    DataRepo dataRepo = new DataRepo();
    private DefaultTableModel model;
    LinkedList<room> LR= dataRepo.getQ();
    double totalCost;


    public houseSelection() {
        setTitle("Hotel Reservation");
        initComponents();
        setLocationRelativeTo(null);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        // Calculate total cost based on the selected row's data
                        totalCost = calculateTotalCost(row);
                        // Display total cost to the user
                        int option = JOptionPane.showConfirmDialog(houseSelection.this,
                                "Total Cost: $" + totalCost + "\nDo you want to continue?",
                                "Confirm Reservation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            // Prompt user to enter first and last name
                            String fullName = JOptionPane.showInputDialog(houseSelection.this,
                                    "Please enter your first and last name:");
                            if (fullName != null && !fullName.isEmpty()) {
                                // Prompt user to select payment method
                                String[] paymentMethods = {"Paypal", "Debit/Credit Card", "Pay when you check in"};
                                String paymentMethod = (String) JOptionPane.showInputDialog(houseSelection.this,
                                        "Select Payment Method:", "Payment Method", JOptionPane.QUESTION_MESSAGE,
                                        null, paymentMethods, paymentMethods[0]);
                                if (paymentMethod != null) {
                                    if (paymentMethod.equals("Debit/Credit Card")) {
                                        // Prompt user to enter card details
                                        String cardDetails = JOptionPane.showInputDialog(houseSelection.this,
                                                "Enter your card details:");
                                        // Display success message and simulate sending confirmation email
                                        if (cardDetails != null && !cardDetails.isEmpty()) {
                                            JOptionPane.showMessageDialog(houseSelection.this,
                                                    "Payment Successful!\nConfirmation email will be sent.");
                                            // Simulate sending confirmation email
                                            sendConfirmationEmail(fullName);
                                        } else {
                                            JOptionPane.showMessageDialog(houseSelection.this,
                                                    "Payment failed. Card details not provided.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(houseSelection.this,
                                                "Payment Successful!\nConfirmation email will be sent.");
                                        // Simulate sending confirmation email
                                        sendConfirmationEmail(fullName);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(houseSelection.this,
                                        "Please enter your first and last name.");
                            }
                        }
                    }
                }
            }
        });
    }
    private double calculateTotalCost(int row) {
        room selectedRoom = LR.get(row);
        return selectedRoom.getPrice();
    }

    private void sendConfirmationEmail(String fullName) {
        // Simulate sending confirmation email
        System.out.println("Confirmation email sent to: Mohammed@azab.io");
    }

    private void updateTable() {
        Object[][] dataArray = new Object[LR.size()][7];

        for (int i = 0; i < LR.size(); i++) {
            room currentRoom = LR.get(i);
            dataArray[i][0] = i + 1;
            dataArray[i][1] = currentRoom.getRoomNo();
            dataArray[i][2] = currentRoom.getType();
            dataArray[i][3] = currentRoom.getPrice();
            dataArray[i][4] = currentRoom.getNumberOfGuests();
            dataArray[i][5] = currentRoom.getAddress();
            dataArray[i][6] = currentRoom.getAvailability();
        }
        String[] columnNames = {"No", "RoomNo", "RoomType", "Cost", "Maximum PPL", "Address", "Availability"};

        jTable1.setModel(new javax.swing.table.DefaultTableModel(dataArray, columnNames));
    }



    private void initComponents() {

        JPanel jPanel4 = new JPanel();
        JLabel jLabel3 = new JLabel();
        JTextField jTextField1 = new JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        JButton jButton2 = new JButton();
        JLabel jLabel4 = new JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JButton jButton1 = new JButton();
        JPanel jPanel2 = new JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 255));
        jButton2.setText("Contiune");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Write your detination");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("House Type");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Check in date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Check out date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(211, 211, 211)
                                                .addComponent(jLabel3))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(226, 226, 226)
                                                .addComponent(jButton2)))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jButton2)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Material/photo.png")))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel9.setText("Azab's Hotel");

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel10.setText("Mohammed@azab.io");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log out");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(162, 162, 162)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(79, 79, 79)
                                                                .addComponent(jLabel9))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(91, 91, 91)
                                                                .addComponent(jButton1))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addComponent(jLabel10)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Write your detination");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Check in date");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Check out date");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String [] {
                        "No", "RoomNo", "RoomType", "Cost", "Maximum PPL", "Address", "Availability"
                }
        ));
        jTable1.setRowHeight(35);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);
        // Set selection mode
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        // Disable editing for the entire table
        jTable1.setDefaultEditor(Object.class, null);


// Add selection listener
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                    // Get selected row and column
                    int selectedRowIndex = jTable1.getSelectedRow();
                    int selectedColumnIndex = jTable1.getSelectedColumn();

                    // Get the value from the selected cell
                    Object selectedValue = jTable1.getValueAt(selectedRowIndex, selectedColumnIndex);

                    // Do something with the selected value
                    System.out.println("Selected Value: " + selectedValue);
                }
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField2)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
                        .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton3)))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String userInput =jTextField2.getText();
        if (userInput.equalsIgnoreCase("Spain")) {
             updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, no rooms available for the specified location.");
        }
    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(houseSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(houseSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(houseSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(houseSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new houseSelection().setVisible(true);
//            }
//        });
//    }


    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
}
