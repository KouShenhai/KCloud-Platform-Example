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

package org.laokou.test.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author laokou
 */
public class Jdk8Test18 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeee", "33d", "cc");
        Stream<String> stringStream = strings.stream().filter(s -> {
            System.out.println("Predicate.test()执行");
            return true;
        });
        System.out.println("count执行");
        stringStream.count();
    }
}
