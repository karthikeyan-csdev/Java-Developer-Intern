 /* 		Level-3    Task-2 : Create a Multi-threaded Application Build a multi-threaded 
 * Java application that demonstrates concurrency concepts like synchronization, locks, and threads. 
 * This task will help them understand concurrent programming and handling shared resources.
 */

package Level3.Task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankApp {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(new BankWorker(account, 200, true), "Thread-1");
        Thread t2 = new Thread(new BankWorker(account, 150, false), "Thread-2");
        Thread t3 = new Thread(new BankWorker(account, 300, true), "Thread-3");
        Thread t4 = new Thread(new BankWorker(account, 100, false), "Thread-4");

        System.out.println("\n\nInitial account balance: " + account.balance+"\n");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal account balance: " + account.balance+"\n\n");
    }
}

class BankWorker implements Runnable {
    private final BankAccount account;
    private final int amount;
    private final boolean isDeposit;

    public BankWorker(BankAccount account, int amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
class BankAccount {
    int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " depositing " + amount);
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal of " + amount);
            }
        } finally {
            lock.unlock();
        }
    }
}
