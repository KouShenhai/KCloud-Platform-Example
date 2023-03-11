/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laokou.test.jdk.jdk8;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author laokou
 */
public class Jdk8Test29 {
    public static void main(String[] args) {
       Predicate<String> stringPredicate = s -> s.length() > 0;
        boolean test = stringPredicate.test("33");
        System.out.println(test);
        boolean test1 = stringPredicate.negate().test("33");
        System.out.println(test1);
        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println(nonNull.test(null));
        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println(isNull.test(null));
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test("333"));
        System.out.println(isEmpty.negate());
    }
}
