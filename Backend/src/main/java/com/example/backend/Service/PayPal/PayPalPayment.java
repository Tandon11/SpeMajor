/*
package com.example.backend.Service.PayPal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.DTO.BookingObject;
import com.example.backend.Model.Booking;
import com.example.backend.Repository.BookingRepository;
import com.example.backend.Repository.SeatRepository;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PayPalPayment {
	
	@Autowired
	private APIContext apiContext;
    @Autowired
    private SeatRepository seats;
    @Autowired
    private BookingRepository book;
	
	public Payment createPayment(
			BookingObject booking ,
			String cancelUrl, 
			String successUrl) throws PayPalRESTException{
		 String Seats = booking.getSeatId();
	        System.out.println("Seat Id's: "+Seats+"\n");

	        String[] strArray = Seats.split(",");
	        int[] seatId = new int[strArray.length];

	        for(int i = 0; i < strArray.length; i++) {
	            seatId[i] = Integer.parseInt(strArray[i]);
	        }

	        for(int i = 0; i < seatId.length; i++) {
	            System.out.println(seatId[i] + " ");
	        }

		
		 int amount1=0;
	      for(int i=0;i<seatId.length;i++) {
	          String cost=seats.getCostById(seatId[i]);
	          Integer price=Integer.parseInt(cost);
	          amount1=amount1+price;
	      }
		Amount amount = new Amount();
		amount.setCurrency("USD");
//		amount1 = (int) new BigDecimal(amount1).setScale(2, RoundingMode.HALF_UP).doubleValue();
		amount.setTotal(String.valueOf(amount1));

		Transaction transaction = new Transaction();
		transaction.setDescription("booking payment");
		transaction.setAmount(amount);

		List transactions = new ArrayList<>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("SALE");
		payment.setPayer(payer);  
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(successUrl);
		payment.setRedirectUrls(redirectUrls);
        Booking b1=new Booking(booking.getEmail(),booking.getMovieId(),booking.getLocationId(),booking.getTheatreId(),booking.getShowId(),booking.getSeatId(),booking.getCount(),amount1);
        book.save(b1);
		return payment.create(apiContext);
	}
	
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
		Payment payment = new Payment();
		payment.setId(paymentId);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId(payerId);
		
		return payment.execute(apiContext, paymentExecute);
	}
}
*/
