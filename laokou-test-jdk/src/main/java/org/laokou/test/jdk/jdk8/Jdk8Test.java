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
public class Jdk8Test {
    public static void main(String[] args) {
        InterfaceNewImpl interfaceNew = new InterfaceNewImpl();
        interfaceNew.def();
    }
    interface InterfaceNew {
        static void s1() {
            System.out.println("接口提供s1(),不可被子类继承");
        }
        static void s2() {
            System.out.println("接口提供s2,不可被子类继承");
        }
        default void d1() {
            System.out.println("default(),可以被子类继承");
        }
        default void d2() {
            System.out.println("default(),可以被子类继承");
        }
        void f();
    }
    interface InterfaceNew2 {
        default void def() {
            System.out.println("default(),可以被子类继承");
        }
    }
    static class InterfaceNewImpl implements InterfaceNew, InterfaceNew2 {

        @Override
        public void f() {

        }

        @Override
        public void def() {
            InterfaceNew2.super.def();
        }
    }
}
