package com.example.thread02.deadlock;

public class FromToDeadLock {

    /**
     * •线程A从X账户向Y账户转账
     * •线程B从账户Y向账户X转账
     * •那么就会发生死锁。(加客户端锁的顺序不一致：使用客户端锁对象的 hash 值决定加锁顺序,如果 hash 值相等单独使用一个锁)
     *
     * @param fromAccount
     * @param toAccount
     * @param money
     */
    public void trans(Account fromAccount,
                      Account toAccount,
                      int money) {
        // 锁定汇款账户
        synchronized (fromAccount) {
            System.out.println(fromAccount+"客户端锁被用");
            try {
                // 线程休眠1000，让客户端锁被获得
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 锁定收款账户
            synchronized (toAccount) {
                fromAccount.debit(money);
                toAccount.credit(money);
            }
        }
    }

    public static void main(String[] args) {
        FromToDeadLock fromToDeadLock = new FromToDeadLock();
        Account fromAccount = new Account(1000);
        Account toAccount = new Account(1000);
        new Thread(
                () -> {
                    fromToDeadLock.trans(fromAccount, toAccount, 100);
                    System.out.println(fromAccount.getMoney());
                    System.out.println(toAccount.getMoney());
                }
        ).start();

        new Thread(
                () -> {
                    fromToDeadLock.trans(toAccount, fromAccount, 100);
                    System.out.println(fromAccount.getMoney());
                    System.out.println(toAccount.getMoney());
                }
        ).start();
    }


}
class Account {

    private int money;

    public Account(int money) {
        this.money = money;
    }

    // 账户减款
    public void debit(int money) {
        this.money -= money;
    }

    // 账户加款
    public void credit(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }
}

