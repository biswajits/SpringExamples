package net.spring.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import net.spring.ex.model.Customer;
import net.spring.ex.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private CustomerService customerService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	 
    @Autowired(required = true)
    @Qualifier(value = "customerService")
    public void setPersonService(CustomerService cs) {
        this.customerService = cs;
    }
 
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
 
    // For add and update person both
    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer c) {
 
        if (c.getId() == 0) {
            // new person, add it
            this.customerService.addCustomer(c);
        } else {
            // existing person, call update
            this.customerService.updateCustomer(c);
        }
 
        return "redirect:/customers";
 
    }
 
    @RequestMapping("/customer/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id) {
 
        this.customerService.removeCustomer(id);
        return "redirect:/customers";
    }
 
    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
    	 model.addAttribute("customer", new Customer());
         model.addAttribute("listCustomers", this.customerService.listCustomers());
         return "customer";
    }
	
}
