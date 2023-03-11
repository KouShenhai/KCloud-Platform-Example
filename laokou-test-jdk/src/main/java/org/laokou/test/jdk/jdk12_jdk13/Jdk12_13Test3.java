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

package org.laokou.test.jdk.jdk12_jdk13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author laokou
 */
public class Jdk12_13Test3 {
    public static void main(String[] args) throws IOException {
        Path tempFile = Files.createTempFile("kcloud_platform_alibaba", ".sql");
        Path tempFile1 = Files.createTempFile("kcloud_platform_alibaba1", ".sql");
        Files.writeString(tempFile1,"333");
        Files.writeString(tempFile,"333");
        long mismatch = Files.mismatch(tempFile1, tempFile);
        System.out.println(mismatch);
    }
}
