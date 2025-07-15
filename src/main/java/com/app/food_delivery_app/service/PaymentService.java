package com.app.food_delivery_app.service;

import com.app.food_delivery_app.model.Payment;
import com.app.food_delivery_app.repository.PaymentRepository;
import java.util.Optional;
import com.app.food_delivery_app.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}