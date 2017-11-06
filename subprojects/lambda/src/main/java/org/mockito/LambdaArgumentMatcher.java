/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito;

public interface LambdaArgumentMatcher<T> extends ArgumentMatcher<T> {

    default T getValue() {
        return null;
    }
}