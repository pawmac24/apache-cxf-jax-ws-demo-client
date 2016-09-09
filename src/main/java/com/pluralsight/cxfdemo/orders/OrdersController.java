package com.pluralsight.cxfdemo.orders;

import com.pluralsight.schema.order.ObjectFactory;
import com.pluralsight.schema.order.OrderInquiryResponseType;
import com.pluralsight.schema.order.OrderInquiryType;
import com.pluralsight.service.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for processing orders through the Orders web service.
 *
 * @author Michael Hoffman, Pluralsight
 */
@Controller("/processOrderPlacement")
public class OrdersController {

    @Autowired
    private Orders orders;

    @RequestMapping(method = RequestMethod.GET)
    public String processOrderPlacement(ModelMap model) throws Exception {
        OrderInquiryType orderInquiry = new ObjectFactory().createOrderInquiryType();
        orderInquiry.setAccountId(1234);
        orderInquiry.setEan13(1234567890123L);
        orderInquiry.setOrderQuantity(2);
        orderInquiry.setUniqueOrderId(999);

        OrderInquiryResponseType response = orders.processOrderPlacement(orderInquiry);

        model.addAttribute("orderStatus", response.getOrder().getOrderStatus().value());

        // View we are returning to, in this case processOrderPlacement.jsp
        return "processOrderPlacement";
    }
}
