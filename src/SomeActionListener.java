import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vladimir on 18-Aug-15.
 */
public class SomeActionListener implements ActionListener, KeyListener {

    private JTextField resultDateField;
    private JTextField textField;
    private JDatePickerImpl datePicker;
    int days;
    //...

    public SomeActionListener(JDatePickerImpl datePicker, JTextField textField, JTextField resultDateField) {
        this.textField = textField;
        this.datePicker = datePicker;
        this.resultDateField = resultDateField;
        //...
    }

    public void actionPerformed(ActionEvent e) {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date selectedDate = (Date) datePicker.getModel().getValue();
        //System.out.println(selectedDate);
        System.out.println(textField.getText());


        if (textField.getText().equals("")) {
            days = 0;
        } else {
            try {
                days = Integer.parseInt(textField.getText());
            } catch (NumberFormatException e1) {
                System.err.println("Not a number: " + textField.getText());
                days = 0;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(selectedDate);

        cal.add(Calendar.DATE, days);

        resultDateField.setText(cal != null ? sdf.format(cal.getTime()) : null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        actionPerformed(null);
    }
}