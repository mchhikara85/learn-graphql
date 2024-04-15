package com.example.learngraphql.controller;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof BookException) {
            ErrorType errorType = null;
            if (((BookException) ex).getStatusCode() == HttpStatus.NO_CONTENT.value()) {
                errorType = ErrorType.NOT_FOUND;
            } else if (((BookException) ex).getStatusCode() == HttpStatus.FAILED_DEPENDENCY.value()) {
                errorType = ErrorType.INTERNAL_ERROR;
            }
            return GraphqlErrorBuilder.newError()
                    .errorType(errorType)
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        } else {
            return GraphqlErrorBuilder.newError().build();
        }
    }
}
