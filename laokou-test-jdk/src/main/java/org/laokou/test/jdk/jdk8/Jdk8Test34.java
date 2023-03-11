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

import java.util.stream.Stream;

/**
 * @author laokou
 */
public class Jdk8Test34 {
    public static void main(String[] args) {
        String reduce = Stream.of("A", "b", "c").reduce("aa", String::concat);
        System.out.println(reduce);
        Integer reduce1 = Stream.of(1, 22, 44, 2).reduce(0, Integer::min);
        System.out.println(reduce1);
        Integer reduce2 = Stream.of(22, 12).reduce(0, Integer::sum);
        System.out.println(reduce2);
        Integer integer = Stream.of(1, 2).reduce(Integer::sum).get();
        System.out.println(integer);
        String reduce3 = Stream.of("1", "d").filter(s -> s.compareTo("1") > 0)
                .reduce("", String::concat);
        System.out.println(reduce3);
    }
}
