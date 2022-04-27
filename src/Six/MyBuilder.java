package Six;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

interface Obsvr {
    public void update(StringBuilder builder);
}

interface Obsrvrbl {
    void registerObserver(Obsvr obs);
    void removeObservr(Obsvr obs);
    void notifyObservers();
}

public class MyBuilder implements Obsrvrbl {

    private interface Action{
        void undo() ;
    }

    private class DeleteAction implements Action{
        private int size;

        public DeleteAction(int size){
            this.size = size;
        }

        @Override
        public void undo() {
            stringBuilder.delete(stringBuilder.length()-size-1, stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {

        MyBuilder builder = new MyBuilder("kukaracha");
        builder.append(" eshe kukaracha");

        builder.undo();
        System.out.println(builder);

    }

    private StringBuilder stringBuilder;
    private Stack<Action> actions = new Stack<>();
    private ArrayList<Obsvr> observers = new ArrayList<>();

    public MyBuilder(){
        stringBuilder = new StringBuilder();
    }

    public MyBuilder(String string){
        stringBuilder = new StringBuilder(string);
        actions.add(() -> stringBuilder.delete(0, string.length()-1));
    }



    public StringBuilder reverse(){
        stringBuilder.reverse();
        Action action = () -> stringBuilder.reverse();
        actions.add(action);
        return stringBuilder;
    }

    public StringBuilder append(String string){
        stringBuilder.append(string);
        DeleteAction action = new DeleteAction(string.length());
        actions.add(action);
        return stringBuilder;
    }

    public StringBuilder delete(int from, int to){
        String deleted = stringBuilder.substring(from, to);
        stringBuilder.delete(from, to);
        Action action = () -> stringBuilder.insert(from, deleted);
        actions.add(action);
        return stringBuilder;
    }

    public StringBuilder deleteCharAt(int index){
        Character ch = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(()->stringBuilder.insert(index, ch));
        return stringBuilder;
    }

    public StringBuilder replace(int from, int to, String string){
        String deleted = stringBuilder.substring(from, to);
        stringBuilder.replace(from, to, string);
        actions.add(() -> stringBuilder.replace(from, string.length(),deleted));
        return stringBuilder;
    }

    void undo(){
        if(!actions.isEmpty()) actions.pop().undo();

    }

    public String toString(){
        return stringBuilder.toString();
    }

    @Override
    public void registerObserver(Obsvr obs){
        observers.add(obs);
    }

    public void removeObservr(Obsvr obs){
        observers.remove(obs);
    }

    public void notifyObservers(){
        for (Obsvr obs: observers) {
            obs.update(stringBuilder);
        }

    }








}
