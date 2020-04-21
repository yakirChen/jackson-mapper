# Jackson Mapper

Clone Source
```bash
git clone git@github.com:yakirChen/jackson-mapper.git jackson-mapper
```


对`ObjectMapper`抛出的`Exception`做了`Catch` (log... _〔霧〕_ )

```java
static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSSSS";
JacksonMapper jacksonMapper = Jackson.builder()
        .snakeCase()
        .upperCamelCase()
        .lowerCamelCase()
        .lowerCase()
        .disableFailOnEmptyBeans()
        .disableFailOnUnknownProperties()
        .disableOnIgnoredProperties()
        .disableWriteDatesAsTimestamps()
        .defaultDateFormat(DATE_PATTERN)
        .addJavaTimeModule(DATE_PATTERN)
        .build();
List<String> hobby = new ArrayList<String>() {
    private static final long serialVersionUID = 1372828590201410789L;
    {
        add(".");
        add("..");
        add("...");
        add("....");
        add(".....");
        add("......");
        add(".......");
    }
};
Bar bar = new Bar()
        .setBar("bar")
        .setBarCdate(new Date())
        .setBarId((long) Integer.MAX_VALUE);
Foo foo = new Foo(
        Long.MAX_VALUE,
        LocalDateTime.now(),
        hobby,
        bar
);
String json = jacksonMapper.defaultPrettyPrinter(foo);
log.info(json);
String json0 = jacksonMapper.withPrettyPrinter(foo);
log.info(json0);
Foo foo0 = jacksonMapper.readValue(json, new TypeReference<Foo>() {});
Truth.assertThat(foo0.getFooCdate()).isEqualTo(foo.getFooCdate());
Truth.assertThat(foo0.getFooId()).isEqualTo(foo.getFooId());
Truth.assertThat(foo0.getHobby()).isEqualTo(foo.getHobby());
Foo foo1 = jacksonMapper.readValue(json, new TypeReference<Foo>() {});
Truth.assertThat(foo1.getFooCdate()).isEqualTo(foo.getFooCdate());
Truth.assertThat(foo1.getFooId()).isEqualTo(foo.getFooId());
Truth.assertThat(foo1.getHobby()).isEqualTo(foo.getHobby());
```

```json
{
  "id" : 9223372036854775807,
  "cdate" : "2019-03-08 12:06:23 943",
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
