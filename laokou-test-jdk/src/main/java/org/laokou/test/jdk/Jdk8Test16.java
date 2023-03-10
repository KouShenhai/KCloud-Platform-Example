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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laokou
 */
public class Jdk8Test16 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("222", "333", "444");
        for (String string : strings) {
            System.out.println(string);
        }
        strings.forEach(item -> System.out.println(item));
        strings.forEach(System.out::println);

        Map<String,String> data = new HashMap<>(1);
        data.put("aa","123");
        data.forEach((k,v) -> System.out.println(k + "->" + v));
    }
}
