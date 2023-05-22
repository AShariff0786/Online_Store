package com.solvd.onlinestore;

import com.solvd.onlinestore.customer.Order;
import com.solvd.onlinestore.customer.Payment;
import com.solvd.onlinestore.customer.ShippingAddress;
import com.solvd.onlinestore.enums.Discount;
import com.solvd.onlinestore.enums.SalesTax;
import com.solvd.onlinestore.enums.ShippingSpeed;
import com.solvd.onlinestore.interfaces.IPrint;
import com.solvd.onlinestore.product.Brand;
import com.solvd.onlinestore.product.Clothing;
import com.solvd.onlinestore.product.Pants;
import com.solvd.onlinestore.product.Shirt;
import com.solvd.onlinestore.customer.Customer;
import com.solvd.onlinestore.utils.DataUtil;
import com.solvd.onlinestore.utils.ReflectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Logger LOGGER = LogManager.getLogger(Main.class);

        //Create Owner of Website
        ContactInformation bossInfo = new ContactInformation("boss@gmail.com", "123456789");
        Retailer boss = new Retailer("John Doe", bossInfo);

        boss.login();

        //Create Employee
        ContactInformation employeeInfo = new ContactInformation("employee@gmail.com", "23134421");
        Retailer employee = new Retailer("Jim Doe", bossInfo);

        boss.addEmployee(1, employee.getFullName());

        //Create Customer
        ContactInformation customerInfo = new ContactInformation("custom@gmail.com", "12342314");
        Customer customer = new Customer("Jane", customerInfo);
        ShippingAddress address = new ShippingAddress("xxxxx", "NY", "NY");
        Payment creditCard = new Payment("1234567891234567", "123");
        customer.addAddress(address);
        customer.addCreditCard(creditCard);

        customer.login();

        //Customer's Order
        Cart cart = new Cart();
        Brand brand = new Brand("NIKE");
        Shirt s1 = new Shirt('M', 'M', 12.50);
        Pants p1 = new Pants('S', 'F', 8.25);
        s1.setBrand(brand);
        p1.setBrand(brand);
        cart.addItem(s1);
        cart.addItem(p1);
        cart.addItem(p1);
        cart.removeItem(p1);
        Order order = new Order("SW12141341");

        customer.addAddress(address);
        customer.addOrder(order);
        customer.addCreditCard(creditCard);

        boss.addUnfulfilledOrder(order);

        //Creates invoice for the  customer
        Invoice.printInvoice(cart);


        //Lambda Using Predicate
        cart.qualifiesFreeShipping((total)-> total>=25);

        LOGGER.info("Qualifies for Free Shipping: " + cart.getFreeShipping());


        //Lambda using Function interface
        GenericLinkedList<Clothing> filtered = cart.filterByPrice((items) -> {
            GenericLinkedList<Clothing> temp = new GenericLinkedList<>();
            IntStream.range(0,items.size()).forEach(index ->{
                if(items.get(index).getPrice() > 10) {
                    temp.add(items.get(index));
                }
            });

            return temp;
        });

        //Prints the Filtered Items Greater then $10
        IntStream.range(0,filtered.size()).forEach(index ->{
            LOGGER.info("Items greater then $10: "+filtered.get(index).printItem());
        });

        //Lambda using IDiscount functional interface
        cart.setDiscount(Discount.FIFTEEN_PERCENT.getDiscountPercentage());
        double discountTotal = cart.calculateDiscountPrice((discount) ->{
            double total = cart.getCartTotal();
            double temp;
            temp = discount * total;
            total -= temp;
            return total;
        });

        LOGGER.info("Original Price: " + cart.getCartTotal() + " Discount Total: " + discountTotal);

        //Lambda using ITaxTotal interface
        double finalTotal = cart.calculateFinalPrice((tax) -> {
            double total = tax;
            double temp;
            temp = total * SalesTax.FIVE_PERCENT.getPercentage();
            total += temp;
            return total;
        }, discountTotal, ShippingSpeed.ONE_DAY_SHIPPING.getPrice());

        LOGGER.info(("Final Amount Post Tax and Shipping Fees: " + finalTotal));

        //Lambda using IPrint interface
        IPrint item = () -> {
            LOGGER.info(cart.getItems().get(1).printItem());
        };
        cart.printItem(item);

        //Tests using Reflection
        DataUtil test = new DataUtil();
        Order classOrder = (Order) ReflectionUtil.createObject("com.solvd.onlinestore.customer.Order", test);
        LOGGER.info("Reflection test for Order: "+classOrder.getOrderNumber());

        Payment classPayment = (Payment) ReflectionUtil.createObject("com.solvd.onlinestore.customer.Payment", test);
        LOGGER.info("Reflection test for Payment: "+classPayment.getCreditCardCsc()+ " " + classPayment.getCreditCardNum());

        Cart classCart = (Cart) ReflectionUtil.createObject("com.solvd.onlinestore.Cart", test);
        LOGGER.info("Reflection test for Cart: "+ classCart.getCartTotal() + " " + classCart.getFinalTotal());

        boss.contactUser(customer);
        boss.contactUser(boss);
        customer.logout();
        boss.logout();
    }

}
