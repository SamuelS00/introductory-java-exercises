package model.service;

public interface PaymentService {

    double paymentFee(double amount);

    double interest(double amount, int months);
}