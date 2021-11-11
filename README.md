# micro_service_seclab
这是一个Java漏洞靶场

这个Java漏洞靶场是基于SpringBoot开发，目的是用来检测SAST工具的准确性(关注漏报和误报问题)的。

可以用此靶场测试(CodeQL, CheckMarx, Fortify SCA)白盒检测工具，根据预先埋点的漏洞，与测试结果进行对比，

判断在什么地方存在误报和漏报的问题。
