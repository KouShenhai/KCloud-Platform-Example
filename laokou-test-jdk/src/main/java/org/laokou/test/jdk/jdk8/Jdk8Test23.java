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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author laokou
 */
public class Jdk8Test23 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        // 获取当月的第一天
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
        // 获取本月最后一天
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
        // 取下一天时间
        LocalDate localDate = lastDayOfMonth.plusDays(1);
        System.out.println(localDate);
        // 当年最后一天时间
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(lastDayOfYear);
        // 取2022年最后一个周末
        LocalDate lastMondayOf2022 = LocalDate.parse("2022-12-31").with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println(lastMondayOf2022);
    }
}
