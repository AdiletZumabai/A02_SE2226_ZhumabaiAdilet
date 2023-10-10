import javax.swing.*;
import java.awt.*;

public class CoffeeShopUI extends JFrame {
    private JComboBox<String> coffeeTypeComboBox;
    private JCheckBox milkCheckBox;
    private JCheckBox sugarCheckBox;
    private JCheckBox whipCreamCheckBox;
    private JButton addCondimentButton;
    private JTextArea orderTextArea;

    private Coffee coffee;

    public CoffeeShopUI() {
        setTitle("Coffee Ordering System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel coffeeLabel = new JLabel("Coffee Type:");
        coffeeTypeComboBox = new JComboBox<>(new String[]{"Espresso", "Latte"});
        JLabel milkLabel = new JLabel("Add Milk:");
        milkCheckBox = new JCheckBox();
        JLabel sugarLabel = new JLabel("Add Sugar:");
        sugarCheckBox = new JCheckBox();
        JLabel whipCreamLabel = new JLabel("Add Whip Cream:");
        whipCreamCheckBox = new JCheckBox();
        addCondimentButton = new JButton("Add Condiment");
        orderTextArea = new JTextArea();

        panel.add(coffeeLabel);
        panel.add(coffeeTypeComboBox);
        panel.add(milkLabel);
        panel.add(milkCheckBox);
        panel.add(sugarLabel);
        panel.add(sugarCheckBox);
        panel.add(whipCreamLabel);
        panel.add(whipCreamCheckBox);
        panel.add(addCondimentButton);

        addCondimentButton.addActionListener(e -> {
            String coffeeType = coffeeTypeComboBox.getSelectedItem().toString();

            if (coffeeType.equals("Espresso")) {
                coffee = new Espresso();
            } else if (coffeeType.equals("Latte")) {
                coffee = new Latte();
            }

            if (milkCheckBox.isSelected()) {
                coffee = new Milk(coffee);
            }

            if (sugarCheckBox.isSelected()) {
                coffee = new Sugar(coffee);
            }

            if (whipCreamCheckBox.isSelected()) {
                coffee = new WhipCream(coffee);
            }

            orderTextArea.setText("Customized Coffee: " + coffee.getDescription() + "\nCost: $" + coffee.cost());
        });

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(orderTextArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoffeeShopUI coffeeShopUI = new CoffeeShopUI();
            coffeeShopUI.setVisible(true);
        });
    }
}
