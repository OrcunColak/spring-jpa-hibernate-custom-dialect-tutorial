package com.colak.springjpatutorial.customdialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class CustomH2Dialect extends H2Dialect {
    @Override
    public void initializeFunctionRegistry(FunctionContributions functionContributions) {
        super.initializeFunctionRegistry(functionContributions);

        // Registering the DATE_FORMAT function to use H2's FORMATDATETIME function
        functionContributions.getFunctionRegistry().register(
                "date_format",
                new StandardSQLFunction("FORMATDATETIME", StandardBasicTypes.STRING)
        );
    }
}
