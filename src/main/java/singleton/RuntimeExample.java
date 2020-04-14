package singleton;

public class RuntimeExample {
    public void testRuntimeSingleton()
    {
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc();
        System.out.println(singletonRuntime);
        Runtime anotherRuntime = Runtime.getRuntime();
        System.out.println(anotherRuntime);
    }
}
