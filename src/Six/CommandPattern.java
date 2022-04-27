package Six;

import java.util.ArrayList;

interface Sender {
    public void send(String str);
}



class Phone {
    public Phone(){};

    public void sentSms(String str){
        System.out.println("I'm sending sms " + str);
    }

    public void sentTelega(String str){
        System.out.println("Im sending telega " + str);
    }
}

class SenderTelega implements Sender {
    private Phone phone;
    public SenderTelega(Phone phone){
        this.phone = phone;
    }

    @Override
    public void send(String str) {
        phone.sentTelega(str);
    }
}

class SenderSms implements Sender {
    private Phone phone;

    public SenderSms(Phone phone){
        this.phone = phone;
    }
    @Override
    public void send(String str) {
        phone.sentTelega(str);
    }
}

class User{
    public void sendSomething(Sender sender, String str){
        sender.send(str);
    }
}




public class CommandPattern {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Sender telega = new SenderTelega(phone);
        Sender sms = new SenderSms(phone);
        User user = new User();
        user.sendSomething(telega, "my text");

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(1);

        arr.forEach(System.out::println);


    }

}
