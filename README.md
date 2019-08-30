# kotlin dagger2 小例子

### 开发环境
>版本
Android studio 3.5
Gradle 5.4.1

### dagger2是干嘛呢？
>dagger2 其实就是类似springmvc中的AOP面向切面编程，主要作用方便解耦， 通过自定义注解和apt插件在适当的时间创建对象和
销毁对象。

### 下面的用一个简单小例子，展示下kotlin+dagger2的使用
#### gradle配置

1. 主项目 ``build.gradle 加入 apply plugin: 'kotlin-kapt'``
![](/img/kapt.webp)
2. 需要的依赖
```gradle
/* Dagger 2 */
        implementation 'com.google.dagger:dagger:2.24'
        implementation 'com.google.dagger:dagger-android-support:2.24'
        kapt 'com.google.dagger:dagger-compiler:2.24'
        kapt 'com.google.dagger:dagger-android-processor:2.24'   
```
#### kotlin代码
1. User
```kotlin
    /**
     * 构造方法添加 @Inject 注解
     */
    data class User @Inject constructor(val name: String, val age: Int)
```
2. UserModule
```kotlin
    @Module
    object BeanModule {
    
        @JvmStatic
        @Provides
        fun name() = "xxx"
    
        @JvmStatic
        @Provides
        @Named("ag")
        fun age1() = 1234
    
        @JvmStatic
        @Provides
        @Named("ags")
        fun age22() = 2132
        
        @JvmStatic
        @Provides
        fun injectUser(
            name: String, //String 类型 会对应找当前Module中String类型，赋值
            @Named("ag") age: Int //当一个module内有多个相同类型时候，可以通过Named注解进行区分
        ): User =
            User(name, age)
    
    }
```     
3. ActivityModule
```kotlin
    
    @Module
    abstract class ActivityModule {
    
        @ContributesAndroidInjector(
            modules = [
                BeanModule::class
            ]
        )
        abstract fun injectScrollingActivity(): ScrollingActivity
    
    }
    
```         
4. ApplicationComponent 接口，创建完之后需要build下工程，通过kapt插件创建DaggerApplicationComponent
```kotlin
  
  //单例
  @Singleton
  @Component(
      modules = [ActivityModule::class,
          AndroidSupportInjectionModule::class
      ]
  )
  interface ApplicationComponent : AndroidInjector<App> {
  
      //这个可以不用写，生成的时候直接用build 不用create
  //    @Component.Builder
  //    abstract class Builder : AndroidInjector.Builder<App>()
  
  }
    
```   
5. App 
```kotlin
    /**
     * Application 需要继承 DaggerApplication
     */
    class App : DaggerApplication() {
    
        /**
         * @see DaggerApplicationComponent 是 ApplicationComponent接口的实现类
         */
    
        override fun applicationInjector():
                AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().build()
    }
```     
6. 在ScrollingActivity使用
```kotlin
    
    class ScrollingActivity : DaggerAppCompatActivity() {
    
        @Inject
        lateinit var user: User
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_scrolling)
            //使用user
            Log.e("onCreate", "user $user  p is ${presenter.hashCode()}")
    
        }
    }

```        

### 一个简单的mvp 直接看代码