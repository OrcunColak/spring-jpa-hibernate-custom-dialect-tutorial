package com.colak.springtutorial.customdialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.query.sqm.function.SqmFunctionRegistry;
import org.hibernate.type.StandardBasicTypes;

public class CustomH2Dialect extends H2Dialect {

    @Override
    public void initializeFunctionRegistry(FunctionContributions functionContributions) {
        super.initializeFunctionRegistry(functionContributions);

        SqmFunctionRegistry functionRegistry = functionContributions.getFunctionRegistry();
        // Registering the DATE_FORMAT function to use H2's FORMATDATETIME function
        functionRegistry.register(
                "date_format",
                new StandardSQLFunction("FORMATDATETIME", StandardBasicTypes.STRING)
        );

        // Register CONCAT function with a custom name
        functionRegistry.register(
                "concat_strings",
                new StandardSQLFunction("CONCAT", StandardBasicTypes.STRING)
        );
    }
}
