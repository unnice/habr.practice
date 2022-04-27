package Eight;

import java.util.Random;

public class ConsumerProducer {

    public static void main(String[] args) {

        MailBox mailBox = new MailBox();
        Producer producer = new Producer(mailBox);
        Client client = new Client(mailBox);

        (new Thread(producer)).start();
        (new Thread(client)).start();



    }


    public static class MailBox {

        private boolean isEmpty;
        private String mail;

        public MailBox(){
            this.isEmpty = true;
            this.mail = null;
        }

        public synchronized void putMail(String message){
            while (!isEmpty){
                try {
                    wait();
                }catch (InterruptedException e){}
            }
            this.mail = message;
            this.isEmpty = false;
            
            notifyAll();
        }

        public synchronized String take(){
            while (isEmpty){
                try {
                    wait();
                } catch (InterruptedException e){}
            }
            isEmpty = true;
            notifyAll();
            return mail;
        }

    }


    public static class Producer implements Runnable{

        private MailBox mailbox;

        public Producer(MailBox mailbox){
            this.mailbox = mailbox;
        }
        @Override
        public void run() {
            Random random = new Random();
            String[] messages = {"First", "Second", "third", "Fourth and last"};

            for (int i = 0; i< messages.length; i++){
               mailbox.putMail(messages[i]);
                System.out.println(Thread.currentThread().getName() + ": I have put in mailbox new mail: " + messages[i]);
               try {
                   Thread.sleep(random.nextInt(2000));
               } catch (InterruptedException e){}
            }
            mailbox.putMail("That's all");
        }
    }

    static class Client implements Runnable{

        private MailBox mailbox;

        public Client(MailBox mailbox){
            this.mailbox = mailbox;
        }

        @Override
        public void run() {

            Random random = new Random();

            for (String message = mailbox.take(); !message.equals("That's all"); message = mailbox.take()){
                System.out.println(Thread.currentThread().getName() + ": I have taken from mailbox new mail: " + message);
                try {
                    Thread.sleep(random.nextInt(2000));
                }catch (InterruptedException e){}
            }
            System.out.println("That's all? ok!");

        }
    }

}
