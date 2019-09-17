//package root.utils.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//
//
//@Slf4j
//@Component
////作用是把当前类标识为一个切面供容器读取
//@Aspect
//public class ServiceAspect {
//
//    /**
//     * @Pointcut用来定义切点范围
//     * @Pointcut所在方法没有任何作用，只是因为@Pointcut需要修饰在方法上
//     * @Pointcut所修饰方法中代码不起任何作用
//     * execution函数用于匹配方法执行的连接点，语法为：
//     *
//     * execution(方法修饰符(可选)  返回类型  方法名  参数  异常模式(可选))
//     *
//     * 参数部分允许使用通配符：
//     *
//     * *  匹配任意字符，但只能匹配一个元素
//     *
//     * .. 匹配任意字符，可以匹配任意多个元素，表示类时，必须和*联合使用
//     *
//     * +  必须跟在类名后面，如Horseman+，表示类本身和继承或扩展指定类的所有类
//     *
//     * 参考：http://blog.csdn.net/autfish/article/details/51184405
//     *
//     *
//     * 除了execution()，Spring中还支持其他多个函数，这里列出名称和简单介绍，以方便根据需要进行更详细的查询
//     *
//     *  @annotation()
//     *
//     * 表示标注了指定注解的目标类方法
//     *
//     * 例如 @annotation(org.springframework.transaction.annotation.Transactional) 表示标注了@Transactional的方法
//     *
//     * args()
//     *
//     * 通过目标类方法的参数类型指定切点
//     *
//     * 例如 args(String) 表示有且仅有一个String型参数的方法
//     *
//     * @args()
//     *
//     * 通过目标类参数的对象类型是否标注了指定注解指定切点
//     *
//     * 如 @args(org.springframework.stereotype.Service) 表示有且仅有一个标注了@Service的类参数的方法
//     *
//     * within()
//     *
//     * 通过类名指定切点
//     *
//     * 如 with(examples.chap03.Horseman) 表示Horseman的所有方法
//     *
//     * target()
//     *
//     * 通过类名指定，同时包含所有子类
//     *
//     * 如 target(examples.chap03.Horseman)  且Elephantman extends Horseman，则两个类的所有方法都匹配
//     *
//     * @within()
//     *
//     * 匹配标注了指定注解的类及其所有子类
//     *
//     * 如 @within(org.springframework.stereotype.Service) 给Horseman加上@Service标注，则Horseman和Elephantman 的所有方法都匹配
//     *
//     * @target()
//     *
//     * 所有标注了指定注解的类
//     *
//     * 如 @target(org.springframework.stereotype.Service) 表示所有标注了@Service的类的所有方法
//     *
//     *  this()
//     *
//     * 大部分时候和target()相同，区别是this是在运行时生成代理类后，才判断代理类与指定的对象类型是否匹配
//     */
//    @Pointcut("execution(* root.code..*.*(..))")
//    public void pointCup(){}
//
//    /**
//     * 环绕通知,环绕增强，相当于MethodInterceptor
//     * 这里面有一个问题，当你想发生异常的时候跳到被@AfterThrowing修饰的方法时
//     * 1.所有方法不可try/catch掉异常必须抛出
//     * 2.切面类@Around修饰的方法不可try/catch掉异常且抛出Throwable类
//     * 3.
//     */
//
//    @Around("pointCup()")
//    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
//        log.info("方法环绕start.....");
//        Object o = pjp.proceed();
//        log.info("方法环绕proceed，结果是 :" + o.getClass());
//        return o;
//    }
//
//    //标识一个前置增强方法，相当于BeforeAdvice的功能
//    @Before("pointCup()")
//    public void before(){
//        log.info("Aop Before start!");
//    }
//
//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("pointCup()")
//    public void after(JoinPoint jp){
//        log.info("方法最后执行.....");
//    }
//
//    /**
//     * 使用@AfterReturning注解可指定如下两个常用属性。
//     *
//     * 1)pointcut/value:这两个属性的作用是一样的，它们都属于指定切入点对应的切入表达式。一样既可以是已有的切入点，也可直接定义切入点表达式。当指定了pointcut属性值后，value属性值将会被覆盖。
//     *
//     * 2)returning:该属性指定一个形参名，用于表示Advice方法中可定义与此同名的形参，该形参可用于访问目标方法的返回值。除此之外，在Advice方法中定义该形参（代表目标方法的返回值）时指定的类型，会限制目标方法必须返回指定类型的值或没有返回值。
//     * @param ret
//     * @throws Throwable
//     */
//    @AfterReturning(returning = "ret", pointcut = "pointCup()")
//    public void doAfterReturning(Object ret){
//        // 处理完请求，返回内容
//        log.info("方法的返回值 : " + ret);
//    }
//
//    //后置异常通知
//    @AfterThrowing(pointcut = "pointCup()",throwing = "e")
//    public void throwss(Throwable e){
//        log.info("方法异常时执行.....");
//    }
//
//}
