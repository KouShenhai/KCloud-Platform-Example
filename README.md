# KCloud-Platform-Example

* @EnableConfigurationProperties -> ConfigurationProperties的类进行一次注入
* AutoConfiguration -> 给插件使用
* Configuration -> 直接使用
* @ConditionalOnBean -> spring容器中存在指定的class实例对象，对应的配置才生效
* @ConditionalOnMissingBean -> ConditionalOnMissingBean 保证只有一个bean被注入 某个class位于类路径上，才会实例化一个bean
* ConditionalOnMissingBean -> 相同类型的bean被注入，保证bean只有一个