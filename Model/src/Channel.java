import java.util.ArrayList;

public class Channel {
    String name;
    boolean isBusy = false;
    EthernetFrame currentFrame;
    NetworkDevice receiver;
    /*
    In the simplified model the network adapter will send onr frame at a time instead of sending each bit serially
    We will also store the receiving device as a reference to the object instead of using the MAC address.
     */

    Channel(String n){
        this.name=n;
    }

    public void connectTo(NetworkDevice n){
        this.receiver = n;
    }

    public void transmit(EthernetFrame frame, NetworkDevice n){
        if (!isBusy){
            isBusy=true;
            connectTo(n);
            currentFrame = frame;
            receiver.receive(this);
            isBusy=false;
        }
        else{
            try {
                wait(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
