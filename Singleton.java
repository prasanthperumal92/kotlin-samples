import java.io.Serializable;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {

    }


}

/**
 * initialization for singleton can be done in two ways
 * Eager - done in class loading
 * lazy - first access
 * we need to make singleton reflection proof -> throw exception if the instance is already initialized
 * we need to make thread safe ->  we can add synchronized keyword but it may slow down the code
 * -> use double check locking method -> add volatile keyword to instance
 *
 * we need to make singleton safe from serialization  ----> for this we need to override the readResolve function
 * **/


class SingletonExample implements Serializable {
    private static volatile SingletonExample instance;
    private SingletonExample() throws Exception {
        if (instance!=null)
            throw new Exception("already initialized");
    }
    public static SingletonExample getInstance(){
        if (instance==null)
        {
            synchronized (SingletonExample.class){
                if (instance==null){
                    try {
                        instance = new SingletonExample();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return instance;
    }

    protected SingletonExample readResolve() {
        return getInstance();
    }
}