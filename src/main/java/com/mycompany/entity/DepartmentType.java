package com.mycompany.entity;

public enum DepartmentType {
    Marketing("Marketing"),
    Purchasing("Purchasing"),
    Human_Resources("Human_Resources"),
    Shipping("Shipping"),
    IT("IT"),
    Public_Relations("Public_Relations"),
    Executive("Executive"),
    Accounting("Accounting"),
    Payroll("Payroll"),
    Sales("Sales"),
    Finance("Finance"),
    Treasury("Treasury"),
    Corporate_Tax("Corporate_Tax"),
    Control_And_Credit("Control_And_Credit"),
    Shareholder_Services("Shareholder_Services"),
    Benefits("Benefits"),
    Manufacturing("Manufacturing"),
    Construction("Construction"),
    Contracting("Contracting"),
    Operations("Operations"),
    IT_Support("IT_Support"),
    IT_Helpdesk("IT_Helpdesk"),
    Government_Sales("Government_Sales"),
    Retail_Sales("Retail_Sales"),
    Recruiting("Recruiting");

    public String text;

    public static DepartmentType fromString(String text) {
        for (DepartmentType b : DepartmentType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    DepartmentType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
