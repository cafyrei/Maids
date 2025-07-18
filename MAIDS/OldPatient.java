package ALLEN_CODE;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class OldPatient extends JFrame {

    private Connection connection;
    private Statement statement;
    private JLabel nameLabel, ageLabel, pictureLabel;
    private JTable NurseTable;
    private String loggedInPatientId;
    private String NurseName;

    public OldPatient(String patientId) {
        this.loggedInPatientId = patientId;
        this.NurseName = NurseName;
        connectToDatabase();
        setTitle("Patient Record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        add(HeaderPanel(), BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, NursePanel(), PatientRecord());
        splitPane.setDividerLocation(350);
        add(splitPane, BorderLayout.CENTER);

        setVisible(true);

        // Load patient's data upon login
        loadPatientData();
        setLocationRelativeTo(null);
    }
   
    private JPanel HeaderPanel() {
        JPanel hP = new JPanel(new BorderLayout());
        hP.setBackground(new Color(0, 153, 153));

        // back button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        backButtonPanel.setBackground(new Color(0, 153, 153));
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        backButton.setFocusable(false);
        backButton.setBackground(new Color(172,216,230)); 
        backButton.setForeground(Color.BLACK);
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(e -> System.out.println("Back button clicked"));
        backButtonPanel.add(backButton);
        hP.add(backButtonPanel, BorderLayout.WEST);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TempMenu main = new TempMenu();
                main.setLocationRelativeTo(null);
                main.setResizable(false);
                main.setTitle(" Login");
                main.setVisible(true);
                OldPatient.this.dispose();
            }
        });

        JPanel titleDatePanel = new JPanel(new BorderLayout(-50, 10));
        titleDatePanel.setBackground(new Color(0, 153, 153));

        // title
        JLabel headerLabel = new JLabel("Nurse Dashboard", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);

        // date
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 25));
        datePanel.setBackground(new Color(0, 153, 153));
        JLabel dateLabel = new JLabel("Date: " + LocalDate.now());
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateLabel.setForeground(Color.WHITE);
        datePanel.add(dateLabel);

        titleDatePanel.add(headerLabel, BorderLayout.CENTER);
        titleDatePanel.add(datePanel, BorderLayout.EAST);

        hP.add(titleDatePanel, BorderLayout.CENTER);

        return hP;
    }

    private JPanel NursePanel() {
        JPanel nP = new JPanel(new BorderLayout(10, 10));
  //      JPanel title = new JPanel();
        nP.setBackground(new Color(0, 153, 153));
        Border border = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.white, 2), // Border style (black line with thickness 2)
            "Nurse Panel", // Title text
            TitledBorder.LEFT, // Position of the title
            TitledBorder.TOP, // Title position relative to the border
            new Font("Tahoma", Font.PLAIN, 12), // Font style for the title
            Color.white // Title text color (blue in this case)
        );
        nP.setBorder(border);
        
        //nP.setBorder(BorderFactory.createTitledBorder(Lineborder,"Nurse Panel", 1, 2, "Tahoma", Color.white));
//        title.setForeground(Color.WHITE);
//        nP.add(title);
        //setForeground(Color.WHITE);

        JLabel titleLabel = new JLabel("<html>Hello Nurse, <br>Your Patients Record Logs:</html>", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        nP.add(titleLabel, BorderLayout.NORTH);

        NurseTable = new JTable(new DefaultTableModel(new Object[]{"Visit Date", "Case Number"}, 0)) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);

                // Alternate row colors (light grey for non-selected rows)
                if (!isRowSelected(row)) {
                    component.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 248, 255)); // Alternating rows with light blue
                } else {
                    component.setBackground(new Color(173, 216, 230)); // Light blue for selected row
                }

                return component;
            }
        };
        NurseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        NurseTable.getSelectionModel().addListSelectionListener(e -> selectRow());
        JScrollPane tableScrollPane = new JScrollPane(NurseTable);
        nP.add(tableScrollPane, BorderLayout.CENTER);

        JButton checkupButton = new JButton("Checkup");
        checkupButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkupButton.setBackground(new Color(172,216,230)); 
        nP.add(checkupButton, BorderLayout.SOUTH);
        
        checkupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queryData = "SELECT First_Name, Last_Name, Age FROM patientaccounts WHERE patientID = ?";
                try {
                    PreparedStatement pst = connection.prepareStatement(queryData);
                    pst.setString(1, loggedInPatientId);
                    ResultSet rs = pst.executeQuery();
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Unexpected Error Occured");
                    }
                    else {
                        String PatientFirstName = rs.getString("First_Name");
                        String PatientLastName = rs.getString("Last_Name");
                        String PatientAge = rs.getString("Age");
                        System.out.println(PatientFirstName + PatientLastName + PatientAge + loggedInPatientId);
                        Login main = new Login(PatientFirstName, PatientLastName, PatientAge, loggedInPatientId);
                        main.setLocationRelativeTo(null);
                        main.setResizable(false);
                        main.setTitle("Doctor Login");
                        main.setVisible(true);
                        OldPatient.this.dispose();
                    }
                } catch (SQLException ex){
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        return nP;
    }
    
    
    
    
    

    private JPanel PatientRecord() {
        JPanel pR = new JPanel(new BorderLayout(10, 10));
        pR.setBackground(new Color(240, 248, 255));
        pR.setBorder(BorderFactory.createTitledBorder("Patient Records"));

        JPanel infoPanel = new JPanel(new BorderLayout(10, 10));
        JPanel nameAgePanel = new JPanel(new GridLayout(2, 1, 0, -25));
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameAgePanel.add(nameLabel);
        nameAgePanel.add(ageLabel);

        // photo
        pictureLabel = new JLabel("Photo: ", SwingConstants.CENTER);
        pictureLabel.setPreferredSize(new Dimension(100, 100));
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        infoPanel.add(nameAgePanel, BorderLayout.WEST);
        infoPanel.add(pictureLabel, BorderLayout.EAST);
        pR.add(infoPanel, BorderLayout.NORTH);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        pR.add(scrollPane, BorderLayout.CENTER);

        return pR;
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maids_database", "root", "");
            statement = connection.createStatement();
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    private void loadPatientData() {
        try {
            String query = "SELECT First_Name, Last_Name, Age FROM patientaccounts WHERE PatientID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loggedInPatientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String patientFullName = resultSet.getString("First_Name") + " " + resultSet.getString("Last_Name");

                nameLabel.setText("Name: " + patientFullName);
                ageLabel.setText("Age: " + resultSet.getString("age"));
            }
            loadTableData();
        } catch (SQLException e) {
            System.out.println("Error loading patient data: " + e.getMessage());
        }
    }

    private void loadTableData() {
        try {
            String query = "SELECT date, caseNumber FROM patienthistory WHERE patientID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, loggedInPatientId);
            ResultSet resultSet = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) NurseTable.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("date"),
                    resultSet.getString("caseNumber")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading diagnosis data: " + e.getMessage());
        }
    }

    private void selectRow() {
        int selectedRow = NurseTable.getSelectedRow();
        if (selectedRow != -1) {
            String caseNumber = (String) NurseTable.getValueAt(selectedRow, 1);
            updatePatientRecord(caseNumber);
        }
    }
    
    
    private void updatePatientRecord(String caseNumber) {
        try {

            String query = "SELECT purpose, diagnosis, prescription "
                         + "FROM patienthistory WHERE caseNumber = ?"; 
    
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, caseNumber);  
            ResultSet resultSet = stmt.executeQuery();
    
    
            if (!resultSet.next()) {
                System.out.println("No data found for case number: " + caseNumber);
                return;  
            }
    
            JPanel uiPanel = (JPanel) ((JSplitPane) getContentPane().getComponent(1)).getRightComponent();
            JPanel containerPanel = (JPanel) ((JScrollPane) uiPanel.getComponent(1)).getViewport().getView();
    
            containerPanel.removeAll(); 

            JPanel purposePanel = SectionPanel("PURPOSE", resultSet.getString("purpose"));
            containerPanel.add(purposePanel);
    
            JPanel diagnosisPanel = SectionPanel("DIAGNOSIS", resultSet.getString("diagnosis"));
            containerPanel.add(diagnosisPanel);
    
            JPanel treatmentPanel = SectionPanel("TREATMENT", resultSet.getString("prescription"));
            containerPanel.add(treatmentPanel);
    
            containerPanel.revalidate();
            containerPanel.repaint();
    
            System.out.println("Patient Record Updated");
    
        } catch (SQLException e) {
            System.out.println("Error updating patient record: " + e.getMessage());
            e.printStackTrace(); 
        }
    }


    private JPanel SectionPanel(String title, String content) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
        sectionPanel.setBorder(BorderFactory.createTitledBorder(title));

        JTextArea textArea = new JTextArea(content);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        sectionPanel.add(textArea);
        return sectionPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OldPatient("P001"));
    }
}
