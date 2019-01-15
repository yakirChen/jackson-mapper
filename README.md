# Jackson Mapper


对`ObjectMapper`抛出的`Exception`做了`Check`(log 🤣)

```java
String pattern = "yyyy-MM-dd HH:mm:ss SSS";
JacksonMapper jacksonMapper = new JacksonMapperBuilder()
        .snakeCase()
        .upperCamelCase()
        .lowerCamelCase()
        .lowerCase()
        .kebabCase()
        .deDisableFailOnUnknowPropertis()
        .deDisableFailOnIgnoredProperties()
        .seDisableDatesAsTimestamps()
        .seDisableFailOnEmptyBeans()
        .seDateTimeFormatterPattern("yyyy-MM-dd HH:mm:ss SSS")
        .deDateTimeFormatterPattern("yyyy-MM-dd HH:mm:ss SSS")
        .dateFormat("yyyy-MM-dd HH:mm:ss SSS")
        .build();

List<String> hobby = new ArrayList<>(1);
hobby.add(".");
hobby.add("..");
hobby.add("...");
hobby.add("....");
Foo foo = new Foo(Long.MAX_VALUE,
        LocalDateTime.now(),
        hobby);
String json = jacksonMapper.defaultPrettyPrinter(foo);
logger.info(json);
Foo foo0 = jacksonMapper.readValue(json, Foo.class);
Assertions.assertEquals(foo0.getCdate(), foo.getCdate());
Assertions.assertEquals(foo0.getId(), foo.getId());
Assertions.assertEquals(foo0.getHobby(), foo.getHobby());
```

```json
{
  "id" : 9223372036854775807,
  "cdate" : "2019-01-13 00:25:49 732",
  "hobby" : [ ".", "..", "...", "...." ]
}
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
