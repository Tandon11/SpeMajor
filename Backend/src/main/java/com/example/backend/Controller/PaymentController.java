/*
package com.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.backend.DTO.BookingObject;
import com.example.backend.DTO.Order;
import com.example.backend.Model.Booking;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.example.backend.Service.PayPal.PayPalPayment;

@CrossOrigin(allowedHeaders = "", origins = "", exposedHeaders =
		"Access-Control-Allow-Origin", methods = {
		RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.HEAD,
		RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.TRACE })
@Controller
public class PaymentController {

	@Autowired
	PayPalPayment service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@PostMapping("/pay")
	public String payment(@RequestBody BookingObject booking) {
		try {
			Payment payment = service.createPayment(booking,
					"http://localhost:8090/" + CANCEL_URL,
					"http://localhost:8090/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "forwardLink:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	                return "success";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }

}
*/
