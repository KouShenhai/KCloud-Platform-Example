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

import java.util.HashMap;
import java.util.Map;

/**
 * @author laokou
 */
public class Jdk8Test36 {
    public static void main(String[] args) {
        Map<String,String> d = new HashMap<>(1);
        d.put("2","33");
        d.put("333","33");
        d.forEach((k,v) -> System.out.println(k + "" + "->" + v));
        d.computeIfPresent("33",(n,p) -> "ee");
        String s = d.get("33");
        System.out.println(d.containsKey("33"));
        System.out.println(s);
        d.computeIfPresent("44",(n,p) -> null);
        System.out.println(d.get("44"));
        System.out.println(d.containsKey("44"));
        d.computeIfPresent("2",(n,p) -> p + "ee");
        System.out.println(d.get("2"));
        System.out.println(d.containsKey("2"));
        d.remove("2","3ee");
        System.out.println(d.get("2"));
        d.remove("2","33ee");
        System.out.println(d.get("2"));
        d.merge("333","3",(v,newV) -> v.concat(newV));
        System.out.println(d.get("333"));
    }
}
