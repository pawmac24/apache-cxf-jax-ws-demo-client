package com.pluralsight.cxfdemo.orders;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for processing orders through the Orders web service.  
 * 
 * @author Michael Hoffman, Pluralsight
 *
 */
@Controller("/processOrderPlacement")
public class OrdersController {

   // TODO: Add the Orders interface as a member of the controller
   
   @RequestMapping(method = RequestMethod.GET)
   public String processOrderPlacement(ModelMap model) throws Exception {
      // TODO: Add the creation of an OrderInquiry request type and populate it
      
      // TODO: Call the orders web service      
      
      // TODO: Replace null with the order status from the web service response.
      model.addAttribute("orderStatus", null);
      
      // View we are returning to, in this case processOrderPlacement.jsp 
      return "processOrderPlacement";
   }
}
