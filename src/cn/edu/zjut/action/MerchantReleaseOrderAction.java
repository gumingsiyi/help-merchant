package cn.edu.zjut.action;

import cn.edu.zjut.service.OrderReleaseController;

import java.util.Date;

/**
 * Created by stiles on 15/12/22.
 */
public class MerchantReleaseOrderAction {
    private OrderReleaseController orderReleaseController;

    public void setOrderReleaseController(OrderReleaseController orderReleaseController) {
        this.orderReleaseController = orderReleaseController;
    }

    private String salaryString;

    public void setSalaryString(String salaryString) {
        this.salaryString = salaryString;
    }

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public String releaseOrder() {
        System.out.println(date);
        double salary = Double.parseDouble(salaryString);
        System.out.println(salary);
        return "success";
    }
}
