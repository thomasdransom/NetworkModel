import java.util.ArrayList;

public class NetworkAdapter implements NetworkDevice {
    ArrayList<EthernetFrame> frameArr;
    NetworkAdapter(){}


    public void packageFrame(int[] data){
    int numberOfFrames = (data.length/64)+1;
        this.frameArr = new ArrayList<EthernetFrame>();
        for(int i = 0; i < numberOfFrames; i++){
            frameArr.add(new EthernetFrame(data,  (64*i)));
            //Creates new frames of max length 64.
        }
    }

    public void printFrames() {
        for (int i = 0; i < frameArr.size(); ++i) {
            EthernetFrame tempFrame = frameArr.get(i);
            tempFrame.print();
        }
    }
}
