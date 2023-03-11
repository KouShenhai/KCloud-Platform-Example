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

package org.laokou.test.jdk.jdk14;

/**
 * @author laokou
 */
public class Jdk14Test1 {
    public static void main(String[] args) {
        // JVM添加参数-XX:+ShowCodeDetailsInExceptionMessages，可获取详细异常信息，快速定位问题
        String body = "D";
        String str = switch (body) {
            case "M" -> "33";
            case "D" -> "3333";
            default -> {
                if (!body.isEmpty()) {
                    yield "3333";
                } else {
                    yield "33";
                }
            }
        };
        System.out.println(str);
    }
}
