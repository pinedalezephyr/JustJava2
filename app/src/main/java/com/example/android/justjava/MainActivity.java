

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // to find users name
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "name;  " +name);
// Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
// Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
// Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

// Display the order summary on the screen
        String message = createOrderSummary(name,price, hasWhippedCream, hasChocolate);
        displayMessage(message);

    }

    public void displayQuantity(int quantity) {
            }
    /**

     * This method is called when the plus button is clicked.

     */

    public void increment(View view) {

        if (quantity == 100) {

// Show an error message as a toast

            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();

// Exit this method early because there's nothing left to do

            return;

        }

        quantity = quantity + 1;

        displayQuantity(quantity);

    }



    /**

     * This method is called when the minus button is clicked.

     */

    public void decrement(View view) {

        if (quantity == 1) {

// Show an error message as a toast

            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();

// Exit this method early because there's nothing left to do

            return;

        }

        quantity = quantity - 1;

        displayQuantity(quantity);

    }

}

    /**

        * Calculates the price of the order.

        * @param addWhippedCream is add or not for customer wants
       * @param addChocolate is add or not for customer wants
        * @return total price

        */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;

        }
        return quantity * basePrice;

    }

    /**
     * Create summary of the order.
     *
     * @param price of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate is whether or not to add chocolate to the coffee
     * @return text summary
     */


    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
    String priceMessage = "Name: " +name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQunantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**

     * This method displays the given price on the screen.

     */

    private void displayPrice(int number) {

        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);

        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    /**

     * This method displays the given text on the screen.

     */

    private void displayMessage(String message) {

        TextView priceTextView = findViewById(R.id.order_summary_text_view);

        priceTextView.setText(message);

    }


}

