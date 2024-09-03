package com.hcl.authorizationfinal.dto.facts;

import java.util.Objects;

public class InvalidCompany {

    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvalidCompany that = (InvalidCompany) o;
        return Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(company);
    }
}
