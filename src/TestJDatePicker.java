import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class TestJDatePicker extends JPanel {
    JTextField textField;
    JTextField resultDateField;
    JDatePicker datePicker;

    public TestJDatePicker() {

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        textField = new JTextField(20);
        //textField.setText("10");

        resultDateField = new JTextField(20);

        SomeActionListener listen = new SomeActionListener(datePicker, textField, resultDateField);
        datePicker.addActionListener(listen);
        textField.addActionListener(listen);
        textField.addKeyListener(listen);

        add(datePicker);
        add(textField);
        add(resultDateField);

        setPreferredSize(new Dimension(850, 250));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Calculate That Date!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TestJDatePicker();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
