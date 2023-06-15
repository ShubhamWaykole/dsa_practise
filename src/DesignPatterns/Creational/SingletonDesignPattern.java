package DesignPatterns.Creational;

public class SingletonDesignPattern {
    public static void main(String[] args) {
        System.out.println("Test Eager");
        System.out.println("Calling getInstance First time : " + SingletonEager.getSingletonObj());
        System.out.println("Calling getInstance Second time : " + SingletonEager.getSingletonObj());
        System.out.println("Test Lazy");
        System.out.println("Calling getInstance First time : " + SingletonLazy.getSingletonLazy());
        System.out.println("Calling getInstance Second time : " + SingletonLazy.getSingletonLazy());
        System.out.println("Test Synchronized");
        System.out.println("Calling getInstance First time : " + SingletonSynchronized.getSingletonSynchronized());
        System.out.println("Calling getInstance Second time : " + SingletonSynchronized.getSingletonSynchronized());

    }
}

class SingletonEager {
    private static SingletonEager singletonObj = new SingletonEager();

    private SingletonEager() {}

    public static SingletonEager getSingletonObj() {
        return singletonObj;
    }
}

class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy() {}

    public static SingletonLazy getSingletonLazy() {
        if(null == singletonLazy)
            singletonLazy =  new SingletonLazy();
        return singletonLazy;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized singletonSynchronized;

    private SingletonSynchronized() {}

    public static SingletonSynchronized getSingletonSynchronized() {
        if(null == singletonSynchronized)
            synchronized (SingletonSynchronized.class) {
                singletonSynchronized =  new SingletonSynchronized();
            }
        return singletonSynchronized;
    }
}