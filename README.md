# Jackson Mapper


对`ObjectMapper`抛出的`Exception`做了`Check`(log 🤣)

```java
String pattern = "yyyy-MM-dd HH:mm:ss";
JacksonMapper jacksonMapper = new JacksonMapperBuilder()
            .deDisableDatesAsTimestamps()
            .dateFormat(pattern)
            .deDateTimeFormatterPattern(pattern)
            .seDateTimeFormatterPattern(pattern)
            .snakeCase()
            .deDisableFailOnUnknowPropertis()
            .deDisableFailOnIgnoredProperties()
            .build();
```

License:
- slf4j     
    + [MIT License](http://www.opensource.org/licenses/mit-license.php)
- logback   
    + [Eclipse Public License - v 1.0](http://www.eclipse.org/legal/epl-v10.html)
    + [GNU Lesser General Public License](http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
- jackson
    + [The Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)
- junit5
    + [Eclipse Public License v2.0](http://www.eclipse.org/legal/epl-v20.html)
- junit4
    + [Eclipse Public License - v 1.0](http://www.eclipse.org/legal/epl-v10.html)
