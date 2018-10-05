import java.util.ArrayList;

public class NetworkAdapter implements NetworkDevice {
    ArrayList<EthernetFrame> frameArr;
    Channel connectedChannel;

    NetworkAdapter(){
        this.frameArr = new ArrayList<EthernetFrame>();
    }

    NetworkAdapter(Channel c){
        this.frameArr = new ArrayList<EthernetFrame>();
        this.connectedChannel = c;
    }


    public void packageFrame(int[] data){
    int numberOfFrames = (data.length/64)+1;
        for(int i = 0; i < numberOfFrames; i++){
            frameArr.add(new EthernetFrame(data,  (64*i)));
            //Creates new frames of max length 64.
        }
    }


    public void receive(Channel c) {
        this.frameArr.add(c.currentFrame);
    }

    public void printFrames() {
        for (int i = 0; i < frameArr.size(); ++i) {
            EthernetFrame tempFrame = frameArr.get(i);
            tempFrame.print();
        }
    }

    public void sendFrames(NetworkDevice n){
        try {

                for (int i = 0; i<this.frameArr.size();++i){
                    connectedChannel.transmit(frameArr.get(i), n);
                }

            }catch (NullPointerException e){
            System.out.println("Connect to a channel first");
        }
    }

    public void connectTo(Channel c){
        connectedChannel = c;
    }
}
