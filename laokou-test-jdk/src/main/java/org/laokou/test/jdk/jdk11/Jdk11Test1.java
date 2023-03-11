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

package org.laokou.test.jdk.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author laokou
 */
public class Jdk11Test1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest build = HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        // 同步
        HttpResponse<String> send = httpClient.send(build, HttpResponse.BodyHandlers.ofString());
        System.out.println(send.body());

        // 异步
        httpClient.sendAsync(build,HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
        Thread.sleep(3000);
    }
}
