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

/**
 * @author laokou
 */
public class Jdk8Test27 {
    public static void main(String[] args) {
       PersionFactory<Persion> persionFactory = Persion::new;
        Persion persion = persionFactory.create("333");
        System.out.println(persion);
    }
    static class Persion {
        String name;
        Persion(String name) {
            this.name = name;
        }
    }
    interface PersionFactory<P extends Persion>{
        P create(String name);
    }
}
