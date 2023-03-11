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

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @author laokou
 */
public class Jdk8Test38 {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId of = ZoneId.of("Europe/Berlin");
        System.out.println(of.getRules());
        ZoneId of1 = ZoneId.of("Brazil/East");
        System.out.println(of1.getRules());
        LocalTime localTime = LocalTime.now(of);
        LocalTime localTime1 = LocalTime.now(of1);
        System.out.println(localTime1.isBefore(localTime));
        long between = ChronoUnit.HOURS.between(localTime1, localTime);
        System.out.println(between);
        long between1 = ChronoUnit.MINUTES.between(localTime1, localTime);
        System.out.println(between1);
    }
}
