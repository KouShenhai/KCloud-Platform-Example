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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author laokou
 */
public class Jdk8Test11 {
    public static void main(String[] args) {
        Function<String,Integer> worldLen = s -> s.length();
        Function<Integer,Boolean> ll = len -> len >= 4;
        Function<String, Boolean> stringBooleanFunction = worldLen.andThen(ll);
        Map<String,Boolean> d = new HashMap<>(2);
        d.computeIfAbsent("233",stringBooleanFunction);
        System.out.println(d);
    }
}
