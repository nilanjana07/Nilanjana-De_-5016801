public class PaymentProcessorTest {
    public static void main(String[] args) {
        // Create instances of the gateways
        PaypalGateway paypalGateway = new PaypalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the gateways
        PaymentProcessor paypalAdapter = new PaypalAdapter(paypalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Use the adapters to process payments
        paypalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
    }
}
