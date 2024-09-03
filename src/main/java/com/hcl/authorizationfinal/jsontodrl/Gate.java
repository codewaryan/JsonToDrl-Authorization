package com.hcl.authorizationfinal.jsontodrl;

public enum Gate {
    AND("&&"),
    OR("||");

    private String gate;

    Gate(String gate) {
        this.gate = gate;
    }

    public String getGate() {
        return gate;
    }
}
