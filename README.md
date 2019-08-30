#kotlin dagger2 小例子

###开发环境
>版本
Android studio 3.5
Gradle 5.4.1

###dagger2是干嘛呢？
>dagger2 其实就是类似springmvc 的面向切面编程，主要作用方便解耦， 通过自定义注解和apt插件在适当的时间创建对象和
销毁对象。

###下面的用一个简单小例子，展示下kotlin+dagger2的使用
####gradle配置

1.![主项目 build.gradle 加入 apply plugin: 'kotlin-kapt'](/img/kapt.png)
2.需要的依赖
    /* Dagger 2 */
        implementation 'com.google.dagger:dagger:2.24'
        implementation 'com.google.dagger:dagger-android-support:2.24'
        kapt 'com.google.dagger:dagger-compiler:2.24'
        kapt 'com.google.dagger:dagger-android-processor:2.24'    
        
        