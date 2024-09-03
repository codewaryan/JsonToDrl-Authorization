package com.hcl.authorizationfinal.jsontodrl;

public enum Operator {
    EQUALS("="),
    NOT_EQUALS("<>"),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN_OR_EQUAL("<="),
    IN("in"),
    NOT_IN("not in"),
    LIKE("like");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator fromString(String text) {
        for (Operator op : Operator.values()) {
            if (op.operator.equalsIgnoreCase(text)) {
                return op;
            }
        }
        throw new IllegalArgumentException("No enum constant for operator: " + text);
    }
}
