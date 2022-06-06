import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();
    ArrayList<Account> list = new ArrayList<>();

    public static Long getNewId() {
        Long result;
        lock.lock();
        try {
             result = ++id;
        } finally {
            lock.unlock();

        }
        return result;
    }

    public static void main(String[] args) {
        getNewId();
        System.out.println(id);
        getNewId();
        System.out.println(id);
    }


    private IdGenerate() {

    }
}
