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
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author laokou
 */
public class Jdk8Test22 {
    public static void main(String[] args) {
        // 一周后的日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.plus(1, ChronoUnit.WEEKS));
        LocalDate localDate1 = localDate.plusWeeks(1);
        System.out.println(localDate1);

        // 计算两个日期隔多少天，多少年，多少月
        LocalDate parse = LocalDate.parse("2021-02-26");
        LocalDate parse1 = LocalDate.parse("2023-01-02");
        Period period = Period.between(parse, parse1);
        System.out.println("两个日期相隔：" + period.getYears() + "年" + period.getMonths() + "月" + period.getYears() + "天");

        // 两个日期相差的总天数
        long l = parse1.toEpochDay() - parse.toEpochDay();
        System.out.println("两个日期相差的总天数：" + l);
    }
}
