package com.finanzas.finanzasback.resource;

public class SaveCostResource {

    private Boolean cost_type;
    private Boolean value_type;
    private double   value;

    public Boolean getCost_type() {
        return cost_type;
    }

    public void setCost_type(Boolean cost_type) {
        this.cost_type = cost_type;
    }

    public Boolean getValue_type() {
        return value_type;
    }

    public void setValue_type(Boolean value_type) {
        this.value_type = value_type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
