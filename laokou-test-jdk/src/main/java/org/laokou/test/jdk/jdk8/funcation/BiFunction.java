package org.laokou.test.jdk.jdk8.funcation;

@FunctionalInterface
public interface BiFunction<T,U,R> {

    R apply(T t,U u);

}
