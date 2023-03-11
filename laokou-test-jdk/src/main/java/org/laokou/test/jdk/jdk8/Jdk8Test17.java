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

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author laokou
 */
public class Jdk8Test17 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "ccc", "ddd", "dax");
        Stream<String> stream = list.stream().filter(item -> item.startsWith("d"));
        long count = list.stream().count();
        System.out.println(count);
        list.stream().forEach(System.out::println);
        System.out.println(list.stream().limit(12).collect(Collectors.toList()));
        for (String s : stream.toArray(String[]::new)) {
            System.out.println(s);
        }
        List<String> collect = list.stream().map(s -> s + "xxx").collect(Collectors.toList());
        System.out.println(collect);
        list.stream().sorted().forEach(System.out::println);
        String collect1 = list.stream().collect(Collectors.joining(","));
        System.out.println(collect1);

        IntSummaryStatistics intSummaryStatistics = Arrays.asList(1, 3, 22, 44).stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("最大数：" + intSummaryStatistics.getMax());
        System.out.println("最小数：" + intSummaryStatistics.getMin());
        System.out.println("平均数：" + intSummaryStatistics.getAverage());
        System.out.println("所有数之和：" + intSummaryStatistics.getSum());
        System.out.println("统计个数：" + intSummaryStatistics.getCount());

        List<String> strings = Arrays.asList("dddxx");
        Stream<String> concat = Stream.concat(list.stream(), strings.stream());
        System.out.println(concat.count());

        Stream<String> stream1 = list.stream();
        // stream1.limit(2);
        // 一个stream最多操作一次
        // stream1.forEach(System.out::println);

        stream1.limit(2).forEach(System.out::println);
    }
}
