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

package org.laokou.test.jdk.jdk10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author laokou
 */
public class Jdk10Test1 {
    public static void main(String[] args) throws MalformedURLException {
        var id = 1;
        System.out.println(id);
        var p = new URL("https://www.baidu.com");
        System.out.println(p);
        var s = List.of(1);
        System.out.println(s);
        for (var o : s) {
            System.out.println(o);
        }
    }
}
