# micro_service_seclab
这是一个Java漏洞靶场

这个Java漏洞靶场是基于SpringBoot开发，目的是用来检测SAST工具的准确性(关注漏报和误报问题)的。

如果想学习使用`CodeQL`检测漏洞，可根据文章[《CodeQL从入门到放弃》](https://www.freebuf.com/articles/web/283795.html) 结合此项目进行学习。

可以用此靶场测试(CodeQL, CheckMarx, Fortify SCA)白盒检测工具，根据预先埋点的漏洞，与测试结果进行对比，

判断在什么地方存在误报和漏报的问题。

当然，你也可以用这个靶场做黑盒测试，所有漏洞都提供了数据库文件。

### 支持的漏洞
#### 1). SQL注入
SQL注入这部分，会出现很多不同白盒写法导致的SQL注入。

种类 | 解释 | 伪代码
---|---|---
String Source | 输入点是字符串类型 | ` one(@RequestParam(value = "username") String username) `
List\<Long\> | 输入点是Long泛型(用来测试误报) | ` longin(@RequestBody List<Long> user_list) `
Optional\<String\> | 新特性 | `  optionalLike(@RequestParam(value = "username") Optional<String> optinal_username)  `
List\<String\> Source | 输入点是String泛型 | ` in(@RequestBody List<String> user_list) `
Object Source | 对象类型 | ` objectParam(@RequestBody Student user) `
MyBatis注入 | XML分离SQL检测 | `myBatis(@RequestParam(value = "name") String name)`
In类型注入 | In类型注入 | 参照代码
Like类型 | Like类型注入 | 参照代码
Lombok | Lombok对注入漏洞的影响 | 参照代码
MyBatis注解方式注入 | MyBatis注解方式注入 | 参照代码
Spring Data JPA | JPA 方式 | 参照代码

#### 2). RCE命令执行

种类 | 解释 | 伪代码
---|---|---
processBuilder|processBuilder导致的RCE| --
Runtime.getRuntime().exec(args)|Runtime.getRuntime().exec(args)导致的RCE|--

#### 3). FastJson反序列化漏洞
提供`1.2.31`版本的Fastjson供进行测试。
```
@RestController
@RequestMapping(value = "/fastjson")
public class FastJsonController {

    @PostMapping(value = "/create")
    public Teacher createActivity(@RequestBody String applyData,
                                  HttpServletRequest request, HttpServletResponse response){
        Teacher teachVO = JSON.parseObject(applyData, Teacher.class);
        return teachVO;
    }

}
```
#### 4. SSRF漏洞
种类 | 解释 | 伪代码
---|---|---
url.openConnection()| url.openConnection()引起的SSRF| 参照代码
Request.Get() | Request.Get()引起的SSRF | 参照代码
OkHttpClient | OkHttpClient引起的SSRF | 参照代码
DefaultHttpClient| DefaultHttpClient引起的SSRF |参照代码
url.openStream()| url.openStream()引起的SSRF | 参照代码
#### 5. XXE
种类 | 解释 | 伪代码
---|---|---
DocumentBuilderFactory| DocumentBuilderFactory引起的SSRF | 参照代码

#### 6. 反序列化漏洞
持续添加中

#### 7. 逻辑漏洞
添加中

#### 欢迎大家提交漏洞代码....
