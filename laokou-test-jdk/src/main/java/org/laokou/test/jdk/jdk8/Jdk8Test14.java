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
public class Jdk8Test14 {
    public static void main(String[] args) {
        A aa = Jdk8Test14::t;
        aa.te();
        Te te = new Te();
        A zz = te::s;
        zz.te();
        Tee tee = new Tee();
        A zzz = tee::x;
        zzz.te();
        A zzzz = Tee::new;
    }
    public static void t() {
        System.out.println(3331);
    }
    static class Te {
        public void s() {
            System.out.println(33);
        }
    }
    static class Tee extends Te {
        public Tee() {
            System.out.println(00);
            System.out.println(11133);
        }

        A x() {
            return null;
        }
    }
    @FunctionalInterface
    public interface A{
        void te();
    }
}
