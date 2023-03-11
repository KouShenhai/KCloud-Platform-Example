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

package org.laokou.test.jdk.jdk17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * @author laokou
 */
public class Jdk17Test1 {
    public static void main(String[] args) {
        // PRNG伪随机数生成
        RandomGeneratorFactory<RandomGenerator> randomGeneratorRandomGeneratorFactory = RandomGeneratorFactory.of("L128X256MixRandom");
        RandomGenerator randomGenerator = randomGeneratorRandomGeneratorFactory.create(System.currentTimeMillis());
        System.out.println(randomGenerator.nextInt(10));
    }
}
