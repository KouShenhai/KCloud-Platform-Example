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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author laokou
 */
public class Jdk8Test24 {
    public static void main(String[] args) {
        // 当前时区时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        // 东京时间
        ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("JST"));
        ZonedDateTime zonedDateTime = now.withZoneSameInstant(zoneId);
        System.out.println("东京时间:" + zonedDateTime);
        // ZoneDateTime 转 LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println("东京时间转当地时间：" + localDateTime);
        // LocalDateTime 转 ZonedDateTime
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.systemDefault());
        System.out.println("本地时区时间：" + zonedDateTime1);
    }
}
