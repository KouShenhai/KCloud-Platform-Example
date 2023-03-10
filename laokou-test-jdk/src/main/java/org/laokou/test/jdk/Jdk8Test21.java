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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author laokou
 */
public class Jdk8Test21 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2021, 1, 26);
        System.out.println(date);
        System.out.println(LocalDate.parse("2021-01-26"));
        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 12, 3, 12);
        System.out.println(dateTime);
        LocalDateTime parse = LocalDateTime.parse("2022-12-12 12:04:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);
        LocalTime time = LocalTime.of(12, 2, 2);
        System.out.println(time);
        LocalTime parse1 = LocalTime.parse("12:01:01");
        System.out.println(parse1);
    }
}
