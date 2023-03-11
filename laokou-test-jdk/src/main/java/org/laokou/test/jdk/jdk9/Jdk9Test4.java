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

package org.laokou.test.jdk.jdk9;

import java.util.stream.Stream;

/**
 * @author laokou
 */
public class Jdk9Test4 {
    public static void main(String[] args) {
        // 输出1~10
        Stream.iterate(1,i -> i + 1).limit(10).forEach(System.out::println);
        Stream.iterate(1, i -> i <= 10, i -> i + 1).forEach(System.out::println);
    }
}
