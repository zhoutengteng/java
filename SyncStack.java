import java.util.Vector;

public class SyncStack {
    private Vector<Character> buff = new Vector<Character>(400,200);
    public synchronized char pop() {
        char c;
        while (buff.size()==0) {
            try {
                this.wait();    
            } catch (InterruptedException e) {


            }
        }
        c = ((Character)buff.remove(buff.size()-1)).charValue();
        return c;
    }
    public synchronized void push(char c) {
        this.notify();
        Character charObj = new Character(c);
        buff.addElement(charObj);

    }

}
