package gas.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class generatebill extends JFrame implements ActionListener {

    String meter;
    JButton bill;
    Choice cmonth;
    JTextArea area;

    generatebill(String meter) {
        this.meter = meter;

        setSize(700, 800); // Adjusted size to accommodate more content
        setLocation(400, 30); // Adjusted location for visibility

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);

        cmonth = new Choice();

        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");

        area = new JTextArea(50, 50); // Increased columns for better readability
        area.setFont(new Font("Senserif", Font.ITALIC, 18));

        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel, "North");

        add(pane, "Center");
        add(bill, "South");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bill) {
            try {
                conn c = new conn();

                String month = cmonth.getSelectedItem();

                area.setText(""); // Clear previous content

                area.append("\t\tINDANE LPG Limited\n");
                area.append("\t\tLPG BILL FOR THE MONTH\n\t\tOF " + month + ", 2024\n");
                area.append("------------------------------------------------------------\n");

                // Fetch customer details
                ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");
                if (rs.next()) {
                    area.append("\nCUSTOMER DETAILS:\n");
                    area.append("------------------------------------------------------------\n");
                    printCustomerDetails(rs);
                }

                // Fetch meter info
                rs = c.s.executeQuery("select * from meter_info where meter_no = '" + meter + "'");
                if (rs.next()) {
                    area.append("\nMETER INFORMATION:\n");
                    area.append("------------------------------------------------------------\n");
                    printMeterInfo(rs);
                }

                // Fetch tax details
                rs = c.s.executeQuery("select * from tax");
                if (rs.next()) {
                    area.append("\nTAX DETAILS:\n");
                    area.append("------------------------------------------------------------\n");
                    printTaxDetails(rs);
                }

                // Check if bill exists for the selected month
                rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' and month='" + month + "'");
                if (rs.next()) {
                    // If bill exists, print bill details
                    area.append("\nBILL DETAILS:\n");
                    area.append("------------------------------------------------------------\n");
                    printBillDetails(rs);
                } else {
                    // If no bill exists, clear the JTextArea and display a message
                    area.setText("\nNo bill found for the selected month.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void printCustomerDetails(ResultSet rs) throws SQLException {
        area.append("\n    Customer Name   : " + rs.getString("name"));
        area.append("\n    Meter Number    : " + rs.getString("meter_no"));
        area.append("\n    Address         : " + rs.getString("address"));
        area.append("\n    City            : " + rs.getString("city"));
        area.append("\n    State           : " + rs.getString("state"));
        area.append("\n    Email           : " + rs.getString("email"));
        area.append("\n    Phone           : " + rs.getString("phone"));
        area.append("\n------------------------------------------------------------\n");
    }

    private void printMeterInfo(ResultSet rs) throws SQLException {
        area.append("\n    Meter Location  : " + rs.getString("meter_location"));
        area.append("\n    Meter Type      : " + rs.getString("meter_type"));
        area.append("\n    Phase Code      : " + rs.getString("phase_code"));
        area.append("\n    Bill Type       : " + rs.getString("bill_type"));
        area.append("\n    Days            : " + rs.getString("days"));
        area.append("\n------------------------------------------------------------\n");
    }

    private void printTaxDetails(ResultSet rs) throws SQLException {
        area.append("\n    Cost Per Unit   : " + rs.getString("cost_per_unit"));
        area.append("\n    Meter Rent      : " + rs.getString("meter_rent"));
        area.append("\n    Service Charge  : " + rs.getString("service_charge"));
        area.append("\n    Service Tax     : " + rs.getString("service_tax"));
        area.append("\n    Swacch Bharat Cess: " + rs.getString("swacch_bharat_cess"));
        area.append("\n    Fixed Tax       : " + rs.getString("fixed_tax"));
        area.append("\n------------------------------------------------------------\n");
    }

    private void printBillDetails(ResultSet rs) throws SQLException {
        area.append("\n    Current Month   : " + rs.getString("month"));
        area.append("\n    Units Consumed  : " + rs.getString("units"));
        area.append("\n    Total Charges   : " + rs.getString("totalbill"));
        area.append("\n------------------------------------------------------------\n");
        area.append("\n    Total Payable   : " + rs.getString("totalbill"));
        area.append("\n");
    }

    public static void main(String[] args) {
        new generatebill("");
    }
}
